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

/**
 * This responsibility is presentation the next position
 */
public class CurrentPosition implements Position {

  private final int row; // the row where the position is located
  private final int column; // the column where the position is located
  private final int size; // the size of matrix


  public CurrentPosition(int row, int column, int size){
    if(row < 0 || column < 0 || size < 0)
      throw new IllegalArgumentException("Coordinate not value");
    this.row = row;
    this.column = column;
    this.size = size;
  }


  @Override
  //TODO: Fix the method in case a direction is null, or is invalid
  public Position move(SlidingDirection direction){
    switch (direction){
      case UP:
        if(row > 0) return new CurrentPosition(row - 1, column, size); // Move up
        else throw new IllegalDirectionException("Invalid direction: " + direction.name());
      case DOWN:
        if(row < size - 1) return new CurrentPosition(row + 1, column, size); // Move down
        else throw new IllegalDirectionException("Invalid direction: " + direction.name());
      case LEFT:
        if(column > 0) return new CurrentPosition(row, column - 1, size); // Move left
        else throw new IllegalDirectionException("Invalid direction: " + direction.name());
      case RIGHT:
        if(column < size - 1) return new CurrentPosition(row, column + 1, size); // Move right
    }
    return null;
  }


  @Override
  public int getRow() { return this.row;}

  @Override
  public int getCol() { return this.column;}

}
