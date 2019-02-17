package com.lpkcti.a01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText editTextUser;
    EditText editTextPassword;
    Button btnLogin;
    SqliteHelper qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        qq = new SqliteHelper(this);
        editTextUser = findViewById(R.id.et_username);
        editTextPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = editTextUser.getText().toString();
                String Password = editTextPassword.getText().toString();
                User currentUser = qq.Authenticate(new User(null, Username, null, Password));
                if (currentUser != null) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Login.this, "Gagal",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void Register(View view) {
        Intent intent = new Intent(Login.this, Regis.class);
        startActivity(intent);
        finish();
    }
}
