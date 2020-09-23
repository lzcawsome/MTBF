package com.example.signaldetect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SinalChangeActivity extends AppCompatActivity {
    ArrayList<ChangeBean> arrayList = new ArrayList<>();
    RecyclerView recyclerView;
    ChangeAdapter changeAdapter;
    private Cursor cursor;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinal_change);
        DatabaseHelper dbHelper = new DatabaseHelper(SinalChangeActivity.this, "log_db", null, 1);
        db = dbHelper.getWritableDatabase();
        innitview();
    }

    private void innitview() {
        LoadDatafromDatabase();
        recyclerView = findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        changeAdapter = new ChangeAdapter(arrayList, this);
        recyclerView.setAdapter(changeAdapter);

    }


    // TODO: 2020/9/24 从数据库中填充数据进arrylsit
    public void LoadDatafromDatabase() {
        cursor = db.query(DatabaseHelper.TB_NAME, null, null, null, null, null, "_id ASC");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String id = cursor.getString(0);
            String time = cursor.getString(1);
            String sim = cursor.getString(2);
            String type = cursor.getString(3);
            ChangeBean changeBean = new ChangeBean(time, sim, type);
            arrayList.add(changeBean);
            cursor.moveToNext();
        }
        cursor.close();
    }

}