package actions;

import orm.model.Contact;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsertContact {
    public void insert(Contact contact) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(contact);
        manager.getTransaction().commit();

        System.out.println("Contact created, ID: " + contact.getId());

        manager.close();
        factory.close();
    }
}