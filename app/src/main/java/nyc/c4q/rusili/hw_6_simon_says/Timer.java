package nyc.c4q.rusili.hw_6_simon_says;

import android.app.Activity;
import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by rusili on 9/28/16.
 */

public class Timer extends Activity{

    public void click(final ImageView bInput, final int iInput) {

        if (bInput.getId() < iInput) {
            bInput.setImageResource(R.drawable.buttonblue2);
        } else if (bInput.getId() >= iInput){
            bInput.setImageResource(R.drawable.buttonred2);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (bInput.getId() < iInput) {
                    bInput.setImageResource(R.drawable.buttonblue1);
                } else if (bInput.getId() >= iInput){
                    bInput.setImageResource(R.drawable.buttonred1);
                }
            }
        }, 200);
    }

    public static void simonClick(final ImageView bInput, final int iInput) {

        if (bInput.getId()< iInput) {
            bInput.setImageResource(R.drawable.buttonblue2);
        } else {
            bInput.setImageResource(R.drawable.buttonred2);
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (bInput.getId()< iInput) {
                    bInput.setImageResource(R.drawable.buttonblue1);
                } else {
                    bInput.setImageResource(R.drawable.buttonred1);
                }            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (bInput.getId()< iInput) {
                    bInput.setImageResource(R.drawable.buttonblue1);
                } else {
                    bInput.setImageResource(R.drawable.buttonred1);
                }            }
        }, 1000);
    }
}
