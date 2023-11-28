import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Kangaro extends Actor
{
    public Kangaro() {
        GreenfootImage image = getImage();
        image.scale(100, 100);
        setImage(image);
    }
    
    
    
    
    
    public void act()
    {
        if(Greenfoot.isKeyDown("a")){
            move(-3);    
        }
        if(Greenfoot.isKeyDown("d")){
            move(3);
        }
        
        eat();
    }
    
    public void eat() {
        // Eat the Fries
        if (isTouching(Fries.class)){
            removeTouching(Fries.class);
            MyWorld world = (MyWorld) getWorld();
            world.spawnFries();
            world.increaseScore();
        }
    }
    
   
}