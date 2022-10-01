package android.example.helpinghands;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button GetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetStarted=findViewById(R.id.get_started);
        GetStarted.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,FirstActivity.class)));


    }
}