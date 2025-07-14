package org.example.entities;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

@Data
@Accessors(chain = true)
public class Snake {

    private int size;
    private Queue<Coordinate> body = new LinkedList<>();
    private HashMap<Coordinate, Boolean> positions = new HashMap<>();
    private String currentDirection = "R";
    private Coordinate head;


    public void move(String direction, Boolean grow, Integer boardSize) throws Exception {

        if(!canMove(direction)){
            throw new IllegalAccessException("Cannot move");
        }

        Coordinate newCoordinate = findNewHead(head, direction, boardSize);

        if(!grow){
            Coordinate tail = body.peek();
            body.remove();
            positions.remove(tail);
        }else{
            size++;
        }

        if(!Objects.isNull(positions.get(newCoordinate))){
            throw new Exception("Collision at " + newCoordinate.getX() + ", " + newCoordinate.getY());
        }

        body.add(newCoordinate);
        positions.put(newCoordinate, true);
        head = newCoordinate;

        currentDirection = direction;

    }

    public boolean canMove(String direction){
        if(Objects.equals(direction, "R") && Objects.equals(currentDirection, "L")){
            return false;
        }else if(Objects.equals(direction, "L") && Objects.equals(currentDirection, "R")){
            return false;
        } else if (Objects.equals(direction, "U") && Objects.equals(currentDirection, "D")) {
            return false;
        } else if (Objects.equals(direction, "D") && Objects.equals(currentDirection, "U")) {
            return false;
        }
        return true;
    }

    public Coordinate findNewHead(Coordinate head, String direction, Integer boardSize) {
        Coordinate newCoordinate = new Coordinate();
        if ("R".equals(direction)) {
            newCoordinate.setX((head.getX() + 1) % boardSize).setY(head.getY());
        } else if ("L".equals(direction)) {
            newCoordinate.setX((head.getX() - 1 + boardSize) % boardSize).setY(head.getY());
        } else if ("U".equals(direction)) {
            newCoordinate.setX(head.getX()).setY((head.getY() + 1) % boardSize);
        } else if ("D".equals(direction)) {
            newCoordinate.setX(head.getX()).setY((head.getY() - 1 + boardSize) % boardSize);
        }
        return newCoordinate;
    }

}
