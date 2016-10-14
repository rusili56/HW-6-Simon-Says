package nyc.c4q.rusili.hw_6_simon_says;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    boolean check = true;
    public int iLevel = 1;
    private int iUserInput = 3;
    private boolean isVertical = true;
    int iClickCount = 0;
    public ArrayList<ImageView> alButtons = new ArrayList<>();
    public ArrayList<Integer> alSequence = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        alSequence.add(0);

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
        CanClick.no(alButtons);
    }

    public void drawWhite(boolean bInput, int iInput) {
        TextView tvLevel = (TextView) findViewById(R.id.idLevel);
        tvLevel.setText(Integer.toString(iLevel));
        Log.d("Draw Level:", Integer.toString(iLevel));

//        Creates button in the layout through java
        LinearLayout llLayout = (LinearLayout) findViewById(R.id.idWhiteLayout);
        // Gets layout parameters
        LinearLayout.LayoutParams lpParams = new LinearLayout.LayoutParams(
                // Width, Height
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, 100/iInput);

        // Creates each button
        for (int i = 0; i < iInput; i++) {

            ImageView button = new ImageView(MainActivity2.this);
            button.setId(i);
            Log.d("Draw White:", Integer.toString(button.getId()));
            button.setTag("White" + i);
            button.setLayoutParams(lpParams);

            button.setImageResource(R.drawable.buttonblue1);
            button.setOnClickListener(this);
            /*
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
            */

            button.setScaleType(ImageView.ScaleType.FIT_XY);

            alButtons.add(button);

            llLayout.addView(button);
        }
    }

    public void drawBlack(boolean bInput, final int iInput) {
        int iBlack = 0;
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

            ImageView button = new ImageView(MainActivity2.this);

            button.setLayoutParams(lpParams);

            if ((i+2) % 2 == 1){
                iBlack++;
                button.setId((iInput - 1) + iBlack);
                Log.d("Draw Black", Integer.toString(button.getId()));
                button.setTag("Button" + i);
                alButtons.add(button);
                button.setImageResource(R.drawable.buttonred1);
                button.setOnClickListener(this);
            } else{
                button.setVisibility(View.INVISIBLE);
            }
            button.setScaleType(ImageView.ScaleType.FIT_XY);

            llLayout.addView(button);
        }
    }

    public void startGame(View v) {

        //while (!check) {
            CanClick.no(alButtons);

            final Context context = getApplicationContext();
            CharSequence tText = "Simon's Turn";
            int tDuration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, tText, tDuration);
            toast.show();

            alSequence = Simon.says(alButtons, iUserInput, iLevel);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast toast = Toast.makeText(context, "Your Turn", Toast.LENGTH_SHORT);
                    toast.show();
                    CanClick.yes(alButtons);
                }
            }, 1500 * (iLevel + 1));

            /*

            iClickCount = 0;
            iLevel++;
            */
        //}

        /* to Endgame
        iClickCount = 0;
        iLevel = 0;
        iUserInput = 0;
        Intent toEndGame = new Intent(this, EndGame.class);
        startActivity(toEndGame);
        */
    }

    @Override
    public void onClick(final View v) {

        ImageView tempbutton = null;
        for (int i=0; i<iUserInput*2-1; i++){
            if (i == v.getId()){
                tempbutton = alButtons.get(i);
            }
        }
        Timer userTimer = new Timer();
        userTimer.click(tempbutton, iUserInput);

        if (tempbutton.getId() == alSequence.get(iClickCount)){
            iClickCount++;
            Toast toast = Toast.makeText(this, "+", Toast.LENGTH_SHORT);
            toast.show();
            if (iClickCount == iLevel){
                iLevel++;
                TextView tvLevel = (TextView) findViewById(R.id.idLevel);
                tvLevel.setText(Integer.toString(iLevel));
                iClickCount = 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startGame(v);
                    }
                }, 2000);
            }
        } else {
            Intent toEndGame = new Intent(this, EndGame.class);
            startActivity(toEndGame);
            finish();
        }
    }
}
