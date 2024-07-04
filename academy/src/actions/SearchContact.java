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

        String sql = "SELECT * FROM contacts";
        Query query = manager.createNativeQuery(sql, Contact.class);

        List<Contact> listContacts = query.getResultList();

        manager.close();
        factory.close();

        return listContacts;
    }

    public List<Contact> getContactsByLetter(String initialLetter) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        String sql = "SELECT * FROM contacts WHERE SUBSTRING(name, 1, 1) = :param";
        Query query = manager.createNativeQuery(sql, Contact.class);
        query.setParameter("param", initialLetter);

        List<Contact> listContacts = query.getResultList();

        manager.close();
        factory.close();

        return listContacts;
    }
}
