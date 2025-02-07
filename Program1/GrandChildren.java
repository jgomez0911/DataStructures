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

    public boolean equals(GrandChildren g){
        if (this.equals(g)){
            return this.generation == g.generation;
        }
        return false;
    }

    @Override
    public String toString(){
        return "GrandChildren" +" name= " + name +", age=" + age +", generation= " + generation;
    }
}
