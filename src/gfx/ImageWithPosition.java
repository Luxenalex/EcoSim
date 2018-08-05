package gfx;

import Utility.Position;

public class ImageWithPosition {

    Image image;
    Position position;

    public ImageWithPosition(Image image, Position position){
        this.image = image;
        this.position = position;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
