package nyc.c4q.rusili.hw_6_simon_says;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    boolean check = true;
    public int iLevel = 5;
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
            button.setId(i);
            button.setTag("White" + i);
            button.setLayoutParams(lpParams);

            button.setImageResource(R.drawable.buttonblue1);
            switch (i){
                case 0:
                    final MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.c);
                    final Timer timer = new Timer();
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mPlayer.start();
                            timer.click(button, iUserInput);
                        }
                    });
                    break;
                case 1:
                    final MediaPlayer mPlayer1 = MediaPlayer.create(this, R.raw.d);
                    final Timer timer1 = new Timer();
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mPlayer1.start();
                            timer1.click(button, iUserInput);
                        }
                    });
                    break;
                case 2:
                    final MediaPlayer mPlayer2 = MediaPlayer.create(this, R.raw.e);
                    final Timer timer2 = new Timer();
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mPlayer2.start();
                            timer2.click(button, iUserInput);
                        }
                    });
                    break;
                case 3:
                    final MediaPlayer mPlayer3 = MediaPlayer.create(this, R.raw.f);
                    final Timer timer3 = new Timer();
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mPlayer3.start();
                            timer3.click(button, iUserInput);
                        }
                    });
                    break;
                case 4:
                    final MediaPlayer mPlayer4 = MediaPlayer.create(this, R.raw.g);
                    final Timer timer4 = new Timer();
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mPlayer4.start();
                            timer4.click(button, iUserInput);
                        }
                    });
                    break;
                case 5:
                    final MediaPlayer mPlayer5 = MediaPlayer.create(this, R.raw.a);
                    final Timer timer5 = new Timer();
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mPlayer5.start();
                            timer5.click(button, iUserInput);
                        }
                    });
                    break;
                case 6:
                    final MediaPlayer mPlayer6 = MediaPlayer.create(this, R.raw.b);
                    final Timer timer6 = new Timer();
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            mPlayer6.start();
                            timer6.click(button, iUserInput);
                        }
                    });
                    break;
            }

            button.setScaleType(ImageView.ScaleType.FIT_XY);

            alButtons.add(button);

            // Button on Click:

            llLayout.addView(button);
        }
    }

    public void drawBlack(boolean bInput, final int iInput) {
        int iInput2 = (iInput*2) - 1;
//        Creates button in the layout through java
        LinearLayout llLayout = (LinearLayout) findViewById(R.id.idBlackLayout);
        // Gets layout parameters
        LinearLayout.LayoutParams lpParams = new LinearLayout.LayoutParams(
                // Width, Height
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 100/iInput);

        // Creates each button
        for (int i = 0; i < iInput2; i++) {

            final ImageView button = new ImageView(MainActivity2.this);
            button.setId(iUserInput + i);
            button.setTag("Button" + i);
            button.setLayoutParams(lpParams);

            if ((i+2) % 2 == 1){
                alButtons.add(button);
                button.setImageResource(R.drawable.buttonred1);
                // Button on Click:
                final Timer timer = new Timer();
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        timer.click(button, iUserInput);
                    }
                });
            } else{
                button.setVisibility(View.INVISIBLE);
            }
            button.setScaleType(ImageView.ScaleType.FIT_XY);

            llLayout.addView(button);
        }
    }

    public void startGame(View view) {
        //Timer.simonClick(alButtons.get(0), iUserInput);

        Simon.says(alButtons, iUserInput, iLevel);
    }
}
