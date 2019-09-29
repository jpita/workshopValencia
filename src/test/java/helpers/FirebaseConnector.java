package helpers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FirebaseConnector {

    public FirebaseConnector() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("bod-qa-firebase-adminsdk-ewpvf-5c6dee2aa1.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://bod-qa.firebaseio.com/")
                .build();

        FirebaseApp.initializeApp(options);

    }

    public DatabaseReference getDatabaseReferenceWithBusStationID(String busStationID) {
        return FirebaseDatabase.getInstance().getReference().child("bus-stations").child(busStationID);
    }


    public DatabaseReference getDatabaseReferenceForServerUp() {
        return FirebaseDatabase.getInstance().getReference().child("admin").child("serverup");
    }

    public DatabaseReference getDatabaseReferenceForNotifications() {
        return FirebaseDatabase.getInstance().getReference().child("notifications");
    }

    public boolean putServiceDown() {
        try {
            getDatabaseReferenceForServerUp().setValueAsync(false).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean putServiceUp() {
        try {
            getDatabaseReferenceForServerUp().setValueAsync(true).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteNotificationsNode() {
        try {
            getDatabaseReferenceForNotifications().setValueAsync(null).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
