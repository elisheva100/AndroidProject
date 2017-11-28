package com.example.owner.takeandgo.controller;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    }
    private EditText branchNumnerEditText;
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
        branchNumnerEditText = (EditText)findViewById( R.id.branchNumnerEditText );
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
        try {
            long number = Long.valueOf(this.NumberEditText.getText().toString());
            contentValues.put(AgencyConsts.CarConst.NUMBER, number);

            int model = Integer.valueOf(this.ModelTypeEditText.getText().toString());
            contentValues.put(AgencyConsts.CarConst.MODEL_TYPE,model);

            double mile = Double.valueOf(this.MileageEditText.getText().toString());
            contentValues.put(AgencyConsts.CarConst.MILEAGE,mile);

            int branch = Integer.valueOf(this.branchNumnerEditText.getText().toString());
            contentValues.put(AgencyConsts.CarConst.BRANCH_NUMBER,branch);

            new AsyncTask<Void, Void, Long>() {
                @Override
                protected void onPostExecute(Long numResult) {
                    super.onPostExecute(numResult);
                    if (numResult != null)
                        Toast.makeText(getBaseContext(), "insert number: " + numResult, Toast.LENGTH_LONG).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    try {
                        return DBManagerFactory.getManager().addCar(contentValues);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return Long.valueOf(-1);
                    }

                }

            }.execute();

        } catch (Exception e) {
        }
    }

}
