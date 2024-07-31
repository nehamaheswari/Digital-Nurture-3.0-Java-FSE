import java.util.Arrays;

class Product {
    int productId;
    String productName;
    String category;

    Product(int id, String name, String category) {
        this.productId = id;
        this.productName = name;
        this.category = category;
    }
}

public class Search {
    public static int linearSearch(Product[] products, String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equals(productName)) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    public static int binarySearch(Product[] products, String productName) {
        Arrays.sort(products, (p1, p2) -> p1.productName.compareTo(p2.productName)); // Ensure products are sorted
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].productName.compareTo(productName);
            if (comparison == 0) {
                return mid; // Found
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Product A", "Category 1"),
            new Product(2, "Product B", "Category 2"),
            new Product(3, "Product C", "Category 1")
        };

        // Example usage:
        String productNameToSearch = "Product B";

        // Linear search
        int index = linearSearch(products, productNameToSearch);
        if (index != -1) {
            System.out.println("Product found at index: " + index);
        } else {
            System.out.println("Product not found using linear search");
        }

        // Binary search (requires sorted array)
        index = binarySearch(products, productNameToSearch);
        if (index != -1) {
            System.out.println("Product found at index: " + index);
        } else {
            System.out.println("Product not found using binary search");
        }
    }
}
