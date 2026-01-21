package se.lexicon.data;

import se.lexicon.exception.ContactStorageEsception;
import se.lexicon.model.Contact;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileContactDAOImpl implements ContactDAO{
    private final Path filePath;// this is the path to the file where contacts will be stored

  // Constructor
    public FileContactDAOImpl(Path filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("filePath cannot be null");

        }
        this.filePath = filePath;
    }

    //override methods here

   //helper methods here to ensure file existence
    private void ensureFileExistence() throws ContactStorageEsception {
        try{
            if (Files.notExists(filePath)){// check if file does not exist
                Path parentDir = filePath.getParent();// get parent directory
                if (parentDir != null){// check if parent directory is not null
                    Files.createDirectories(parentDir);// create parent directories if they do not exist
                }
                Files.createFile(filePath);// create the file
            }
        }catch (IOException e){
            throw new ContactStorageEsception("Failed to create storage file at: "+ filePath);// wrap IOException in ContactStorageEsception

        }
    }



}
