package com.example.alexsteen.hackgt16;

import java.util.LinkedList;

/**
 * Created by Alex Steen on 9/24/2016.
 */
public class Elist {
    private String name;
    private LinkedList<String> exercises;
    private static int total_num_lists = 0;

    public Elist(String name) {
        total_num_lists++;
        this.name = name;
        exercises = new LinkedList<>();
    }

    public Elist() {
        this("Exercises" + total_num_lists);
    }

    public void changeName(String newName) {
        name = newName;
    }

    public LinkedList<String> getElist() {
        return exercises;
    }


}
