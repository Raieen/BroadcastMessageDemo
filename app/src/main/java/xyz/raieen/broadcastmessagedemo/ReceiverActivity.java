package xyz.raieen.broadcastmessagedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;

public class ReceiverActivity extends Activity {
    private String TAG = "SenderActivity";

    String ourUser = "bob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        TextView textName = findViewById(R.id.text_name);
        textName.setText(ourUser);

        // Firestore
        FirebaseFirestore.getInstance()
                .collection("user")
                .document(ourUser)
                .collection("message")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        Log.d(TAG, "onCreate: Error " + e.getMessage());
                        return;
                    }

                    for (DocumentChange documentChange : queryDocumentSnapshots.getDocumentChanges()) {
                        if (documentChange.getType().equals(DocumentChange.Type.ADDED)) {
                            String message = (String) documentChange.getDocument().getData().get("message");
                            long timestamp = (long) documentChange.getDocument().getData().get("sent");

                            runOnUiThread(() -> addMessageUI(message, timestamp));
                        }
                    }
                });
    }


    public void addMessageUI(String message, long sent) {
        MessageView messageView = new MessageView(this);
        messageView.setMessage(message);
        messageView.setSent(sent);

        Log.d(TAG, "addMessageUI: Added message " + message);
    }
}