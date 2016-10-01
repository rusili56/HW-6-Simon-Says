package nyc.c4q.rusili.hw_6_simon_says;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toMain = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(toMain);
                finish();
            }
        }, 5000);

    }
}
