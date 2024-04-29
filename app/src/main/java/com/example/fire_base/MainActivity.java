package com.example.fire_base;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class MainActivity extends AppCompatActivity {
private EditText editTextTex;
private EditText editTextText5;
private Button button;
private FirebaseFirestore fb= FirebaseFirestore.getInstance();

private CollectionReference ColRef=fb.collection("emps");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTex=findViewById(R.id.editTextText);

        editTextText5=findViewById(R.id.editTextText5);

        button=findViewById(R.id.button);


    }

    public void btnsave(View view) {

        String name=editTextTex.getText().toString().trim();

        String dep=editTextText5.getText().toString().trim();

        Employees emp=new Employees(name,dep);

        ColRef.add(emp).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(MainActivity.this,"Data Good",Toast.LENGTH_SHORT).show();
            }
        }) .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("ERROR 336",e.toString());
                Toast.makeText(MainActivity.this,"DATA NOT GOOD " , Toast.LENGTH_SHORT).show();
            }
        });


    }
}