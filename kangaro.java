import greenfoot.*;

public class Kangaro extends Actor {
    private boolean isJumping = false;

    GreenfootImage[] rightImages = new GreenfootImage[8];
    GreenfootImage[] leftImages = new GreenfootImage[8];
    int animationDelay = 100;
    int animationCounter = 0;
    boolean facingRight = true;

    GreenfootSound sound = new GreenfootSound("sounds/Eating sound effect.mp3");

    public Kangaro() {
        for (int i = 0; i < rightImages.length; i++) {
            rightImages[i] = new GreenfootImage("images/kangaroo.png");
            rightImages[i].scale(100, 100);
        }
        for (int i = 0; i < leftImages.length; i++) {
            leftImages[i] = new GreenfootImage("images/kangaroo.png");
            leftImages[i].scale(100, 100);
            leftImages[i].mirrorHorizontally();
        }
        setImage(rightImages[3]);
    }

    public void animateKangaro() {
        if (animationCounter % (animationDelay / 100) == 0) {
            if (facingRight) {
                setImage(rightImages[(animationCounter / (animationDelay / 100)) % rightImages.length]);
            } else {
                setImage(leftImages[(animationCounter / (animationDelay / 100)) % leftImages.length]);
            }
        }
        animationCounter++;
    }

    public void act() {
        animateKangaro();

        if (Greenfoot.isKeyDown("a")) {
            move(-3);
        }
        if (Greenfoot.isKeyDown("d")) {
            move(3);
        }
        if (Greenfoot.isKeyDown("space") && !isJumping) {
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
