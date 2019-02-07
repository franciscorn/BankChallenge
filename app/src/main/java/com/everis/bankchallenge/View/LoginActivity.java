package com.everis.bankchallenge.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.everis.bankchallenge.Model.User;
import com.everis.bankchallenge.R;
import com.everis.bankchallenge.ToolBox.Utils;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

import static com.everis.bankchallenge.ToolBox.Constants.TAG_SHARED_USER;
import static com.everis.bankchallenge.ToolBox.Constants.TAG_SHARED_USER_EMAIL;
import static com.everis.bankchallenge.ToolBox.Constants.TAG_USER;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login;
    private TextInputEditText editTextUser, editTextPassword;
    private String userEmail, password, userPrefer;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        preferences = getSharedPreferences(TAG_SHARED_USER, MODE_PRIVATE);
        userPrefer = preferences.getString(TAG_SHARED_USER_EMAIL, "");


        btn_login = findViewById(R.id.button_login);
        editTextUser = findViewById(R.id.editText_user);
        editTextPassword = findViewById(R.id.editText_password);

        editTextUser.setText(userPrefer);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {
        userEmail = editTextUser.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();


        if (!Utils.validateEmail(userEmail)) {
            editTextUser.setError(getString(R.string.EmailErrorMessage));
        }
        if (!Utils.validatePassword(password)) {
            editTextPassword.setError(getString(R.string.PasswordErrorMessage));
        }
        if (Utils.validateEmail(userEmail) && Utils.validatePassword(password)) {
            User user = new User(userEmail, password);
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(TAG_SHARED_USER_EMAIL, userEmail).apply();

            Bundle bundle = new Bundle();
            bundle.putSerializable(TAG_USER, user);
            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        }
    }
}
