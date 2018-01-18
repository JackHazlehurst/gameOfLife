public class Cell {
    private boolean alive;

    /**
     * cell is generated with a random starting state (dead or alive)
     */
    public Cell() {
        alive = false;

        if (Math.random() > 0.5)
            alive = true;
    }

    /**
     * cell is passed the starting state
     *
     * @param startingState true = alive, false = dead
     */
    public Cell(boolean startingState) {
        alive = startingState;
    }

    /**
     * gets the state of the cell
     *
     * @return if the cell is alive or not
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * kills the cell
     */
    public void kill() {
        alive = false;
    }

    /**
     * revives the cell
     */
    public void revive() {
        alive = true;
    }
}
