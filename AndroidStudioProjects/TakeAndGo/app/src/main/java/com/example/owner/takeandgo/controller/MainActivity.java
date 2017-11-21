package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.owner.takeandgo.R;



public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private Button CarButton;
    private Button BranchButton;
    private Button CarModelButton;
    private Button ClientButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-21 20:13:22 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        CarButton = (Button)findViewById( R.id.CarButton );
        BranchButton = (Button)findViewById( R.id.BranchButton );
        CarModelButton = (Button)findViewById( R.id.CarModelButton );
        ClientButton = (Button)findViewById( R.id.ClientButton );

        CarButton.setOnClickListener(this);
        BranchButton.setOnClickListener( this );
        CarModelButton.setOnClickListener( this );
        ClientButton.setOnClickListener( this );
    }

    private void Car() {
        Intent intent = new Intent(this,AddLecturerActivity.class);
        startActivity(intent);
    }
    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-21 20:13:22 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == CarButton ) {
            // Handle clicks for CarButton
        } else if ( v == BranchButton ) {
            // Handle clicks for BranchButton
        } else if ( v == CarModelButton ) {
            // Handle clicks for CarModelButton
        } else if ( v == ClientButton ) {
            // Handle clicks for ClientButton
        }
    }

}
