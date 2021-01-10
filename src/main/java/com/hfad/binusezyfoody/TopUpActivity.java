package com.hfad.binusezyfoody;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TopUpActivity extends AppCompatActivity {


    DatabaseHelper mDatabaseHelper;
    Integer balance = 1;
    private Button btnTopUp;
    private EditText editText;
    private TextView balanceText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        editText = (EditText) findViewById(R.id.amount);
        balanceText = (TextView) findViewById(R.id.balance);
        btnTopUp = (Button) findViewById(R.id.topup);
        mDatabaseHelper = new DatabaseHelper(this);
        Cursor data = mDatabaseHelper.getData();
        balanceText.setText(data.toString());

        btnTopUp.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                int newBalance = Integer.parseInt(newEntry);
                if (editText.length() != 0){
                    balance += newBalance;
                    AddData(balance);
                    editText.setText("");
                    balanceText.setText(balance.toString());

                }else{
                    toastMessage("Input false");

                }
            }
        });

    }



    public void AddData(int newEntry){
        boolean insertData = mDatabaseHelper.addData(newEntry);
        if (insertData){
            toastMessage("TopUp Succesfully Inserted");

        }else{
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
