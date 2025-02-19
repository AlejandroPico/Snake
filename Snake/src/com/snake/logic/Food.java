package com.snake.logic;

public class Food {
    private Position position;
    
    public Food(int x, int y) {
        this.position = new Position(x, y);
    }
    
    public Position getPosition() {
        return position;
    }
}
