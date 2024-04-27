package com.example.tarea3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PedidoActivity extends Activity {

    private EditText editTextNombre;
    private EditText editTextCantidad;
    private Button btnConfirmarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidos);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextCantidad = findViewById(R.id.editTextCantidad);
        btnConfirmarPedido = findViewById(R.id.btnConfirmarPedido);

        btnConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarPedido();
            }
        });
    }

    private void confirmarPedido() {
        String nombre = editTextNombre.getText().toString().trim();
        String cantidadStr = editTextCantidad.getText().toString().trim();

        if (nombre.isEmpty() || cantidadStr.isEmpty()) {
            Toast.makeText(this, getString(R.string.por_favor_completa_todos_los_campos), Toast.LENGTH_SHORT).show();
            return;
        }

        int cantidad = Integer.parseInt(cantidadStr);

        if (cantidad <= 0) {
            Toast.makeText(this, getString(R.string.la_cantidad_debe_ser_mayor_que_cero), Toast.LENGTH_SHORT).show();
            return;
        }

        String mensaje = getString(R.string.pedido_confirmado_para) + nombre + ", cantidad: " + cantidad;
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
