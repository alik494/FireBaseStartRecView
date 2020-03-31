package com.example.firebasestart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylcerViewMain);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        Map<String,Object> user= new HashMap<>();
//        user.put("first", "Ada");
//        user.put("last", "Lovelace");
//        user.put("born", 1815);
//        db.collection("users")
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Toast.makeText(MainActivity.this, "Succes", Toast.LENGTH_SHORT).show();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
//            }
//        });

//        db.collection("users")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        QuerySnapshot querySnapshot=task.getResult();
//                        if (querySnapshot==null) return;
//                        if (task.isSuccessful()){
//                            for (QueryDocumentSnapshot documentSnapshots: task.getResult()){
//                                Map<String,Object> user=documentSnapshots.getData();
//                                Log.i("fireStore", user.get("first").toString());
//                                Log.i("fireStore", user.get("last").toString());
//                                Log.i("fireStore", user.get("born").toString());
//                            }
//                        }else{
//
//                            Toast.makeText(MainActivity.this, "fail"+task.getException(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        db.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                if (queryDocumentSnapshots != null) {
                    for (QueryDocumentSnapshot documentSnapshots : queryDocumentSnapshots) {
                        Map<String, Object> user = documentSnapshots.getData();
                        Log.i("fireStore", user.get("first").toString());
                        Log.i("fireStore", user.get("last").toString());
                        Log.i("fireStore", user.get("born").toString());
                        Toast.makeText(MainActivity.this, "succes", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    public void onClickAddClientActivity(View view) {

    }
}
