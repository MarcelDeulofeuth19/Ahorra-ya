package com.umb.ahorraya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/** Ventana 1: presentación de la APP. */
public class PresentacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        Button btnComenzar = findViewById(R.id.btnComenzar);

        // Componente básico que pasa a la siguiente ventana
        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PresentacionActivity.this, FormularioActivity.class);
                startActivity(intent);
            }
        });
    }
}
