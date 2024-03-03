package com.example.rungame;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;


public class GameActivity extends AppCompatActivity{

    GameView gameView;
    //private AdView mAdView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppConstants.gameActivityContext = this;
//        mAdView = new AdView(this);
//        mAdView.setAdSize(AdSize.BANNER);
//        // Replace this with your ad unit Id
//        mAdView.setAdUnitId(getResources().getString(R.string.banner_adunit_id));
//        // Create an ad request.
//        AdRequest adRequest = new AdRequest.Builder().build();
//        // Start loading the ad in the background.
//        mAdView.loadAd(adRequest);
        // Add the AdView to the view hierarchy. The view will have no size
        // until the ad is loaded.
        RelativeLayout layout = new RelativeLayout(this);
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        gameView = new GameView(this);
        // Define ad view parameters
        RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        adParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        layout.addView(gameView);
//        layout.addView(mAdView, adParams);
        // Set main renderer
        setContentView(layout);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (MainActivity.mediaPlayer != null) {
            MainActivity.mediaPlayer.stop();
            MainActivity.mediaPlayer.release();
            MainActivity.mediaPlayer = null;
        }
    }


}
