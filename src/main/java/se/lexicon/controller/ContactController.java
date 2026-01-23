package se.lexicon.controller;

import se.lexicon.data.ContactDAO;
import se.lexicon.exception.ContactStorageEsception;
import se.lexicon.exception.DuplicateContactException;
import se.lexicon.model.Contact;
import se.lexicon.view.ContactView;

import java.util.List;

public class ContactController {

    private final ContactDAO contactDAO;// dependency
    private final ContactView contactView;// dependency

    // Constructor

    public ContactController(ContactDAO contactDAO, ContactView contactView) {
        this.contactDAO = contactDAO;
        this.contactView = contactView;
    }

    public void run(){
        boolean running = true;

        while (running){// keeps the application running until user decides to exit
            contactView.displayMenu();

            String choice = contactView.getUserInput("");// get user input

            try {
                switch (choice){
                    case "1"-> listAllContacts();
                    case "2" -> addContact();
                    case "3" -> findContactByName();
                    case "4" -> running = false;
                    default -> contactView.displayMessage("Invalid option. Please select a valid option (1-4).");
                }
            } catch (ContactStorageEsception e){
                contactView.displayMessage("Storage error:" + e.getMessage());
            }catch (DuplicateContactException e){
                contactView.displayMessage("Duplicate contact error: " + e.getMessage());
            }catch (IllegalArgumentException e){// handle invalid input
                contactView.displayMessage("Input error: " + e.getMessage());
            }
        }
        contactView.displayMessage("Goodbye!");
    }

    private void listAllContacts() throws ContactStorageEsception {
        List<Contact> contacts = contactDAO.findAll();
        contactView.displayContacts(contacts);
    }

    private void findContactByName() throws ContactStorageEsception{
        String name = contactView.getUserInput("Enter contact name to search: ").trim();
        Contact foundContact = contactDAO.findByName(name);

        if (foundContact == null){
            contactView.displayMessage("Contact with name " + name + " not found.");
        } else {
            contactView.displayMessage("Contact found: " + foundContact);
        }
    }

    private void addContact() throws ContactStorageEsception, DuplicateContactException {
        String name = contactView.getUserInput("Enter contact name: ").trim();
        String phone = contactView.getUserInput("Enter contact phone: ").trim();

        Contact newContact = new Contact(name, phone);
        contactDAO.save(newContact);
        contactView.displayMessage("Contact added successfully: " + newContact);

    }




}
