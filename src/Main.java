import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Contact> contactList = new ArrayList<>();

        System.out.println("-----------------------------");
        System.out.println("Welcome to the contact list");

        DisplayMenu(scanner, contactList);
    }

    static void DisplayMenu(Scanner scanner, List<Contact> contactList ){
        boolean showMenu = true;

        while (showMenu){
            ShowMenuOptions();
            int numberSelected = scanner.nextInt();
            scanner.nextLine();

            switch (numberSelected){
                case 1:
                    ShowAllContacts(contactList);
                    break;
                case 2:
                    AddContact(scanner, contactList);
                    break;
                case 3:
                    SearchContactByName(scanner, contactList);
                    break;
                case 4:
                    DeleteContact(scanner, contactList);
                    break;
                case 5:
                    showMenu = false;
                    break;
            }
        }
    }

    static void ShowMenuOptions(){
        System.out.println("Chose an option:");
        System.out.println("1. Show all contacts");
        System.out.println("2. Add new contact");
        System.out.println("3. Search contact by name");
        System.out.println("4. Delete contact");
        System.out.println("5. Exit program");
    }

    static void ShowAllContacts(List<Contact> contactList){

        System.out.println("Full contacts list: ");
        for (Contact contact: contactList){
            System.out.println(contact.showInfo());
        }

        System.out.print("\n");

    }

    static void AddContact(Scanner scanner, List<Contact> contactList){
        System.out.println("Enter the information of the contact");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone number: ");
        String phoneNumber = scanner.nextLine();

        Contact newContact = new Contact(name, email, phoneNumber);
        contactList.add(newContact);

        System.out.println("Contact added\n");

    }

    static void SearchContactByName(Scanner scanner, List<Contact> contactList){
        System.out.println("Enter the name of the contact: ");

        System.out.print("Name: ");
        String contactName = scanner.nextLine();

        boolean contactFound = false;
        for (Contact contact: contactList){
            if (contact.getName().contains(contactName)){
                if (!contactFound){
                    System.out.println("Contact found: ");
                }
                System.out.println(contact.showInfo());
                contactFound = true;
            }
        }
        System.out.print("\n");
        if (contactFound) return;
        System.out.println("Contact not found");
    }

    static void DeleteContact(Scanner scanner, List<Contact> contactList){
        System.out.println("What contact you wish to delete?: ");

        int i = 1;
        for (Contact contact: contactList){
            System.out.printf("%d. %s%n", i, contact.getName());
            i++;
        }

        int contactIndex = scanner.nextInt() - 1;
        if (contactList.get(contactIndex) != null){
            contactList.remove(contactIndex);
            System.out.println("Contact deleted\n");
        }

    }

}