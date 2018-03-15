package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;
import com.example.owner.takeandgo.model.entities.Car;

import java.util.ArrayList;
import java.util.List;

/**
 *The class represnts all the cars that exists in the system
 */
public class ShowCarListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //creates logo
        getSupportActionBar().setLogo(R.mipmap.my_car);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_show_car_list);
        initByListView();
    }


    /**
     * initByListView creates AsyncTask that gets the cars list from background
     */
    public void initByListView()
    {
        try
        {
            new AsyncTask<Car, Void, List<Car>>() {
                @Override
                protected void onPostExecute(final List<Car> myItemList) {
                    Adaptor(myItemList); //sent cars list to adaptor
                }
                //gets cars list from background:
                @Override
                protected List<Car> doInBackground(Car... params) {
                    try {
                        return DBManagerFactory.getManager().getCars();
                    }
                    catch (Exception e) {
                        return null;
                    }
                }

            }.execute();
        }
        catch (Exception e) {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    /**
     * creates ArrayAdapter
     */
    protected void Adaptor(final List<Car>  myItemList) {
        ListView listView = new ListView(this);
        ArrayAdapter<Car> adapter = new ArrayAdapter<Car>(this, R.layout.activity_show_car_list, myItemList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(ShowCarListActivity.this, R.layout.activity_show_car_list, null);

                }
                //creates text view
                TextView productNumberTextView = (TextView) convertView.findViewById(R.id.numberTextView);
                TextView productBranchNumberTextView = (TextView) convertView.findViewById(R.id.branchNumberTextView);
                TextView productionModelTypeTextView = (TextView) convertView.findViewById(R.id.modelTypeTextView);
                TextView productionMileageTextView = (TextView) convertView.findViewById(R.id.mileageTextView);
                //sets text:
                productNumberTextView.setText("" + myItemList.get(position).getNumber());
                productBranchNumberTextView.setText("" + myItemList.get(position).getBranchNumber());
                productionModelTypeTextView.setText("" + myItemList.get(position).getModelType());
                productionMileageTextView.setText("" + myItemList.get(position).getMileage());
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        this.setContentView(listView);
    }
}
