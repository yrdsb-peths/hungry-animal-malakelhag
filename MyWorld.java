import greenfoot.*;

public class MyWorld extends World {
    private int score = 0;
    private int friesEatenCount = 0;

    private Label scoreLabel;
    private boolean gameOver = false;

    public MyWorld() {
        super(600, 400, 1, false);
        Kangaro kangaro = new Kangaro();
        addObject(kangaro, 300, 300);
        spawnFries();

        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
    }

    public void act() {
        if (Greenfoot.isKeyDown("space") && gameOver) {
            Greenfoot.setWorld(new MyWorld());
        }
    }

    public void onGameOver() {
        gameOver = true;
        Label gameOverLabel = new Label("Game Over", 50);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);

        // Display the score
        Label scoreMessageLabel = new Label("Score: " + score + "\nPress space to start again", 30);
        addObject(scoreMessageLabel, getWidth() / 2, getHeight() / 2 + 50);
    }

    public void increaseScore() {
        if (getObjects(Fries.class).isEmpty()) {
            // No fries on the screen, spawn a new one
            spawnFries();
        }

        int points = 1; // Default points
        if (++friesEatenCount % 5 == 0) {
            for (Object obj : getObjects(Fries.class)) {
                Fries fries = (Fries) obj;
                fries.setActInterval(fries.getActInterval() - 1);
            }
        }

        for (Object obj : getObjectsAt(getWidth() / 2, getHeight() / 2, Label.class)) {
            Label scoreMessageLabel = (Label) obj;
            removeObject(scoreMessageLabel);
        }

        for (Object obj : getObjectsAt(getWidth() / 2, getHeight() / 2 + 50, Label.class)) {
            Label scoreMessageLabel = (Label) obj;
            removeObject(scoreMessageLabel);
        }

        for (Object obj : getObjectsAt(getWidth() / 2, getHeight() / 2, Label.class)) {
            Label gameOverLabel = (Label) obj;
            removeObject(gameOverLabel);
        }

        if (!gameOver) {
            for (Object obj : getObjectsAt(getWidth() / 2, getHeight() / 2 + 50, Label.class)) {
                Label scoreMessageLabel = (Label) obj;
                removeObject(scoreMessageLabel);
            }
            score += points;

            // Check if the fries is special
            for (Object obj : getObjectsAt(getWidth() / 2, getHeight() / 2 + 50, Label.class)) {
                Label scoreMessageLabel = (Label) obj;
                removeObject(scoreMessageLabel);
            }

            for (Object obj : getObjectsAt(getWidth() / 2, getHeight() / 2, Label.class)) {
                Label scoreMessageLabel = (Label) obj;
                removeObject(scoreMessageLabel);
            }

            if (Greenfoot.getRandomNumber(10) == 0) {
                // Special fries - double points
                points = 2;
                Label specialFriesLabel = new Label("Special Fries - Extra point!!!", 20);
                addObject(specialFriesLabel, getWidth() / 2, getHeight() / 2 + 50);
            }

            score += points;
            scoreLabel.setValue(score);
        }
    }

    public void spawnFries() {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        Fries fries = new Fries();
        addObject(fries, x, y);
    }
}
