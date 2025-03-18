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

package environment.engine;

import java.util.Scanner;
import action.CurrentPosition;
import action.Position;
import action.SlidingDirection;
import environment.setup.SetPuzzleMatrix;
import validator.PuzzleValidate;

//TODO: Arrange methods to only use get and throw exceptions
//TODO: Separating concepts with position swap
public class GameEngine {

  private final SetPuzzleMatrix puzzle;
  private static Position currentPosition;
  private final PuzzleValidate puzzleValidate;

  public GameEngine(SetPuzzleMatrix game, PuzzleValidate puzzleValidate) {
    this.puzzle = game;
    this.puzzleValidate = puzzleValidate;
    currentPosition = new CurrentPosition(0, 0, puzzle.getSize());
  }


  /**
   * Selective game start
   *
   */
  public void play() {
    Scanner keyboard = new Scanner(System.in);
    do {
      printBoard();
      SwapPosition(stringToDirection(keyboard));
    } while(!this.puzzleValidate.isSolvable(puzzle));

    keyboard.close();
  }


  /**
   * This method converted an Object <code> keyboard </code>
   * in a direction
   *
   * @param keyboard The object to be converted
   * @return The string as input
   */
  private SlidingDirection stringToDirection(Scanner keyboard) {
    if(keyboard == null) throw new NullPointerException("keyboard is null");
    String direction = keyboard.nextLine().toUpperCase();

    return SlidingDirection.valueOf(direction);
  }


  /**
   * Method for exchanging positions, relative to a direction
   *
   * @param direction the relative direction
   */
  private void SwapPosition(SlidingDirection direction) {
    try {
      Position position = currentPosition.move(direction);

      this.puzzle.setValue(currentPosition.getRow(), currentPosition.getCol(),
              this.puzzle.getValue(position.getRow(), position.getCol()));
      this.puzzle.setValue(position.getRow(),
              position.getCol(), 0);
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid move!");
    }
  }


  /**
   * Print the Puzzle game.
   *
   */
  public void printBoard() {
    System.out.println("-----------------");
    for (int[] value : this.puzzle.getMatrix()) {
      for (int i : value) {
        if (i == 0) {
          System.out.print("|   " );
        } else {
          System.out.printf("|%2d ", i);
        }
      }
      System.out.println("|");
      System.out.println("-----------------");
    }
    System.out.print("Enter move (UP, DOWN, LEFT, RIGHT)");
  }
}
