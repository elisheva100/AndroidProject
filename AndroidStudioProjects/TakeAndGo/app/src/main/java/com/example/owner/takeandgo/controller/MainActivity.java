package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.owner.takeandgo.R;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setLogo(R.mipmap.my_car);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private Button AddCarButton;
    private Button AddBranchButton;
    private Button AddCarModelButton;
    private Button AddClientButton;
    private Button showCarListButton;
    private Button showBranchListButton;
    private Button showCarModelListButton;
    private Button showClientListButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-12-02 20:56:37 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        AddCarButton = (Button)findViewById( R.id.AddCarButton );
        AddBranchButton = (Button)findViewById( R.id.AddBranchButton );
        AddCarModelButton = (Button)findViewById( R.id.AddCarModelButton );
        AddClientButton = (Button)findViewById( R.id.AddClientButton );
        showCarListButton = (Button)findViewById( R.id.showCarListButton );
        showBranchListButton = (Button)findViewById( R.id.showBranchListButton );
        showCarModelListButton = (Button)findViewById( R.id.showCarModelListButton );
        showClientListButton = (Button)findViewById( R.id.showClientListButton );

        AddCarButton.setOnClickListener( this );
        AddBranchButton.setOnClickListener( this );
        AddCarModelButton.setOnClickListener( this );
        AddClientButton.setOnClickListener( this );
        showCarListButton.setOnClickListener( this );
        showBranchListButton.setOnClickListener( this );
        showCarModelListButton.setOnClickListener( this );
        showClientListButton.setOnClickListener( this );
    }

    private void AddCar() {
        Intent intent = new Intent(this,AddCarActivity.class);
        startActivity(intent);
    }

    private void AddBranch() {
        Intent intent = new Intent(this,AddBranchActivity.class);
        startActivity(intent);
    }

    private void AddCarModel() {
        Intent intent = new Intent(this,AddCarModelActivity.class);
        startActivity(intent);
    }

    private void AddClient() {
        Intent intent = new Intent(this,AddClientActivity.class);
        startActivity(intent);
    }

    private void showCarList() {
        Intent intent = new Intent(this,ShowCarListActivity.class);
        startActivity(intent);
    }

    private void showBranchList() {
        Intent intent = new Intent(this,ShowBranchListActivity.class);
        startActivity(intent);
    }

    private void showCarModelList() {
        Intent intent = new Intent(this,ShowCarModelListActivity.class);
        startActivity(intent);
    }

    private void showClientList() {
        Intent intent = new Intent(this,ShowClientListActivity.class);
        startActivity(intent);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-12-02 20:56:37 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == AddCarButton ) {
            AddCar();// Handle clicks for AddCarButton
        } else if ( v == AddBranchButton ) {
            AddBranch();// Handle clicks for AddBranchButton
        } else if ( v == AddCarModelButton ) {
            AddCarModel();// Handle clicks for AddCarModelButton
        } else if ( v == AddClientButton ) {
            AddClient();// Handle clicks for AddClientButton
        } else if ( v == showCarListButton ) {
            showCarList();// Handle clicks for showCarListButton
        } else if ( v == showBranchListButton ) {
            showBranchList();// Handle clicks for showBranchListButton
        } else if ( v == showCarModelListButton ) {
            showCarModelList();// Handle clicks for showCarModelListButton
        } else if ( v == showClientListButton ) {
            showClientList();// Handle clicks for showClientListButton
        }
    }
}


