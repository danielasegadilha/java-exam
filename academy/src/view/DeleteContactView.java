package view;

import actions.DeleteContact;

import java.util.Scanner;

public class DeleteContactView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter ID of the contact to delete: ");
        Long contactId = scanner.nextLong();

        scanner.close();

        DeleteContact deleteContact = new DeleteContact();
        deleteContact.delete(contactId);
    }
}
