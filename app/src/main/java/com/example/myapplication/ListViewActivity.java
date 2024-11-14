package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    Toolbar toolbar;
    String [] weekDays = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = findViewById(R.id.listView);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.list_item_layout,weekDays);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(arrayAdapter);
        //Action
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Clicked: "+weekDays[position],Toast.LENGTH_LONG).show();
            }
        });
    }//on create

    //function call----->on create options menu key
    //---Menu Bar----//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }//menu upload

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(R.id.itemNext==item.getItemId())
        {
            //Next option choose
            Toast.makeText(this,"Next Item Selected",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(R.id.itemExit==item.getItemId())
        {
            //Exit option choose
            Toast.makeText(this,"Exit Item Selected",Toast.LENGTH_LONG).show();
            finish();
            return true;
        }
        else return super.onOptionsItemSelected(item);
    }
    //Menu Bar//

}//end of the class
