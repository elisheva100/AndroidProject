package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;
import com.example.owner.takeandgo.model.entities.CarModel;

import java.util.List;

public class ShowCarModelListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_car_model_list);
        initByListView();
    }


    public void initByListView()
    {
        try
        {
            new AsyncTask<CarModel, Void, List<CarModel>>() {

                @Override
                protected void onPostExecute(final List<CarModel> myItemList) {
                    Adaptor(myItemList);
                }

                @Override
                protected List<CarModel> doInBackground(CarModel... params) {
                    try {
                        return DBManagerFactory.getManager().getCarModels();
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


    protected void Adaptor(final List<CarModel>  myItemList) {
        ListView listView = new ListView(this);
        ArrayAdapter<CarModel> adapter = new ArrayAdapter<CarModel>(this, R.layout.activity_show_car_model_list, myItemList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(ShowCarModelListActivity.this, R.layout.activity_show_car_model_list, null);

                }
                TextView codeTextView = (TextView)convertView.findViewById( R.id.codeTextView );
                TextView modelNameTextView = (TextView)convertView.findViewById( R.id.modelNameTextView );
                TextView companyNameTextView = (TextView)convertView.findViewById( R.id.companyNameTextView );
                TextView seatsTextView = (TextView)convertView.findViewById( R.id.seatsTextView );
                codeTextView.setText("" + myItemList.get(position).getCode());
                modelNameTextView.setText(myItemList.get(position).getModelName());
                companyNameTextView.setText(myItemList.get(position).getCompanyName());
                seatsTextView.setText("" + myItemList.get(position).getSeats());
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        this.setContentView(listView);
    }
}



