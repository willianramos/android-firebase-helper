package com.example.wramos.firebasehelperproject;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by wramos on 17/04/17.
 */

class FIRAuthenticationManager {
    private static final FIRAuthenticationManager ourInstance = new FIRAuthenticationManager();
    private FirebaseAuth auth;

    private static FIRAuthenticationManager getInstance() {
        return ourInstance;
    }

    private FIRAuthenticationManager() {
        auth = FirebaseAuth.getInstance();
    }
}
