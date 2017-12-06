package com.example.owner.takeandgo.controller;
//TODO add Asynig task
import android.app.Activity;
import android.content.ClipData;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;
import com.example.owner.takeandgo.model.entities.Client;

import java.util.List;

public class ShowClientListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_client_list);
    }

    void initItemByListView()
    {
        final ListView listView = new ListView(this);
        //final List<Client> myItemList = DBManagerFactory.getManager().getClients();
        new AsyncTask<Void, Void, List<Client>>() {
            @Override
            protected void onPostExecute(final List<Client> myItemList) {
                final ArrayAdapter<Client> adapter = new ArrayAdapter<Client>(ShowClientListActivity.this, R.layout.activity_show_client_list, myItemList) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        if (convertView == null) {
                            convertView = View.inflate(ShowClientListActivity.this, R.layout.activity_show_client_list, null);
                        }
                        TextView productIdTextView = (TextView) convertView.findViewById(R.id.idTextView);
                        TextView productNameTextView = (TextView) convertView.findViewById(R.id.nameTextView);
                        TextView productionCellphoneNumberTextView = (TextView) convertView.findViewById(R.id.cellphoneNumberTextView);
                        TextView productionEmailTextView = (TextView) convertView.findViewById(R.id.emailTextView);
                        productIdTextView.setText((myItemList.get(position).getId()));
                        productNameTextView.setText(myItemList.get(position).getFirstName() + " " + myItemList.get(position).getLastName());
                        productionCellphoneNumberTextView.setText((myItemList.get(position).getCellphoneNumber()));
                        productionEmailTextView.setText((myItemList.get(position).getEmail()));
                        return convertView;
                    }
                };
                listView.setAdapter(adapter);
            }

            @Override
            protected List<Client> doInBackground(Void... params) {
                try {
                    return DBManagerFactory.getManager().getClients();
                }
                catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }.execute();
        this.setContentView(listView);
    }
}
