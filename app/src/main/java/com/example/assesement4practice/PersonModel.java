package com.example.assesement4practice;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "PersonModel")
public class PersonModel {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    private String name;


    public PersonModel(String name ,int ID) {
        this.name = name;
        this.ID = ID;
    }
    @Ignore
    public PersonModel(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
