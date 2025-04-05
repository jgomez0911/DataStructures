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

    public boolean equals(MenuItem m){

    }

    public int compareTo(MenuItem m){

    }

    public String toString(){

    }
}