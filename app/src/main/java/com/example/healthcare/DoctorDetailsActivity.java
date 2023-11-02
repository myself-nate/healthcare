package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Nume Doctor : Viorela Calin", "Adresa Spital : Galați", "Exp : 5yrs", "Nr. telefon: 0718213405", "600"},
            {"Nume Doctor : Anton Gheorghiu", "Adresa Spital : Brașov", "Exp : 15yrs", "Nr. telefon: 0725976695", "900"},
            {"Nume Doctor : Olivia Gherban", "Adresa Spital : Mureș", "Exp : 8yrs", "Nr. telefon: 0219175551", "300"},
            {"Nume Doctor : Florin Gheorghiu", "Adresa Spital : Satu Mare", "Exp : 6yrs", "Nr. telefon: 0242958203", "500"},
            {"Nume Doctor : Lidia Buţi", "Adresa Spital : Mehedinți", "Exp : 7yrs", "Nr. telefon: 0736550049", "800"},
    };

    private String[][] doctor_details2 = {
            {"Nume Doctor : Laurențiu Tudor", "Adresa Spital : Alba", "Exp : 5yrs", "Nr. telefon: 0334842107", "600"},
            {"Nume Doctor : Anton Sava", "Adresa Spital : Prahova", "Exp : 15yrs", "Nr. telefon: 0752903773", "900"},
            {"Nume Doctor : Marius Voinea", "Adresa Spital : Mehedinți", "Exp : 8yrs", "Nr. telefon: 0239844147", "300"},
            {"Nume Doctor : David Dumitrescu", "Adresa Spital : Arad", "Exp : 6yrs", "Nr. telefon: 0782137829", "500"},
            {"Nume Doctor : Alexandru Iancu", "Adresa Spital : Caraș-Severin", "Exp : 7yrs", "Nr. telefon: 0792577047", "800"},
    };

    private String[][] doctor_details3 = {
            {"Nume Doctor : Robert Diaconescu", "Adresa Spital : Argeș", "Exp : 4yrs", "Nr. telefon: 0355675591", "300"},
            {"Nume Doctor : David Călinescu", "Adresa Spital : Hunedoara", "Exp : 12yrs", "Nr. telefon: 0352074968", "800"},
            {"Nume Doctor : Florin Manole", "Adresa Spital : Alba", "Exp : 6yrs", "Nr. telefon: 0727864809", "600"},
            {"Nume Doctor : Ania Todică", "Adresa Spital : Ialomița", "Exp : 7yrs", "Nr. telefon: 0315605992", "500"},
            {"Nume Doctor : Smaranda Pălici", "Adresa Spital : Vrancea", "Exp : 17yrs", "Nr. telefon: 0311485384", "900"},
    };

    private String[][] doctor_details4 = {
            {"Nume Doctor : Adrian Tămaș", "Adresa Spital : Satu Mare", "Exp : 5yrs", "Nr. telefon: 0310893855", "800"},
            {"Nume Doctor : Andrei Toma", "Adresa Spital : Bistrița Năsăud", "Exp : 19yrs", "Nr. telefon: 0797631160", "900"},
            {"Nume Doctor : Mirel Toma", "Adresa Spital : București", "Exp : 7yrs", "Nr. telefon: 0378253215", "500"},
            {"Nume Doctor : Alfred Ursu", "Adresa Spital : Harghita", "Exp : 4yrs", "Nr. telefon: 0719223522", "300"},
            {"Nume Doctor : Elisabeta Stăruială", "Adresa Spital : Sălaj", "Exp : 8yrs", "Nr. telefon: 0330096344", "600"},
    };

    private String[][] doctor_details5 = {
            {"Nume Doctor : Iulian Dabija", "Adresa Spital : Hunedoara", "Exp : 4yrs", "Nr. telefon: 0310809359", "500"},
            {"Nume Doctor : Zoe Stăruială", "Adresa Spital : Dolj", "Exp : 12yrs", "Nr. telefon: 0269197805", "900"},
            {"Nume Doctor : Daniel Dinu", "Adresa Spital : Constanța", "Exp : 8yrs", "Nr. telefon: 0219175551", "800"},
            {"Nume Doctor : Mădălina Manolache", "Adresa Spital : Olt", "Exp : 7yrs", "Nr. telefon: 0367520228", "600"},
            {"Nume Doctor : Marius Mocanu", "Adresa Spital : Galați", "Exp : 2yrs", "Nr. telefon: 0241395572", "300"},
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewCartPackageName);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Medic de familie")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Nutritionist")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Chirurg")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Tarif consultatie: "+doctor_details[i][4]+" lei");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4", "line5"}, new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst = findViewById(R.id.listViewBM);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}