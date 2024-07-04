package view;

import orm.model.Contact;
import actions.SearchContact;

import java.util.List;

public class SearchContactView {
    public static void main(String[] args) {

        SearchContact searchContact = new SearchContact();
        List<Contact> allContacts = searchContact.getAllContacts();

        for (Contact contact : allContacts) {
            System.out.println("ID: " + contact.getId());
            System.out.println("Name: " + contact.getName());
            System.out.println("Email: " + contact.getEmail());
            System.out.println("CPF: " + contact.getCpf());
            System.out.println("Birth Date: " + contact.getBirthDate());
            System.out.println("Nationality: " + contact.getNationality());
            System.out.println("Address: " + contact.getAddress());
            System.out.println("-----------------------------------");
        }
    }
}
