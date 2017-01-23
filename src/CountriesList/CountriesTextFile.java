package CountriesList;

import Interfaces.FileIOInterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by David on 1/23/17.
 */
public class CountriesTextFile implements FileIOInterface{
    private String fileName;
    private String directory;

    public CountriesTextFile (String directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
    }

    @Override
    public Path setDirectoryPath(String directory) {
        Path directoryPath = Paths.get(directory);
        return directoryPath;
    }

    @Override
    public Path setFilePath(String fileName) {
        Path filePath = Paths.get(directory, fileName);
        return filePath;
    }

    @Override
    public void addToFile(String s) throws IOException {
        Path filePath = setFilePath(fileName);

        checkPath();

        FileWriter fileWriter = new FileWriter(filePath.toFile(), true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter writer = new PrintWriter(bufferedWriter);

        writer.println(s);

        writer.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    @Override
    public void displayFile() throws IOException {
        Path filePath = setFilePath(fileName);

        checkPath();

        FileReader fileReader = new FileReader(filePath.toFile());
        BufferedReader reader = new BufferedReader(fileReader);

        System.out.println("---");

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }

        System.out.println("---");

        reader.close();
        fileReader.close();
    }

    @Override
    public void checkPath() throws IOException {
        Path directoryPath = setDirectoryPath(directory);

        if (Files.notExists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }

        Path filePath = setFilePath(fileName);

        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
    }
}
