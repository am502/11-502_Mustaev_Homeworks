package ru.itis.inform;
public class Human {
    private int age;
    private String name;
    public Human(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return getAge() + " " + getName() + " ";
    }
}
