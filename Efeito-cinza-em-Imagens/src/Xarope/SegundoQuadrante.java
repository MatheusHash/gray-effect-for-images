package Xarope;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class SegundoQuadrante implements Runnable{
	
	private BufferedImage img = null, grayImg;
	
	public SegundoQuadrante(BufferedImage img, BufferedImage grayImg){
		this.img = img;
		this.grayImg = grayImg;
	}
	
	@Override
	public void run(){
		
		// Quadrante superior direito
        for(int row = 0; row < img.getHeight()/2; row++){
            for(int col = img.getWidth()/2; col < img.getWidth(); col++){

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
