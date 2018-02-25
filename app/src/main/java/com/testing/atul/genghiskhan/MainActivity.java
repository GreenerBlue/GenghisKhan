package com.testing.atul.genghiskhan;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase base;
    EditText box;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper helper = new DBHelper(this,"feeds",null,1);
        base = helper.getWritableDatabase();
        box = findViewById(R.id.box1);
    }

    public void insDB(View v){
        ContentValues cv = new ContentValues();
        cv.put("title",box.getText().toString());
        base.insert("drums",null,cv);
        Toast.makeText(this,"Inserted values!",Toast.LENGTH_SHORT).show();
        box.setText("");
    }
}
