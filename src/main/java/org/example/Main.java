package org.example;

import entities.Board;
import entities.Coordinate;
import entities.Snake;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter square board size n");

        String n = input.nextLine();

        System.out.println("Enter start size of snake");

        int size = Integer.parseInt(input.nextLine());

        //body would change like a queue

        Queue<Coordinate> body = new LinkedList<>();
        HashMap<Coordinate, Boolean> positions = new HashMap<>();

        for(int i = 0;i<size;i++){
            Coordinate coordinate = new Coordinate().setY(0).setX(i);
            body.add(coordinate);
            positions.put(coordinate, true);
        }

        Snake snake = new Snake().setSize(size).setBody(body).setPositions(positions).setCurrentDirection("R").setHead(new Coordinate().setY(0).setX(size - 1));
        Board board = Board.builder().size(Integer.parseInt(n)).snake(snake).moves(0).build();

        board.moveSnake("R");
        board.printBoard();
        board.moveSnake("L");
        board.printBoard();
        board.moveSnake("U");
        board.printBoard();
        board.moveSnake("U");
        board.printBoard();
        board.moveSnake("U");
        board.printBoard();
        board.moveSnake("U");
        board.printBoard();
        board.moveSnake("U");
        board.printBoard();
        board.moveSnake("R");
        board.printBoard();
        board.moveSnake("R");
        board.printBoard();
        board.moveSnake("R");
        board.printBoard();
        board.moveSnake("R");
        board.printBoard();
        board.moveSnake("R");
        board.printBoard();
        board.moveSnake("R");
        board.printBoard();
    }
}