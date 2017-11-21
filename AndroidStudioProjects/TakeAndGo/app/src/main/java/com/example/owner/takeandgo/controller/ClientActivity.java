package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.owner.takeandgo.R;
//TODO
public class ClientActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
    }

    private Button AddClientButton;
    private Button RemoveClientButton;
    private Button UpdateClientButton;
    private Button showClientListButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-21 21:18:13 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        AddClientButton = (Button)findViewById( R.id.AddClientButton );
        RemoveClientButton = (Button)findViewById( R.id.RemoveClientButton );
        UpdateClientButton = (Button)findViewById( R.id.UpdateClientButton );
        showClientListButton = (Button)findViewById( R.id.showClientListButton );

        AddClientButton.setOnClickListener( this );
        RemoveClientButton.setOnClickListener( this );
        UpdateClientButton.setOnClickListener( this );
        showClientListButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-21 21:18:13 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == AddClientButton ) {
            // Handle clicks for AddClientButton
        } else if ( v == RemoveClientButton ) {
            // Handle clicks for RemoveClientButton
        } else if ( v == UpdateClientButton ) {
            // Handle clicks for UpdateClientButton
        } else if ( v == showClientListButton ) {
            // Handle clicks for showClientListButton
        }
    }


}
