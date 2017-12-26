package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.content.ClipData;
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
import com.example.owner.takeandgo.model.entities.Client;

import java.util.List;

public class ShowClientListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client_list);
        initByListView();
    }

    public void initByListView()
    {

        try
        {
            new AsyncTask<Client, Void, List<Client>>() {

                @Override
                protected void onPostExecute(final List<Client> myItemList) {
                    Adaptor(myItemList);
                }

                @Override
                protected List<Client> doInBackground(Client... params) {
                    try {
                        return DBManagerFactory.getManager().getClients();
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


    protected void Adaptor(final List<Client>  myItemList) {
        ListView listView = new ListView(this);
        ArrayAdapter<Client> adapter = new ArrayAdapter<Client>(this, R.layout.activity_show_client_list, myItemList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(ShowClientListActivity.this, R.layout.activity_show_client_list, null);

                }
                TextView productIdTextView = (TextView) convertView.findViewById(R.id.idTextView);
                TextView productNameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
                TextView productionCellphoneNumberTextView = (TextView) convertView.findViewById(R.id.cellphoneNumberTextView);
                TextView productionEmailTextView = (TextView) convertView.findViewById(R.id.emailTextView);
                productIdTextView.setText(("" + myItemList.get(position).getId()));
                productNameTextView.setText(myItemList.get(position).getFirstName() + " " + myItemList.get(position).getLastName());
                productionCellphoneNumberTextView.setText((myItemList.get(position).getCellphoneNumber().toString()));
                productionEmailTextView.setText((myItemList.get(position).getEmail().toString()));
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        this.setContentView(listView);
    }
}
