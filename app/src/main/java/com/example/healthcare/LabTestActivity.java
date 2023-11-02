package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
        {"Pachet 1 : Verificare Completă", "", "", "", "999"},
        {"Pachet 2 : Analize Diabet", "", "", "", "299"},
        {"Pachet 3 : Analize COVID-19", "", "", "", "899"},
        {"Pachet 4 : Analize Glanda Tiroidă", "", "", "", "499"},
        {"Pachet 5 : Verificare Imunitate", "", "", "", "699"},
    };

    private String[] package_details = {
            "Analize Diabet\n" +
                    "Hemograma Completa\n" +
                    "HbA1c\n" +
                    "Analize de Fier\n" +
                    "Analize Rinichi\n" +
                    "Profilul Lipidic\n" +
                    "Testul Funcției Hepatice",
            "Analize Diabet",
            "Analize COVID-19",
            "Profil Tiroidal Complet (T3, T4, & TSH Ultra-sensitive)",
            "Hemograma Completă\n" +
                    "Analize de Fier\n" +
                    "Testul Funcției Hepatice\n" +
                    "Testul Funcției Renale\n" +
                    "Profilul Lipidic"
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonBMGoToCart);
        btnBack = findViewById(R.id.buttonBMBack);
        listView = findViewById(R.id.listViewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Cost total: " + packages[i][4] + " lei");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });
    }
}