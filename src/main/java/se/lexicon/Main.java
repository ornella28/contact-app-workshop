package se.lexicon;

import se.lexicon.model.Contact;

public class Main {

    public static void main(String[] args) {

        try {
            Contact contact1 = new Contact("Alice", "1234567890");
            System.out.println("Contact created successfully"+ contact1);
        }catch (IllegalArgumentException e){
            System.err.println("Error"+ e.getMessage());
        }

        try{
            Contact contact2 = new Contact("", "");//will throw exception

        }catch (IllegalArgumentException e){
            System.err.println("Contact could not be saved!"+ e.getMessage());
        }

        try{
            Contact contact3 = new Contact(null, null);//will throw exception

        }catch (IllegalArgumentException e){
            System.err.println("Contact could not be saved!"+ e.getMessage());
        }

        try {
            Contact contact4 = new Contact("0", "0");//will throw exception

        } catch (IllegalArgumentException e) {
            System.err.println("Contact could not be saved!" + e.getMessage());
        }






    }
}
