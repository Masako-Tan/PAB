package edu.uph.m23si1.aplikasipertama;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorActivity extends AppCompatActivity {

    EditText edtAngka1, edtAngka2;
    Button btnTambah, btnKali, btnBagi;
    TextView textViewHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        edtAngka1 = findViewById(R.id.edtAngka1);
        edtAngka2 = findViewById(R.id.edtAngka2);
        btnTambah = findViewById(R.id.btnTambah);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        textViewHasil = findViewById(R.id.textView4);


        btnTambah.setOnClickListener(v -> {
            double a = ambilAngka(edtAngka1);
            double b = ambilAngka(edtAngka2);
            double hasil = a + b;
            textViewHasil.setText(String.valueOf(hasil));
        });


        btnKali.setOnClickListener(v -> {
            double a = ambilAngka(edtAngka1);
            double b = ambilAngka(edtAngka2);
            double hasil = a * b;
            textViewHasil.setText(String.valueOf(hasil));
        });


        btnBagi.setOnClickListener(v -> {
            double a = ambilAngka(edtAngka1);
            double b = ambilAngka(edtAngka2);
            if (b == 0) {
                textViewHasil.setText("∞");
            } else {
                double hasil = a / b;
                textViewHasil.setText(String.valueOf(hasil));
            }
        });
    }


    private double ambilAngka(EditText editText) {
        String isi = editText.getText().toString().trim();
        if (isi.isEmpty()) return 0;
        try {
            return Double.parseDouble(isi);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
