package edu.school21.printer.app;

import edu.school21.printer.logic.Logic;

import java.io.IOException;

class Program {

    public static void main(String[] args)  throws IOException {
		if (args.length != 2) {
			System.out.println("Usage: . 0 <path img>");
			System.exit(-1);
		}
		char symbWhite = args[0].charAt(0);
		char symbBlack = args[1].charAt(0);
		String pathImg = "/resources/image.bmp";

		int[][] arrImg = Logic.bpBMPImage(pathImg, symbWhite, symbBlack);
		for (int x = 0; x < arrImg.length; x++){
			for(int y = 0; y < arrImg[x].length; y++){
				System.out.print((char)arrImg[y][x]);
			}
			System.out.print("\n");
		}
		


		
       
}
}