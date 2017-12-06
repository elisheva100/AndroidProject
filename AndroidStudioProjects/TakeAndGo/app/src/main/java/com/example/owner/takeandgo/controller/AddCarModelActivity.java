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
import com.example.owner.takeandgo.model.entities.GEARBOX;

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
        gearboxSpinner.setAdapter(new ArrayAdapter<GEARBOX>(this,android.R.layout.simple_expandable_list_item_1,GEARBOX.values()));
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
            addCarModel();
        }
    }
    private void addCarModel()
    {
        final ContentValues contentValues = new ContentValues();
        try {
            if(Legal.isNum(this.CodeEditText.getText().toString())){
                int code = Integer.valueOf(this.CodeEditText.getText().toString());
                contentValues.put(AgencyConsts.CarModelConst.CODE, code);
            }
            else{
                Toast.makeText(AddCarModelActivity.this, "code is not valid!", Toast.LENGTH_LONG).show();
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
                Toast.makeText(AddCarModelActivity.this, "engine capacity is not valid!", Toast.LENGTH_LONG).show();
            }
            String gear  = ((GEARBOX)gearboxSpinner.getSelectedItem()).name();
            contentValues.put(AgencyConsts.CarModelConst.GEARBOX,gear);

            if(!Legal.isNum(this.SeatsEditText.getText().toString()))
            {
                Toast.makeText(AddCarModelActivity.this, "number of seats is not valid!", Toast.LENGTH_LONG).show();
            }
            else if(Integer.valueOf(this.SeatsEditText.getText().toString()) > 9 || Integer.valueOf(this.SeatsEditText.getText().toString()) < 2)
            {
                Toast.makeText(AddCarModelActivity.this, "There is no car with such number of seats! ", Toast.LENGTH_LONG).show();
            }
            else {
                int seats = Integer.valueOf(this.SeatsEditText.getText().toString());
                contentValues.put(AgencyConsts.CarModelConst.SEATS, seats);
            }


        new AsyncTask<Void, Void, Integer>() {
            @Override
            protected void onPostExecute(Integer numResult) {
                super.onPostExecute(numResult);
                if (numResult > 0)
                    Toast.makeText(getBaseContext(), "insert car: " + numResult + "successfully", Toast.LENGTH_LONG).show();
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
