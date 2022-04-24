package edu.school21.printer.logic;

import java.io.FileInputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Logic {
    public static int[][] bpBMPImage(String pathImg, char symbWhite, char symbBlack) throws IOException {
       BufferedImage img = ImageIO.read(new FileInputStream(pathImg));
		
	   int arrImage[][] = new int[img.getWidth()][img.getHeight()];

	   for (int xPixel = 0; xPixel < img.getWidth(); xPixel++)
	   {
		   for (int yPixel = 0; yPixel < img.getHeight(); yPixel++){
			   int color = img.getRGB(xPixel, yPixel);
			   if (color == Color.BLACK.getRGB()){
				   arrImage[xPixel][yPixel] = symbBlack;
			   }else if (color == Color.WHITE.getRGB()){
				   arrImage[xPixel][yPixel] = symbWhite;
			   }
		   }
	   }
	   return arrImage;
    }
}