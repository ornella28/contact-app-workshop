package se.lexicon.view;

import se.lexicon.model.Contact;

import java.util.List;
import java.util.Scanner;

public class ContactView {

    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu(){
        System.out.println("=== Contact Management System ===");
        System.out.println("1. View All Contacts");
        System.out.println("2. Add New Contact");
        System.out.println("3. Search Contact by Name");
        System.out.println("4. Exit");
        System.out.print("Please select an option (1-4): ");
    }

    // Additional methods for user interaction can be added here
    //Get user input

    public String getUserInput(String prompt){//method to get user input
        System.out.print(prompt);
        return scanner.nextLine();
    }

    //display contacts

    public void displayContacts(List<Contact> contacts){
        if (contacts ==null || contacts.isEmpty()){
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("--- Contact List ---");
        for (Contact contact : contacts){
            System.out.println(contact);
        }
    }

    //display message
    public void displayMessage(String message){
        System.out.println(message);
    }
}
