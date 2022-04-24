package edu.school21.printer.logic;

import com.diogonunes.jcdp.color.ColoredPrinter;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Logic {
    public static int[][] bpBMPImage(String pathImg, ColoredPrinter cp1, ColoredPrinter cp2) throws IOException {
       BufferedImage img = ImageIO.read(Logic.class.getResource("/resources/image.bmp"));
		
	   int arrImage[][] = new int[img.getWidth()][img.getHeight()];

	   for (int xPixel = 0; xPixel < img.getWidth(); xPixel++)
	   {
		   for (int yPixel = 0; yPixel < img.getHeight(); yPixel++){
			   
			int color = img.getRGB(yPixel, xPixel);
			   if (color == Color.BLACK.getRGB()){
				cp1.print("  ");
			   }else if (color == Color.WHITE.getRGB()){
				cp2.print("  ");
			   }
		   }
		   System.out.print("\n");
	   }
	   return arrImage;
    }
}
