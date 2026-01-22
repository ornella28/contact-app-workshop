package se.lexicon.data;

import se.lexicon.exception.ContactStorageEsception;
import se.lexicon.model.Contact;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        System.out.println("List of contacts: " + Path.of("contacts.txt").toAbsolutePath());//print absolute path of contacts file


        ContactDAO dao = new FileContactDAOImpl();//Using FileContactDAOImpl

        //1. Test: read all contacts
        try {
            List<Contact> contacts = dao.findAll();
            System.out.println("-----All Contacts-----");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }catch (ContactStorageEsception e){
            System.err.println("Error reading contacts: " + e.getMessage());
            return;
        }

        //test find contact by name
        try {
            String searchName = "Alice";
            Contact foundContact = dao.findByName(searchName);

            System.out.println("----------Find by name----------");
            if (foundContact != null) {
                System.out.println("Contact found: " + foundContact);
            } else {
                System.out.println("Contact with name " + searchName + " not found.");
            }
        } catch (ContactStorageEsception e) {
            System.err.println("Error finding contact: " + e.getMessage());
        }
        try {
            String searchName = "Anna Andersson";
            Contact foundContact = dao.findByName(searchName);

            System.out.println("----------Find by name----------");
            if (foundContact != null) {
                System.out.println("Contact found: " + foundContact);
            } else {
                System.out.println("Contact with name " + searchName + " not found.");
            }
        } catch (ContactStorageEsception e) {
            System.err.println("Error finding contact: " + e.getMessage());
        }
    }



}
