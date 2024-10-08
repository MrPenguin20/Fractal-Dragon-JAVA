/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragoncurve;

/**
 *
 * @author mosva
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package dragoncurve;

/**
 *
 * @author mosva
 */
//public class Dragon1 {

    /**
     * @param args the command line arguments
     */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public final class DragonCurve {
//DOCUMENTAR ESTA APP.

    
	private BufferedImage img = null;
	private int IMG_WIDTH;
	private int IMG_HEIGHT;

	private GraphicsEnvironment ge = null;
	private GraphicsDevice gd = null;
	private GraphicsConfiguration gc = null;

	public DragonCurve() {
        	IMG_WIDTH = 1000; // 1400;
		IMG_HEIGHT = 1000;// 1400;

		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		gd = ge.getDefaultScreenDevice();
		gc = gd.getDefaultConfiguration();

	}

	private void createDragonFractal() {
		Graphics g = null;
		Graphics2D g2d = (Graphics2D) g;

		img = gc.createCompatibleImage(IMG_WIDTH, IMG_HEIGHT);
		g2d = img.createGraphics();
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
                
		//g2d.setColor(new Color(200,200,100));     //Color.red);
                g2d.setColor(Color.GREEN);
                //g2d.setColor(new Color(0xfa,0x0,0x0));
                
		dragonRecur(300, 500, 1000, 1100, 20, g2d);
               
		g2d.drawImage(img, 0, 0, null);
		g2d.dispose();
		writeImage();

	}

	private void writeImage() {
		File file = new File("dragon_Ejemplo5.png");
		
                try {
			file.createNewFile();
			OutputStream out = new FileOutputStream(file);
			ImageIO.write(img, "png", out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

        //REALIZAR PRUEBA DE SCRITORIO A ESTE METODO
	private void dragonRecur(int x1, int y1, int x2, int y2, int k,
			Graphics2D g2d) {
		if (k > 0) {
			int xn = (x1 + x2) / 2 + (y2 - y1) / 2;
			int yn = (y1 + y2) / 2 - (x2 - x1) / 2;
			dragonRecur(x2, y2, xn, yn, k - 1, g2d);
			dragonRecur(x1, y1, xn, yn, k - 1, g2d);
		} else {
			g2d.drawLine(x1, y1, x2, y2);
		}
	}
        
        //INVESTIGA Y ANALIZAR EL PROBLEMA DE LA 8 REINAS
        //Y EL MOVIMIENTO DEL CABALLO

	//public static void main(String... strings) {
        public static void main(String[] args)
        {
		new DragonCurve().createDragonFractal();
                
	}

}
    
