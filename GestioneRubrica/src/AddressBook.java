import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    private Contact createNewContact(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Phone: ");
        String phone = scanner.next();
        System.out.print("Enter Address: ");
        String address = scanner.next();
        System.out.println("Contact added successfully!");
        return new Contact(name, phone, address);
    }
    public void visualizeMenu() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        while (true) {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    contacts.add(createNewContact(scanner));
                    break;

                case 2:
                    // View Contacts
                    System.out.println("\n--- Contact List ---");
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        for (int i = 0; i < contacts.size(); i++) {
                            System.out.println((i + 1) + ". " + contacts.get(i));
                        }
                    }
                    break;

                case 3:
                    // Edit Contact
                    System.out.print("Enter the number of the contact to edit: ");
                    String phoneToEdit = scanner.next();
                    Contact paolo = null;
                    int i;
                    for (i = 0; i < contacts.size(); i++) {
                        if (contacts.get(i).phone.equals(phoneToEdit)) {
                            paolo = contacts.get(i);
                        }
                    }
                    if (paolo != null) {
                        System.out.print("Enter New Name: ");
                        String newName = scanner.next();
                        System.out.print("Enter New Phone: ");
                        String newPhone = scanner.next();
                        System.out.print("Enter New Address: ");
                        String newAddress = scanner.next();
                        contacts.set(i - 1, new Contact(newName, newPhone, newAddress));
                        System.out.print("Contact updated successfully!");
                    } else {
                        System.out.println("Invalid contact number.");
                    }
                    break;

                case 4:
                    // Delete Contact
                    System.out.print("Enter the number of the contact to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume the newline
                    if (deleteIndex >= 0 && deleteIndex < contacts.size()) {
                        contacts.remove(deleteIndex);
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Invalid contact number.");
                    }
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting Address Book. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}



