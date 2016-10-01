package nyc.c4q.rusili.hw_6_simon_says;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    boolean check = true;
    public int iLevel = 1;
    private int iUserInput = 2;
    private boolean isVertical = true;
    public ArrayList<Button> alButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  Vertical = 1, Horizontal = 2
        if (getResources().getConfiguration().orientation == 1){
            isVertical = true;
        } else {
            isVertical = false;
        }

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
        }
    }

    public void Draw(boolean bInput, int iInput) {
//        Creates button in the layout through java
        LinearLayout llLayout = (LinearLayout)findViewById(R.id.idLayout);
        if (bInput) {
            llLayout.setOrientation(LinearLayout.VERTICAL);
        } else {
            llLayout.setOrientation(LinearLayout.HORIZONTAL);
        }

        // Gets layout parameters
        LinearLayout.LayoutParams lpParams = new LinearLayout.LayoutParams(
                // Width, Height
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 100/iInput);

        // Creates each button
        for (int i=0; i<iInput; i++) {

            final Button button = new Button(MainActivity.this);
            button.setText("" + i);
            button.setTag("Button"+i);
            button.setLayoutParams(lpParams);
            button.setBackgroundResource(R.drawable.button1);

            alButtons.add(button);

            // Button on Click:
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Timer.wait(button);
                }
            });
            llLayout.addView(button);
            button.setText("" + alButtons.size());
        }
    }
}
