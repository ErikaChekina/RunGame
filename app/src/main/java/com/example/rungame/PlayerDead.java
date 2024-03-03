package com.example.rungame;

public class PlayerDead extends Player {

    public PlayerDead(){
        pX = AppConstants.SCREEN_WIDTH/3 - AppConstants.getBitmapBank().getPlayerDeadWidth();
        pYInitial = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathHeight()
                - AppConstants.getBitmapBank().getPlayerDeadHeight();
        pY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathHeight()
                - AppConstants.getBitmapBank().getPlayerDeadHeight();
        pFrame = 0;
        velocity = 0;
    }

    // Getter method for velocity
    public int getVelocity(){
        return velocity;
    }

    // Setter method for velocity
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }

    // Getter method for getting X-coordinate of the Player
    public int getX(){
        return pX;
    }

    // Getter method for getting the Y-coordinate of the Player
    public int getY(){
        return pY;
    }

    // Setter method for setting the Y-coordinate
    public void setY(int pY){
        this.pY = pY;
    }
}
