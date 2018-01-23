import ecs100.*;

import java.awt.*;

public class Simulation {
    private static Cell[][] board;
    private static final int BOARD_SIZE = 50;

    public static void main(String[] args) {
        new Simulation();
    }

    /**
     * runs the simulation of Conway's Game of Life
     */
    public Simulation() {
        board = generateBoard(BOARD_SIZE);
        drawBoard();
    }

    /**
     * draws the board in its current state
     */
    private void drawBoard() {
        UI.setImmediateRepaint(false);

        final int CELL_SIZE = 10; //size of each cell in pixels
        final int OFFSET = 25;//offset from the borders on the top and left

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                //changes color depending on if the cell is alive or not
                UI.setColor(Color.WHITE);

                if (board[row][col].isAlive())
                    UI.setColor(Color.BLACK);

                UI.fillRect(OFFSET + row * CELL_SIZE, OFFSET + col * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                //draws number of neighbours 
                UI.setColor(Color.YELLOW);
                UI.drawString(Integer.toString(numNeighbours(row, col)), OFFSET + row * CELL_SIZE, OFFSET + col * CELL_SIZE + CELL_SIZE);
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

        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                board[row][col] = new Cell();
            }
        }

        return board;
    }

    /**
     * returns the number of neighbours for a given cell
     * <p>
     * Note: for cells on the edge of the board this will wrap around to the other side to look for neighbours
     *
     * @param row the row the cell is in
     * @param col the column the cell is in
     * @return the number of neighbours
     */
    private int numNeighbours(int row, int col) {
        int numNeighbours = 0;

        //for all neighbours check if they are alive
        for (int rowOffSet = -1; rowOffSet <= 1; rowOffSet++)
            for (int colOffSet = -1; colOffSet <= 1; colOffSet++)
                if (board[Math.floorMod(row + rowOffSet, BOARD_SIZE)][Math.floorMod(col + colOffSet, BOARD_SIZE)].isAlive()
                        && !(rowOffSet == 0 && colOffSet == 0))//so the cell does not count itself
                    numNeighbours++;

        return numNeighbours;
    }
}
