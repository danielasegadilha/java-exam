package actions;

import orm.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateContact {
    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.setId(2L);
        contact.setDescricao("Estudar Java ate o fim");
        contact.setFinalizada(false);
        contact.setDataFinalizacao(null);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.merge(contact);
        manager.getTransaction().commit();

        System.out.println("Alteração concluída");

        manager.close();
        factory.close();
    }
}