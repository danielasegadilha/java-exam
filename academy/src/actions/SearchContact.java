package actions;

import orm.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class SearchContact {
    public static void main(String[] ARGS) {
        //1. Conectar ao operador do ORM/JPA
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        String sql = "Select t from Tarefa as t where t.finalizada = :paramfinalizada";

        //JPQL: classe Query de "javax.persistence"
        Query query = manager.createQuery(sql);
        query.setParameter("paramFinalizado", true);

        List<Contact> listaTarefas = query.getResultList();

        for(Contact contact: listaTarefas) {
            System.out.println(contact.getDescricao());
        }

        manager.close();
        factory.close();
    }
}
