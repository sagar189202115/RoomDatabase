package com.example.roomdatabase;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class home extends AppCompatActivity {
    MyDatabase myDatabase;
    EditText name, id, email;
    Button submit,fetch,update,delete;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        update = findViewById(R.id.updatedata);
        delete = findViewById(R.id.delete);
        id = findViewById(R.id.id);
        myDatabase = MyDatabase.getMyDatabase(this);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = id.getText().toString();
                String userName = name.getText().toString();
                String userEmail = email.getText().toString();


                user = new User(userId, userName, userEmail);

                Executor executor = Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {

                            myDatabase.getDao().insertUser(user);


                    }
                });
            }
        });
        fetch = findViewById(R.id.fetch);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this, Fetch.class));
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = id.getText().toString();
                String userName = name.getText().toString();
                String userEmail = email.getText().toString();


                user = new User(userId, userName, userEmail);
                Executor executor = Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {

                        myDatabase.getDao().deleteUser(user);
                    }
                });
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = id.getText().toString();
                String userName = name.getText().toString();
                String userEmail = email.getText().toString();


                user = new User(userId, userName, userEmail);
                Executor executor = Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {

                        myDatabase.getDao().updateUser(user);
                    }
                });

            }
        });


    }
}

