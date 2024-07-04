package actions;

import orm.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateContact {
    public void update(Contact contact) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.merge(contact);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }
}