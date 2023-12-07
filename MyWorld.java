import greenfoot.*;

public class MyWorld extends World {
    private int score = 0;
    private int friesEatenCount = 0;
    private int highestScore = 0; // New variable to store the highest score
    private Label scoreLabel;

    public MyWorld() {    
        super(600, 400, 1, false);
        Kangaro kangaroo = new Kangaro();
        addObject(kangaroo, 300, 300);
        spawnFries();

        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 50, 50);
    }

    public void onGameOver() {
        Label gameOverLabel = new Label("Game Over", 50);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);

        // Display the score and check for a new record
        String message = "Score: " + score;
        if (score > highestScore) {
            highestScore = score;
            message += "\nNew Record!";
        }
        Label scoreMessageLabel = new Label(message, 30);
        addObject(scoreMessageLabel, getWidth() / 2, getHeight() / 2 + 50);

        // Reset the score for the next game
        score = 0;
        friesEatenCount = 0;
        Greenfoot.delay(100); // Delay before restarting the game
        Greenfoot.setWorld(new MyWorld());
    }

    public void increaseScore() {
        score = score + 1;
        scoreLabel.setValue(score);

        if (++friesEatenCount % 5 == 0) {
            for (Object obj : getObjects(Fries.class)) {
                Fries fries = (Fries) obj;
                fries.setActInterval(fries.getActInterval() - 1);
            }
        }
    }

    public void spawnFries() {
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        Fries fries = new Fries();
        addObject(fries, x, y);
    }
}
