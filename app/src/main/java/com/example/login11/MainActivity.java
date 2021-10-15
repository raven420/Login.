package com.example.login11;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.lang.ref.Reference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText emailTxt, passTxt;
    private String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        emailTxt = findViewById(R.id.editTextTextPersonName2);
        passTxt = findViewById(R.id.editTextTextPersonName2);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                email = emailTxt.getText().toString();
                password = passTxt.getText().toString();



            }
        });
    }

    private void checkLoginDetails() {

        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance;


        Call<String> call = null;

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()){
                    if (response.body().matches("success")){
                        Toast.makeText(getApplicationContext(), "Successfully Logged In.", Toast.LENGTH_LONG).show();

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Invalid credentials.", Toast.LENGTH_LONG).show();
                    }

                }
                else {
                    //handle error
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Log.e("TAG", t.toString());
                t.printStackTrace();

            }
        });
    }


}