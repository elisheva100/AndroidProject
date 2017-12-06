package com.example.owner.takeandgo.controller;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.AgencyConsts;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;

public class AddCarActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }
    private EditText branchNumberEditText;
    private EditText ModelTypeEditText;
    private EditText MileageEditText;
    private EditText NumberEditText;
    private Button addCarButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-28 21:19:18 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        branchNumberEditText = (EditText)findViewById( R.id.branchNumberEditText );
        ModelTypeEditText = (EditText)findViewById( R.id.ModelTypeEditText );
        MileageEditText = (EditText)findViewById( R.id.MileageEditText );
        NumberEditText = (EditText)findViewById( R.id.NumberEditText );
        addCarButton = (Button)findViewById( R.id.addCarButton );

        addCarButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-28 21:19:18 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addCarButton ) {
            addCar();
        }
    }
    private void addCar() {
        final ContentValues contentValues = new ContentValues();
        String strExepetion = "";

            if(Legal.isNum(NumberEditText.getText().toString())) {
                long number = Long.valueOf(this.NumberEditText.getText().toString());
                contentValues.put(AgencyConsts.CarConst.NUMBER, number);
            }
            else {
                Toast.makeText(AddCarActivity.this, "Car number is not valid!", Toast.LENGTH_LONG).show();
                //strExepetion += "Car number is not valid!\n";
            }
            if(Legal.isNum(this.ModelTypeEditText.getText().toString())) {
                int model = Integer.valueOf(this.ModelTypeEditText.getText().toString());
                contentValues.put(AgencyConsts.CarConst.MODEL_TYPE, model);
            }
            else{
                Toast.makeText(AddCarActivity.this, "Model type is not valid!", Toast.LENGTH_LONG).show();
                //strExepetion += "Model type is not valid!\n";
            }
            if(Legal.isNum(this.MileageEditText.getText().toString())) {
                double mile = Double.valueOf(this.MileageEditText.getText().toString());
                contentValues.put(AgencyConsts.CarConst.MILEAGE, mile);
            }
            else{
                Toast.makeText(AddCarActivity.this, "Mileage value is not valid!", Toast.LENGTH_LONG).show();
                //strExepetion += "Mileage value is not valid!\n";
            }
            if(Legal.isNum(this.branchNumberEditText.getText().toString())) {
                int branch = Integer.valueOf(this.branchNumberEditText.getText().toString());
                contentValues.put(AgencyConsts.CarConst.BRANCH_NUMBER, branch);
            }
            else{
                Toast.makeText(AddCarActivity.this, "Branch number is not valid!", Toast.LENGTH_LONG).show();
                //strExepetion += "Branch number is not valid!\n";
            }
           /** if(strExepetion != "")
            {
                throw new Exception(strExepetion);
            }**/

            new AsyncTask<Void, Void, Long>() {
                @Override
                protected void onPostExecute(Long numResult) {
                    super.onPostExecute(numResult);
                    if (numResult != null)
                        Toast.makeText(AddCarActivity.this, "insert number: " + numResult +" added successfully", Toast.LENGTH_LONG).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    try {
                        return DBManagerFactory.getManager().addCar(contentValues);
                    } catch (Exception e) {

                        Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                        return Long.valueOf(-1);

                    }

                }

            }.execute();

        }
        catch (Exception e) {
    }

    }



