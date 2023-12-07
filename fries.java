import greenfoot.*;

public class Fries extends Actor {
    public Fries() {
        GreenfootImage image = getImage();
        image.scale(40, 40);
        setImage(image);
    }

    public void act() {
        setLocation(getX(), getY() + 2);
        MyWorld world = (MyWorld) getWorld();
        if (getY() > world.getHeight()) {
            world.onGameOver();
        }
    }
}
