package com.example.assesement4practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.assesement4practice.RoomDB.AppDatabase;
import com.example.assesement4practice.RoomDB.AppExecutors;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AppDatabase appDatabase;
    List<PersonModel> mList;
    EditText eName;
    PersonAdapter personAdapter;
    AppExecutors appExecutors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        eName = findViewById(R.id.editName);
        mList = new ArrayList<>();
        appDatabase = AppDatabase.getInstance(getApplicationContext());

    }

    public void queryData(View view) {
        appExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<PersonModel> persons = appDatabase.personDao().loadAllPerson();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        personAdapter = new PersonAdapter(MainActivity.this, persons);
                        recyclerView.setAdapter(personAdapter);
                    }
                });
            }
        });
    }

    public void submitData(View view) {
      appExecutors.getInstance().diskIO().execute(new Runnable() {
          @Override
          public void run() {
              String name = eName.getText().toString();
              PersonModel person = new PersonModel(name);
              appDatabase.personDao().insertPerson(person);
          }
      });



    }
}
