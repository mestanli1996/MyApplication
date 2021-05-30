package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class RegisterActivity extends AppCompatActivity {
    ArrayList<Person> persons;
    EditText name_register;
    EditText surname_register;
    EditText birthday_register;
    EditText phone_register;
    EditText password_register;
    EditText password2_register;

    EditText emailValidate;
    Button buton_register;
    String name;
    String surname;
    String birthday;
    String phone;
    String password;
    String password2;
    String email;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private static final String FILE_NAME = "example.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        defineVariables();
        defineListeners();
    }

    public void defineVariables() {
        persons = Person.getPersonsList();
        buton_register = findViewById(R.id.register_buton);
        emailValidate = (EditText)findViewById(R.id.email_text);
        name_register = (EditText)findViewById(R.id.register_name);
        surname_register = (EditText)findViewById(R.id.register_surname);
        birthday_register = (EditText)findViewById(R.id.register_birthday);
        phone_register = (EditText)findViewById(R.id.register_phone);
        password_register =(EditText)findViewById(R.id.register_password);
        password2_register = (EditText)findViewById(R.id.register_password2);
    }

    public void defineListeners() {
        buton_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = name_register.getText().toString();
                surname = surname_register.getText().toString();
                birthday = birthday_register.getText().toString();
                phone = phone_register.getText().toString();
                password = password_register.getText().toString();
                password2 = password2_register.getText().toString();
                email = emailValidate.getText().toString().trim();

                if(name.matches("") || surname.matches("") || birthday.matches("") || phone.matches("") ||
                        password.matches("") || password2.matches("") || email.matches("") ) {
                    Toast.makeText(RegisterActivity.this,"Fill in all mandatory fields", Toast.LENGTH_SHORT).show();
                } else if (!email.matches(emailPattern)) {
                    Toast.makeText(RegisterActivity.this,"invalid email address", Toast.LENGTH_SHORT).show();
                } else if (phone.length() != 14) {
                    Toast.makeText(RegisterActivity.this,"Check the your phone number", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(password2)) {
                    Toast.makeText(RegisterActivity.this,"Re-entered password is not correct", Toast.LENGTH_SHORT).show();
                } else {
                    Intent register;
                    register = new Intent(v.getContext(), MainActivity.class);
                    startActivity(register);
                }

            }
        });
        phone_register.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }
}