import greenfoot.*;

public class GameOverWorld extends World {

    public GameOverWorld() {    
        super(600, 400, 1); 
        Label gameOverLabel = new Label("Game Over", 80);
        addObject(gameOverLabel, getWidth() / 2, getHeight() / 2);
    }
}
