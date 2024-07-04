package actions;

import orm.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteContact {

    public void delete(Long contactId) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        Contact contact = manager.find(Contact.class, contactId);

        if (contact != null) {
            manager.remove(contact);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

}