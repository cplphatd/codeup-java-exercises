package Interfaces;

import java.io.IOException;

/**
 * Created by David on 1/23/17.
 */
public interface FileIOInterface {

    void setDirectoryPath ();

    void setFilePath ();

    void addToFile (String s) throws IOException;

    void displayFile () throws  IOException;

    void checkPath () throws IOException;

    void deleteFromFile (String s) throws IOException;

    void sortFile () throws IOException;
}
