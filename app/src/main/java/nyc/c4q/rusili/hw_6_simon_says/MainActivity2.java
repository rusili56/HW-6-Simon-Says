package nyc.c4q.rusili.hw_6_simon_says;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    boolean check = true;
    public int iLevel = 1;
    private int iUserInput = 4;
    private boolean isVertical = true;
    public ArrayList<ImageView> alButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //  Vertical = 1, Horizontal = 2
        isVertical = getResources().getConfiguration().orientation == 1;
        /*
        while (check) {
            Simon.says(alButtons, iUserInput, iLevel);
            iLevel++;
        }
        */
        drawWhite(isVertical, iUserInput);
        drawBlack(isVertical, iUserInput);

        if (!check) {
            Intent toEnd = new Intent(this, EndGame.class);
            startActivity(toEnd);
            finish();
        }
    }

    public void drawWhite(boolean bInput, int iInput) {
//        Creates button in the layout through java
        LinearLayout llLayout = (LinearLayout) findViewById(R.id.idWhiteLayout);
        // Gets layout parameters
        LinearLayout.LayoutParams lpParams = new LinearLayout.LayoutParams(
                // Width, Height
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 100/iInput);

        // Creates each button
        for (int i = 0; i < iInput; i++) {

            final ImageView button = new ImageView(MainActivity2.this);
            button.setId(0);
            button.setTag("Button" + i);
            button.setLayoutParams(lpParams);

            button.setImageResource(R.drawable.buttonblue1);

            button.setScaleType(ImageView.ScaleType.FIT_XY);

            alButtons.add(button);

            // Button on Click:
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Timer.wait(button);
                }
            });
            llLayout.addView(button);
        }
    }

    public void drawBlack(boolean bInput, int iInput) {
        iInput = (iInput*2) - 1;
//        Creates button in the layout through java
        LinearLayout llLayout = (LinearLayout) findViewById(R.id.idBlackLayout);
        // Gets layout parameters
        LinearLayout.LayoutParams lpParams = new LinearLayout.LayoutParams(
                // Width, Height
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 100/iInput);

        // Creates each button
        for (int i = 0; i < iInput; i++) {

            final ImageView button = new ImageView(MainActivity2.this);
            button.setId(1);
            button.setTag("Button" + i);
            button.setLayoutParams(lpParams);

            if ((i+2) % 2 == 1){
                button.setImageResource(R.drawable.buttonred1);
            } else{
                button.setVisibility(View.INVISIBLE);
            }
            button.setScaleType(ImageView.ScaleType.FIT_XY);

            alButtons.add(button);

            // Button on Click:
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Timer.wait(button);
                }
            });
            llLayout.addView(button);
        }
    }
}
