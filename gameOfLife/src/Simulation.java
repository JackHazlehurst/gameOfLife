import ecs100.*;

import java.awt.*;

public class Simulation {
    private static Cell[][] board;
    private static final int NUM_CELLS = 20;

    public static void main(String[] args){
        new Simulation();
    }

    /**
     * runs the simulation of Conway's Game of Life
     */
    public Simulation(){
        board = generateBoard(NUM_CELLS);
        drawBoard(board);
    }

    /**
     * draws the board in its current state
     *
     * @param toDraw the board that is to be drawn
     */
    private void drawBoard(Cell[][] toDraw) {
        UI.setImmediateRepaint(false);

        final int CELL_SIZE = 10; //size of each cell in pixels
        final int OFFSET = 150;//offset from the borders on the top and left

        for (int row = 0; row < toDraw.length; row++) {
            for (int col = 0; col < toDraw[row].length; col++) {
                //changes color depending on if the cell is alive or not
                UI.setColor(Color.WHITE);

                if (toDraw[row][col].isAlive())
                    UI.setColor(Color.BLACK);

                UI.fillRect(OFFSET + row * CELL_SIZE, OFFSET + col * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }

        UI.repaintGraphics();
    }

    /**
     * generates new board with random starting positions
     *
     * @param boardSize the size of the board
     * @return the new board with random starting positions
     */
    private Cell[][] generateBoard(int boardSize) {
        Cell[][] board = new Cell[boardSize][boardSize];

        UI.println("Generating Board");

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                board[row][col] = new Cell();
            }
        }

        UI.println("Board Generated");
        return board;
    }
}
