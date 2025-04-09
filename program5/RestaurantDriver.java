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

    }
}
