package com.example.wramos.firebasehelperproject;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by wramos on 17/04/17.
 */

class FIRDatabaseManager {
    private static final FIRDatabaseManager ourInstance = new FIRDatabaseManager();
    private DatabaseReference ref;

    private static FIRDatabaseManager getInstance() {
        return ourInstance;
    }

    private FIRDatabaseManager() {
        this.ref = FirebaseDatabase.getInstance().getReference();
    }

    static void setValue(Object value, String reference, String id) {
        getInstance().ref.child(reference + "/" + id).setValue(value);
    }

    static String push(Object value, String reference){
        String key = getInstance().ref.child(reference).push().getKey();
        getInstance().ref.child(reference + "/" + key).setValue(value);

        return key;
    }

    static void getValue(String reference, final FIRCallbackInterface callback) {
        getInstance().ref.child(reference).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                callback.onSuccess(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onError(databaseError.getMessage());
            }
        });
    }

    static void getValue(String reference, String order, String filter, final FIRCallbackInterface callback){
        getInstance().ref.child(reference).orderByChild(order).equalTo(filter).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                callback.onSuccess(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callback.onError(databaseError.getMessage());
            }
        });
    }

    static void deleteValue(String id, String reference) {
        getInstance().ref.child(reference + "/" + reference).removeValue();
    }
}
