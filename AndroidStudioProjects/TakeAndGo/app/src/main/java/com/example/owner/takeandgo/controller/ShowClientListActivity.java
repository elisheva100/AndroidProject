package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.content.ClipData;
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
import com.example.owner.takeandgo.model.entities.Client;

import java.util.List;

/**
 *The class represents all the client that exists in the system
 */
public class ShowClientListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client_list);
        initByListView();
    }

    /**
     * initByListView creates AsyncTask that gets the client list from background
     */
    public void initByListView()
    {
        try
        {
            new AsyncTask<Client, Void, List<Client>>() {

                @Override
                protected void onPostExecute(final List<Client> myItemList) {
                    Adaptor(myItemList);  //sent client list to adaptor
                }
                @Override
                protected List<Client> doInBackground(Client... params) {
                    try {
                        return DBManagerFactory.getManager().getClients(); //gets client list from background:
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
    protected void Adaptor(final List<Client>  myItemList) {
        ListView listView = new ListView(this);
        ArrayAdapter<Client> adapter = new ArrayAdapter<Client>(this, R.layout.activity_show_client_list, myItemList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(ShowClientListActivity.this, R.layout.activity_show_client_list, null);
                }
                //creates text views:
                TextView productIdTextView = (TextView) convertView.findViewById(R.id.idTextView);
                TextView productNameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
                TextView productionCellphoneNumberTextView = (TextView) convertView.findViewById(R.id.cellphoneNumberTextView);
                TextView productionEmailTextView = (TextView) convertView.findViewById(R.id.emailTextView);
                //sets text:
                productIdTextView.setText(("" + myItemList.get(position).getId()));
                productNameTextView.setText(myItemList.get(position).getFirstName() + " " + myItemList.get(position).getLastName());
                productionCellphoneNumberTextView.setText((myItemList.get(position).getCellphoneNumber()));
                productionEmailTextView.setText((myItemList.get(position).getEmail()));
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        this.setContentView(listView);
    }
}
