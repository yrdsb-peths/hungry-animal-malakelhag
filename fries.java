import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fries extends Actor
{
    public void act()
    {
        setLocation(getX(), getY() + 2);
        MyWorld world = (MyWorld) getWorld();
        if(getY() > world.getHeight()) {
            world.onGameOver();
        }
    }
}