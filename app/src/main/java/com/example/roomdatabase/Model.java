package com.example.roomdatabase;

public class Model {
    String name,id,email;

       public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Model(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
}
