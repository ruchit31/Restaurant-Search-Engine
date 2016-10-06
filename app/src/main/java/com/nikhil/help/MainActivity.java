package com.nikhil.help;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText msearchTerm;
    private EditText msearchLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msearchTerm = (EditText) findViewById(R.id.search_term);
        msearchLocation = (EditText) findViewById(R.id.search_location);
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

    public void search(View view)
    {
        String searchTerm = msearchTerm.getText().toString();
        String searchLocation = msearchLocation.getText().toString();

        Intent intent =new Intent(this, YelpSearchListActivity.class);
        intent.setData(new Uri.Builder().appendQueryParameter("term",searchTerm)
                .appendQueryParameter("location",searchLocation).build());
        startActivity(intent);
    }
}
