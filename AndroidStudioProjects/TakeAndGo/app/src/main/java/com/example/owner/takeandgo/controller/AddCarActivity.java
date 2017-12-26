package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.AgencyConsts;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;
import com.example.owner.takeandgo.model.entities.Branch;
import com.example.owner.takeandgo.model.entities.CarModel;
import static com.example.owner.takeandgo.model.datasource.List_DBManager.*;

public class AddCarActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        findViews();
    }

    //private EditText branchNumberEditText;
    //private EditText ModelTypeEditText;
    private Spinner branchSpinner;
    private Spinner carModelSpinner;
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
        branchSpinner = (Spinner)findViewById( R.id.branchSpinner);
        carModelSpinner = (Spinner)findViewById( R.id.carModelSpinner );
        //branchNumberEditText = (EditText) findViewById(R.id.branchNumberEditText);
        //ModelTypeEditText = (EditText) findViewById(R.id.ModelTypeEditText);
        MileageEditText = (EditText) findViewById(R.id.MileageEditText);
        NumberEditText = (EditText) findViewById(R.id.NumberEditText);
        addCarButton = (Button) findViewById(R.id.addCarButton);
        branchSpinner.setAdapter(new ArrayAdapter<Branch>(this,android.R.layout.simple_expandable_list_item_1,branches));

        carModelSpinner.setAdapter(new ArrayAdapter<CarModel>(this,R.layout.car_models,carModels)
                                    {

                                        @Override
                                        public View getView(int position, View convertView, ViewGroup parent) {
                                            return getCarModelView(position, convertView, parent);
                                        }

                                        @Override
                                        public View getDropDownView(int position, View convertView, ViewGroup parent) {
                                            return getCarModelView(position, convertView, parent);
                                        }
                                        View getCarModelView(int position, View convertView, ViewGroup parent)
                                        {
                                            if (convertView == null)
                                            {
                                                convertView = View.inflate(AddCarActivity.this,R.layout.car_models,null);
                                            }
                                            TextView productCodeModelTextView = (TextView) convertView
                                                    .findViewById(R.id.CodeTextView);

                                            TextView productCompanyNameTextView = (TextView) convertView
                                                    .findViewById(R.id.CompanyNameTextView);

                                            TextView productionModelNameTextView = (TextView) convertView
                                                    .findViewById(R.id.ModelNameTextView);

                                            TextView productionSeatsTextView = (TextView) convertView
                                                    .findViewById(R.id.SeatsTextView);

                                            productCodeModelTextView.setText((carModels.get(position).getCode()));
                                            productCompanyNameTextView.setText((carModels.get(position).getCompanyName()));
                                            productionModelNameTextView.setText((carModels.get(position).getModelName()));
                                            productionSeatsTextView.setText(carModels.get(position).getSeats());

                                            return convertView;
                                        }
                                    });

        addCarButton.setOnClickListener(this);
        //addCarButton.setEnabled(false);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-28 21:19:18 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == addCarButton) {
            addCar();
             MileageEditText.getText().clear();
             NumberEditText.getText().clear();
        }
    }

    private void addCar() {
        final ContentValues contentValues = new ContentValues();
        try {

            String strExepetion = "";


             if (Legal.isNum(NumberEditText.getText().toString())) {
                long number = Long.valueOf(this.NumberEditText.getText().toString());
                contentValues.put(AgencyConsts.CarConst.NUMBER, number);

            } else {
                //Toast.makeText(AddCarActivity.this, "Car number is not valid!", Toast.LENGTH_LONG).show();
                strExepetion += "Car number is not valid!\n";
            }
            /*if (Legal.isNum(this.ModelTypeEditText.getText().toString())) {
                int model = Integer.valueOf(this.ModelTypeEditText.getText().toString());
                contentValues.put(AgencyConsts.CarConst.MODEL_TYPE, model);
            } else {
                //Toast.makeText(AddCarActivity.this, "Model type is not valid!", Toast.LENGTH_LONG).show();
                strExepetion += "Model type is not valid!\n";
            }*/
            if (Legal.isNum(this.MileageEditText.getText().toString())) {
                double mile = Double.valueOf(this.MileageEditText.getText().toString());
                contentValues.put(AgencyConsts.CarConst.MILEAGE, mile);
            } else {
                //Toast.makeText(AddCarActivity.this, "Mileage value is not valid!", Toast.LENGTH_LONG).show();
               strExepetion += "Mileage value is not valid!\n";
            }
            /*if (Legal.isNum(this.branchNumberEditText.getText().toString())) {
                int branch = Integer.valueOf(this.branchNumberEditText.getText().toString());
                contentValues.put(AgencyConsts.CarConst.BRANCH_NUMBER, branch);
            } else {
                //Toast.makeText(AddCarActivity.this, "Branch number is not valid!", Toast.LENGTH_LONG).show();
                strExepetion += "Branch number is not valid!\n";
            }*/
            if( branchSpinner.getSelectedItem() != null) {
                int branchNumber = ((Branch) branchSpinner.getSelectedItem()).getBranchNumber();
                contentValues.put(AgencyConsts.CarConst.BRANCH_NUMBER, branchNumber);
            }
            else {
                strExepetion += "There are no branches!\n";
            }
            if(carModelSpinner.getSelectedItem() != null) {
                int carModelCode = ((CarModel) carModelSpinner.getSelectedItem()).getCode();
                contentValues.put(AgencyConsts.CarConst.MODEL_TYPE, carModelCode);
            }
            else{
                strExepetion += "There are no car models!\n";
            }


             if(strExepetion != "")
             {
                 Toast.makeText(AddCarActivity.this, strExepetion, Toast.LENGTH_LONG).show();
                 return;
             }


            new AsyncTask<Void, Void, Long>() {
                @Override
                protected void onPostExecute(Long numResult) {
                    super.onPostExecute(numResult);
                    if (numResult != Long.valueOf(-1))
                        Toast.makeText(AddCarActivity.this, "car number: " + numResult + " was added successfully", Toast.LENGTH_LONG).show();
                }

                @Override
                protected Long doInBackground(Void... params) {
                    try {
                        return Long.valueOf(DBManagerFactory.getManager().addCar(contentValues));
                    } catch (Exception e) {
                        Toast.makeText(AddCarActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    return Long.valueOf(-1);
                }
            }.execute();

        } catch (Exception e) {
            Toast.makeText(AddCarActivity.this, "Error!", Toast.LENGTH_LONG).show();
        }

    }
}






