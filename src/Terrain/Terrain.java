package Terrain;

public abstract class Terrain {

    String name;
    int foodValue;
    int maxFoodValue;
    int foodRegenTime;
    int blockValue;
    int startX;
    int startY;
    int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(int foodValue) {
        this.foodValue = foodValue;
    }

    public int getMaxFoodValue() {
        return maxFoodValue;
    }

    public void setMaxFoodValue(int maxFoodValue) {
        this.maxFoodValue = maxFoodValue;
    }

    public int getFoodRegenTime() {
        return foodRegenTime;
    }

    public void setFoodRegenTime(int foodRegenTime) {
        this.foodRegenTime = foodRegenTime;
    }

    public int getBlockValue() {
        return blockValue;
    }

    public void setBlockValue(int blockValue) {
        this.blockValue = blockValue;
    }
}


