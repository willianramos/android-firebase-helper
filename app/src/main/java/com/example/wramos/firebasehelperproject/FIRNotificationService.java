package com.example.wramos.firebasehelperproject;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FIRNotificationService extends FirebaseMessagingService {
    public FIRNotificationService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //TODO: Handle here the remoteMessage
    }
}
