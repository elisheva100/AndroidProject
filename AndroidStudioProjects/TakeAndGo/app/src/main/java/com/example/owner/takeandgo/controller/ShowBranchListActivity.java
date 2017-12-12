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

public class ShowBranchListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_branch_list);
        //initItemByListView();
        //final ListView listView = new ListView(this);
        findViews();
    }


    private TextView parkingTextView;
    private TextView branchNumberTextView;
    private TextView adressTextView;

    //private void initItemByListView()
    private void findViews()
   {
        try{
        new AsyncTask<Void, Void, List<Branch>>()
        {
            @Override
            protected void onPostExecute(final List<Branch> myItemList)
            {
                final ListView listView = new ListView(ShowBranchListActivity.this);
                //creates inner class
                ArrayAdapter<Branch> adapter = new ArrayAdapter<Branch>(ShowBranchListActivity.this, R.layout.activity_show_client_list, myItemList)
                {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        if (convertView == null) {
                            convertView = View.inflate(ShowBranchListActivity.this, R.layout.activity_show_branch_list, null);

                        }
                        //View view = super.getView(position,convertView,parent);
                        parkingTextView = (TextView)findViewById( R.id.parkingTextView );
                        branchNumberTextView = (TextView)findViewById( R.id.branchNumberTextView );
                        adressTextView = (TextView)findViewById( R.id.adressTextView );
                        parkingTextView.setText((myItemList.get(position).getParking()));
                        adressTextView.setText((CharSequence) myItemList.get(position).getAdress());
                        branchNumberTextView.setText((myItemList.get(position).getBranchNumber()));
                        return convertView;
                        //return view;

                    }
                };
                listView.setAdapter(adapter);
                ShowBranchListActivity.this.setContentView(listView);
            }


            @Override
            protected List<Branch> doInBackground(Void... params)
            {
                try {
                    return DBManagerFactory.getManager().getBranches();
                }
                catch (Exception e) {
                    //e.printStackTrace();
                    return null;
                }
            }
        }.execute();
        }
        catch (Exception e) {
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
}
