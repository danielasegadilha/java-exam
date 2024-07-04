package view;

import actions.UpdateContact;
import orm.model.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
public class UpdateContactView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the contact to update: ");
        Long contactId = scanner.nextLong();

        scanner.nextLine(); // Consumir a quebra de linha pendente após nextLong()

        // Instanciar o EntityManager e buscar o contato pelo ID
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contacts");
        EntityManager manager = factory.createEntityManager();

        Contact contact = manager.find(Contact.class, contactId);

        if (contact == null) {
            System.out.println("Contact with ID " + contactId + " not found.");
            manager.close();
            factory.close();
            return;
        }

        // Capturar novos dados do contato
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        contact.setName(newName);

        System.out.print("Enter new email: ");
        String newEmail = scanner.nextLine();
        contact.setEmail(newEmail);

        System.out.print("Enter new nationality: ");
        String newNationality = scanner.nextLine();
        contact.setNationality(newNationality);

        System.out.print("Enter new CPF: ");
        String newCpf = scanner.nextLine();
        contact.setCpf(newCpf);

        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();
        contact.setAddress(newAddress);

        // Fechar o scanner após o uso
        scanner.close();

        // Atualizar o contato
        UpdateContact updateContact = new UpdateContact();
        updateContact.update(contact);

        manager.close();
        factory.close();
    }
}
