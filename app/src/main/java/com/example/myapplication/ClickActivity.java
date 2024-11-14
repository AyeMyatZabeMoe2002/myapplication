package com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class ClickActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
     Button btnClick,btnConfirm;
     EditText editName,editEmail;
     String name,email;
     Student std;
     CheckBox checkTerms;
     Spinner spinner;
     String [] countries = {"Choose Your Country....","Thailand","Singapore","Japan","United Kingdom","United State","Malaysia","Cambodia"};
     String country;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        //std = new Student("P002","John","john@gmail.com");//create object

        btnClick = findViewById(R.id.btnClick);
        btnConfirm =findViewById(R.id.btnConfirm);
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        checkTerms =findViewById(R.id.checkTerms);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,countries);
         arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(arrayAdapter);

        //editName.getText();
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clickMeAction();//function call
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmAction();
            }
        });
    }//end of onCreate

    /*------------------------Confirm Button----------------------*/
    private void confirmAction() {

        String name = editName.getText().toString();
        String email = editEmail.getText().toString();

        if(checkTerms.isChecked()) {
            if((!name.isEmpty()) && (!email.isEmpty())) {

                if(country=="Choose Your Country....")
                Toast.makeText(getApplicationContext(),"Please select your country!",Toast.LENGTH_LONG).show();

                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Confirmation")
                            .setMessage("Name: " + name + "\nEmail: " + email + "\nCountry:" + country)
                            .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    clickMeAction();
                                    //Toast.makeText(getApplicationContext(), "Clicked Save", Toast.LENGTH_LONG).show();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(), "Clicked Cancel", Toast.LENGTH_LONG).show();
                                }
                            });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }//name, email, country correct
            }
            else {
                Toast.makeText(getApplicationContext(),"Please Enter your name or email",Toast.LENGTH_LONG).show();
            }
        }
        else{ //else if (!checkTerms.isChecked())//unchecked
            Toast.makeText(getApplicationContext(),"Please accept Terms and Conditions",Toast.LENGTH_LONG).show();
        }
    }//end of Confirm Action Function

    /*-------------------------Save Button------------------*/
    public void clickMeAction() {
         name = editName.getText().toString();
         email =editEmail.getText().toString();
         std = new Student("P001",name,email);
         if(name=="" || name==null || name.length()==0)
         {
             //txtDisplayName.setText("");
             Toast.makeText(getApplicationContext(),"Please enter your name!",Toast.LENGTH_LONG).show();
         }
         else if(email.isEmpty()){
             Toast.makeText(getApplicationContext(),"Please enter your email!",Toast.LENGTH_LONG).show();
        }
         else
         {
             //Toast.makeText(getApplicationContext(),"Hello, "+name,Toast.LENGTH_LONG).show();
             //txtDisplayName.setText(" Hello, "+name);
             Intent intent = new Intent(ClickActivity.this,ClickActionActivity.class);
             //intent.putExtra("username",name);
             intent.putExtra("student",std);
             startActivity(intent);
             //finish();
         }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             country = countries[position]; //countries[3]==Japan
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    //Do nothing
    }
}//end of Click Activity Class