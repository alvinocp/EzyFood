package com.hfad.binusezyfoody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Menu(View view){
        Intent menuIntent = new Intent(this, MenuActivity.class);
        startActivity(menuIntent);
    }

    public void TopUp(View view){
        Intent topUpIntent = new Intent(this, TopUpActivity.class);
        startActivity(topUpIntent);
    }

    public void MyOrder(View view){
        Intent myOrderIntent = new Intent(this, MyOrderActivity.class);
        startActivity(myOrderIntent);
    }

    public void Map(View view){
        Intent mapIntent = new Intent(this, MapActivity.class);
        startActivity(mapIntent);
    }
}