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

}
