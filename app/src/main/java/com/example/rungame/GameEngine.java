package com.example.rungame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;
    Path path;
    Player player;
    PlayerDead playerDead;
    Random random;
    int score;
    Paint scorePaint;
    int pFrame, pJFrame, pDFrame;
    static int gameState;
    ArrayList<Obstacles> obstaclesList;
    Obstacles obstacles;
    Obstacles obstacles1;
    Obstacles obstacles2;
    Obstacles obstacles3;
    Obstacles obstacles4;
    Obstacles obstacles5;
    Bitmap obs;
    boolean obsSpawned;
    int points;
    final int TEXT_SIZE = 80;
    boolean collision = false;
    MediaPlayer hit;
    boolean hitSound;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        path = new Path();
        player = new Player();
        playerDead = new PlayerDead();
        // 0 = Not started
        // 1 = Playing
        // 2 = GameOver
        gameState = 0;
        obsSpawned = false;
        pFrame = 0;
        pJFrame = 0;
        pDFrame = 0;
        random = new Random();
        score = 0;
        scorePaint = new Paint();
        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(TEXT_SIZE);
        scorePaint.setTextAlign(Paint.Align.LEFT);
        obstaclesList = new ArrayList<>();
        obstacles = new Obstacles("");
        obstacles1 = new Obstacles("Box");
        obstacles2 = new Obstacles("Crystal");
        obstacles3 = new Obstacles("IceBox");
        obstacles4 = new Obstacles("Snowman");
        obstacles5 = new Obstacles("Stone");
        obstaclesList.add(obstacles1);
        obstaclesList.add(obstacles2);
        obstaclesList.add(obstacles3);
        obstaclesList.add(obstacles4);
        obstaclesList.add(obstacles5);
        points = 0;
        hitSound = false;
        hit = MediaPlayer.create(AppConstants.gameActivityContext, R.raw.hit);
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        if (collision == false) {
            backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
            if (backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
                backgroundImage.setX(0);
            }
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
        if (backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
                    AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(), null);
        }
    }

    public void updateAndDrawPath(Canvas canvas) {
        if (collision == false) {
            path.setPathX(path.getPathX() - path.getPathVelocity());
            if (path.getPathX() < -AppConstants.getBitmapBank().getPathWidth()) {
                path.setPathX(0);
            }
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX(), path.getPathY(), null);
        if (path.getPathX() < -(AppConstants.getBitmapBank().getPathWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX() +
                    AppConstants.getBitmapBank().getPathWidth(), path.getPathY(), null);
        }
    }

    public void updateAndDrawPlayer(Canvas canvas) {
        if (gameState == 1) {
            if (collision == false && AppConstants.playerGrounded == false) {
                player.setVelocity(player.getVelocity() + AppConstants.gravity);
                player.setY(player.getY() + player.getVelocity());
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerJump(pJFrame), player.getX(), player.getY(), null);
                pJFrame++;
                if (pJFrame > 15) {
                    pJFrame = 0;
                }
                if (player.getY() >= player.pYInitial) {
                    player.setY(player.pYInitial);
                    AppConstants.playerGrounded = true;
                }
            } else if (collision == true && AppConstants.playerGrounded == false) {
                playerDead.setVelocity(playerDead.getVelocity() + AppConstants.gravity);
                playerDead.setY(playerDead.getY() + playerDead.getVelocity());
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(pDFrame), playerDead.getX(), playerDead.getY(), null);
                pDFrame++;
                if (pDFrame == 17) {
                    gameState = 2;
                    Context context = AppConstants.gameActivityContext;
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("points", points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
                if (playerDead.getY() >= playerDead.pYInitial) {
                    playerDead.setY(playerDead.pYInitial);
                    AppConstants.playerGrounded = true;
                }
                if(hitSound == false) {
                    hit.start();
                    hitSound = true;
                }
            } else if (collision == false && AppConstants.playerGrounded) {
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayer(pFrame), player.getX(), player.getY(), null);
                pFrame++;
                if (pFrame > 10) {
                    pFrame = 0;
                }
            } else if (collision == true && AppConstants.playerGrounded) {
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(pDFrame), playerDead.getX(), playerDead.getY(), null);
                pDFrame++;
                if (pDFrame == 16) {
                    gameState = 2;
                    Context context = AppConstants.gameActivityContext;
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("points", points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
                if(hitSound == false) {
                    hit.start();
                    hitSound = true;
                }
            }
            if (obstacles.cX <= player.pX + AppConstants.getBitmapBank().getPlayerWidth()
                    && obstacles.cX + obstacles.width >= player.pX
                    && obstacles.cY >= player.pY
                    && obstacles.cY <= player.pY + AppConstants.getBitmapBank().getPlayerHeight()) {
                collision = true;
                obstacles.reset();
            }
            canvas.drawText("Pt: " + points, 0, TEXT_SIZE, scorePaint);
        }
    }

    public void updateAndDrawObstacles(Canvas canvas) {
        if (gameState == 1) {
            if (obsSpawned == false) {
                int randIndex = random.nextInt(5);
                obstacles = obstaclesList.get(randIndex);
                obsSpawned = true;
            }
            if (collision == false) {
                obstacles.cX -= obstacles.velocity;
                if (obstacles.type.equalsIgnoreCase("Box")) {
                    obs = AppConstants.getBitmapBank().getBox();
                }
                if (obstacles.type.equalsIgnoreCase("Crystal")) {
                    obs = AppConstants.getBitmapBank().getCrystal();
                }
                if (obstacles.type.equalsIgnoreCase("IceBox")) {
                    obs = AppConstants.getBitmapBank().getIceBox();
                }
                if (obstacles.type.equalsIgnoreCase("Snowman")) {
                    obs = AppConstants.getBitmapBank().getSnowman();
                }
                if (obstacles.type.equalsIgnoreCase("Stone")) {
                    obs = AppConstants.getBitmapBank().getStone();
                }
                canvas.drawBitmap(obs, obstacles.cX, obstacles.cY, null);
                if (obstacles.cX <= -AppConstants.getBitmapBank().getBoxWidth()) {
                    obstacles.reset();
                    points++;
                    obsSpawned = false;
                }
            }
        }
    }

    public void tapToStart(Canvas canvas){
        if(AppConstants.getGameEngine().gameState == 0){
            canvas.drawBitmap(AppConstants.getBitmapBank().getTapToStart(),
                    AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getTapToStartWidth()/2,
                    AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getTapToStartHeight()/2,
                    null);
        }
    }
}
