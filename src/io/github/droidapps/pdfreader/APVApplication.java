package io.github.droidapps.pdfreader;

import android.app.Application;
import android.util.Log;
import io.github.droidapps.lib.pdf.PDF;

public class APVApplication extends Application {
    
    private final static String TAG = "io.github.droidapps.pdfreader";

    public void onCreate() {
        super.onCreate();
        PDF.setApplicationContext(this); // PDF class needs application context to load assets
    }
    
    /**
     * Called by system when low on memory.
     * Currently only logs.
     */
    public void onLowMemory() {
        super.onLowMemory();
        Log.w(TAG, "onLowMemory"); // TODO: free some memory (caches) in native code
    }

}
