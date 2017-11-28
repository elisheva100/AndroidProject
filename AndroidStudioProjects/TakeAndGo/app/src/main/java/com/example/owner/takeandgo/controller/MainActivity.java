package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.owner.takeandgo.R;



public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private Button CarButton;
    private Button BranchButton;
    private Button CarModelButton;
    private Button ClientButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     */
    private void findViews() {
        CarButton = (Button)findViewById( R.id.CarButton );
        BranchButton = (Button)findViewById( R.id.BranchButton );
        CarModelButton = (Button)findViewById( R.id.CarModelButton );
        ClientButton = (Button)findViewById( R.id.ClientButton );

        CarButton.setOnClickListener(this);
        BranchButton.setOnClickListener(this);
        CarModelButton.setOnClickListener(this);
        ClientButton.setOnClickListener(this);
    }

    private void Car() {
        Intent intent = new Intent(this,CarActivity.class);
        startActivity(intent);
    }

    private void Branch() {
        Intent intent = new Intent(this,BranchActivity.class);
        startActivity(intent);
    }

    private void CarModel() {
        Intent intent = new Intent(this,CarModelActivity.class);
        startActivity(intent);
    }

    private void Client() {
        Intent intent = new Intent(this,ClientActivity.class);
        startActivity(intent);
    }
    /**
     * Handle button click events<br />
     * <br />
     */
    @Override
    public void onClick(View v) {
        if ( v == CarButton ) {
            Car() ;// Handle clicks for CarButton
        } else if ( v == BranchButton ) {
            Branch(); // Handle clicks for BranchButton
        } else if ( v == CarModelButton ) {
            CarModel(); // Handle clicks for CarModelButton
        } else if ( v == ClientButton ) {
            Client(); // Handle clicks for ClientButton
        }
    }
}
