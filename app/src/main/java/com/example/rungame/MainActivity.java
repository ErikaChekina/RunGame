package com.example.rungame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.OnBackPressedCallback;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;
    ImageButton ibStartGame;
    //private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.mediaPlayer = MediaPlayer.create(this, R.raw.bg_music);
        if(MainActivity.mediaPlayer != null){
            MainActivity.mediaPlayer.setLooping(true);
            MainActivity.mediaPlayer.start();
        }
        AppConstants.initialization(this.getApplicationContext());
        ibStartGame = findViewById(R.id.ibStartGame);
        ibStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if(MainActivity.mediaPlayer != null){
            MainActivity.mediaPlayer.stop();
            MainActivity.mediaPlayer.release();
            MainActivity.mediaPlayer = null;
        }
        super.onBackPressed();
        //onBackPressedDispatcher.onBackPressed();
        //requireActivity().onBackPressedDispatcher.onBackPressed();
    }


//    getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
//        @Override
//        public void handleOnBackPressed() {
//            // Back is pressed... Finishing the activity
//            if(MainActivity.mediaPlayer != null){
//                MainActivity.mediaPlayer.stop();
//                MainActivity.mediaPlayer.release();
//                MainActivity.mediaPlayer = null;
//            }
//            finish();
//        }
//    });

}