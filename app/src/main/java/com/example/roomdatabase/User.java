package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class User {
    @NonNull
    @PrimaryKey
   public String Id;

    public String Name;

    public String Email;

    public User() {
    }

    public User(@NonNull String id, String name, String email) {
        this.Id = id;
        this.Name = name;
        this.Email = email;
    }

    @NonNull
    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setId(@NonNull String id) {
        this.Id = id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setEmail(String email) {
        this.Email = email;
    }
}
