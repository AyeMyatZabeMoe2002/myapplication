package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
public class NextActivity extends AppCompatActivity {
    TextView txt_next;
    Student std1 = new Student();
    Student std2 = new Student("P002","Mg Mg","mgmg@gmail.com");
    Student std3 = new Student("P003","Ma Ma","mama@gmail.com");
    ArrayList<Student> stdList = new ArrayList<Student>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        txt_next=findViewById(R.id.txt_next);
        stdList.add(std1);
        stdList.add(std2);
        stdList.add(std3);
        for(int i=0;i<stdList.size();i++){
            Student std = stdList.get(i);
            txt_next.append("\nID:"+std2.getId());
            txt_next.append("\nName:"+std2.getName());
            txt_next.append("\nEmail:"+std2.getEmail()+"\n\n");
        }

    }
}