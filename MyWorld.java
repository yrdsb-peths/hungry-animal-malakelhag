import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int random;
    private int counter = 0;
    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Kangaro kangaro = new Kangaro();
        addObject(kangaro, 300, 300);
       
    }
    public void act(){
        if(counter == 0){
            spawnFries();
            counter = 30;
        }
        else{
            counter--;
        }
    }

    public void spawnFries() {
            random = Greenfoot.getRandomNumber(4);
            Fries fries = new Fries();
            if(random == 0){
                addObject(fries, 250, 0);
            }
            if(random == 1){
                addObject(fries, 500, 0);
            }
            if(random == 2){
                addObject(fries, 750, 0);
            }
            if(random == 3){
                addObject(fries, 1000, 0);
            }
            if(random == 4){
                addObject(fries, 100, 0);
            }
            if(random == 5){
                addObject(fries, 400, 0);
            }
            if(random == 6){
                addObject(fries, 850, 0);
            }
            if(random == 7){
                addObject(fries, 300, 0);
            }
            if(random == 8){
                addObject(fries, 600, 0);
            }
    }
   
   
}

