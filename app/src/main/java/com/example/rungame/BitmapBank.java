package com.example.rungame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap path;
    Bitmap[] player = new Bitmap[11];
    Bitmap[] playerJump = new Bitmap[16];
    Bitmap[] playerDead = new Bitmap[17];
    Bitmap box;
    Bitmap crystal;
    Bitmap iceBox;
    Bitmap snowMan;
    Bitmap stone;
    Bitmap tapToStart;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = scaleImage(background);
        path = BitmapFactory.decodeResource(res, R.drawable.path);
        player[0] = BitmapFactory.decodeResource(res, R.drawable.run1);
        player[1] = BitmapFactory.decodeResource(res, R.drawable.run2);
        player[2] = BitmapFactory.decodeResource(res, R.drawable.run3);
        player[3] = BitmapFactory.decodeResource(res, R.drawable.run4);
        player[4] = BitmapFactory.decodeResource(res, R.drawable.run5);
        player[5] = BitmapFactory.decodeResource(res, R.drawable.run6);
        player[6] = BitmapFactory.decodeResource(res, R.drawable.run7);
        player[7] = BitmapFactory.decodeResource(res, R.drawable.run8);
        player[8] = BitmapFactory.decodeResource(res, R.drawable.run9);
        player[9] = BitmapFactory.decodeResource(res, R.drawable.run10);
        player[10] = BitmapFactory.decodeResource(res, R.drawable.run11);

        playerJump[0] = BitmapFactory.decodeResource(res, R.drawable.jump1);
        playerJump[1] = BitmapFactory.decodeResource(res, R.drawable.jump2);
        playerJump[2] = BitmapFactory.decodeResource(res, R.drawable.jump3);
        playerJump[3] = BitmapFactory.decodeResource(res, R.drawable.jump4);
        playerJump[4] = BitmapFactory.decodeResource(res, R.drawable.jump5);
        playerJump[5] = BitmapFactory.decodeResource(res, R.drawable.jump6);
        playerJump[6] = BitmapFactory.decodeResource(res, R.drawable.jump7);
        playerJump[7] = BitmapFactory.decodeResource(res, R.drawable.jump8);
        playerJump[8] = BitmapFactory.decodeResource(res, R.drawable.jump9);
        playerJump[9] = BitmapFactory.decodeResource(res, R.drawable.jump10);
        playerJump[10] = BitmapFactory.decodeResource(res, R.drawable.jump11);
        playerJump[11] = BitmapFactory.decodeResource(res, R.drawable.jump12);
        playerJump[12] = BitmapFactory.decodeResource(res, R.drawable.jump13);
        playerJump[13] = BitmapFactory.decodeResource(res, R.drawable.jump14);
        playerJump[14] = BitmapFactory.decodeResource(res, R.drawable.jump15);
        playerJump[15] = BitmapFactory.decodeResource(res, R.drawable.jump16);

        playerDead[0] = BitmapFactory.decodeResource(res, R.drawable.dead1);
        playerDead[1] = BitmapFactory.decodeResource(res, R.drawable.dead2);
        playerDead[2] = BitmapFactory.decodeResource(res, R.drawable.dead3);
        playerDead[3] = BitmapFactory.decodeResource(res, R.drawable.dead4);
        playerDead[4] = BitmapFactory.decodeResource(res, R.drawable.dead5);
        playerDead[5] = BitmapFactory.decodeResource(res, R.drawable.dead6);
        playerDead[6] = BitmapFactory.decodeResource(res, R.drawable.dead7);
        playerDead[7] = BitmapFactory.decodeResource(res, R.drawable.dead8);
        playerDead[8] = BitmapFactory.decodeResource(res, R.drawable.dead9);
        playerDead[9] = BitmapFactory.decodeResource(res, R.drawable.dead10);
        playerDead[10] = BitmapFactory.decodeResource(res, R.drawable.dead11);
        playerDead[11] = BitmapFactory.decodeResource(res, R.drawable.dead12);
        playerDead[12] = BitmapFactory.decodeResource(res, R.drawable.dead13);
        playerDead[13] = BitmapFactory.decodeResource(res, R.drawable.dead14);
        playerDead[14] = BitmapFactory.decodeResource(res, R.drawable.dead15);
        playerDead[15] = BitmapFactory.decodeResource(res, R.drawable.dead16);
        playerDead[16] = BitmapFactory.decodeResource(res, R.drawable.dead17);

        box = BitmapFactory.decodeResource(res, R.drawable.box);
        crystal = BitmapFactory.decodeResource(res, R.drawable.crystal);
        iceBox = BitmapFactory.decodeResource(res, R.drawable.icebox);
        snowMan = BitmapFactory.decodeResource(res, R.drawable.snowman);
        stone = BitmapFactory.decodeResource(res, R.drawable.stone);
        tapToStart = BitmapFactory.decodeResource(res, R.drawable.tap_to_start);
    }

    // Return background bitmap
    public Bitmap getBackground(){
        return background;
    }

    // Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    // Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    // Return Path bitmap
    public Bitmap getPath(){
        return path;
    }

    // Return Path width
    public int getPathWidth(){
        return path.getWidth();
    }

    // Return Path height
    public int getPathHeight(){
        return path.getHeight();
    }

    // Return player bitmap
    public Bitmap getPlayer(int pFrame){
        return player[pFrame];
    }

    // Return player width
    public int getPlayerWidth(){
        return player[0].getWidth();
    }

    // Return player height
    public int getPlayerHeight(){
        return player[0].getHeight();
    }

    // Return player jump bitmap
    public Bitmap getPlayerJump(int pJFrame){
        return playerJump[pJFrame];
    }

    // Return player dead bitmap
    public Bitmap getPlayerDead(int pDFrame){
        return playerDead[pDFrame];
    }

    // Return player dead width
    public int getPlayerDeadWidth(){
        return playerDead[0].getWidth();
    }

    // Return player dead height
    public int getPlayerDeadHeight(){
        return playerDead[0].getHeight();
    }

    // Return Box bitmap
    public Bitmap getBox(){
        return box;
    }

    // Return Box width
    public int getBoxWidth(){
        return box.getWidth();
    }

    // Return Box height
    public int getBoxHeight(){
        return box.getHeight();
    }

    // Return Crystal bitmap
    public Bitmap getCrystal(){
        return crystal;
    }

    // Return Crystal width
    public int getCrystalWidth(){
        return crystal.getWidth();
    }

    // Return Crystal height
    public int getCrystalHeight(){
        return crystal.getHeight();
    }

    // Return IceBox bitmap
    public Bitmap getIceBox(){
        return iceBox;
    }

    // Return IceBox width
    public int getIceBoxWidth(){
        return iceBox.getWidth();
    }

    // Return IceBox height
    public int getIceBoxHeight(){
        return iceBox.getHeight();
    }

    // Return Snowman bitmap
    public Bitmap getSnowman(){
        return snowMan;
    }

    // Return Snowman width
    public int getSnowmanWidth(){
        return snowMan.getWidth();
    }

    // Return Snowman height
    public int getSnowmanHeight(){
        return snowMan.getHeight();
    }

    // Return Stone bitmap
    public Bitmap getStone(){
        return stone;
    }

    //Return Stone width
    public int getStoneWidth(){
        return stone.getWidth();
    }

    // Return Stone height
    public int getStoneHeight(){
        return stone.getHeight();
    }

    // Return Tap to Start bitmap
    public Bitmap getTapToStart(){
        return tapToStart;
    }

    //Return Tap to Start width
    public int getTapToStartWidth(){
        return tapToStart.getWidth();
    }

    // Return Tap to Start height
    public int getTapToStartHeight(){
        return tapToStart.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        /*
        We'll multiply widthHeightRatio with screenHeight to get
        scaled width of the bitmap. Then call createScaledBitmap()
        to create a new bitmap, scaled from an existing bitmap, when possible.
         */
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }

}
