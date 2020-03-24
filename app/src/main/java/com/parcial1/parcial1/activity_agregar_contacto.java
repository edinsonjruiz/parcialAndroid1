package com.parcial1.parcial1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import com.parcial1.parcialandroid.R;

public class activity_agregar_contacto extends AppCompatActivity {

    private Spinner spinnerGrupo;
    private EditText edtNombre, edtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);

        initViews();
        initListeners();
    }

    private void initViews(){
        spinnerGrupo = findViewById(R.id.spinner);
        edtNombre = findViewById(R.id.edtNombre);
        edtTelefono = findViewById(R.id.edtTelefono);
    }

    private void initListeners(){

        findViewById(R.id.btnCancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.btnGuardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkForm()){
                    lista_conctacto contact = new lista_conctacto(
                            edtNombre.getText().toString(),
                            edtTelefono.getText().toString(),
                            spinnerGrupo.getItemAtPosition(spinnerGrupo.getFirstVisiblePosition()).toString());

                    Intent intent = getIntent();
                    intent.putExtra("newPerson", contact);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        spinnerGrupo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private boolean checkForm(){
        if (edtNombre.getText().toString().isEmpty()) {
            edtNombre.setError("Ingrese un nombre");
            return false;
        }
        if (edtTelefono.getText().toString().isEmpty()) {
            edtTelefono.setError("Ingrese un número de teléfono");
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_agregar_contacto, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_limpiar:
                edtNombre.setText("");
                edtTelefono.setText("");
                return true;
            case R.id.menu_mostrar:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

