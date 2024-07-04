package actions;

import orm.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteContact {
    public static void main(String[] args) {
        //1. Conectar ao operador do ORM/JPA
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        //2. Buscar o objeto a ser excluido
        Contact contact = new Contact();
        contact.setId(1L);
        contact = manager.find(Contact.class, contact.getId());

        //3. Operar com "remove"
        manager.getTransaction().begin();
        manager.remove(contact);
        manager.getTransaction().commit();

        System.out.println("Tarefa excluida!");

        manager.close();
        factory.close();
    }
}