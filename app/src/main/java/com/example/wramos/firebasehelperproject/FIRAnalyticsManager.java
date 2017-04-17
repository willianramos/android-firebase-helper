package com.example.wramos.firebasehelperproject;

import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by wramos on 17/04/17.
 */

class FIRAnalyticsManager {
    private FirebaseAnalytics mFirebaseAnalytics;
    private static final FIRAnalyticsManager ourInstance = new FIRAnalyticsManager();

    private static FIRAnalyticsManager getInstance() {
        return ourInstance;
    }

    private FIRAnalyticsManager() {
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(App.get().getApplicationContext());
    }

    static void trackEvent(String event) {
        getInstance().mFirebaseAnalytics.logEvent(event, null);
    }

    static void trackEvent(String event, Bundle bundle) {
        getInstance().mFirebaseAnalytics.logEvent(event, bundle);
    }
}
