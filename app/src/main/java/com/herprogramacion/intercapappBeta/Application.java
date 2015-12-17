package com.herprogramacion.intercapappBeta;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by Matias on 01/12/2015.
 */
public class Application extends android.app.Application {
    public Application(){
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, "oejVNc5vF8m1kPT9Fm8Ty38rk1xLlMgDInHlGmIJ", "e7pn6XcgxQbJ4XH19vDRpfmMB7SImNafPtfCjuMI");
        ParseInstallation.getCurrentInstallation().saveInBackground();


    }



}
