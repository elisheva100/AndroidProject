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
import android.widget.Toast;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.AgencyConsts;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;
import com.example.owner.takeandgo.model.entities.Branch;
import com.example.owner.takeandgo.model.entities.CarModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.owner.takeandgo.model.datasource.List_DBManager.*;

public class AddCarActivity extends Activity implements View.OnClickListener {

    private Integer[] getBranches() {
        Integer[] numbers = new Integer[]{};
        List<Integer> lst = new ArrayList<Integer>();
        for (Branch branch : branches) {
            lst.add(branch.getBranchNumber());
        }
        return lst.toArray(numbers);
    }

    private Integer[] getModels() {
        Integer[] numbers = new Integer[]{};
        List<Integer> lst = new ArrayList<Integer>();
        for (CarModel carModel : carModels) {
            lst.add(carModel.getCode());
        }
        return lst.toArray(numbers);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        //Set sppiner views
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
                initSpinners();
            }

            @Override
            protected Void doInBackground(Void... voids) {
            carModelList = DBManagerFactory.getManager().getCarModels();
                branchList = DBManagerFactory.getManager().getBranches();
                return null;
            }
        }.execute();
        findViews();
    }

    //private EditText branchNumberEditText;
    //private EditText ModelTypeEditText;
    private Spinner branchSpinner;
    private Spinner carModelSpinner;
    private EditText MileageEditText;
    private EditText NumberEditText;
    private Button addCarButton;
    //List for sppiners
    List<CarModel> carModelList;
    List<Branch> branchList;
    private void initSpinners(){
        Integer [] branches = getBranches();
        ArrayAdapter<Integer> branchAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,branches);
        branchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        branchSpinner.setAdapter(branchAdapter);

        Integer [] models = getModels();
        ArrayAdapter<Integer> modelAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,models);
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carModelSpinner.setAdapter(modelAdapter);
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-28 21:19:18 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        branchSpinner = (Spinner) findViewById(R.id.branchSpinner);
        carModelSpinner = (Spinner) findViewById(R.id.carModelSpinner);
        //branchNumberEditText = (EditText) findViewById(R.id.branchNumberEditText);
        //ModelTypeEditText = (EditText) findViewById(R.id.ModelTypeEditText);
        MileageEditText = (EditText) findViewById(R.id.MileageEditText);
        NumberEditText = (EditText) findViewById(R.id.NumberEditText);
        addCarButton = (Button) findViewById(R.id.addCarButton);
        addCarButton.setOnClickListener(this);


    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-28 21:19:18 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v){
        if(v==addCarButton){
        addCar();

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
            if (branchSpinner.getSelectedItem() != null) {
                int branchNumber = (Integer) branchSpinner.getSelectedItem();
                contentValues.put(AgencyConsts.CarConst.BRANCH_NUMBER, branchNumber);
            } else {
                strExepetion += "There are no branches!\n";
            }
            if (carModelSpinner.getSelectedItem() != null) {
                int carModelCode = (Integer) carModelSpinner.getSelectedItem();
                contentValues.put(AgencyConsts.CarConst.MODEL_TYPE, carModelCode);
            } else {
                strExepetion += "There are no car models!\n";
            }


            if (strExepetion != "") {
                Toast.makeText(AddCarActivity.this, strExepetion, Toast.LENGTH_LONG).show();
                return;
            }


            new AsyncTask<Void, Void, Long>() {
                @Override
                protected void onPostExecute(Long numResult) {
                    super.onPostExecute(numResult);
                    if (numResult != Long.valueOf(-1)) {
                        Toast.makeText(AddCarActivity.this, "car number: " + numResult + ", added successfully", Toast.LENGTH_LONG).show();
                        //MileageEditText.getText().clear();
                        //NumberEditText.getText().clear();
                    }
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






