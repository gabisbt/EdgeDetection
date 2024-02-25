import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ReadImg extends DisplayImg{
    
    static long time;
    // bloc static de initializare
    static {
        time = 0;
    }

    // constructor implicit pentru clasa ReadImage
    public ReadImg() {
    }

    //metoda care citeste imaginea
    static public BufferedImage readImg(String fileName){
        BufferedImage img = null;
        fileName = "src/images/" + fileName;
        try {
            System.out.println("  Reading image.");
            long startTime = System.currentTimeMillis();
            img = ImageIO.read(new File(fileName));
            long endTime = System.currentTimeMillis();
            time = endTime - startTime;
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return img;
    }

    // display image in a JPanel popup
	public static void display (BufferedImage img) {
	System.out.println("  Displaying image.");
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	frame.setSize(img.getWidth(), img.getHeight());
	label.setIcon(new ImageIcon(img));
	frame.getContentPane().add(label, BorderLayout.CENTER);
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.pack();
	frame.setVisible(true);
	}

    @Override
    public long readTime() {
        System.out.println("Reading image took " + time + " ms");
        return time;
    }

    // metodele abstracte care sunt suprascrise, afiseaza timpul de executie al
    // sharpen-ului si al scrierii imaginii
    @Override
    public long edgeTime()
    {
        return 0;
    }

    @Override
    public long writeTime()
    {
        return 0;
    }
}
