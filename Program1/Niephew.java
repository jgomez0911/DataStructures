package Program1;

public class Niephew extends Children{
    private String name = "";
    private int age = 0;
    private boolean male = false;

    public Niephew(){}

    public Niephew(String n,int a, boolean b){
        this.name= n;
        this.age = a;
        this.male = b;
    }

    @Override
    public String toString(){
        return "Niephew" + " name='" + name + ", age=" + age + ", male=" + male;
    }

    public boolean equals(Niephew b){
        if (this.equals(b)){
            return this.male == b.male;
        }
        return false;
    }
}