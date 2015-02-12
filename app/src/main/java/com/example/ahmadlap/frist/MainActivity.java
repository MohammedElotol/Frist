package com.example.ahmadlap.frist;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);

        editText= (EditText) this.findViewById(R.id.editText2);


    }

    public void saveInternal(View view) {
        try {
            FileOutputStream fos = new FileOutputStream(this.getFilesDir().getPath().toString()+"/myfile.txt");
            OutputStreamWriter osr = new OutputStreamWriter(fos);
            PrintWriter pr = new PrintWriter(osr);
            pr.write(editText.getText().toString());
            pr.close();
            editText.setText("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void loadInternal(View view) {
        try {
            File file = new File(this.getFilesDir().getPath().toString() + "/myfile.txt");
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr= new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                String txt="", temp=null;
                while ((temp=br.readLine()) !=null){
                    txt+=temp;
                }
                br.close();
                editText.setText("");

            }


        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public void saveExternal(View view){

    }
    public void loadExternal(View view){

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
