package nyc.c4q.rusili.hw_6_simon_says;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

/**
 * Created by rusili on 9/30/16.
 */
public class EndGame extends Activity {
    Button bYes = (Button) findViewById(R.id.idYes);
    Button bNo = (Button) findViewById(R.id.idNo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);
    }

    public void restart(View view) {
        Intent toMain = new Intent(this, MainActivity.class);
        startActivity(toMain);
    }

    public void endGame(View view) {
        this.finish();
    }
}