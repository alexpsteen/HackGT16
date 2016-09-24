package com.example.alexsteen.hackgt16;

/**
 * Created by ericachia on 9/24/16.
 */

public class User {

    private String name;
    private String username;
    private String password;
    private int age;
    private int weight;
    private double height;
    private boolean isConsultant;

    public User(String name, String username, String password, int age, int weight, double height, boolean isConsultant) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.isConsultant = isConsultant;
    }

    public String getName(){
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public boolean getIsConsultant() {
        return isConsultant;
    }
}
