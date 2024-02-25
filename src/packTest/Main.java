

import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the image1 filename to process: ");
            String fileName = scanner.nextLine();
            System.out.print("Enter the image2 filename to process: ");
            String fileName1 = scanner.nextLine();
            
            System.out.print("Enter the output filename: ");
            String outputFileName = scanner.nextLine();
            System.out.print("Enter the output filename: ");
            String outputFileName1 = scanner.nextLine();

            BufferedImage img = null;
            BufferedImage img1 = null;

            img = ReadImg.readImg(fileName);
            ReadImg.display(img);

            img1 = ReadImg.readImg(fileName1);
            ReadImg.display(img1);
            // Detect edges in the image
            img = ImageFilter.detectEdges(img);
            img1 = ImageFilter.detectEdges(img1);
            // ImageFilter.display(img);

            // Save the processed image
            WriteImg.writeImg(img, outputFileName + ".bmp");
            WriteImg.writeImg(img1, outputFileName1 + "1.bmp");
            
            WriteImg.display(img);
            WriteImg.display(img1);
            // Save the processed image
            // ImageIO.write(img, "bmp", new File(outputFileName + ".bmp"));
            // ImageFilter.display(img);
            WriteImg write = new WriteImg();

            write.readTime();
            write.edgeTime();
            write.writeTime();
        }
    }

}
