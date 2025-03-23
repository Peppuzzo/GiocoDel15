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

package validator;

import utils.IllegalSizeMatrixException;
import environment.setup.SetPuzzleMatrix;


/**
 * This class is responsible for implementing the
 *      default puzzle solution, according to the Wikipedia guide.
 * <p>
 * A (similar) solution for the game can be found at the following link:
 * @see <a href="https://it.wikipedia.org/wiki/Gioco_del_quindici">Wikipedia - Gioco del quindici </a>
 */
public class DefaultValidator implements PuzzleValidate {

  private static final int DEFAULT_SIZE = 16;
  private static int[] line;
  private static int inversion;


  /**
   * This method set the size for array line
   *
   */
  private static void setDefaultSize(){
    line = new int[DEFAULT_SIZE];
  }


  /**
   * Transform the matrix into a linear array
   *
   * @param puzzle The reference matrix
   * @throws IllegalSizeMatrixException If the length of the matrix is 0
   */
  private static void lineMatrixNumber(int[][] puzzle){
    if(puzzle.length == 0){
      throw new IllegalSizeMatrixException("Puzzle is empty");
    }
    setDefaultSize();
    int index = 0;
    for (int[] e : puzzle) {
      for (int j = 0; j < puzzle.length; j++) {
        if (e[j] != 0) {
          line[index++] = e[j];
        }
      }
    }
  }


  /**
   * This method determines whether there are any inversions
   */
  private static void determinateInversions(int[] ln){
    for(int i = 0; i < ln.length - 1; i++){
      if(ln[i] > ln[i+1]){
        inversion++;
      }
    }
  }


  @Override
  public boolean isSolvable(SetPuzzleMatrix puzzle) {
    lineMatrixNumber(puzzle.getMatrix());
    determinateInversions(DefaultValidator.line);
    return inversion % 2 == 0;
  }

}
