import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

public abstract class DisplayImg implements Time{
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
    public abstract long readTime();

    @Override
    public abstract long edgeTime();

    @Override
    public abstract long writeTime();
}
