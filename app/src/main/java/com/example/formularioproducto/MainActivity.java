package com.example.formularioproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.formularioproducto.clases.Producto;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_PRODUCTO = "com.example.formularioproducto.producto";
    private Producto producto;
    private EditText edtIdentificadorProducto;
    private EditText edtNombreCliente;
    private EditText edtDireccionEnvio;
    private String tipoEnvio;
    private EditText edtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtIdentificadorProducto = (EditText) findViewById(R.id.edt_identificadorProducto);
        edtNombreCliente = (EditText) findViewById(R.id.edt_nombreCliente);
        edtDireccionEnvio = (EditText) findViewById(R.id.edt_direccionEnvio);
        edtTelefono = (EditText) findViewById(R.id.edt_telefono);
        tipoEnvio = "normal";
    }

    public void enviarFormulario(View view) {
        String identificador = String.valueOf(edtIdentificadorProducto.getText());
        String nombre = String.valueOf(edtNombreCliente.getText());
        String direccion = String.valueOf(edtDireccionEnvio.getText());
        String telefono = String.valueOf(edtTelefono.getText());
        producto = new Producto(identificador, nombre, direccion, telefono,tipoEnvio);
        Toast.makeText(this,producto.toString(),Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,Ventana2Activity.class);
        intent.putExtra(EXTRA_PRODUCTO,producto);
        startActivity(intent);
    }

    public void cambiarPrecioEnvio(View view) {
        RadioButton rb = (RadioButton) view;
        if(rb.isChecked()) {
            switch (rb.getId()){
                case R.id.rb_urgente:
                    tipoEnvio = "urgente";
                case R.id.rb_normal:
                    tipoEnvio = "normal";
                case R.id.rb_lento:
                    tipoEnvio = "lento";
            }
        }
        else{
            Toast.makeText(this,"Debes marcar una casilla",Toast.LENGTH_LONG).show();
        }
    }
}