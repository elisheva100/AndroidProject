package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.owner.takeandgo.R;

public class AddCarModelActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);
    }
    private EditText CodeEditText;
    private EditText ModelNameEditText;
    private EditText CompanyNameEditText;
    private EditText EngineCApicityEditText;
    private TextView gearboxTextView;
    private Spinner gearboxSpinner;
    private EditText SeatsEditText;
    private TextView colorTextView;
    private Spinner colorSpinner;
    private Button addClientButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-29 01:22:58 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        CodeEditText = (EditText)findViewById( R.id.CodeEditText );
        ModelNameEditText = (EditText)findViewById( R.id.ModelNameEditText );
        CompanyNameEditText = (EditText)findViewById( R.id.CompanyNameEditText );
        EngineCApicityEditText = (EditText)findViewById( R.id.EngineCApicityEditText );
        gearboxTextView = (TextView)findViewById( R.id.gearboxTextView );
        gearboxSpinner = (Spinner)findViewById( R.id.gearboxSpinner );
        SeatsEditText = (EditText)findViewById( R.id.SeatsEditText );
        colorTextView = (TextView)findViewById( R.id.colorTextView );
        colorSpinner = (Spinner)findViewById( R.id.colorSpinner );
        addClientButton = (Button)findViewById( R.id.addClientButton );

        addClientButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-29 01:22:58 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addClientButton ) {
            // Handle clicks for addClientButton
        }
    }

}
