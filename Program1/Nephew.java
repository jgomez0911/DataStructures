package Program1;

public class Nephew extends Children{
    private String name = "";
    private int age = 0;
    private boolean male = false;

    public Nephew(){}

    public Nephew(String n,int a, boolean b){
        this.name= n;
        this.age = a;
        this.male = b;
    }

    @Override
    public String toString(){
        return "Niephew" + " name='" + name + ", age=" + age + ", male=" + male;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Check base class equality
        if (!(obj instanceof Nephew)) return false;
        Nephew other = (Nephew) obj;
        return this.male == other.male;
    }
}