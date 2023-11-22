import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class kangaro extends Actor
{
    /**
     * Act - do whatever the kangaro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        
        if (Greenfoot.isKeyDown("a"))
        {
            setLocation(getX() - 1, getY());
        }
        if (Greenfoot.isKeyDown("d"))
        {
            setLocation(getX() + 1, getY());
        }
    }
}
