package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.owner.takeandgo.R;

public class CarActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
    }

    private Button AddCarButton;
    private Button RemoveCarButton;
    private Button UpdateCarButton;
    private Button showCarListButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-21 21:20:34 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        AddCarButton = (Button)findViewById( R.id.AddCarButton );
        RemoveCarButton = (Button)findViewById( R.id.RemoveCarButton );
        UpdateCarButton = (Button)findViewById( R.id.UpdateCarButton );
        showCarListButton = (Button)findViewById( R.id.showCarListButton );

        AddCarButton.setOnClickListener( this );
        RemoveCarButton.setOnClickListener( this );
        UpdateCarButton.setOnClickListener( this );
        showCarListButton.setOnClickListener( this );
    }

    private void AddCar() {
        Intent intent = new Intent(this,AddCarActivity.class);
        startActivity(intent);
    }

    private void ShowCarList() {
        Intent intent = new Intent(this,ShowCarListActivity.class);
        startActivity(intent);
    }
    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-21 21:20:34 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == AddCarButton ) {
            AddCar();// Handle clicks for AddCarButton
       // } else if ( v == RemoveCarButton ) {
            // Handle clicks for RemoveCarButton
       // } else if ( v == UpdateCarButton ) {
            // Handle clicks for UpdateCarButton
        } else if ( v == showCarListButton ) {
            ShowCarList(); // Handle clicks for showCarListButton
        }
    }

}
