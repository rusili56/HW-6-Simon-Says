package nyc.c4q.rusili.hw_6_simon_says;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean check = true;
    public int iLevel = 1;
    private int iUserInput = 6;
    private boolean isVertical = true;
    public ArrayList<ImageView> alButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Vertical = 1, Horizontal = 2
        isVertical = getResources().getConfiguration().orientation == 1;

        this.Draw(isVertical, iUserInput);

        /*
        while (check) {
            Simon.says(alButtons, iUserInput, iLevel);
            iLevel++;
        }
        */

        if (!check) {
            Intent toEnd = new Intent(this, EndGame.class);
            startActivity(toEnd);
            finish();
        }
    }

    public void Draw(boolean bInput, final int iInput) {
//        Creates button in the layout through java
        LinearLayout llLayout = (LinearLayout) findViewById(R.id.idLayout);
        if (bInput) {
            llLayout.setOrientation(LinearLayout.VERTICAL);
        } else {
            llLayout.setOrientation(LinearLayout.HORIZONTAL);
        }

        // Gets layout parameters
        LinearLayout.LayoutParams lpParams = new LinearLayout.LayoutParams(
                // Width, Height
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 100 / iInput);

        // Creates each button
        for (int i = 0; i < iInput; i++) {

            final ImageView button = new ImageView(MainActivity.this);
            button.setId(i);
            button.setTag("Button" + i);
            button.setLayoutParams(lpParams);
            switch (i) {
                case 0:
                    button.setImageResource(R.drawable.buttonblue1);
                    break;
                case 1:
                    button.setImageResource(R.drawable.buttonred1);
                    break;
                case 2:
                    button.setImageResource(R.drawable.buttongreen1);
                    break;
                case 3:
                    button.setImageResource(R.drawable.buttonyellow1);
                    break;
                case 4:
                    button.setImageResource(R.drawable.buttonpurple1);
                    break;
                case 5:
                    button.setImageResource(R.drawable.buttonorange1);
                    break;
            }
            button.setScaleType(ImageView.ScaleType.FIT_XY);

            alButtons.add(button);

            // Button on Click:
            final Timer timer = new Timer();
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    timer.click(button, iInput);
                }
            });
            llLayout.addView(button);
        }
    }
}
