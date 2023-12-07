import greenfoot.*;

public class MyWorld extends World {
    private int score = 0;
    private int friesEatenCount = 0;
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
        Label gameOverLabel = new Label("Game Over!", 70);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);
    }

    public void increaseScore() {
        score = score + 1;
        scoreLabel.setValue(score);

        if (++friesEatenCount % 1 == 0) {
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
