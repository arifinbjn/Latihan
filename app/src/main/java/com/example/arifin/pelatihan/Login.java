package com.example.arifin.pelatihan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText name_login, editpassword;
    Button buttondaftar, buttonbatal;
    String Username = "Arifin";
    String Password = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name_login = (EditText) findViewById(R.id.name_login);
        editpassword = (EditText) findViewById(R.id.editpassword);
        buttondaftar = (Button) findViewById(R.id.buttondaftar);
        buttonbatal = (Button) findViewById(R.id.buttonbatal);

        buttondaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name_login.getText().toString();
                String password = editpassword.getText().toString();
                if (password.equals(Password) && (username.equals(Username))) {
               /* Toast.makeText(Login.this,"Username:"+username+"Password:"+password,Toast.LENGTH_LONG).show();*/
                    Intent intent = new Intent(Login.this, TrainingDetails.class);
                    startActivity(intent);
                    login();
                } else {
                    Toast.makeText(Login.this, "Username dan Password Salah", Toast.LENGTH_LONG).show();
                }
            }

            private void login() {

            }
        });
        buttonbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                batal();
            }

            private void batal() {

            }
        });
    }
}
