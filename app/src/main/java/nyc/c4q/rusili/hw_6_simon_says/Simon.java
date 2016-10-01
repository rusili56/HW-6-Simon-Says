package nyc.c4q.rusili.hw_6_simon_says;

import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by rusili on 9/30/16.
 */

public class Simon {
    public static ArrayList<Integer> alSequence = new ArrayList<>();
    static Random rGenerator = new Random();

    public static ArrayList<Integer> says(ArrayList<Button> bInput, int iInputDifficulty, int iInputLevel) {
        alSequence.add(rGenerator.nextInt(iInputDifficulty));

        // Flashes the sequence
        for (int i = 0; i < iInputLevel; i++) {
            //Timer.wait(bInput.get(???));
        }

        return alSequence;
    }
}
