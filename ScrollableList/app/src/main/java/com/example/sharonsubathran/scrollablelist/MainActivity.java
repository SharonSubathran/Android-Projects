package com.example.sharonsubathran.scrollablelist;

import android.app.ActionBar;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    String[] countries = new String[] {
            "Australia",
            "Brazil",
            "India",
            "USA",
            "Canada",
            "Sri Lanka",
            "Wales",
            "Algeria",
            "France",
            "Germany",
            "England",
            "Portugal"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCountries = (ListView) findViewById(R.id.lvCountries);
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, countries);
       // getListView().setAdapter(adapter);
        lvCountries.setAdapter(adapter);

        lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener()) {

            public void onItemClick(AdapterView<?>) parent, View view, int position, long id); {
                Toast.makeText(getApplicationContext(), "Position:" + position + " - Item:" + countries[position], Toast.LENGTH_LONG).show();
            }



        };

    }
}
