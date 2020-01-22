package com.example.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public long insertUser(User user);



    @Query("SELECT * FROM User order by id")
    public List<User> getUsers();

    @Update
    public void updateUser(User user);

    @Delete
    public void deleteUser(User user);



}
