package com.example.aplikasiedosirdatabase;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText mEmail, mPassword, mName;
    Button btnRegister, btnLogin;
    FirebaseAuth mAuth;
    FirebaseFirestore mFStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mName = findViewById(R.id.name);

        btnRegister = findViewById(R.id.btn_register);
        btnLogin = findViewById(R.id.btn_login);

        mAuth = FirebaseAuth.getInstance();
        mFStore = FirebaseFirestore.getInstance();

        btnRegister.setOnClickListener(v ->{
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            String name = mName.getText().toString();

            if (TextUtils.isEmpty(email)){
                mEmail.setError("Masukan Email Anda");
                return;
            }

            if (TextUtils.isEmpty(password)){
                mPassword.setError("Masukan Password Anda");
                return;
            }

            if (password.length() < 6){
                mPassword.setError("Password harus lebih dari 6 huruf");
                return;
            }

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((task) -> {
                if (task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "Akun telah dibuat", Toast.LENGTH_SHORT).show();
                    userId = mAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = mFStore.collection("users").document(userId);
                    Map<String, Object> user = new HashMap<>();
                    user.put("email", email);
                    user.put("nama", name);
                    documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Log.d(TAG, "onSuccess: user profile telah dibuat" + userId);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure :" + e.toString());
                        }
                    });
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                }else {
                    Toast.makeText(RegisterActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}