import greenfoot.*;  

public class Kangaro extends Actor
{
    GreenfootSound sound = new GreenfootSound("sounds/Eating sound effect.mp3");
    
    GreenfootImage[] rightImages = new GreenfootImage[8];
    GreenfootImage[] leftImages = new GreenfootImage[8];
    int animationDelay = 100; // Set your desired delay here
    int animationCounter = 0;
    boolean facingRight = true;

    public Kangaro() {
        for(int i = 0; i < rightImages.length; i++) {
            rightImages[i] = new GreenfootImage("images/kangaroo.png");
            rightImages[i].scale(100, 100);
        }
        for(int i = 0; i < leftImages.length; i++) {
            leftImages[i] = new GreenfootImage("images/kangaroo.png");
            leftImages[i].scale(100, 100);
            leftImages[i].mirrorHorizontally();
        }
        setImage(rightImages[3]);
    }

    public void animateKangaro() {
        if (animationCounter % (animationDelay / 100) == 0) {
            if(facingRight) {
                setImage(rightImages[(animationCounter / (animationDelay / 100)) % rightImages.length]);
            } else {
                setImage(leftImages[(animationCounter / (animationDelay / 100)) % leftImages.length]);
            }
        }
        animationCounter++;
    }
    
    public void act()
    {
        animateKangaro();
        
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
            sound.play();
            MyWorld world = (MyWorld) getWorld();
            world.spawnFries();
            world.increaseScore();
        }
    }
}
