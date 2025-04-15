package program5;

public class RestaurantDriver {

    public static void main(String[] args) {
        // Create two orders
        Order order1 = new Order("Table 1");
        Order order2 = new Order("Table 2");

        // Create 15 menu items
        MenuItem[] menuItems = new MenuItem[]{
            new MenuItem("Pasta", 12.99, 1),
            new MenuItem("Burger", 8.99, 2),
            new MenuItem("Salad", 7.99, 1),
            new MenuItem("Steak", 19.99, 1),
            new MenuItem("Fries", 3.99, 3),
            new MenuItem("Soda", 1.99, 5),
            new MenuItem("Pizza", 11.99, 1),
            new MenuItem("Tacos", 9.99, 2),
            new MenuItem("Ice Cream", 4.99, 2),
            new MenuItem("Wings", 10.99, 1),
            new MenuItem("Nachos", 6.99, 1),
            new MenuItem("Soup", 5.99, 2),
            new MenuItem("Breadsticks", 3.49, 1),
            new MenuItem("Cheesecake", 5.49, 1),
            new MenuItem("Coffee", 2.49, 4)
        };

        // Add menu items to the first order in a specific order
        order1.insert(menuItems[0]); // Pasta
        order1.insert(menuItems[1]); // Burger
        order1.insert(menuItems[2]); // Salad
        order1.insert(menuItems[3]); // Steak
        order1.insert(menuItems[4]); // Fries
        order1.insert(menuItems[5]); // Soda
        order1.insert(menuItems[6]); // Pizza
        order1.insert(menuItems[7]); // Tacos
        order1.insert(menuItems[8]); // Ice Cream
        order1.insert(menuItems[9]); // Wings
        order1.insert(menuItems[10]); // Nachos
        order1.insert(menuItems[11]); // Soup
        order1.insert(menuItems[12]); // Breadsticks
        order1.insert(menuItems[13]); // Cheesecake
        order1.insert(menuItems[14]); // Coffee

        // Add menu items to the second order in a different order
        order2.insert(menuItems[1]); // Burger
        order2.insert(menuItems[3]); // Steak
        order2.insert(menuItems[0]); // Pasta
        order2.insert(menuItems[5]); // Soda
        order2.insert(menuItems[4]); // Fries
        order2.insert(menuItems[8]); // Ice Cream
        order2.insert(menuItems[2]); // Salad
        order2.insert(menuItems[6]); // Pizza
        order2.insert(menuItems[7]); // Tacos
        order2.insert(menuItems[9]); // Wings
        order2.insert(menuItems[10]); // Nachos
        order2.insert(menuItems[11]); // Soup
        order2.insert(menuItems[12]); // Breadsticks
        order2.insert(menuItems[13]); // Cheesecake
        order2.insert(menuItems[14]); // Coffee

        // Test all methods of the Order class for order1
        System.out.println("Order 1:");
        System.out.println("Size: " + order1.size());
        System.out.println("Height: " + order1.height());
        System.out.println("Total Quantity: " + order1.getTotalQty());
        System.out.println("Total Before Tax and Tip: " + order1.getTotalBeforeTaxAndTip());
        System.out.println("Tax (8%): " + order1.getTax(8));
        System.out.println("Tip (20%): " + order1.getTip(20));
        System.out.println("Searching for 'Pizza': \n" + order1.search("Pizza"));
        System.out.println("\nPreorder Traversal:");
        order1.preorder();
        System.out.println("\nInorder Traversal:");
        order1.inorder();
        System.out.println("\nPostorder Traversal:");
        order1.postorder();
        System.out.println(order1.toString());

        // Test all methods of the Order class for order2
        System.out.println("\nOrder 2:");
        System.out.println("Size: " + order2.size());
        System.out.println("Height: " + order2.height());
        System.out.println("Total Quantity: " + order2.getTotalQty());
        System.out.println("Total Before Tax and Tip: " + order2.getTotalBeforeTaxAndTip());
        System.out.println("Tax (8%): " + order2.getTax(8));
        System.out.println("Tip (20%): " + order2.getTip(20));
        System.out.println("Searching for 'Tacos': \n" + order2.search("Tacos"));
        System.out.println("\nPreorder Traversal:");
        order2.preorder();
        System.out.println("\nInorder Traversal:");
        order2.inorder();
        System.out.println("\nPostorder Traversal:");
        order2.postorder();
        System.out.println(order2.toString());
    }
}