package com.example.homework4_sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = findViewById(R.id.textView2);
        EditText edit = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        SharedPreferences sp = getSharedPreferences("name", MODE_PRIVATE);

        String savedText = sp.getString("savedText", "###");
        text.setText("Hello " + savedText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edit.getText().toString();
                text.setText("Hello " + user);

                SharedPreferences.Editor editor = sp.edit();
                editor.putString("savedText", user);
                editor.apply();
            }
        });
    }
}
