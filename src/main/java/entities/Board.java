package entities;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

@Builder
@Getter
public class Board {

    private Integer size;
    private Snake snake;
    private Integer moves;

    public void moveSnake(String direction) throws Exception {
        System.out.println("Moving snake in direction: " + direction);
        moves++;
        boolean grow = moves % 3 == 0;
        try {
            snake.move(direction, grow, size);
        }catch (IllegalAccessException ie){
            System.out.println(ie.getMessage());
            moves--;
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new RuntimeException("Something went wrong while moving the snake", e);
        }
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Coordinate coordinate = new Coordinate().setX(j).setY(i);
                if (snake.getPositions().containsKey(coordinate)) {
                    System.out.print("S ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
