import java.util.HashMap;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int id, String name, int qty, double price) {
        this.productId = id;
        this.productName = name;
        this.quantity = qty;
        this.price = price;
    }
}

class Inventory {
    HashMap<Integer, Product> products;

    Inventory() {
        products = new HashMap<>();
    }

    void addProduct(Product product) {
        products.put(product.productId, product);
    }

    void updateProduct(int productId, int newQuantity, double newPrice) {
        Product product = products.get(productId);
        if (product != null) {
            product.quantity = newQuantity;
            product.price = newPrice;
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void deleteProduct(int productId) {
        if (products.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    void displayInventory() {
        System.out.println("Product ID\tProduct Name\tQuantity\tPrice");
        for (Product product : products.values()) {
            System.out.println(product.productId + "\t\t" + product.productName + "\t\t" + product.quantity + "\t\t" + product.price);
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice;
        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display Inventory");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();   
                    inventory.addProduct(new Product(id, name, quantity, price));
                    break;
                case 2:
                    System.out.print("Enter product ID to update: ");
                    id = scanner.nextInt();
                    System.out.print("Enter new quantity: ");
                    quantity = scanner.nextInt();
                    System.out.print("Enter new price: ");
                    price = scanner.nextDouble();
                    inventory.updateProduct(id, quantity, price);
                    break;
                case 3:
                    System.out.print("Enter product ID to delete: ");
                    id = scanner.nextInt();
                    inventory.deleteProduct(id);
                    break;
                case 4:
                    inventory.displayInventory();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}
