package xyz.raieen.broadcastmessagedemo;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void initFirestore() {

        /*public void initFirestore() {
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();

        // Collections
        collectionReferenceUser = firestore.collection(COLLECTION_USER);
        collectionReferenceQueue = firestore.collection(COLLECTION_QUEUE);
        collectionReferenceQueueElement = firestore.collection(COLLECTION_QUEUEELEMENT);*/
    }
}
