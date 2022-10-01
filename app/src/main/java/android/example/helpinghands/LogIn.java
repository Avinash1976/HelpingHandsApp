package android.example.helpinghands;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    TextView regHere;
    Button btnLogIn;
    TextInputEditText etLogInEmail;
    TextInputEditText etLogInPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etLogInEmail=findViewById(R.id.logInEmail);
        etLogInPassword=findViewById(R.id.logInPassword);
        btnLogIn=findViewById(R.id.btn_logIn);

        regHere=findViewById(R.id.RegHere);
        regHere.setOnClickListener(view -> startActivity(new Intent(LogIn.this,Register.class)));

        mAuth=FirebaseAuth.getInstance();

        btnLogIn.setOnClickListener(view -> {
            loginUser();
        });


    }

    private void loginUser() {
        String email=etLogInEmail.getText().toString();
        String password=etLogInPassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            etLogInEmail.setError("Email cannot be Empty");
            etLogInEmail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            etLogInPassword.setError("Passwoed cannot be Empty");
            etLogInPassword.requestFocus();
        }else{
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(LogIn.this, "User Logged In Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LogIn.this,MainActivity.class));
                    }else{
                        Toast.makeText(LogIn.this, "Login Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}