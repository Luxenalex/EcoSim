package Rendering;

import java.awt.*;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.util.*;

import Utility.Position;
import gfx.ImageWithPosition;


public class Renderer {

    private int[] pixels;
    private int canvasWidth;
    private Queue<ImageWithPosition> drawQueue;

    public Renderer(Window window){

        pixels = ((DataBufferInt)window.getImageRasterDataBuffer()).getData();
        int canvasHeight = window.getHEIGHT();
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

    //Håller på att göra typ image renderer och renderer i samma klass
}
