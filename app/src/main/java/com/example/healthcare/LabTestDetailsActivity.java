package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnAddToCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName = findViewById(R.id.textViewBMCartTitle);
        tvTotalCost = findViewById(R.id.textViewBMCartTotalPrice);
        edDetails = findViewById(R.id.listViewBMCart);
        btnAddToCart = findViewById(R.id.buttonBMCartCheckout);
        btnBack = findViewById(R.id.buttonBMCartGoBack);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Cost Total: " + intent.getStringExtra("text3") + " lei");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(), "health4all", null, 1);
                if(db.checkCart(username, product) == 1) {
                    Toast.makeText(getApplicationContext(), "Produs este deja în coș!", Toast.LENGTH_SHORT).show();
                } else {
                   db.addCart(username, product, price, "lab");
                    Toast.makeText(getApplicationContext(), "Produs adăugat în coș.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            }
        });
    }
}