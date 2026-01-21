package se.lexicon.data;

import se.lexicon.exception.ContactStorageEsception;
import se.lexicon.exception.DuplicateContactException;
import se.lexicon.model.Contact;

import java.util.List;

public interface ContactDAO {

    List<Contact> findAll() throws ContactStorageEsception;
    void save (Contact contact) throws ContactStorageEsception, DuplicateContactException;
    Contact findByName(String name) throws ContactStorageEsception;
}
