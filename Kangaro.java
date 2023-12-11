import greenfoot.*;

public class Kangaro extends Actor {
    private boolean isJumping = false;

    GreenfootImage[] idleRight = new GreenfootImage[3];
    GreenfootImage[] idleLeft = new GreenfootImage[3];
    boolean facingRight = true;
    SimpleTimer animationTimer = new SimpleTimer();
    GreenfootSound sound = new GreenfootSound("sounds/Eating sound effect.mp3");

    public Kangaro() {
        for (int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/tile00" + i + ".png");
            idleRight[i].scale(100, 100);
        }

        for (int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/tile00" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100, 100);
        }

        animationTimer.mark();
        // Initial elephant image
        setImage(idleRight[0]);
    }


    /**
     * Animate the Kangaro
     */
    int imageIndex = 0;
    public void animateKangaro()
    {
        if (animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();

        if (facingRight == true)
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }

    public void act() {
        animateKangaro();

        if (Greenfoot.isKeyDown("a")) {
            move(-4);
            facingRight = false;
        }
        if (Greenfoot.isKeyDown("d")) {
            move(4);
            facingRight = true;
        }
        if (Greenfoot.isKeyDown("j") && !isJumping) {
            jump();
        }

        eat();
    }

    private void jump() {
        isJumping = true;
        for (int i = 0; i < 20; i++) {
            setLocation(getX(), getY() - 5);
            Greenfoot.delay(1);
        }
        for (int i = 0; i < 20; i++) {
            setLocation(getX(), getY() + 5);
            Greenfoot.delay(1);
        }
        isJumping = false;
    }

    public void eat() {
        if (isTouching(Fries.class)) {
            removeTouching(Fries.class);
            sound.play();
            MyWorld world = (MyWorld) getWorld();
            world.spawnFries();
            world.increaseScore();
        }
    }
}
