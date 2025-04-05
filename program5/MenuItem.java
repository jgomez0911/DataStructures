package program5;

class MenuItem {

    private String name;
    private double price;
    private int quantity;

    public MenuItem( MenuItem m, BSTNode l, BSTNode r ){
        name = m.name;
        l= null;
        r= null;
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


}