package app.demo.com.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class Information extends AppCompatActivity {

    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        textView3 = (TextView) findViewById(R.id.textView3);

        // To read text file stored in asset

        String text = " ";
        try {
            InputStream is = getAssets().open("About.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        textView3.setText(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater =getMenuInflater();
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
        // if (id == R.id.profile_settings) {
        //   return true;
        //}
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){

            case R.id.profile_settings:
                Intent intent = new Intent(Information.this, app.demo.com.demo.AccDetails.class);
                startActivity(intent);
                return true;

            case R.id.information_settings:
                Intent ntent = new Intent(Information.this, app.demo.com.demo.Information.class);
                startActivity(ntent);
                return true;

            default: return false;
        }
}
}
