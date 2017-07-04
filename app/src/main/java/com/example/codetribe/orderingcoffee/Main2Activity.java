package com.example.codetribe.orderingcoffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.codetribe.orderingcoffee.MainActivity.capaccino;
import static com.example.codetribe.orderingcoffee.MainActivity.coffee;
import static com.example.codetribe.orderingcoffee.MainActivity.expresso;
import static com.example.codetribe.orderingcoffee.MainActivity.latte;
import static com.example.codetribe.orderingcoffee.MainActivity.milkshake;
import static com.example.codetribe.orderingcoffee.MainActivity.tea;
import static com.example.codetribe.orderingcoffee.MainActivity.z;

public class Main2Activity extends AppCompatActivity {
     //declaring variables
    TextView orderDetails,quantity;
    MainActivity x = new MainActivity();
    String cof="";
    String exp="";
    String tae="";
    String milk="";
    String cap="";
    String lat="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //calling selected spinners to display from mainActivity

        Bundle FirstData =getIntent().getExtras();
        String FirstMassage=FirstData.getString("TeamA");
        final TextView Secondmessage=(TextView) findViewById(R.id.spinner_results);
        Secondmessage.setText(FirstMassage);

        Bundle FirstData1 =getIntent().getExtras();
        String FirstMassage1=FirstData1.getString("TeamAa");
       final TextView Secondmessage1=(TextView) findViewById(R.id.spinner_results);
        Secondmessage1.setText(FirstMassage1);

        Bundle FirstData2 =getIntent().getExtras();
        String FirstMassage2=FirstData2.getString("TeamA1");
       final TextView Secondmessage2=(TextView) findViewById(R.id.spinner_results);
        Secondmessage2.setText(FirstMassage2);

        //ordered and quantity casting
        orderDetails = (TextView)findViewById(R.id.orderDetails);
        quantity= (TextView) findViewById(R.id.textView);



          //coffe ordered method
        if(coffee.isChecked())
        {

            cof=coffee.getText().toString();
            quantity.setText(z.getText());

        }
        //expresso ordered method
        if(expresso.isChecked())
        {
            exp=expresso.getText().toString();
            quantity.setText(z.getText());

        }
           //tea ordered method
           if(tea.isChecked()){
               tae=tea.getText().toString();
               quantity.setText(z.getText());
           }
             //milkshake ordered method
           if (milkshake.isChecked()){
               milk=milkshake.getText().toString();
               quantity.setText(z.getText());
           }
              //capaccino ordered method
           if (capaccino.isChecked()){
               cap=capaccino.getText().toString();
               quantity.setText(z.getText());
           }
            //latte ordered method
            if (latte.isChecked()){
                lat=latte.getText().toString();
                quantity.setText(z.getText());
            }
        orderDetails.setText(cof+"\n"+exp+"\n"+ tae+"\n"+milk+"\n"+cap+"\n"+lat );


    }



}
