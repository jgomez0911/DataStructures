package program5;

public class Order {

    private BSTNode root;
    private String tableID;
    private static String restaurantName = "\nJ's Bar"; // Set your restaurant name here

    public Order(String tableID) {
        this.tableID = tableID;
        this.root = null; // Instantiate an empty binary search tree
    }

    // Insert a MenuItem into the BST
    public void insert(MenuItem m) {
        root = insertRec(root, m);
    }

    private BSTNode insertRec(BSTNode node, MenuItem m) {
        if (node == null) {
            return new BSTNode(m, null, null);
        }

        int comparison = m.getName().compareTo(node.getMenuItem().getName());
        if (comparison < 0) {
            node.setLeft(insertRec(node.getLeft(), m));
        } else if (comparison > 0) {
            node.setRight(insertRec(node.getRight(), m));
        } else {
            // If the item already exists, increment the quantity
            node.getMenuItem().setQuantity(node.getMenuItem().getQuantity() + m.getQuantity());
        }
        return node;
    }

    // Preorder traversal
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(BSTNode node) {
        if (node != null) {
            System.out.println(node.getMenuItem());
            preorderRec(node.getLeft());
            preorderRec(node.getRight());
        }
    }

    // Inorder traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(BSTNode node) {
        if (node != null) {
            inorderRec(node.getLeft());
            System.out.println(node.getMenuItem());
            inorderRec(node.getRight());
        }
    }

    // Postorder traversal
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(BSTNode node) {
        if (node != null) {
            postorderRec(node.getLeft());
            postorderRec(node.getRight());
            System.out.println(node.getMenuItem());
        }
    }

    // Get the size of the BST
    public int size() {
        return sizeRec(root);
    }

    private int sizeRec(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRec(node.getLeft()) + sizeRec(node.getRight());
    }

    // Get the height of the BST
    public int height() {
        return heightRec(root);
    }

    private int heightRec(BSTNode node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }
        return 1 + Math.max(heightRec(node.getLeft()), heightRec(node.getRight()));
    }

    // Get the total quantity of MenuItems
    public int getTotalQty() {
        return getTotalQtyRec(root);
    }

    private int getTotalQtyRec(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return node.getMenuItem().getQuantity() + getTotalQtyRec(node.getLeft()) + getTotalQtyRec(node.getRight());
    }

    // Search for a MenuItem by name
    public MenuItem search(String itemName) {
        return searchRec(root, itemName);
    }

    private MenuItem searchRec(BSTNode node, String itemName) {
        if (node == null) {
            return null; // Item not found
        }
        if (itemName.equals(node.getMenuItem().getName())) {
            return node.getMenuItem(); // Item found
        }
        if (itemName.compareTo(node.getMenuItem().getName()) < 0) {
            return searchRec(node.getLeft(), itemName);
        } else {
            return searchRec(node.getRight(), itemName);
        }
    }

    // Calculate total before tax and tip
    public double getTotalBeforeTaxAndTip() {
        return getTotalBeforeTaxAndTipRec(root);
    }

    private double getTotalBeforeTaxAndTipRec(BSTNode node) {
        if (node == null) {
            return 0.0;
        }
        return (node.getMenuItem().getPrice() * node.getMenuItem().getQuantity()) +
               getTotalBeforeTaxAndTipRec(node.getLeft()) +
               getTotalBeforeTaxAndTipRec(node.getRight());
    }

    // Calculate the tip amount
    public double getTip(double tipPct) {
        return getTotalBeforeTaxAndTip() * (tipPct / 100);
    }

    // Calculate the tax amount
    public double getTax(double taxPct) {
        return getTotalBeforeTaxAndTip() * (taxPct / 100);
    }

    // String representation of the Order
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s %s\n", restaurantName, tableID));
        result.append("-------------------------------------------\n");
        result.append(String.format("%-14s %-9s %-7s %-10s\n", "Item", "Price", "Qty", "Total"));
        result.append("-------------------------------------------\n");

        // Add menu items in a tabular format
        toStringRec(root, result);

        // Calculate totals
        double totalBeforeTax = getTotalBeforeTaxAndTip();
        double tax = getTax(8);
        double tip = getTip(20);
        double grandTotal = totalBeforeTax + tax + tip;

        // Add totals to the result
        result.append("-------------------------------------------\n");
        result.append(String.format("Total:\t\t$ %.2f\n", totalBeforeTax));
        result.append(String.format("Tax:\t\t$ %.2f\n", tax));
        result.append(String.format("Tip:\t\t$ %.2f\n", tip));
        result.append("-------------------------------------------\n");
        result.append(String.format("Grand total:\t$ %.2f\n", grandTotal));

        return result.toString();
    }

    private void toStringRec(BSTNode node, StringBuilder result) {
        if (node != null) {
            toStringRec(node.getLeft(), result);
            result.append(String.format("%-14s $%-9.2f %-7d $%-9.2f\n",
                node.getMenuItem().getName(),
                node.getMenuItem().getPrice(),
                node.getMenuItem().getQuantity(),
                node.getMenuItem().getPrice() * node.getMenuItem().getQuantity()));
            toStringRec(node.getRight(), result);
        }
    }
}