package view;

import actions.SearchContact;
import orm.model.Contact;
import java.util.Scanner;

import java.util.List;

public class SearchContactByLetterView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial letter of the contact names to search: ");
        String initialLetter = scanner.nextLine().toUpperCase(); // Converte para maiúsculas para padronização

        SearchContact searchContact = new SearchContact();
        List<Contact> contacts = searchContact.getContactsByLetter(initialLetter);

        if (contacts.isEmpty()) {
            System.out.println("No contacts found starting with the letter '" + initialLetter + "'.");
        } else {
            System.out.println("Contacts starting with the letter '" + initialLetter + "':");

            for (Contact contact : contacts) {
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
        scanner.close();
    }
}
