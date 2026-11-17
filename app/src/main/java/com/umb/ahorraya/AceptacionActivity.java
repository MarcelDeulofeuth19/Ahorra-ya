package com.umb.ahorraya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/** Ventana 3: aceptación de la inscripción. Muestra lo que el usuario escribió y seleccionó. */
public class AceptacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aceptacion);

        TextView tvResumen = findViewById(R.id.tvResumen);
        Button btnNuevaInscripcion = findViewById(R.id.btnNuevaInscripcion);
        Button btnSalir = findViewById(R.id.btnSalir);

        // Datos recibidos desde el formulario
        Intent datos = getIntent();
        String nombre = datos.getStringExtra(FormularioActivity.EXTRA_NOMBRE);
        String correo = datos.getStringExtra(FormularioActivity.EXTRA_CORREO);
        String ciudad = datos.getStringExtra(FormularioActivity.EXTRA_CIUDAD);
        String ingresos = datos.getStringExtra(FormularioActivity.EXTRA_INGRESOS);
        String temas = datos.getStringExtra(FormularioActivity.EXTRA_TEMAS);

        // Se arma el resumen añadiendo texto con append()
        tvResumen.setText(nombre + ", quedaste inscrito en el programa AhorraYa.\n\n");
        tvResumen.append("Nombre: " + nombre + "\n");
        tvResumen.append("Correo: " + correo + "\n");
        tvResumen.append("Ciudad: " + ciudad + "\n");
        tvResumen.append("Ingresos: " + ingresos + "\n");
        tvResumen.append("Temas de interés: " + temas + "\n");

        btnNuevaInscripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vuelve a la ventana de presentación cerrando las demás
                Intent intent = new Intent(AceptacionActivity.this, PresentacionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cierra todas las actividades y detiene el proceso de la APP
                finishAffinity();
                System.exit(0);
            }
        });
    }
}
