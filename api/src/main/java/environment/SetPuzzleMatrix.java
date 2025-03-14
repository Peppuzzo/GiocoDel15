package environment;

import java.util.List;

public abstract class SetPuzzleMatrix {

  protected final int size;

  public SetPuzzleMatrix(int size) {
    if (size < 1) throw new IllegalArgumentException("The matrix cannot be smaller than 1");
    this.size = size;
    setSize(size);
    initializeBoard();
  }


  /**
   * Method to generate random numbers (from 1 to 15) for
   *        the entire matrix, except in the first position
   *
   * @return the list with random numbers from 1 to 15
   */
  protected abstract List<Integer> generateRandomNumbers();


  /**
   * This method get a matrix
   *
   * @return get a matrix
   */
  public abstract int[][] getMatrix();


  /**
   * Method to read the data contained in a given row and column.
   *
   * @param row the row of the matrix
   * @param col the column of the matrix
   * @return the value contained in the matrix
   */
  public abstract int getValue(int row, int col);

  /**
   * Sets the value in a position of the matrix
   *
   * @param row the row to be set
   * @param col the column to be set
   * @param value the value set in the matrix
   */
  protected abstract void setValue(int row, int col, int value);


  /**
   * This method set the size for matrix
   *
   * @param size the size for matrix
   */
  protected abstract void setSize(int size);

  /**
   * Determines the length of the array
   *
   * @return the length of the array
   */
  public abstract int getSize();



  /**
   * Initializes the game array
   */
  protected abstract void initializeBoard();

  /**
   * Method to initialize the array with random
   *        numbers (except in the first position)
   *
   * @param numbers <code> List </code> of random numbers
   */
  protected abstract void fillBoard(List<Integer> numbers);

}
