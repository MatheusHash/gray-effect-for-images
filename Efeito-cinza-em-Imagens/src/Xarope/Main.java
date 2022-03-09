package Xarope;

//import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;
//import java.lang.*;

public class Main {

	public static void main(String[] args) {
		
        String caminho,nome;
    	System.out.println("Digite o caminho para a imagem:");
    	Scanner scan = new Scanner(System.in);
    	caminho = scan.nextLine();
    	System.out.println("Se estiver utilizando Windows digite '\\\\' no inicio do nome da imagem, se for Linux digite '/'.");
    	System.out.println("Digite o nome do arquivo com o tipo: ");
    	nome = scan.nextLine();scan.close();
    	
    	File imagem = new File(caminho + nome);

        BufferedImage img = null;

        try {
            img = ImageIO.read(imagem);
            BufferedImage grayImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);

            System.out.println("Altura: " + img.getHeight());
            System.out.println("Largura: " + img.getWidth());

                PrimeiroQuadrante Q1 = new PrimeiroQuadrante(img,grayImg);
        	Thread tQ1 = new Thread(Q1);
        	
        	SegundoQuadrante Q2 = new SegundoQuadrante(img,grayImg);
        	Thread tQ2 = new Thread(Q2);
        	
        	TerceiroQuadrante Q3 = new TerceiroQuadrante(img,grayImg);
        	Thread tQ3 = new Thread(Q3);

        	QuartoQuadrante Q4 = new QuartoQuadrante(img,grayImg);
        	Thread tQ4 = new Thread(Q4);
        	
        	tQ1.start();
        	Thread.sleep(1000);
        	tQ2.start();
        	tQ3.start();      	
        	tQ4.start();
        	
            ImageIO.write(grayImg,"png", new File(caminho + "/Imagegray.png"));
            
        }catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
	}

}
