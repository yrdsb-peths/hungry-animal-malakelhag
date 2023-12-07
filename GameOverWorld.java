import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverWorld extends World
{

    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld()
    {    
        super(600, 400, 1); 
        Label gameOverLabel = new Label("Game Over", 80);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
        
    }
    

}
