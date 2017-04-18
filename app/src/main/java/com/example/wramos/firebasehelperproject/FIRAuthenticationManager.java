package com.example.wramos.firebasehelperproject;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

class FIRAuthenticationManager {
    private static final FIRAuthenticationManager ourInstance = new FIRAuthenticationManager();
    private FirebaseAuth auth;

    private static FIRAuthenticationManager getInstance() {
        return ourInstance;
    }

    private FIRAuthenticationManager() {
        auth = FirebaseAuth.getInstance();
    }

    static void createUser(String email, String password, final FIRCallbackInterface callback) {
        getInstance().auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = getCurrentUser();
                    callback.onSuccess(user);
                } else {
                    callback.onError(task.getException().getLocalizedMessage());
                }
            }
        });
    }

    static void login(String email, String password, final FIRCallbackInterface callback) {
        getInstance().auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = getCurrentUser();
                    callback.onSuccess(user);
                } else {
                    callback.onError(task.getException().getLocalizedMessage());
                }
            }
        });
    }

    static FirebaseUser getCurrentUser() {
        FirebaseUser user = getInstance().auth.getCurrentUser();
        return user;
    }
}
