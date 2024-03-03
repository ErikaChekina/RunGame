package com.example.rungame;

import java.util.Random;

public class Obstacles {
    public int cX, cY;
    public String type;
    public int velocity;
    public int width;
    Random random;
    public Obstacles(String type) {
        this.type = type;
        cX = AppConstants.SCREEN_WIDTH + 1000;
        cY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathHeight();
        random = new Random();
        if(type.equalsIgnoreCase("Box")){
            cY -= AppConstants.getBitmapBank().getBoxHeight();
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 14 + random.nextInt(5);// 14-18
            width = AppConstants.getBitmapBank().getBoxWidth();
        }else if(type.equalsIgnoreCase("Crystal")){
            cY -= AppConstants.getBitmapBank().getCrystalHeight();
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 12 + random.nextInt(5); // 12-16
            width = AppConstants.getBitmapBank().getCrystalWidth();
        }else if(type.equalsIgnoreCase("IceBox")){
            cY -= AppConstants.getBitmapBank().getIceBoxHeight();
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 11 + random.nextInt(5); // 11-15
            width = AppConstants.getBitmapBank().getIceBoxWidth();
        }else if(type.equalsIgnoreCase("Snowman")){
            cY -= AppConstants.getBitmapBank().getSnowmanHeight();
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 10 + random.nextInt(6); // 10-15
            width = AppConstants.getBitmapBank().getSnowmanWidth();
        }else if(type.equalsIgnoreCase("Stone")){
            cY -= AppConstants.getBitmapBank().getStoneHeight();
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 15 + random.nextInt(11); // 15-25
            width = AppConstants.getBitmapBank().getStoneWidth();
        }
    }

    public void reset(){
        cX = AppConstants.SCREEN_WIDTH + 300;
        if(type.equalsIgnoreCase("Box")){
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 14 + random.nextInt(5);// 14-18
        }else if(type.equalsIgnoreCase("Crystal")){
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 12 + random.nextInt(5); // 12-16
        }else if(type.equalsIgnoreCase("IceBox")){
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 11 + random.nextInt(5); // 11-15
        }else if(type.equalsIgnoreCase("Snowman")){
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 10 + random.nextInt(6); // 10-15
        }else if(type.equalsIgnoreCase("Stone")){
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 15 + random.nextInt(11); // 15-25
        }
    }
}
