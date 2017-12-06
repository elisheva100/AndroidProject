package com.example.owner.takeandgo.controller;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.owner.takeandgo.R;

import java.util.Calendar;

public class AddClientActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
        Calendar calander = Calendar.getInstance();
        myDay = calander.get(Calendar.DAY_OF_MONTH);
        myMonth = calander.get(Calendar.MONTH) + 1;
        myYear = calander.get(Calendar.YEAR);
        findViews();
    }
    protected Dialog onCreateDialog(int id){
        if(id == DIALOG)
        {
           return new DatePickerDialog(this,dPickerListener,myYear,myMonth,myDay);
        }
        return null;
    }
    private EditText clientIdEditText;
    private EditText FirstNameEditText;
    private EditText LastNameEditText;
    private EditText PhoneNumberEditText;
    private EditText EmailEditText;
    private TextView birthdayTextView;
    private Button datePickerButton;
    private EditText CreditCardEditText;
    private Button addClientButton;
    private DatePickerDialog.OnDateSetListener dPickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        /**
         * Gets the user's date.
         */
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myYear = year;
            myMonth = month;
            myDay = dayOfMonth;
            Calendar calander = Calendar.getInstance();
            int cDay = calander.get(Calendar.DAY_OF_MONTH);
            int cMonth = calander.get(Calendar.MONTH) + 1;
            int cYear = calander.get(Calendar.YEAR);
            if (myYear - cYear < 18) {
                flag =  false;//The user is younger than 18.
            } else if (myYear == cYear && myMonth < cMonth) {
                flag =  false; //The user is 18 this year but next months.
            } else if (myYear == cYear && myMonth == cMonth && myDay < cDay) {
                flag =  false; //The user is 18 this month but the next days.
            }

        }
    };
    int myYear, myMonth, myDay; //The user's birthday.
    static final int DIALOG = 0;
    static boolean flag = true;
    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-12-06 17:20:57 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        clientIdEditText = (EditText)findViewById( R.id.clientIdEditText );
        FirstNameEditText = (EditText)findViewById( R.id.FirstNameEditText );
        LastNameEditText = (EditText)findViewById( R.id.LastNameEditText );
        PhoneNumberEditText = (EditText)findViewById( R.id.PhoneNumberEditText );
        EmailEditText = (EditText)findViewById( R.id.EmailEditText );
        birthdayTextView = (TextView)findViewById( R.id.birthdayTextView );
        datePickerButton = (Button)findViewById( R.id.datePickerButton );
        CreditCardEditText = (EditText)findViewById( R.id.CreditCardEditText );
        addClientButton = (Button)findViewById( R.id.addClientButton );

        datePickerButton.setOnClickListener( this );
        addClientButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-12-06 17:20:57 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == datePickerButton ) {
            showDialog(DIALOG);
        } else if ( v == addClientButton ) {
            // Handle clicks for addClientButton
        }
    }


}
