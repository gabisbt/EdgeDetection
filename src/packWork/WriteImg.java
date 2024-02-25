import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public  class WriteImg extends ImageFilter{
    static long timeWrite;
    // bloc static de initializare
    static {
        timeWrite = 0;
    }

    // constructor implicit pentru clasa WriteImage
    public WriteImg() {
    }

    // metoda care scrie imaginea
    public static void writeImg(BufferedImage img, String fileName) {
        try {
            System.out.println("  Writing image.");
            long startTime = System.currentTimeMillis();
            ImageIO.write(img, "bmp", new File(fileName));
            long endTime = System.currentTimeMillis();
            timeWrite = endTime - startTime;
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public long writeTime() {
        System.out.println("Writing image took " + timeWrite + " ms");
        return timeWrite;
    }
}
