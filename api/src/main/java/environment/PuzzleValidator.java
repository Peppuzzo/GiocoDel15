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

public class PuzzleValidator {

  private static final int DEFAULT_SIZE = 16;
  private static int[] line;

  public static void lineMatrixNumber(int[][] puzzle){
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
   * This method set a size default with a constant
   *     <code> DEFAULT_SIZE </code>
   *
   */
  private static void setDefaultSize(){
    line = new int[DEFAULT_SIZE];
  }





}
