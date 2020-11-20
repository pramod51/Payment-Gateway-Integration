package com.example.paymentgetewayintergation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class SelectAmount extends AppCompatActivity {

    public static final String KEY_STATUS="mask";
    public static final String KEY_STATUS1="mask1";
    private EditText amount;
    private Button proced;
    private String s,amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_amount);
        amount=findViewById(R.id.select_amount);
        Intent status = getIntent();
        s=status.getStringExtra(KEY_STATUS);
        proced=findViewById(R.id.proceed);
        proced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(SelectAmount.this,s,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(SelectAmount.this,CardDetails.class);
                amt=amount.getText().toString();
                if (amt.isEmpty())
                    amt="0";
                intent.putExtra(KEY_STATUS,s);
                intent.putExtra(KEY_STATUS1,amt);
                startActivity(intent);
            }
        });
    }


}