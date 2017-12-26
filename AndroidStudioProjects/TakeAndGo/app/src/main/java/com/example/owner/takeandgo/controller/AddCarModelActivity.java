package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.AgencyConsts;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;
import com.example.owner.takeandgo.model.entities.COLOR;
import com.example.owner.takeandgo.model.entities.GEARBOX;

public class AddCarModelActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_model);
        findViews();
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
    private Button addCarModelButton;

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
        addCarModelButton = (Button)findViewById( R.id.addModelButton );

        gearboxSpinner.setAdapter(new ArrayAdapter<GEARBOX>(this, android.R.layout.simple_list_item_1,GEARBOX.values()));
        colorSpinner.setAdapter(new ArrayAdapter<COLOR>(this, android.R.layout.simple_list_item_1,COLOR.values()));
        addCarModelButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-29 01:22:58 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addCarModelButton ) {
            addCarModel();
            /*
            CodeEditText.getText().clear();
            ModelNameEditText.getText().clear();
             CompanyNameEditText.getText().clear();
            EngineCApicityEditText.getText().clear();
             SeatsEditText.getText().clear();
            */
        }
    }
    private void addCarModel()
    {
        final ContentValues contentValues = new ContentValues();
        try {
            String strException = "";
            if(Legal.isNum(this.CodeEditText.getText().toString())){
                int code = Integer.valueOf(this.CodeEditText.getText().toString());
                contentValues.put(AgencyConsts.CarModelConst.CODE, code);
            }
            else{
                //Toast.makeText(AddCarModelActivity.this, "code is not valid!", Toast.LENGTH_LONG).show();
                strException += "code is not valid!\n";
            }
            String company = this.CompanyNameEditText.getText().toString();
            contentValues.put(AgencyConsts.CarModelConst.COMPANY_NAME, company);
            String model = this.ModelNameEditText.getText().toString();
            contentValues.put(AgencyConsts.CarModelConst.MODEL_NAME, model);
            if(Legal.isNum(this.EngineCApicityEditText.getText().toString())){
                double capacity = Double.valueOf(this.EngineCApicityEditText.getText().toString());
                contentValues.put(AgencyConsts.CarModelConst.ENGINE_CAPACITY, capacity);
            }
            else{
                //Toast.makeText(AddCarModelActivity.this, "engine capacity is not valid!", Toast.LENGTH_LONG).show();
                strException += "engine capacity is not valid!\n";
            }
            String gear  = ((GEARBOX) gearboxSpinner.getSelectedItem()).name();
            contentValues.put(AgencyConsts.CarModelConst.GEARBOX, gear);
            String color  = ((COLOR) colorSpinner.getSelectedItem()).name();
            contentValues.put(AgencyConsts.CarModelConst.COLOR, color);

            if(!Legal.isNum(this.SeatsEditText.getText().toString()))
            {
                //Toast.makeText(AddCarModelActivity.this, "number of seats is not valid!", Toast.LENGTH_LONG).show();
                strException += "number of seats is not valid!\n";
            }
            else if(Integer.valueOf(this.SeatsEditText.getText().toString()) > 9 || Integer.valueOf(this.SeatsEditText.getText().toString()) < 2)
            {
                Toast.makeText(AddCarModelActivity.this, "There is no car with such number of seats! ", Toast.LENGTH_LONG).show();
            return;
            }
            else {
                ///vbdjksb

                int seats = Integer.valueOf(this.SeatsEditText.getText().toString());
                contentValues.put(AgencyConsts.CarModelConst.SEATS, seats);
            }
            if(strException != "")
            {
                Toast.makeText(AddCarModelActivity.this, strException, Toast.LENGTH_LONG).show();
                return;
            }


        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected void onPostExecute(Integer numResult) {
                super.onPostExecute(numResult);
                if (numResult != -1)
                    Toast.makeText(AddCarModelActivity.this, "car model : " + numResult + " was added successfully", Toast.LENGTH_LONG).show();
            }

            @Override
            protected Integer doInBackground(Void... params) {
                try {
                    return DBManagerFactory.getManager().addCarModel(contentValues);
                } catch (Exception e) {
                    Toast.makeText(AddCarModelActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
                return -1;
            }
        }.execute();

    } catch (Exception e) {
        Toast.makeText(AddCarModelActivity.this, "Error!", Toast.LENGTH_LONG).show();
    }
    }

}
