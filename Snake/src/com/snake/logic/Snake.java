package com.snake.logic;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Position> body;
    private Direction currentDirection;
    private boolean grow;
    
    public Snake(int startX, int startY) {
        body = new ArrayList<>();
        body.add(new Position(startX, startY));
        currentDirection = Direction.RIGHT;
    }
    
    public void move() {
        Position head = getHead();
        Position newHead = new Position(head.getX(), head.getY());
        
        switch (currentDirection) {
            case UP:    newHead = new Position(head.getX(), head.getY() - 1); break;
            case DOWN:  newHead = new Position(head.getX(), head.getY() + 1); break;
            case LEFT:  newHead = new Position(head.getX() - 1, head.getY()); break;
            case RIGHT: newHead = new Position(head.getX() + 1, head.getY()); break;
        }
        body.add(0, newHead);
        if (!grow) {
            body.remove(body.size() - 1);
        } else {
            grow = false;
        }
    }
    
    public void grow() {
        grow = true;
    }
    
    public void setDirection(Direction newDirection) {
        // Evitar dar la vuelta a 180 grados
        if (currentDirection.isOpposite(newDirection)) return;
        this.currentDirection = newDirection;
    }
    
    public Position getHead() {
        return body.get(0);
    }
    
    public List<Position> getBody() {
        return body;
    }
    
    public boolean checkSelfCollision() {
        Position head = getHead();
        for (int i = 1; i < body.size(); i++) {
            if (head.equals(body.get(i))) return true;
        }
        return false;
    }
}
