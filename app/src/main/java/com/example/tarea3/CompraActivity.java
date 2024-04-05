package com.example.tarea3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompraActivity extends Activity {

    private ListView listViewProductos;
    private List<String> productos;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compras);

        productos = new ArrayList<>(Arrays.asList("Producto 1", "Producto 2", "Producto 3"));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, productos);

        listViewProductos = findViewById(R.id.listViewProductos);
        listViewProductos.setAdapter(adapter);

        listViewProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                agregarAlCarrito(position);
            }
        });
    }

    private void agregarAlCarrito(int position) {
        String producto = productos.get(position);
        Toast.makeText(this, "Agregado al carrito: " + producto, Toast.LENGTH_SHORT).show();
    }
}
