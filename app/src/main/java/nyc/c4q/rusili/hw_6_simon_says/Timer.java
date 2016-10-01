package nyc.c4q.rusili.hw_6_simon_says;

import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by rusili on 9/28/16.
 */

public class Timer {

    public static void wait(final ImageView bInput) {

        switch (bInput.getId()) {
            case 0:
                bInput.setImageResource(R.drawable.buttonblue2);
                break;
            case 1:
                bInput.setImageResource(R.drawable.buttonred2);
                break;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (bInput.getId()) {
                    case 0:
                        bInput.setImageResource(R.drawable.buttonblue1);
                        break;
                    case 1:
                        bInput.setImageResource(R.drawable.buttonred1);
                        break;
                }
            }
        }, 150);
    }
}
