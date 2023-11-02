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
import java.util.SimpleTimeZone;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages = {
            {"ACC 600mg Sandoz", "", "", "", "38"},
            {"Bixtonim 10ml Biofarm", "", "", "", "14"},
            {"Tantum verde spray 3mg/ml Angelini", "", "", "", "25"},
            {"Exoderil 10mg/ml Sandoz", "", "", "", "36"},
            {"Defumoxan 1,5mg Aflofarm", "", "", "", "114"},
            {"Nurofen 200mg Reckitt Benckiser", "", "", "", "23"},
            {"Espumisan 100mg Berlin-Chemie", "", "", "", "25"},
            {"Claritine 10mg Bayer", "", "", "", "18"},
            {"Vibrocil 15ml GSK", "", "", "", "21"},
    };

    private String[] package_details = {
            "ACC 600 mg are actiune expectoranta si este indicat in terapia mucolitica in cazul afectiunilor acute si cronice ale bronhiilor si plamanilor, cu secretie mucoasa vascoasa.",
            "Bixtonim este un decongestionant nazal de uz local ce contine clorhidrat de efedrina, hidrocortizon, clorhidrat de nafazolina si este destinat administrarii la adulti, " +
                    "adolescenti si copii peste 3 ani.\n" +
                    "Bixtonim este utilizat in rinite acute si subacute, rinite alergice, edem postoperator al mucoasei nazale.",
            "Este indicat in tratamentul antiinflamator si analgezic al afectiunilor inflamatorii ale mucoasei oro-faringiene (stomatite, faringite) si ale gingiilor.\n" +
                    "Bucofaringian este indicat, de asemenea, in stomatologie, dupa extractii dentare.",
            "Exoderil 10 mg/ml solutie cutanata (clorhidrat de naftifina) este un medicament folosit impotriva fungilor, cu utilizare la nivelul pielii.",
            "Renuntarea la fumat si reducerea poftei de nicotina la fumatorii care doresc sa se opreasca din fumat.\n" +
                    "Obiectivul tratamentului cu Defumoxan este renuntarea permanenta la utilizarea produselor cu continut de nicotina.",
            "Substanta activa este ibuprofen.\n" +
                    "Ibuprofenul apartine unui grup de medicamente cunoscut sub numele de antiinflamatoare nesteroidiene (AINS), care actioneaza prin schimbarea raspunsului organismului la durere, inflamatie si febra.",
            "Acest medicament trateaza simptomele balonarii (acumulare excesiva de gaze in intestin) si este indicat pentru toate grupele de varsta.\n" +
                    "Actioneaza prin dezintegrarea bulelor de gaz din bolul alimentar si din mucusul din tractul digestiv.\n" +
                    "Gazele eliberate in cursul acestui proces pot fi absorbite (preluate) prin peretele intestinal sau eliminate prin miscarile intestinale.",
            "Claritine ajuta la reducerea simptomelor alergiei impiedicand efectele unei substante numite „histamina”, care este produsa in corp atunci cand sunteti alergic la ceva.",
            "Raceli, rinite acute si cronice, rinite alergice sezoniere (febra fanului) si nesezoniere, sinuzite acute si cronice, ingrijire pre- si postoperatorie.\n" +
                    "Adjuvant in otite medii acute.\n" +
                    "Vibrocilul gel se recomanda in special in cazuri de mucoasa nazala uscata, cruste ori sechele ale traumatismelor nazale, precum si pentru a mentine nasul curat in timpul noptii."
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
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
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}