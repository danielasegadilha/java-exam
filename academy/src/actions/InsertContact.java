package actions;

        import orm.model.Contact;
        import orm.model.Tarefa;

        import javax.persistence.EntityManager;
        import javax.persistence.EntityManagerFactory;
        import javax.persistence.Persistence;
        import java.util.Calendar;

public class InsertContact {
    public static void main(String[] args) {
        //1. Instanciar e preencher os dados do JavaBeans
        Contact contact = new Contact();
        contact.setDescricao("Estudar Java");
        contact.setFinalizada(false);
        contact.setDataFinalizacao(Calendar.getInstance());

        //2. Conectar ao operador do ORM/JPA
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        // 3. Executar a operação
        manager.getTransaction().begin();
        //O "C" do CRUD é dado pelo método "persist" de Hibernate
        manager.persist(contact);
        manager.getTransaction().commit();

        System.out.print("Tarefa inserida, ID: " + contact.getId());

        manager.close();
        factory.close();
    }
}