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

package action;

import utils.IllegalSizeMatrixException;

public record CurrentPosition(int row, int col, int size)  {

  public CurrentPosition {
    if(row < 0 || col < 0 || size < 0)
      throw new IllegalSizeMatrixException("Row and column are negative");
  }


  /**
   * This method calculate the next position of presentation
   *
   * @param dir la direzione effettiva del movimento
   * @return <code> TRUE </code>  If moving between positions is allowed
   *         <code> FALSE </code> The exact same position
   */
  public CurrentPosition move(SlidingDirection dir){

    switch (dir){
      case UP: if(row > 0) return new CurrentPosition(row - 1, col, size);

      case DOWN: if(row < size - 1) return new CurrentPosition(row + 1, col, size);

      case LEFT: if(col > 0) return new CurrentPosition(row, col - 1, size);

      case RIGHT:
        if(col < size - 1) return new CurrentPosition(row, col + 1, size);
    }
    return this;
  }

}
