public class Hw0 {

    public static void main(String[] args) {


        double[] prices;
        prices = new double[50];
        prices[2] = 13.99;

        double sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > 10) {
                sum += prices[i];
            }
        }
        System.out.println(sum);


        Car[] dealerCars = new Car[40];

        dealerCars[0] = new Car("123", "black");
        dealerCars[1] = new Car("456", "blue");
        dealerCars[2] = new Car("789", "red");

        // Move all index up by one
        // Car temp = dealerCars[dealerCars.length - 1];
        for (int i = dealerCars.length - 1; i > 0; i--) {
            dealerCars[i] = dealerCars[i - 1];
        }
        dealerCars[0] = new Car("988","pink");

        // Print VIN of each car
        for (Car car : dealerCars) {
            if (car != null) {
                System.out.println("VIN: " + car.getVin()+ "  Color: "+ car.getColor());
            }
        }
    }

    public static class Car {

        private String vin;
        private String color;

        public Car() {
            vin = "";
        }

        public Car(String vin, String color) {
            this.vin = vin;
            this.color = color;
        }

        public String getVin() {
            return vin;
        }

        public String getColor() {
            return color;
        }

        public Boolean isEqual(Car obj) {
            return obj.getVin().equals(this.vin);
        }
    }
}