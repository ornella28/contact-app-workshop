package se.lexicon.controller;

import se.lexicon.data.ContactDAO;
import se.lexicon.data.FileContactDAOImpl;
import se.lexicon.view.ContactView;

public class Main {

    public static void main(String[] args) {

        ContactDAO contactDAO = new FileContactDAOImpl();
        ContactView contactView = new ContactView();
        ContactController contactController = new ContactController(contactDAO, contactView);

        contactController.run();

    }
}
