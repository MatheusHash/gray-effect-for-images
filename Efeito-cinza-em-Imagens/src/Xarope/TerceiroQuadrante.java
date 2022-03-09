package Xarope;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class TerceiroQuadrante implements Runnable{
	
	private BufferedImage img = null,grayImg;		

	public TerceiroQuadrante(BufferedImage img, BufferedImage grayImg){
		this.img = img;
		this.grayImg = grayImg;
	}
	
	@Override
	public void run() {
		// Quadrande inferior esquerdo
        for(int row = ((img.getHeight()/2 )); row < img.getHeight(); row++){
            for(int col = 0; col < ((img.getWidth()/2)+1); col++){

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