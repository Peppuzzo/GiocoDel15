/*
 * MIT License
 *
 * Copyright (c) 2025 Giuseppe Calabrese
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
  public abstract List<Integer> generateRandomNumbers();


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
   *              @throws IllegalSizeMatrixException if the value not valid
   */
  protected abstract void setValue(int row, int col, int value);


  /**
   * This method return the size of matrix.
   *
   * @return the size of matrix.
   */
  public abstract int getSize();


  /**
   * This method set the size for matrix
   *
   * @param size the size for matrix
   * @throws IllegalSizeMatrixException if the zie of matrix not is four
   */
  protected abstract void setSize(int size);


  /**
   * Initializes the game array
   */
  protected abstract void initializeBoard();

  /**
   * Method to initialize the array with random
   *        numbers (except in the first position)
   *
   * @param numbers <code> List </code> of random numbers
   * @throws IllegalSizeMatrixException if the size of matrix is empty
   */
  protected abstract void fillBoard(List<Integer> numbers);

}
