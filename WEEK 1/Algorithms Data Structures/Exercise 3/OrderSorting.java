import java.util.Arrays;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int id, String name, double price) {
        this.orderId = id;
        this.customerName = name;
        this.totalPrice = price;
    }
}

public class OrderSorting {
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j + 1].totalPrice < orders[j].totalPrice) {
                    // Swap orders[j] and orders[j+1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                // swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // swap orders[i+1] and orders[high]
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Customer A", 100.0),
            new Order(2, "Customer B", 250.0),
            new Order(3, "Customer C", 50.0)
        };

        // Bubble Sort
        bubbleSort(orders);
        System.out.println("Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order.orderId + " " + order.customerName + " " + order.totalPrice);
        }

        // Quick Sort
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nQuick Sort:");
        for (Order order : orders) {
            System.out.println(order.orderId + " " + order.customerName + " " + order.totalPrice);
        }
    }
}
