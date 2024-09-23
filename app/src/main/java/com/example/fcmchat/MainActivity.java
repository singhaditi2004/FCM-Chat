package com.example.fcmchat;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if(!task.isSuccessful()){
                    Log.e("ONCOMPLETEFIREBASE","Error some");
                    return;
                }
                String token=task.getResult();
                Log.d("TOKEN","TOKEN is "+token); //eB85wHWQQw2qZEBswQaIqn:APA91bH51SFMYIKznFjipl6edXEoUvq2Oa8kXaqOuxVNgDj-Y_OsnD5Z_zzS83MaXHeYSzCCzS8NyKed66x_HR7oE86wd9-M4SyRBMoQLw2NrNtuJwoAlyLzjdxo26ZnNzTovk0JqCBf
            }
        });
        DatabaseReference dbRef= FirebaseDatabase.getInstance().getReference("CopyWright");
        dbRef.setValue("Heyyyyyyyyyyyyyyyyyyy");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}