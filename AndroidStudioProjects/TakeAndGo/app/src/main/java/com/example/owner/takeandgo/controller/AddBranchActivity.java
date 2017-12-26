package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.AgencyConsts;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;

import static com.example.owner.takeandgo.controller.Legal.isNum;
import static com.example.owner.takeandgo.controller.Legal.isString;

public class AddBranchActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);
        findViews();
    }

    private EditText StreetNumberEditText;
    private EditText StreetEditText;
    private EditText CityEditText;
    private EditText ParkingEditText;
    private EditText BranchNumberEditText;
    private Button addBranchButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-12-06 20:55:55 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        StreetNumberEditText = (EditText)findViewById( R.id.StreetNumberEditText );
        StreetEditText = (EditText)findViewById( R.id.StreetEditText );
        CityEditText = (EditText)findViewById( R.id.CityEditText );
        ParkingEditText = (EditText)findViewById( R.id.ParkingEditText );
        BranchNumberEditText = (EditText)findViewById( R.id.BranchNumberEditText );
        addBranchButton = (Button)findViewById( R.id.addBranchButton );

        addBranchButton.setOnClickListener(this);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-12-06 20:55:55 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addBranchButton ) {
            addBranch();
            StreetNumberEditText.getText().clear();
             StreetEditText.getText().clear();
            CityEditText.getText().clear();
             ParkingEditText.getText().clear();
             BranchNumberEditText.getText().clear();
        }
    }

    private void addBranch() {
        final ContentValues contentValues = new ContentValues();
        String strExepetion = "";//String for concatenation all the exceptions.
        try {
        if(isNum(BranchNumberEditText.getText().toString())) {
            int number = Integer.parseInt((this.BranchNumberEditText.getText().toString()));
            contentValues.put(AgencyConsts.BranchConst.BRANCH_NUMBER , number);
        }
        else {
            //Toast.makeText(AddBranchActivity.this, "Branch number is not valid!", Toast.LENGTH_LONG).show();
            strExepetion += "number is not valid!\n";

        }
        if(isNum(this.ParkingEditText.getText().toString())) {
            int park = Integer.valueOf(this.ParkingEditText.getText().toString());
            contentValues.put(AgencyConsts.BranchConst.PARKING, park);
        }
        else{
            //Toast.makeText(AddBranchActivity.this, "Parking number is not valid!", Toast.LENGTH_LONG).show();
            strExepetion += "Parking is not valid!\n";
        }
        if(Legal.isString(this.CityEditText.getText().toString())) {
            String city = this.CityEditText.getText().toString();
            contentValues.put(AgencyConsts.BranchConst.CITY, city);
        }
        else{
            //Toast.makeText(AddBranchActivity.this, "City name is not valid!", Toast.LENGTH_LONG).show();
            strExepetion += "City is not valid!\n";
            CityEditText.getText().clear();
        }
        if(Legal.isString(this.StreetEditText.getText().toString())) {
            String street = this.StreetEditText.getText().toString();
            contentValues.put(AgencyConsts.BranchConst.STREET, street);
        }
        else{
            //Toast.makeText(AddBranchActivity.this, "Street name is not valid!", Toast.LENGTH_LONG).show();
            strExepetion += "Street is not valid!\n";
        }
        if(Legal.isNum(this.StreetNumberEditText.getText().toString())) {
            int street_number = Integer.valueOf(this.StreetNumberEditText.getText().toString());
            contentValues.put(AgencyConsts.BranchConst.STREET_NUMBER, street_number);
        }
        else{
            //Toast.makeText(AddBranchActivity.this, "Street number name is not valid!", Toast.LENGTH_LONG).show();
            strExepetion += "street number is not valid!\n";
        }

         if(strExepetion != "")
         {
             Toast.makeText(AddBranchActivity.this, strExepetion, Toast.LENGTH_LONG).show();
             return;
         }

        new AsyncTask<Void, Void, Long>() {

            @Override
            protected void onPostExecute(Long numResult) {
                super.onPostExecute(numResult);
                if (numResult != Long.valueOf(-1))
                    Toast.makeText(AddBranchActivity.this, "Branch number: " + numResult +" was added successfully", Toast.LENGTH_LONG).show();
            }

            @Override
            protected Long doInBackground(Void... params) {
                try {
                    return Long.valueOf(DBManagerFactory.getManager().addBranch(contentValues));
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    return Long.valueOf(-1);
                }
            }
        }.execute();

        } catch (Exception e) {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }

}
