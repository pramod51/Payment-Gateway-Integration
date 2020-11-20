package com.example.paymentgetewayintergation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class PaymentSucessed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_sucessed);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(PaymentSucessed.this,MainActivity.class);
                PaymentSucessed.this.startActivity(mainIntent);
                PaymentSucessed.this.finish();
            }
        }, 1700);

    }
}