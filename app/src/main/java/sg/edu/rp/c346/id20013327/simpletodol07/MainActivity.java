package sg.edu.rp.c346.id20013327.simpletodol07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnClear;
    EditText etTask;
    ListView lvTask;
    ArrayList<String> alTask;
    ArrayAdapter<String> aaTask;
    //Enchancement
    Button btnDelete;
    Spinner spnAddRemove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        etTask = findViewById(R.id.etTask);
        lvTask = findViewById(R.id.lvTask);
        //Enchancement
        btnDelete = findViewById(R.id.btnDelete);
        spnAddRemove = findViewById(R.id.spinnerChoice);

        alTask = new ArrayList<String>();

        aaTask = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alTask);

        lvTask.setAdapter(aaTask);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = etTask.getText().toString();
                if(task.isEmpty() == false) {
                    alTask.add(task); //add the user input into the ArrayList, alTask.
                    aaTask.notifyDataSetChanged(); //notifies the attached observers that the underlying data has been changed and any view reflecting the data set should refresh itself.
                } else {
                    Toast.makeText(MainActivity.this, "There are no task filled", Toast.LENGTH_SHORT).show(); //If the input is empty it will display no task filled
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTask.clear();
                aaTask.notifyDataSetChanged();
            }
        });

        //Enchancement
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(alTask.isEmpty() == false) {
//                    alTask;

                } else {
                    Toast.makeText(MainActivity.this, "There are no activity to be deleted", Toast.LENGTH_SHORT).show();
                    if(alTask.isEmpty() == true) {
                        btnClear.setEnabled(false);
                    } else {
                        btnClear.setEnabled(true);
                    }
                }
            }
        });

        spnAddRemove.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 ) {

                    btnAdd.setEnabled(true);
                    btnDelete.setEnabled(false);
                    if(alTask.isEmpty() == true) {
                        btnClear.setEnabled(false);
                    } else {
                        btnClear.setEnabled(true);
                    }
                } else if(position == 1) {

                    btnDelete.setEnabled(true);
                    btnAdd.setEnabled(false);
                    if(alTask.isEmpty() == true) {
                        btnClear.setEnabled(false);
                    } else {
                        btnClear.setEnabled(true);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}