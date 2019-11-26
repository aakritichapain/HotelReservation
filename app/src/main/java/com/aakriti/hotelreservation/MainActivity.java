package com.aakriti.hotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private Spinner spinRoomType;
    EditText etAdult,etChild,etRoomno;
    Button btnCalculate;
    TextView cbIn,cbOut,roomCost,totalDays,tvtotalCost,tvVat,tvGrandTotal,noofRoom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Binding
        spinRoomType=findViewById(R.id.spRoomType);
        cbIn=findViewById(R.id.cbIn);
        cbOut=findViewById(R.id.cbOut);
        etAdult=findViewById(R.id.etAdult);
        etChild=findViewById(R.id.etChild);
        etRoomno=findViewById(R.id.etRoomno);
        totalDays=findViewById(R.id.totalDays);
        btnCalculate=findViewById(R.id.btnCalculate);

        roomCost=findViewById(R.id.roomCost);
        totalDays=findViewById(R.id.totalDays);
        tvtotalCost=findViewById(R.id.totalCost);
        tvVat=findViewById(R.id.tvVat);
        tvGrandTotal=findViewById(R.id.tvGrandTotal);
        noofRoom=findViewById(R.id.roomNo);


        String roomType[]={"Deluxe","Presidential", "Premium"};
        ArrayAdapter adapter1=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,roomType
        );
        spinRoomType.setAdapter(adapter1);






    }


    }

