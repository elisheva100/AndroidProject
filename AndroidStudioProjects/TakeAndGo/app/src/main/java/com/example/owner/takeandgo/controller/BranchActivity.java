package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.owner.takeandgo.R;
//TODO
public class BranchActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);
    }

    private Button AddBranchButton;
    private Button RemoveBranchButton;
    private Button UpdateBranchButton;
    private Button showBranchListButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-21 21:21:23 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        AddBranchButton = (Button)findViewById( R.id.AddBranchButton );
        RemoveBranchButton = (Button)findViewById( R.id.RemoveBranchButton );
        UpdateBranchButton = (Button)findViewById( R.id.UpdateBranchButton );
        showBranchListButton = (Button)findViewById( R.id.showBranchListButton );

        AddBranchButton.setOnClickListener( this );
        RemoveBranchButton.setOnClickListener( this );
        UpdateBranchButton.setOnClickListener( this );
        showBranchListButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-21 21:21:23 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == AddBranchButton ) {
            // Handle clicks for AddBranchButton
        } else if ( v == RemoveBranchButton ) {
            // Handle clicks for RemoveBranchButton
        } else if ( v == UpdateBranchButton ) {
            // Handle clicks for UpdateBranchButton
        } else if ( v == showBranchListButton ) {
            // Handle clicks for showBranchListButton
        }
    }

}
