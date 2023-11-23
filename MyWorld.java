import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{

    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        kangaro kangaro = new kangaro();
        addObject(kangaro, 300, 300);
        prepare();
    }
    

    public void spawnFries()
    {
        fries fries = new fries();
        addObject(fries, 300, 100);
    }
    
    
    public void act()
    {
        spawnFries();
    }
    
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
