package com.example.alexsteen.hackgt16;

import java.util.LinkedList;

/**
 * Created by Alex Steen on 9/24/2016.
 */
public class Elist {
    private String name;
    private LinkedList<exerciseEntry> exercises;
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

    public LinkedList<exerciseEntry> getElist() {
        return exercises;
    }

    public String toString() {
        return name;
    }
}
