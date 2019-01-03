package xyz.raieen.broadcastmessagedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SenderActivity extends Activity {

    private String TAG = "ReceiverActivity";

    String ourUser = "alice";
    String targetUser = "bob";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sender);

        TextView textName = findViewById(R.id.text_name);
        textName.setText(ourUser);

        EditText editMessage = findViewById(R.id.edit_message);

        Button buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(v -> {
            Log.d(TAG, "onCreate: asldaksdaasda");
            addMessage(editMessage.getText().toString());
        });
    }

    public void addMessage(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("sent", System.currentTimeMillis());

        FirebaseFirestore.getInstance().collection("user")
                .document(targetUser).collection("message").add(map);
        Log.d(TAG, "addMessage: " + message);
    }
}
