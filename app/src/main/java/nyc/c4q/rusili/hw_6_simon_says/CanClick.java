package nyc.c4q.rusili.hw_6_simon_says;

import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by rusili on 10/1/16.
 */

public class CanClick {

    public static void no(ArrayList<ImageView> bInput){
        for (int i=0; i<bInput.size(); i++){
            bInput.get(i).setClickable(false);
            bInput.get(i).setFocusable(false);
            bInput.get(i).setEnabled(false);
        }
    }

    public static void yes(ArrayList<ImageView> bInput){
        for (int i=0; i<bInput.size(); i++){
            bInput.get(i).setClickable(true);
            bInput.get(i).setFocusable(true);
            bInput.get(i).setEnabled(true);
        }
    }
}
