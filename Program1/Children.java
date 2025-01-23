package Program1;

public class Children {

    private String name;
    private int age;

    public Children(){
        this.name = "";
        this.age = 0;
    }

    public Children(String name, int age){
        this.name = name;
        this.age = age;
    }
    // getters
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
    // setters
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public boolean equals(Children o){
        return this.name.equalsIgnoreCase(o.getName()) && this.age == o.getAge();
    }

    @Override
    public String toString(){
        return "Name: " + this.name + ", Age: " + this.age;
    }
}