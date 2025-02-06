package week2;

public class Hw2 {

    public class Shape{

        private String color;

        public Shape(String color){
            this.color = color;
        }

        public String getColor(){
            return color;
        }

        public double getArea(){
            //this method should be implemented in the subclass
            throw new UnsupportedOperationException();
        }

        public String compareTo(Shape other) {
            double result = Double.compare(this.getArea(), other.getArea());
            if (result == 0){
                return "Both shapes have the same area";
            }
            else if (result < 0){
                return "This shape has a smaller area than the other shape";
            }
            else {
                return "This shape has a larger area than the other shape";
            }
        }
    }

    public class Circle extends Shape{

        private  int radius;

        public Circle(String color,int radius){
            super(color);
            this.radius = radius;
        }

        public double getRadius(){
            return this.radius;
        }

        @Override
        public double getArea(){
            return Math.PI*Math.pow(radius, 2);
        }

        @Override
        public String toString(){
            return "Circle, color = " + getColor() + ", radius = " + radius;
        }

    }

    public class Rectangle extends Shape{
        private int width;
        private int length;

        public Rectangle(String color, int width, int length){
            super(color);
            this.width = width;
            this.length = length;
        }

        public int getLenght(){
            return length;
        }

        public int getWidth(){
            return width;
        }

        @Override
        public double getArea(){
            return width*length;
        }

        @Override
        public String toString(){
            return "Rectangle, color = " + getColor() + ", length = " + length + ", width = " + width;
        }

    }

    public class shapeTest{
        public static void main(String[] args) {

            Shape[] myShapes = new Shape[4];
            myShapes[0] = new Circle("red", 5);
            myShapes[1] = new Rectangle("blue", 4, 5);
            myShapes[2] = new Circle("green", 3);
            myShapes[3] = new Rectangle("yellow", 6, 7);

            System.out.println(findLargestShape(myShapes).toString());
        }

        public static Shape findLargestShape( Shape[] myShapes ){
            Shape largestShape = myShapes[0];
            for (int i = 0; i < myShapes.length; i++) {
                if (myShapes[i].getArea() > largestShape.getArea()) {
                    largestShape = myShapes[i];
                }
            }
            return largestShape;
        }
    }
}