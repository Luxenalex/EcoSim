package Rendering;



import java.awt.image.DataBufferInt;
import java.util.ArrayDeque;
import java.util.Queue;


import Utility.Position;
import gfx.Image;
import gfx.ImageWithPosition;


public class Renderer {

    private int[] pixels;
    private int canvasWidth;
    private int canvasHeight;
    private Queue<ImageWithPosition> drawQueue;

    public Renderer(Window window){

        pixels = ((DataBufferInt)window.getImageRasterDataBuffer()).getData();
        canvasHeight = window.getHEIGHT();
        canvasWidth = window.getWIDTH();

        drawQueue = new ArrayDeque<>();
    }

    public void clear(){
        for (int pixel : pixels) {
            pixel = 0;
        }
    }

    public void addImageToDraw(Image image, Position position){
        drawQueue.add(new ImageWithPosition(image, position));
    }

    public void drawImages(){

        ImageWithPosition image;
        while(!drawQueue.isEmpty()){
           image = drawQueue.poll();
            drawImage(image.getImage(), image.getPosition());
        }
    }

    private void drawImage(Image image, Position position) {

        int posX = position.getX();
        int posY = position.getY();

        if(isOutsideOfCanvas(image.getWidth(), image.getHeight(), position)){
            System.err.println("Tried to draw image outside of canvas");
            return;
        }

        int startDrawingX = 0;
        int startDrawingY = 0;

        if(posX < 0){
            startDrawingX = reduceAreaToDraw(startDrawingX, posX);
        }
        if(posY < 0){
            startDrawingY = reduceAreaToDraw(startDrawingY, posY);
        }

        int imageWidth = image.getWidth();
        if(imageWidth + posX >= canvasWidth){
            imageWidth = reduceAreaToDraw(imageWidth, imageWidth + posX - canvasWidth);
        }

        int imageHeight = image.getHeight();
        if(imageHeight + posY >= canvasHeight){
            imageHeight = reduceAreaToDraw(imageHeight, imageHeight + posY - canvasHeight);
        }

        for(int y = startDrawingY; y < imageHeight; y++){
            for(int x = startDrawingX; x < imageWidth; x++){
                setPixel(x + posX, y + posY, image.getPixelColor(x, y));
            }
        }
    }

    private void setPixel(int x, int y, int pixelColor) {

        if(x < 0 || x >= canvasWidth || y < 0 || y >= canvasHeight){
            return;
        }

        this.pixels[x + y * canvasWidth] = pixelColor;
    }

    public int reduceAreaToDraw(int start, int pos){
        return start - pos;
    }


    private boolean isOutsideOfCanvas(int width, int height, Position position) {

        return position.getX() < -width || position.getY() < -height ||
                position.getX() >= canvasWidth || position.getY() >= canvasHeight;
    }

}
