package Xarope;

import java.awt.Color;
import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import javax.imageio.ImageIO;
//import java.util.Scanner;
//import java.lang.*;

public class PrimeiroQuadrante implements Runnable{
	
	private BufferedImage img = null, grayImg;
	
	public PrimeiroQuadrante(BufferedImage img, BufferedImage grayImg){
		this.img = img;
		this.grayImg = grayImg;
	}
	
	@Override
	public void run() {
		// Quadrante superior esquerdo
        for(int row = 0; row < img.getHeight()/2; row++){
            for(int col = 0; col < img.getWidth()/2; col++){

                Color cor = new Color(img.getRGB(col, row));

                int r = cor.getRed();
                int g = cor.getGreen();
                int b = cor.getBlue();
                int a = cor.getAlpha();
                
                int gr = (r + g + b) / 3;
                
                // Create grayImg color 
                Color gColor = new Color(gr,gr,gr,a);
                
                grayImg.setRGB(col, row, gColor.getRGB());
            }
        }
	}
}