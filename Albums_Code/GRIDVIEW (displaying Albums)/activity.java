package com.example.weirdo.photosexporting;
 
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
 
public class GridViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        GridView gridview = (GridView) findViewById(R.id.gridview);

        //Here i should pass the album names array i fetched albumName
        final String[] albumName = null;
 
        ArrayAdapter<String> ad = new ArrayAdapter<String>(
                getApplicationContext(), android.R.layout.simple_list_item_1,
                albumName);
       
        gridview.setNumColumns(2);
        gridview.setGravity(Gravity.CENTER);
        gridview.setAdapter(ad);
 
        gridview.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
            // Here i should fetch the images and display them 
                Toast.makeText(getApplicationContext(), "" + arg2,
                        Toast.LENGTH_SHORT).show();
            }
        });
 
    }
}