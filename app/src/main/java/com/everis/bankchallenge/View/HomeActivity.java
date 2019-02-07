package com.everis.bankchallenge.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.everis.bankchallenge.R;
import com.everis.bankchallenge.ToolBox.Utils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
    private Context context;
    private TextView textViewUserName;
    private TextView textViewAccountNumber;
    private TextView textViewAccountBalance;
    private RecyclerView recyclerView;
    private Bundle parametros;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;
        textViewAccountBalance = findViewById(R.id.account_balance);
        textViewUserName = findViewById(R.id.user_name);
        textViewAccountNumber = findViewById(R.id.account_number);
        recyclerView = findViewById(R.id.recycler_home);

        parametros = getIntent().getExtras();

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_exit:
                onBackButtonPressed();
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onBackPressed() {
        Runnable ifTrue = new Runnable() {
            @Override
            public void run() {
                finish();
            }
        };

        Utils.alertDialog(getString(R.string.app_name), "Deseja sair?", true, "Sim", "Não",
                HomeActivity.this, ifTrue, null);
    }

    public void onBackButtonPressed() {

        Runnable ifTrue = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Runnable ifFalse = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        };

        Utils.alertDialog(getString(R.string.app_name), "Deseja fazer logout?", false, "Sim", "Não",
                HomeActivity.this, ifTrue, ifFalse);

    }
}
