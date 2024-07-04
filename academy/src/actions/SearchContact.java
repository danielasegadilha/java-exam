package actions;

import orm.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class SearchContact {
    public List<Contact> getAllContacts() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        String jpql = "SELECT c FROM Contact c";
        Query query = manager.createQuery(jpql);

        List<Contact> listContacts = query.getResultList();

        manager.close();
        factory.close();

        return listContacts;
    }

    public List<Contact> getContactsByLetter() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        String jpql = "SELECT c FROM CONTACTS WHERE NAME IS LIKE ?";
        Query query = manager.createQuery(jpql);

        List<Contact> listContacts = query.getResultList();

        manager.close();
        factory.close();

        return listContacts;
    }
}
