package com.kaustubh.rubrics;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Course_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        DatabaseHelper db = new DatabaseHelper(this);

        db.open();
        Cursor cursor = db.showcourselist();
        startManagingCursor(cursor);
        String[] ar = new String[]{DatabaseHelper.COLUMN_CONAME};
        int[] name = new int[]{R.id.cours};

        SimpleCursorAdapter myadapter =
                new SimpleCursorAdapter(
                        this,
                        R.layout.display_courses,
                        cursor,
                        ar,
                        name,
                        0
                );
        ListView ll = (ListView)findViewById(R.id.courselist);
        ll.setAdapter(myadapter);
        // db.close();

        ll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.cours);
                //  String list = (ll.getItemAtPosition(position));
                String text = textView.getText().toString();
                // Toast.makeText(getApplicationContext(), "Class "+text  , Toast.LENGTH_LONG).show();
                // System.out.println("Choosen Country = : " + list);
              //  Intent i = new Intent(getApplicationContext(), Showclass.class);
                //i.putExtra("text",text);
                // Toast.makeText(getApplicationContext(), "Id is "+pid , Toast.LENGTH_LONG).show();
               // startActivity(i);

            }});
    }
}
