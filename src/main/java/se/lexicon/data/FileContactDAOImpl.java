package se.lexicon.data;

import se.lexicon.exception.ContactStorageEsception;
import se.lexicon.model.Contact;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileContactDAOImpl implements ContactDAO{
    private final Path filePath = Path.of("dir/contacts.txt");// this is the path to the file where contacts will be stored



    //override methods here

   //override methods here to find all contacts from file
    @Override
    public List<Contact> findAll() throws ContactStorageEsception{// read all contacts from file and return as list
        List<Contact> contacts = new ArrayList<>();// create empty list to store contacts
        try(BufferedReader reader = Files.newBufferedReader(filePath)){// create buffered reader to read file
            String line;// variable to store each line
            while((line = reader.readLine()) != null){// read each line until end of file
                line = line.trim();//trim whitespace
                if(!line.isEmpty())
                    continue;
                    String [] parts = line.split(",");// split contact line by comma
                    if(parts.length != 2){// check if line has two parts
                        throw new ContactStorageEsception("Invalid contact format in file: " + line);

                    }
                    try {
                        Contact contact = new Contact(parts[0].trim(), parts[1].trim());// create contact object
                        contacts.add(contact);// add contact to list
                    }catch (IllegalArgumentException e){
                        throw new ContactStorageEsception("Invalid contact data in file: " + line + ". Error: " + e.getMessage());
                    }



            }
            return contacts;// return list of contacts
        }catch (IOException e){
            throw new ContactStorageEsception("Error reading contacts from file: " + e.getMessage());
        }
    }

    //override method to find contact by name
    @Override
    public Contact findByName(String name) throws ContactStorageEsception {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        for (Contact contact : findAll()){// iterate through all contacts
            if (contact.getName().equalsIgnoreCase(name.trim())){// check if name matches
                return contact;// return contact if found
            }

        }
        return null;// return null if not found

    }

    //Override method to save contact to file
    @Override






}
