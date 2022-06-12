package com.example.app07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtUsuario;
    private EditText txtContrasena;
    private Button btnIngresar;
    private Usuarios user = new Usuarios();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtUsuario.getText().toString().matches("") ||
                        txtContrasena.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Faltan algunos datos por llenar.", Toast.LENGTH_SHORT).show();
                } else {
                    if(txtUsuario.getText().toString().matches(user.getUser()) &&
                            txtContrasena.getText().toString().matches(user.getContrasena())){
                        Intent intent = new Intent(MainActivity.this, LstActivity.class);
                        // intent.putExtra("Usuario", txtUsuario.getText().toString());
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("Usuario", user);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Usuario y/o contraseña incorrectos.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void iniciar(){
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtContrasena = (EditText) findViewById(R.id.txtContrasena);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        user.setUser(getResources().getString(R.string.userName));
        user.setContrasena(getResources().getString(R.string.contraseña));
        user.setNombreCompleto(getResources().getString(R.string.nombre));
        user.setEmail(getResources().getString(R.string.email));
    }
}