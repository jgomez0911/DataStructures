package Program1;

public class GrandChildren extends Children{
    private String name = "";
    private int age = 0;
    private int generation = 0;

    public GrandChildren(){}

    public GrandChildren(String s, int age, int g){
        this.name = s;
        this.age = age;
        this.generation = g;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Check base class equality
        if (!(obj instanceof GrandChildren)) return false;
        GrandChildren other = (GrandChildren) obj;
        return this.generation == other.generation;
    }


    @Override
    public String toString(){
        return "GrandChildren" +" name= " + name +", age=" + age +", generation= " + generation;
    }
}
