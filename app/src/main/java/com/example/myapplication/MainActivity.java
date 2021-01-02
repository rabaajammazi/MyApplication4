package com.example.myapplication;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button mMy_button;
    EditText nName, pPassword;
    CheckBox cCheckbox;
    SharedPreferences pPreferences;
    SharedPreferences.Editor eEditor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMy_button = findViewById(R.id.login);
        cCheckbox = findViewById(R.id.checkBox2);
        nName = findViewById(R.id.textPersonLogin);
        pPassword = findViewById(R.id.textPassword);

        pPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //pPreferences = getSharedPreferences("com.example.myapplication",MODE_PRIVATE);
        eEditor = pPreferences.edit();

        checkSharedPreferences();

        mMy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cCheckbox.isChecked()) {

                    eEditor.putString(getString(R.string.checkbox), "True");
                    eEditor.commit();

                    String name = nName.getText().toString();
                    eEditor.putString(getString(R.string.your_name), name);
                    eEditor.commit();

                    String password = pPassword.getText().toString();
                    eEditor.putString(getString(R.string.your_password), password);


                } else {
                    eEditor.putString(getString(R.string.checkbox), "False");
                    eEditor.commit();

                    eEditor.putString(getString(R.string.your_name), "");
                    eEditor.commit();

                    eEditor.putString(getString(R.string.your_password), "");
                    eEditor.commit();
                }

            }
        });
    }


    private void checkSharedPreferences() {
        String checkbox = pPreferences.getString(getString(R.string.checkbox), "false");
        String name = pPreferences.getString(getString(R.string.your_name), "");
        String password = pPreferences.getString(getString(R.string.your_password), "");

        nName.setText(name);
        pPassword.setText(password);


        if (checkbox.equals("True")) {
            cCheckbox.setChecked(true);
        } else {
            cCheckbox.setChecked(false);
        }


    }


}








