import java.util.ArrayList;
import java.util.Scanner;

class Item {
    int id;
    String name;
    int quantity;
    String location;

    Item(int id, String name, int quantity, String location) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }
}

public class SmartWarehouse {

    static ArrayList<Item> warehouse = new ArrayList<>();

    public static void addItem(int id, String name, int quantity, String location) {
        warehouse.add(new Item(id, name, quantity, location));
        System.out.println("Item Added Successfully!");
    }

    public static void searchItem(int id) {
        for (Item item : warehouse) {
            if (item.id == id) {
                System.out.println("Item Found!");
                System.out.println("ID: " + item.id);
                System.out.println("Name: " + item.name);
                System.out.println("Quantity: " + item.quantity);
                System.out.println("Location: " + item.location);
                return;
            }
        }
        System.out.println("Item Not Found!");
    }

    public static void updateItem(int id, int newQuantity) {
        for (Item item : warehouse) {
            if (item.id == id) {
                item.quantity = newQuantity;
                System.out.println("Item Updated Successfully!");
                return;
            }
        }
        System.out.println("Item Not Found!");
    }

    public static void deleteItem(int id) {
        for (Item item : warehouse) {
            if (item.id == id) {
                warehouse.remove(item);
                System.out.println("Item Deleted Successfully!");
                return;
            }
        }
        System.out.println("Item Not Found!");
    }

    public static void displayAll() {
        if (warehouse.isEmpty()) {
            System.out.println("Warehouse Empty!");
            return;
        }

        System.out.println("\n===== Warehouse Items =====");
        for (Item item : warehouse) {
            System.out.println(
                "ID: " + item.id +
                " | Name: " + item.name +
                " | Qty: " + item.quantity +
                " | Location: " + item.location
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Smart Warehouse Grid Locator =====");
            System.out.println("1. Add Item");
            System.out.println("2. Search Item");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Display All");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Location (e.g. A1): ");
                    String location = sc.nextLine();

                    addItem(id, name, qty, location);
                    break;

                case 2:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();

                    searchItem(id);
                    break;

                case 3:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();

                    updateItem(id, newQty);
                    break;

                case 4:
                    System.out.print("Enter Item ID: ");
                    id = sc.nextInt();

                    deleteItem(id);
                    break;

                case 5:
                    displayAll();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}