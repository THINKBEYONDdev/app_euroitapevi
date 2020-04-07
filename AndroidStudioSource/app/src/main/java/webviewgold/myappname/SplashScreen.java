package webviewgold.myappname;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static SplashScreen instance;

    public static SplashScreen getInstance() {
        return instance;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.splash_screen);
        final ImageView splash = findViewById(R.id.splash);

        if (Config.SPLASH_SCREEN_ACTIVATED) {

            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                public void run() {
                    finish();
                }
            }, Config.SPLASH_TIMEOUT);


            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            splash.setImageResource(R.mipmap.splash);
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorWhite));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorWhite));

        }
        else{
            splash.setVisibility(View.GONE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    finish();
                    overridePendingTransition(0, 0);
                }
            }, 0);
        }
    }
}
