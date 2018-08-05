package gfx;


import javax.imageio.ImageIO;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Image {

    private int width;
    private int height;
    private int[] pixels;

    public Image(String path){

        InputStream inputStream = getImageInputStream(path);
        BufferedImage image = null;

        try {
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image != null){
            width = image.getWidth();
            height = image.getHeight();
            pixels = image.getRGB(0, 0, width, height, null, 0, width);
            image.flush();
        }
    }

    private InputStream getImageInputStream(String path) {

        InputStream inputStream = Image.class.getResourceAsStream(path);
        if (inputStream == null){
            System.err.println("Failed to create input stream from path (Image)");
           System.exit(-1);
        }

        return inputStream;
    }

    public int getPixelColor(int x, int y){
        return pixels[x+y*width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[] getPixels() {
        return pixels;
    }
}
