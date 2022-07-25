package com.example.assesement4practice.RoomDB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.assesement4practice.PersonModel;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM PersonModel ORDER BY ID")
    List<PersonModel> loadAllPerson();
    @Insert
    void insertPerson(PersonModel personModel);
}
