package view;

import actions.InsertContact;
import orm.model.Contact;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class InsertContactView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter nationality: ");
        String nationality = scanner.nextLine();

        System.out.print("Enter CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        System.out.print("Enter birth date (dd/MM/yyyy): ");
        String birthDateStr = scanner.nextLine();

        scanner.close();

        Calendar birthDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            java.util.Date date = sdf.parse(birthDateStr);
            birthDate = Calendar.getInstance();
            birthDate.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace(); // Tratar o erro de formatação de data
            return; // Saída em caso de erro
        }

        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setNationality(nationality);
        contact.setCpf(cpf);
        contact.setAddress(address);
        contact.setBirthDate(birthDate);

        // Chamar método para inserir o contato no banco de dados usando InsertContact
        InsertContact insertContact = new InsertContact();
        insertContact.insert(contact);
    }
}
