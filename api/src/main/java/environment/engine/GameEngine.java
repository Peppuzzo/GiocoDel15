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
import action.IllegalDirectionException;
import action.SlidingDirection;
import environment.setup.SetPuzzleMatrix;
import validator.PuzzleValidate;

//TODO: Separating concepts with position swap
public class GameEngine {

  private final SetPuzzleMatrix puzzle;
  private static CurrentPosition currentPosition;
  private final PuzzleValidate validate;

  public GameEngine(SetPuzzleMatrix game, PuzzleValidate validate) {
    this.puzzle = game;
    this.validate = validate;
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
    } while(!this.validate.isSolvable(puzzle));
    System.out.println("\n" + "YOU ARE SOLVED");
    keyboard.close();
  }


  /**
   * This method converted an Object <code> keyboard </code>
   * in a direction
   *
   * @param keyboard The object to be converted
   * @return The string as input
   * @throws NullPointerException if keyboard is null
   * @throws IllegalDirectionException if the direction is not valid
   */
  private SlidingDirection stringToDirection(Scanner keyboard) {
    if(keyboard == null) throw new NullPointerException("keyboard is null");
    String direction = keyboard.nextLine().toUpperCase();

    try{
      return SlidingDirection.valueOf(direction);
    }
    catch (Exception e) {
      throw new IllegalDirectionException("Invalid direction: " + direction);
    }

  }


  /**
   * Method for exchanging positions, relative to a direction
   *
   * @param direction the relative direction
   */
  private void SwapPosition(SlidingDirection direction) {
    try {
      CurrentPosition position = currentPosition.move(direction);

      this.puzzle.setValue(currentPosition.row(), currentPosition.row(),
              this.puzzle.getValue(position.row(), position.row()));
      this.puzzle.setValue(position.row(),
              position.row(), 0);
      currentPosition = position; // update position
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
    System.out.print("Enter move (UP, DOWN, LEFT, RIGHT) ");
  }
}
