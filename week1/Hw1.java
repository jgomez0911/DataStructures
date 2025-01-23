package week1;

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

        public double getX(){
            return this.x;
        }

        public double getY(){
            return this.y;
        }

        public double setX(double x){
           return this.x = x;
        }

        public double setY(double y){
           return this.y = y;
        }

        @Override
        public String toString(){
            return "(" + this.x + "," + this.y + ")";
        }

    }
}