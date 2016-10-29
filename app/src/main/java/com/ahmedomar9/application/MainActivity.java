package com.ahmedomar9.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    //Defining android ListView
    ListView mListView;

    //Elements that will be displayed in android ListView
    String[] Countries = new String[]{"India", "Australia", "Newzealand",
            "Indonesia", "China", "Russia", "Japan", "South Korea"};

    //Ids of flag Images that are placed in res> drawable folder. They return the int value
    int[] FlagId = new int[]{R.drawable.flag_a, R.drawable.flag_b,
            R.drawable.flag_c,R.drawable.flag_d,
            R.drawable.flag_e, R.drawable.flag_f,R.drawable.flag_g,
            R.drawable.flag_h};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);

        //Declaring Array adapter
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Countries);

        //Setting the android ListView's adapter to the newly created adapter
        mListView.setAdapter(countryAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //The position where the list item is clicked is obtained from the
                //the parameter position of the android listview
                int itemPosition = position;

                //Get the String value of the item where the user clicked
                String itemValue = (String) mListView.getItemAtPosition(position);

                //In order to start displaying new activity we need an intent
                Intent intent = new Intent(getApplicationContext(),CountryActivity.class);

                //Putting the Id of image as an extra in intent
                intent.putExtra("flag",FlagId[position]);

                //Here we will pass the previously created intent as parameter
                startActivity(intent);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
