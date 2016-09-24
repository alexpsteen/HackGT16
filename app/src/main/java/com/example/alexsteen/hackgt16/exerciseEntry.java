package com.example.alexsteen.hackgt16;

/**
 * Created by Alex Steen on 9/24/2016.
 */
public class exerciseEntry {
    public String name;
    private int num_sets;
    private int num_reps;

    //this is a change
    public exerciseEntry(String name, int sets, int reps) {
        this.name = name;
        num_sets = sets;
        num_reps = reps;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public void changeSets(int num) {
        num_sets = num;
    }

    public void changeReps(int reps) {
        num_reps = reps;
    }

    public String getName() {
        return name;
    }

    public int getReps() {
        return num_reps;
    }

    public int getSets() {
        return num_sets;
    }

}
