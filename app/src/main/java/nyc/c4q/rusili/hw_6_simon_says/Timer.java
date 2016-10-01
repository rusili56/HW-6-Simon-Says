package nyc.c4q.rusili.hw_6_simon_says;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.widget.Button;
import android.widget.FrameLayout;

import static nyc.c4q.rusili.hw_6_simon_says.R.attr.alpha;

/**
 * Created by rusili on 9/28/16.
 */

public class Timer {

    public static void wait(final Button bInput) {
        bInput.setBackgroundResource(R.drawable.button2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bInput.setBackgroundResource(R.drawable.button1);
            }
        }, 100);
    }
}
