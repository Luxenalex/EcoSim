package Animals;

public abstract class Animal {

    int hunger;
    int thirst;
    int speed;
    int size;
    int age;
    boolean isHiding;
    boolean isEating;
    boolean isMating;
    int x;
    int y;

    public abstract void move();

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHiding() {
        return isHiding;
    }

    public void setHiding(boolean hiding) {
        isHiding = hiding;
    }

    public boolean isEating() {
        return isEating;
    }

    public void setEating(boolean eating) {
        isEating = eating;
    }

    public boolean isMating() {
        return isMating;
    }

    public void setMating(boolean mating) {
        isMating = mating;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
