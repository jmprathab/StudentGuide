package loginexample.techblogon.com.studentguide;

import android.app.Application;
import android.content.Context;

/**
 * This class extends Application
 * This class is contains methods used throughout the application
 */
public class ApplicationHelper extends Application {
    private static ApplicationHelper sInstance;

    public static ApplicationHelper getMyApplicationInstance() {
        return sInstance;
    }

    public static Context getMyApplicationContext() {
        return sInstance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
