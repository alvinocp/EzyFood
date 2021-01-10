package com.hfad.binusezyfoody;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyOrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter orderAdapter;
    RecyclerView.LayoutManager layoutManager;

    String[] programNameList={"Air Mineral","Just Apel", "Jus Mangga", "Jus Alpukat", "Jus Jeruk", "Es Campur"};
    String[] programDescriptionList = {"Rp. 2000","Rp. 8000","Rp. 10000", "Rp. 12000", "Rp. 7000", "Rp. 16000"};
    int[] programImages = {R.drawable.mineral, R.drawable.apel, R.drawable.mangga, R.drawable.alpukat, R.drawable.jeruk, R.drawable.escampur};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorder);

        recyclerView = findViewById(R.id.rvMyOrder);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager( this);
        recyclerView.setLayoutManager(layoutManager);
        orderAdapter = new MyOrderAdapter(this, programNameList, programDescriptionList, programImages);
        recyclerView.setAdapter(orderAdapter);

    }

    public void Pay(View view){
        Intent Pay = new Intent(this, ReceiptActivity.class);
        startActivity(Pay);
    }
}
