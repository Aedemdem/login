package com.lpkcti.a01;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Regis extends AppCompatActivity {
    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextConfirmPassword;
    Button btnRegis;

    SqliteHelper qq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        qq = new SqliteHelper(this);

        btnRegis = (Button) findViewById(R.id.btn_regis);
        editTextEmail = (EditText) findViewById(R.id.et_email);
        editTextPassword = (EditText) findViewById(R.id.et_password_reg);
        editTextConfirmPassword = (EditText) findViewById(R.id.et_password_konfir);
        editTextUserName = (EditText) findViewById(R.id.et_username_reg);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = editTextUserName.getText().toString();
                String Email = editTextEmail.getText().toString();
                String Password = editTextPassword.getText().toString();
                qq.addUser(new User(null, UserName, Email, Password));
                Toast.makeText(Regis.this, "Tersimpan",
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}
