
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.rest.models.Bill;
import com.rest.models.Order;
import com.rest.models.menu;
import com.rest.repo.MenuRepo;
import com.rest.services.BillService;
import com.rest.services.MenuService;
import com.rest.services.OrderSrvice;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MenuService menuService = new MenuService();
        OrderSrvice orderService = new OrderSrvice();
        BillService billService = new BillService();

        while (true) {
            System.out.println("\n===== RESTAURANT MANAGEMENT SYSTEM =====");
            System.out.println("1. View Menu");
            System.out.println("2. View Orders");
            System.out.println("3. Add Order");
            System.out.println("4. Update Order Status");
            System.out.println("5. Remove Order");
            System.out.println("6. Create Bill");
            System.out.println("7. View All Bills");
            System.out.println("8. Search Bill by ID");
            System.out.println("9. Remove Bill");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- MENU ---");
                    menuService.getAll().forEach(System.out::println);
                    break;

                case 2:
                    System.out.println("\n--- ORDERS ---");
                    orderService.getAll().forEach(System.out::println);
                    break;

                case 3: {
                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();

                    List<menu> items = new ArrayList<>();
                    items.add(new menu(1, "Pizza", 10.99, menu.Type.FOOD));
                    items.add(new menu(2, "Burger", 5.99, menu.Type.FOOD));
                    items.add(new menu(3, "Pasta", 12.99, menu.Type.FOOD));

                    int newId = 1;
                    for (Order o : orderService.getAll()) {
                        if (o.getId() >= newId) {
                            newId = o.getId() + 1;
                        }
                    }

                    Order newOrder = new Order(newId, customerName, items);
                    System.out.println(orderService.addOrder(newOrder));
                    break;
                }

                case 4: {
                    System.out.print("Enter order ID: ");
                    int orderId = sc.nextInt();

                    Order order = orderService.getOrderById(orderId);

                    if (order == null) {
                        System.out.println("Order not found.");
                        break;
                    }

                    System.out.println("1. PENDING");
                    System.out.println("2. CONFIRMED");
                    System.out.println("3. CANCELLED");
                    System.out.print("Choose new status: ");

                    int statusChoice = sc.nextInt();

                    if (statusChoice >= 1 && statusChoice <= 3) {
                        Order.Status status =
                                Order.Status.values()[statusChoice - 1];

                        System.out.println(
                                orderService.updateOrderStatus(orderId, status)
                        );
                    } else {
                        System.out.println("Invalid status choice.");
                    }
                    break;
                }

                case 5: {
                    System.out.print("Enter order ID to remove: ");
                    int orderId = sc.nextInt();
                    boolean removed = orderService.getAll()
                        .removeIf(order -> order.getId() == orderId);
                    System.out.println(removed ? "Order removed successfully."
                        : "Order not found.");
                    break;
                }

                case 6: {
                    sc.nextLine();

                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();

                    System.out.print("Enter bill ID: ");
                    int billId = sc.nextInt();

                    System.out.print("Enter total price: ");
                    double totalPrice = sc.nextDouble();

                    Bill bill = new Bill(billId, customerName, totalPrice);
                    System.out.println(billService.addBill(bill));
                    break;
                }

                case 7:
                    System.out.println("\n--- ALL BILLS ---");

                    if (billService.getAllBills().isEmpty()) {
                        System.out.println("No bills available.");
                    } else {
                        billService.getAllBills().forEach(System.out::println);
                    }
                    break;

                case 8: {
                    System.out.print("Enter bill ID to search: ");
                    int billId = sc.nextInt();

                    Bill bill = billService.getBillById(billId);

                    if (bill != null) {
                        System.out.println(bill);
                    } else {
                        System.out.println("Bill not found.");
                    }
                    break;
                }

                case 9: {
                    System.out.print("Enter bill ID to remove: ");
                    int billId = sc.nextInt();
                    System.out.println(billService.removeBill(billId));
                    break;
                }

                case 10:
                    System.out.println("Thank you for using the Restaurant Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
