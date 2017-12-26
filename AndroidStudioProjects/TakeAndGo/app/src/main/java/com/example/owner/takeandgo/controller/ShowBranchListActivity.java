package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.owner.takeandgo.R;
import com.example.owner.takeandgo.model.backEnd.DBManagerFactory;
import com.example.owner.takeandgo.model.entities.Branch;

import java.util.List;

import static com.example.owner.takeandgo.R.id.branchNumberTextView;

public class ShowBranchListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_branch_list);
        initByListView();
    }


    public void initByListView()
    {

        try
        {
            new AsyncTask<Branch, Void, List<Branch>>() {
                @Override
                protected void onPostExecute(final List<Branch> myItemList) {
                Adaptor(myItemList);
                }

                @Override
                protected List<Branch> doInBackground(Branch... params) {
                try {
                    return DBManagerFactory.getManager().getBranches();
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


    protected void Adaptor(final List<Branch>  myItemList) {
        ListView listView = new ListView(this);
        ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(this, R.layout.activity_show_branch_list, myItemList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(ShowBranchListActivity.this, R.layout.activity_show_branch_list, null);

                }
                TextView parkingTextView = (TextView) convertView.findViewById(R.id.parkingTextView);
                TextView branchNumberTextView = (TextView) convertView.findViewById(R.id.branchNumberTextView);
                TextView adressTextView = (TextView) convertView.findViewById(R.id.adressTextView);
                parkingTextView.setText(""+(myItemList.get(position).getParking()));
                adressTextView.setText(myItemList.get(position).getAdress().toString());
                branchNumberTextView.setText(""+(myItemList.get(position).getBranchNumber()));
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        this.setContentView(listView);
    }
}
