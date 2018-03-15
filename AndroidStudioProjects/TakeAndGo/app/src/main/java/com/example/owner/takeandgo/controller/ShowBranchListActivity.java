package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

/**
 * The class show all the branches that exists in the system
 */
public class ShowBranchListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //creates logo
        getSupportActionBar().setLogo(R.mipmap.my_car);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_show_branch_list);
        initByListView();
    }


    //initByListView contains AsyncTask that gets the branches list from background
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
                try { //gets branches list from background
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


    //creates ArrayAdapter
    protected void Adaptor(final List<Branch>  myItemList) {
        ListView listView = new ListView(this);
        ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(this, R.layout.activity_show_branch_list, myItemList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = View.inflate(ShowBranchListActivity.this, R.layout.activity_show_branch_list, null);

                }
                //creates text view
                TextView parkingTextView = (TextView) convertView.findViewById(R.id.parkingTextView);
                TextView branchNumberTextView = (TextView) convertView.findViewById(R.id.branchNumberTextView);
                TextView adressTextView = (TextView) convertView.findViewById(R.id.adressTextView);
                //sets text:
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
