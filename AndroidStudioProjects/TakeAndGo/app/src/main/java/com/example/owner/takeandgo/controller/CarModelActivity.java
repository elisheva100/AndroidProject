package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.owner.takeandgo.R;
//TODO
public class CarModelActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_model);
    }

    private Button AddCarModelButton;
    private Button RemoveCarModelButton;
    private Button UpdateCarModelButton;
    private Button showCarModelListButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-21 21:20:01 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        AddCarModelButton = (Button)findViewById( R.id.AddCarModelButton );
        RemoveCarModelButton = (Button)findViewById( R.id.RemoveCarModelButton );
        UpdateCarModelButton = (Button)findViewById( R.id.UpdateCarModelButton );
        showCarModelListButton = (Button)findViewById( R.id.showCarModelListButton );

        AddCarModelButton.setOnClickListener( this );
        RemoveCarModelButton.setOnClickListener( this );
        UpdateCarModelButton.setOnClickListener( this );
        showCarModelListButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-21 21:20:01 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == AddCarModelButton ) {
            // Handle clicks for AddCarModelButton
        } else if ( v == RemoveCarModelButton ) {
            // Handle clicks for RemoveCarModelButton
        } else if ( v == UpdateCarModelButton ) {
            // Handle clicks for UpdateCarModelButton
        } else if ( v == showCarModelListButton ) {
            // Handle clicks for showCarModelListButton
        }
    }

}
