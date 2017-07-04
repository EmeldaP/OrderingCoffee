package com.example.codetribe.orderingcoffee;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener{

    //declare and initiate totalAmount
   public  double totalAmount = 0;

    //declare checkbox,buttons and editText
 static CheckBox coffee,latte,capaccino,expresso,tea,milkshake;
    private Button btnTotal,btnOrder,btnCancel;
    public static EditText z;

    //Spinners declared
    public String spinner;
    Spinner spinnerf;
    public String spinner2;
    Spinner spinnerb;
    public String spinner3;
    Spinner spinners;

    //array adapters for spinners
    static ArrayAdapter<String> listAdapter;

    //arraylist for array containers and content
    ArrayList<String> itemordered= new ArrayList<>();
    ArrayList<String> topping = new ArrayList<>();
    ArrayList<String> teas = new ArrayList<>();
    ArrayList<String>flavour = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //casting resource id into checkbox
        coffee = (CheckBox) findViewById(R.id.checkBox5);
        latte = (CheckBox) findViewById(R.id.checkBox10);
        capaccino = (CheckBox) findViewById(R.id.checkBox9);
        expresso = (CheckBox) findViewById(R.id.checkBox7);
        tea = (CheckBox) findViewById(R.id.checkBox6);
        milkshake = (CheckBox) findViewById(R.id.checkBox8);
        btnCancel = (Button) findViewById(R.id.cancel_action3);
        btnOrder = (Button) findViewById(R.id.Order);
        btnTotal = (Button) findViewById(R.id.total);
        z=(EditText) findViewById(R.id.editText2);

        btnCancel.setOnClickListener(this);

        //casting Spinners by resource id
        spinnerf = (Spinner) findViewById(R.id.spinner);
        spinnerb = (Spinner) findViewById(R.id.spinner2);
        spinners = (Spinner) findViewById(R.id.spinner3);

        //arrays
        String[] extra = {"white sugar", "brown sugar", "milk", "cream",""};
        listAdapter = new ArrayAdapter<String>(this, R.layout.text, extra);
        spinnerf.setAdapter(listAdapter);

        final String[] tea_type = {"white sugar", "brown sugar", "milk", "cream",""};
        listAdapter = new ArrayAdapter<String>(this, R.layout.text, tea_type);
        spinnerb.setAdapter(listAdapter);

        final String[] flavours = {"strawberry", "chocolate", "bubblegum", "vanila",""};
        listAdapter = new ArrayAdapter<String>(this, R.layout.text, flavours);
        spinners.setAdapter(listAdapter);


        btnTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (coffee.isChecked()) {
                    spinner=spinnerf.getSelectedItem().toString();
                    topping.add(spinner);
                    itemordered.add(coffee.getText().toString());
                    double x = Double.valueOf(z.getText().toString());
                    totalAmount = (x * 15.00);
                     //totalAmount += 15.00;
                    btnTotal.setText("Total R" +Double.toString(totalAmount) );

                }
                if (expresso.isChecked()) {
                    spinner2=spinnerb.getSelectedItem().toString();
                    topping.add(spinner2);
                    itemordered.add(expresso.getText().toString());
                    double x=Double.valueOf(z.getText().toString());
                    totalAmount=(x*19.59);
                    //totalAmount += 19.59;
                    btnTotal.setText("Total R" +Double.toString(totalAmount) );
                }

                if (tea.isChecked()) {
                    topping.add(tea.getText().toString());
                    itemordered.add(tea.getText().toString());
                    double x=Double.valueOf(z.getText().toString());
                    totalAmount=(x*13.00);
                  //  totalAmount += 13.00;
                    btnTotal.setText("Total R" +Double.toString(totalAmount) );
                }
                if (milkshake.isChecked()) {
                   spinner3= spinners.getSelectedItem().toString();
                    topping.add(spinner3);
                    itemordered.add(milkshake.getText().toString());
                    double x=Double.valueOf(z.getText().toString());
                    totalAmount=(x*17.00);
                    //totalAmount += 17.00;
                    btnTotal.setText("Total R" +Double.toString(totalAmount) );
                }

                if (capaccino.isChecked()) {
                    topping.add(capaccino.getText().toString());
                    itemordered.add(capaccino.getText().toString());
                    double x=Double.valueOf(z.getText().toString());
                    totalAmount=(x*15.00);
                   // totalAmount += 15.00;
                    btnTotal.setText("Total R" +Double.toString(totalAmount) );
                }
                if (latte.isChecked()) {
                    topping.add(latte.getText().toString());
                    itemordered.add(latte.getText().toString());
                    double x=Double.valueOf(z.getText().toString());
                    totalAmount=(x*21.90);
                    Math.round(totalAmount);
                    // totalAmount += 21.90;
                    btnTotal.setText("Total R" +Double.toString(totalAmount) );
                }

            }
        });
         //onclick method for button order
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Your order went through successfully.\n Thank you", Toast.LENGTH_SHORT).show();
                Intent btnOrder = new Intent(MainActivity.this,Main2Activity.class);
               // btnOrder.putStringArrayListExtra(ITEMSORDERD,itemordered);
                //btnOrder.putStringArrayListExtra(FLAVOURS,flavour);
                //btnOrder.putStringArrayListExtra(TEATYPE,teas);

                final Spinner ScoreA= (Spinner) findViewById(R.id.spinner);
                String usermessage=ScoreA.getSelectedItem().toString();
                btnOrder.putExtra("TeamA",usermessage);

                final Spinner ScoreB= (Spinner) findViewById(R.id.spinner2);
                String userMessage1=ScoreB.getSelectedItem().toString();
                btnOrder.putExtra("TeamAa",userMessage1);

                final Spinner Scorec= (Spinner) findViewById(R.id.spinner3);
                String usermessages=Scorec.getSelectedItem().toString();
                btnOrder.putExtra(""  + "TeamA1",usermessages);
                btnTotal.setText("Total R"+ Double.toString(totalAmount) );
                
                startActivity(btnOrder);

            }
        });
        //cancell button method
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnTotal.setText("Total");
                z.setText("0");
                Toast.makeText(MainActivity.this, " Your order have been cancelled", Toast.LENGTH_SHORT).show();

            }
        });

         }

    @Override
    public void onClick(View v) {

    }
}





