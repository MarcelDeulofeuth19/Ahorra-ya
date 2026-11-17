package com.umb.ahorraya;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/** Ventana 2: formulario de inscripción. Los datos no se guardan: viajan por Intent. */
public class FormularioActivity extends AppCompatActivity {

    // Claves de los datos que se envían a la ventana de aceptación
    public static final String EXTRA_NOMBRE = "com.umb.ahorraya.NOMBRE";
    public static final String EXTRA_CORREO = "com.umb.ahorraya.CORREO";
    public static final String EXTRA_CIUDAD = "com.umb.ahorraya.CIUDAD";
    public static final String EXTRA_INGRESOS = "com.umb.ahorraya.INGRESOS";
    public static final String EXTRA_TEMAS = "com.umb.ahorraya.TEMAS";

    private EditText etNombre, etCorreo, etCiudad;
    private RadioGroup rgIngresos;
    private CheckBox cbAhorro, cbCredito, cbInversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNombre = findViewById(R.id.etNombre);
        etCorreo = findViewById(R.id.etCorreo);
        etCiudad = findViewById(R.id.etCiudad);
        rgIngresos = findViewById(R.id.rgIngresos);
        cbAhorro = findViewById(R.id.cbAhorro);
        cbCredito = findViewById(R.id.cbCredito);
        cbInversion = findViewById(R.id.cbInversion);
        Button btnInscribirme = findViewById(R.id.btnInscribirme);
        Button btnLimpiar = findViewById(R.id.btnLimpiar);

        btnInscribirme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarInscripcion();
            }
        });

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiarFormulario();
            }
        });
    }

    private void enviarInscripcion() {
        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String ciudad = etCiudad.getText().toString().trim();

        // Validaciones de los cuadros de texto
        if (nombre.isEmpty()) {
            etNombre.setError("Escribe tu nombre");
            etNombre.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Correo no válido");
            etCorreo.requestFocus();
            return;
        }
        if (ciudad.isEmpty()) {
            etCiudad.setError("Escribe tu ciudad");
            etCiudad.requestFocus();
            return;
        }

        // Botón de radio seleccionado
        int idSeleccionado = rgIngresos.getCheckedRadioButtonId();
        if (idSeleccionado == -1) {
            Toast.makeText(this, "Selecciona tu rango de ingresos", Toast.LENGTH_SHORT).show();
            return;
        }
        RadioButton rbSeleccionado = findViewById(idSeleccionado);
        String ingresos = rbSeleccionado.getText().toString();

        // Cuadros de selección marcados
        StringBuilder temas = new StringBuilder();
        agregarTema(temas, cbAhorro);
        agregarTema(temas, cbCredito);
        agregarTema(temas, cbInversion);
        if (temas.length() == 0) {
            Toast.makeText(this, "Marca al menos un tema de interés", Toast.LENGTH_SHORT).show();
            return;
        }

        // Los datos pasan a la siguiente ventana como extras del Intent
        Intent intent = new Intent(this, AceptacionActivity.class);
        intent.putExtra(EXTRA_NOMBRE, nombre);
        intent.putExtra(EXTRA_CORREO, correo);
        intent.putExtra(EXTRA_CIUDAD, ciudad);
        intent.putExtra(EXTRA_INGRESOS, ingresos);
        intent.putExtra(EXTRA_TEMAS, temas.toString());
        startActivity(intent);
    }

    private void agregarTema(StringBuilder temas, CheckBox casilla) {
        if (casilla.isChecked()) {
            if (temas.length() > 0) {
                temas.append(", ");
            }
            temas.append(casilla.getText());
        }
    }

    private void limpiarFormulario() {
        etNombre.setText("");
        etCorreo.setText("");
        etCiudad.setText("");
        rgIngresos.clearCheck();
        cbAhorro.setChecked(false);
        cbCredito.setChecked(false);
        cbInversion.setChecked(false);
        etNombre.requestFocus();
        Toast.makeText(this, "Formulario limpio", Toast.LENGTH_SHORT).show();
    }
}
