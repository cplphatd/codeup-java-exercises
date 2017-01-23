package Interfaces;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by David on 1/23/17.
 */
public interface FileIOInterface {

    Path setDirectoryPath (String directory);

    Path setFilePath (String fileName);

    void addToFile (String s) throws IOException;

    void displayFile () throws  IOException;

    void checkPath () throws IOException;
}
