import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kangaro here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Kangaro extends Actor
{
    /**
     * Act - do whatever the Kangaro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        keys();
        checkFries();
    }
    public void keys(){
        if(Greenfoot.isKeyDown("a")){
            move(-5);
        }
        if(Greenfoot.isKeyDown("d")){
            move(5);
        }
       
       
       
       
    }
    public void checkFries(){
        Fries a = (Fries)getOneIntersectingObject(Fries.class);
        if(a != null){
            getWorld().removeObject(a);
        }
    }
}
