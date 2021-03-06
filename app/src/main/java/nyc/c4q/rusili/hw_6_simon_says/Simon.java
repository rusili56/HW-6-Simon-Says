package nyc.c4q.rusili.hw_6_simon_says;

import android.app.Activity;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import javax.xml.datatype.Duration;

/**
 * Created by rusili on 9/30/16.
 */

public class Simon extends Activity{
    public static ArrayList<Integer> alSequence = new ArrayList<>();
    static Random rGenerator = new Random();

    public static ArrayList<Integer> says(final ArrayList<ImageView> bInput, final int iInputDifficulty, final int iInputLevel) {

        // Flashes the sequence
        for (int i = 0; i < iInputLevel; i++) {

            final int finalI = i;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    alSequence.add(rGenerator.nextInt((iInputDifficulty*2)-1));
                    Timer.simonClick(bInput.get(alSequence.get(finalI)), iInputDifficulty);
                }
            }, 1500*i);
        }

        return alSequence;
    }
}
