package com.snake.input;

import javafx.scene.input.KeyEvent;
import com.snake.logic.Direction;
import com.snake.logic.GameEngine;

public class InputHandler {
    private GameEngine engine;
    
    public InputHandler(GameEngine engine) {
        this.engine = engine;
    }
    
    public void handleKeyPress(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
            case W:
                engine.setDirection(Direction.UP);
                break;
            case DOWN:
            case S:
                engine.setDirection(Direction.DOWN);
                break;
            case LEFT:
            case A:
                engine.setDirection(Direction.LEFT);
                break;
            case RIGHT:
            case D:
                engine.setDirection(Direction.RIGHT);
                break;
            default:
                break;
        }
    }
}
