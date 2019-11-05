package com.michelle.shop;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText ed_Name;
    private EditText ed_Password;
    private ImageView result1;
    private ImageView result2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ed_Name = findViewById(R.id.name);
        ed_Password = findViewById(R.id.password);
        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void enter(View view){
        int name_size = ed_Name.length();
        int password_size = ed_Password.length();
        result1.setAlpha(1.0f);
        result2.setAlpha(1.0f);
        result1.setVisibility(View.VISIBLE);
        result2.setVisibility(View.VISIBLE);
        if(name_size >= 3 && password_size >= 5){//登入成功
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("登入成功 ! !")
                    .setMessage("歡迎 !")
                    .setPositiveButton("OK",null)
                    .show();
            result1.setImageResource(R.drawable.check);
            result2.setImageResource(R.drawable.check);
        }
        else if(name_size < 3 && password_size >= 5){//名字需3個字以上
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("登入失敗 !")
                    .setMessage("名字需3個字以上 !")
                    .setPositiveButton("OK",null)
                    .show();
            result1.setImageResource(R.drawable.x);
            result2.setImageResource(R.drawable.check);
        }
        else if(name_size >= 3 && password_size < 5){//密碼需五個字以上
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("登入失敗 !")
                    .setMessage("密碼需五個字以上!")
                    .setPositiveButton("OK",null)
                    .show();
            result1.setImageResource(R.drawable.check);
            result2.setImageResource(R.drawable.x);
        }
        else{//名字需3個字以上，密碼需5個字以上
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("登入失敗 !")
                    .setMessage("名字需3個字以上，密碼需5個字以上!")
                    .setPositiveButton("OK",null)
                    .show();
            result1.setImageResource(R.drawable.x);
            result2.setImageResource(R.drawable.x);
        }
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
