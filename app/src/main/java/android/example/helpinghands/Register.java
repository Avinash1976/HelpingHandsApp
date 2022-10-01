package android.example.helpinghands;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private TextView logIn;

    Button RegisterBtn;
    FirebaseAuth mAuth;
    TextInputEditText regPassword,regEmail,regName;
    EditText regPhone;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReferenceFromUrl("https://helpinghands-e4daf-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regEmail=findViewById(R.id.RegEmail);
        regName=findViewById(R.id.RegName);
        regPassword=findViewById(R.id.RegPassword);
        regPhone=findViewById(R.id.RegPhone);
        RegisterBtn=findViewById(R.id.btn_register);
        logIn=findViewById(R.id.txt_alreadyLog);
        logIn.setOnClickListener(view -> startActivity(new Intent(Register.this,LogIn.class)));

        mAuth=FirebaseAuth.getInstance();

        RegisterBtn.setOnClickListener(view -> {
            createUser();
        });
    }

    private void createUser() {
        final String email=regEmail.getText().toString();
        final String password=regPassword.getText().toString();
        final String userName=regName.getText().toString();
        final String phone=regPhone.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(userName) || TextUtils.isEmpty(phone)){
            regEmail.setError("Fill all the blanks");
            regName.requestFocus();
        }else{
            databaseReference.child("users").child(phone).child("Full name").setValue(userName);
            databaseReference.child("users").child(phone).child("Email").setValue(email);
            databaseReference.child("users").child(phone).child("Password").setValue(password);

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Register.this, "User Register Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this,LogIn.class));
                    }else{
                        Toast.makeText(Register.this, "Registration Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}