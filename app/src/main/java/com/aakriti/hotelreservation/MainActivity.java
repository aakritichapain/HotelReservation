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
    TextView cbIn,cbOut,tvtotalCost,tvVat,tvGrandTotal;
    int year1,year2,month1,month2,day1,day2;


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
        btnCalculate=findViewById(R.id.btnCalculate);

        tvtotalCost=findViewById(R.id.totalCost);
        tvVat=findViewById(R.id.tvVat);
        tvGrandTotal=findViewById(R.id.tvGrandTotal);



        String roomType[]={"Deluxe","Presidential", "Premium"};
        ArrayAdapter adapter1=new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,roomType
        );
        spinRoomType.setAdapter(adapter1);



        cbIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadDatePicker();
            }
        });

        cbOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker1();
            }
        });



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(cbIn.getText())) {
                    cbIn.setText("Please enter checkin date ");
                    return;
                }
                else if (TextUtils.isEmpty(cbOut.getText())) {
                    cbOut.setText("Please enter checkedout date ");
                    return;
                }


                Calendar cal1 = Calendar.getInstance();
                Calendar cal2 = Calendar.getInstance();
                cal1.set(year1, month1, day1);
                cal2.set(year2, month2, day2);
                long millis1 = cal1.getTimeInMillis();
                long millis2 = cal2.getTimeInMillis();
                long diff = millis2 - millis1;
                long diffDays = (diff / (86400000));

                int  numRoom = Integer.parseInt(etRoomno.getText().toString());

                double roomprice,totalprice,vat,grandtotal;
                String roomtype=spinRoomType.getSelectedItem().toString();

                if(roomtype=="Deluxe"){
                    roomprice=2000;
                    totalprice=roomprice*numRoom*diffDays;
                    vat=(0.13*totalprice) + totalprice;
                    grandtotal= vat;

                    tvtotalCost.setText("Total cost is: "+totalprice);
                    tvVat.setText("Price after VAT(13%) is: "+vat);
                    tvGrandTotal.setText("GrandTotal: "+grandtotal);
                }

                else if(roomtype=="Presidential"){
                    roomprice=5000;
                    totalprice=roomprice*numRoom*diffDays;
                    vat=(0.13*totalprice) + totalprice;
                    grandtotal= vat;

                    tvtotalCost.setText("Total cost is: "+totalprice);
                    tvVat.setText("Price after VAT(13%) is: "+vat);
                    tvGrandTotal.setText("GrandTotal: "+grandtotal);
                }

                else if(roomtype=="Premium"){
                    roomprice=4000;
                    totalprice=roomprice*numRoom*diffDays;
                    vat=(0.13*totalprice) + totalprice;
                    grandtotal= vat;

                    tvtotalCost.setText("Total cost is: "+totalprice);
                    tvVat.setText("Price after VAT(13%) is: "+vat);
                    tvGrandTotal.setText("GrandTotal: "+grandtotal);
                }

            }
        });

    }



    private  void loadDatePicker(){
        final Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Checking Date : " +month +"/"+dayOfMonth+"/"+year;
                year1=year;
                month1=month;
                day1=dayOfMonth;

                cbIn.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }


    private  void loadDatePicker1(){
        final Calendar ca=Calendar.getInstance();
        int year=ca.get(Calendar.YEAR);
        int month=ca.get(Calendar.MONTH);
        int day=ca.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date = "Checkout Date : " +month +"/"+dayOfMonth+"/"+year;

                year2=year;
                month2=month;
                day2=dayOfMonth;

                cbOut.setText(date);
            }
        },year,month,day);
        datePickerDialog.show();
    }


    }

