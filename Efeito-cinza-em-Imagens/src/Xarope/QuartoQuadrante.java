package Xarope;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class QuartoQuadrante implements Runnable{
	
	private BufferedImage img=null,grayImg;
	
	public QuartoQuadrante(BufferedImage img, BufferedImage grayImg) {
		this.grayImg = grayImg;
		this.img = img;
	}
	
	@Override
	public void run() {
		// Quadrante inferior direito
        for(int row = ((img.getHeight()/2 )); row < img.getHeight(); row++){
            for(int col = ((img.getWidth()/2 )+ 1); col < img.getWidth(); col++){

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
