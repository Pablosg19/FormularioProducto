package com.example.formularioproducto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.formularioproducto.clases.Producto;

public class Ventana2Activity extends AppCompatActivity {

    private TextView txtMostrarProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);
        txtMostrarProducto = (TextView) findViewById(R.id.txt_mostrarProducto);
        // Coger el intent
        Intent intent = getIntent();
        if(intent != null){
            Producto p = (Producto) intent.getSerializableExtra(MainActivity.EXTRA_PRODUCTO);
            txtMostrarProducto.setText(p.toString());
        }

    }
}