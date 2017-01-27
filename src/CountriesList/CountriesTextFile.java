package CountriesList;

import Interfaces.FileIOInterface;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by David on 1/23/17.
 */
public class CountriesTextFile implements FileIOInterface {
    private String fileName;
    private String directory;
    private Path directoryPath;
    private Path filePath;

    public CountriesTextFile (String directory, String fileName) {
        this.directory = directory;
        this.fileName = fileName;
        setDirectoryPath();
        setFilePath();
    }

    @Override
    public void setDirectoryPath() {
        this.directoryPath = Paths.get(directory);
    }

    @Override
    public void setFilePath() {
        this.filePath = Paths.get(directory, fileName);
    }

    @Override
    public void addToFile(String countryName) throws IOException {

        checkPath();

        FileWriter fileWriter = new FileWriter(filePath.toFile(), true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter writer = new PrintWriter(bufferedWriter);

        writer.println(countryName);

        writer.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    @Override
    public void displayFile() throws IOException {

        checkPath();

        FileReader fileReader = new FileReader(filePath.toFile());
        BufferedReader reader = new BufferedReader(fileReader);

        System.out.println("---");

        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }

        reader.close();
        fileReader.close();
    }

    @Override
    public void checkPath() throws IOException {

        if (Files.notExists(directoryPath)) {
            Files.createDirectories(directoryPath);
        }

        if (Files.notExists(filePath)) {
            Files.createFile(filePath);
        }
    }

    @Override
    public void deleteFromFile (String countryName) throws IOException{

        checkPath();

        List<String> countryList = storeFileLinesInArray();

        FileWriter fileWriter = new FileWriter(filePath.toFile());
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter writer = new PrintWriter(bufferedWriter);

        for (String country : countryList) {
            if (!country.equalsIgnoreCase(countryName)) {
                writer.println(country);
            }
        }

        writer.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    @Override
    public void sortFile () throws IOException {
        List<String> countriesList = storeFileLinesInArray();

        Collections.sort(countriesList);

        FileWriter fileWriter = new FileWriter(filePath.toFile());
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        PrintWriter writer = new PrintWriter(fileWriter);

        for (String country : countriesList) {
            writer.println(country);
        }

        writer.close();
        bufferedWriter.close();
        fileWriter.close();
    }

    private List<String> storeFileLinesInArray () throws IOException {
        FileReader fileReader = new FileReader(filePath.toFile());
        BufferedReader reader = new BufferedReader(fileReader);

        List<String> countryList = new ArrayList<>();
        int i = 0;
        String line = reader.readLine();

        while (line != null) {
            countryList.add(i, line);
            i += 1;
            line = reader.readLine();
        }

        return countryList;
    }
}
