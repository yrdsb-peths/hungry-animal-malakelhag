import greenfoot.*;

public class Fries extends Actor {
    private int actInterval = 5; // Initial act interval
    private int actCounter = 0;
    private boolean isSpecial = false; // New variable for special fries

    public Fries() {
        GreenfootImage image = getImage();
        image.scale(40, 40);
        setImage(image);

        // Randomly set fries as special (1 in 10 chance)
        if (Greenfoot.getRandomNumber(10) == 0) {
            isSpecial = true;
        }
    }

    public void act() {
        if (actCounter % actInterval == 0) {
            setLocation(getX(), getY() + 5);
        }

        actCounter++;

        checkCollision();
    }

    public void setActInterval(int interval) {
        actInterval = interval;
    }

    public int getActInterval() {
        return actInterval;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void checkCollision() {
        setLocation(getX(), getY() + 2);
        MyWorld world = (MyWorld) getWorld();
        if (getY() > world.getHeight()) {
            world.onGameOver();
        }
    }
}
