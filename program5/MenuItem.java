package program5;

class MenuItem {

    private String name;
    private double price;
    private int quantity;

    public MenuItem( String name, double price, int quantity ){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if the same object
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class type
        MenuItem menuItem = (MenuItem) obj; // Cast to MenuItem
        return Double.compare(menuItem.price, price) == 0 && // Compare prices
                    name.equals(menuItem.name); // Compare names
    }

    public int compareTo(MenuItem m) {
    int nameComparison = this.name.compareTo(m.name);
    if (nameComparison != 0) {
        return nameComparison; // Compare by name first
    }
    // If names are equal, compare by price
    return Double.compare(this.price, m.price);
}

    @Override
    public String toString() {
        return String.format("%-14s $%-9.2f %-7d  $%-9.2f", name, price, quantity,(price*quantity));
    }
}