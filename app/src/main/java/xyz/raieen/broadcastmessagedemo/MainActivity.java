package xyz.raieen.broadcastmessagedemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Buttons
        Button sender = findViewById(R.id.button_sender);
        Button receiver = findViewById(R.id.button_reciever);

        // Listeners to start sender/receiver activities
        sender.setOnClickListener(v -> {
            Intent intent = new Intent(this, SenderActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
            startActivity(intent);
            finish(); // Close activity
        });

        receiver.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReceiverActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
            startActivity(intent);
            finish(); // Close activity
        });
    }
}
