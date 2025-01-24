package week1;
import java.util.ArrayList;

public class Hw1 {

    public static int[] oddAndEven( int[] scores ){
        int even = 0;
        int odd = 0;
        int result[] = new int[2];

        for( int i=0;i<scores.length;i++){
            if( scores[i] % 2 == 0 ){
                even++;
            }
            else {
                odd++;
            }
        }

        result[0] = odd;
        result[1] = even;

        return result;
    }

    public static boolean containsX( int[] scores, int x ){
        for (int score: scores){
            if (score == x){
                return true;
            }
        }
        return  false;
    }

    public static void main(String[] args) {

        int scores[] = {10, 40, -10, 50, 70, 65, 54, 23, 82 };

        //System.out.println(Arrays.toString(oddAndEven(scores)));

        containsX(scores, -10);
    }

    public class Point{
        private double x;
        private double y;

        public Point(){
            this.x = 0;
            this.y = 0;
        }

        public Point(double x,double y){
            this.x = x;
            this.y = y;
        }

        public Point(Point p){
            this.x = p.x;
            this.y = p.y;
        }

        public double getX(){
            return this.x;
        }

        public double getY(){
            return this.y;
        }

        public void setX(double x){
           this.x = x;
        }

        public void setY(double y){
           this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            // Check if the object is the same instance
            if (this == o) return true;

            // Check if the object is null or not an instance of Point
            if (o == null || getClass() != o.getClass()) return false;

            // Cast to Point and compare fields
            Point point = (Point) o;

            // Use a small epsilon value for double comparison
            double epsilon = 1e-10; // Adjust this value as needed
            return Math.abs(x - point.x) < epsilon && Math.abs(y - point.y) < epsilon;
        }

        @Override
        public int hashCode() {
            // Use a prime number to generate a hash code
            long xBits = Double.doubleToLongBits(x);
            long yBits = Double.doubleToLongBits(y);
            return 31 * Long.hashCode(xBits) + Long.hashCode(yBits);
        }

        @Override
        public String toString(){
            return "(" + this.x + "," + this.y + ")";
        }
    }

    public class Line{

        private Point start;
        private Point end;

        public Line(Point start,Point end){
            this.start = start;
            this.end = end;
        }

        public Point getStart(){
            return this.start;
        }

        public Point getEnd(){
            return this.end;
        }

        public void setStart(Point start){
            this.start = start;
        }

        public void setEnd(Point end){
            this.end = end;
        }

        public double length(){
           return Math.sqrt(Math.pow(end.x-start.x,2)+ Math.pow(end.y-start.y,2));
        }

        public Point midPoint(){
            return new Point((start.x + end.x) / 2,(start.y + end.y)/2);
        }

        public Line longestLine( Line[] lineArray ){
            Line longest = new Line(new Point(0.0,0.0), new Point(0.0,0.0));
            for (Line line: lineArray){
                if (line.length() > longest.length()){
                    longest = line;
                }
            }
            return longest;
        }

        public void deleteOriginLines( Line[] lineArray ){
            start = new Point(0.0,0.0);
            end = new Point(0.0,0.0);

            for (Line line: lineArray){
                if (line.getStart().equals(start) || line.getEnd().equals(end)){
                    line = null;
                }
            }
        }

        public Line longestLine(ArrayList<Line> lineList) {

           //Collections.sort(lineList);
            return lineList.get(lineList.size() - 1);
        }

        public void deleteOriginLines(ArrayList<Line> lineList) {
            start = new Point(0.0, 0.0);
            end = new Point(0.0, 0.0);

            lineList.removeIf(line -> line.getStart().equals(start) || line.getEnd().equals(end));
        }
    }
}