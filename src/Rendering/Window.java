package Rendering;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;

public class Window {

    private int WIDTH = 860;
    private int HEIGHT = 640;
    private String TITLE;

    private JFrame frame;
    private BufferedImage image;
    private BufferStrategy bufferStrategy;
    private Canvas canvas;
    private Graphics graphics;

    public Window(){
        image = new BufferedImage(
                WIDTH,
                HEIGHT,
                BufferedImage.TYPE_INT_RGB
        );

        createCanvas();

        bufferStrategy = canvas.getBufferStrategy();
        graphics = bufferStrategy.getDrawGraphics();
    }

    public Window(int width, int height){
        image = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB
        );

        createCanvas();

        bufferStrategy = canvas.getBufferStrategy();
        graphics = bufferStrategy.getDrawGraphics();
    }

    private void createCanvas() {

        canvas = new Canvas();
        Dimension dimension = new Dimension(WIDTH, HEIGHT);
        canvas.setSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMaximumSize(dimension);
        createFrame();
        canvas.createBufferStrategy(3);
    }

    private void createFrame() {

        frame = new JFrame(TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
    }

    public void setVisible(boolean value){
        frame.setVisible(value);
    }

    public void update(){

        graphics.drawImage(image, 0, 0, canvas.getWidth(),
                canvas.getHeight(), null);
        bufferStrategy.show();
    }

    public DataBuffer getImageRasterDataBuffer(){
        return image.getRaster().getDataBuffer();
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
