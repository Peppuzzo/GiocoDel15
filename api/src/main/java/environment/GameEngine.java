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

import java.util.Scanner;
import Action.CurrentPosition;
import Action.Position;
import Action.SlidingDirection;

public class GameEngine {

  private final PuzzleMatrix puzzle;
  private static CurrentPosition currentPosition;


  public GameEngine(PuzzleMatrix game) {
    this.puzzle = game;
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
    } while(!isSolved(this.puzzle));

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

      // Update the current position of the empty cell
      currentPosition = (CurrentPosition) position;
    } catch (IllegalArgumentException e) {
      System.out.println("Invalid move!");
    }
  }


  /**
   * Determines whether the game is in a solved state
   *
   * @param puzzle The current game
   * @return if the game is solved
   */
  public boolean isSolved(PuzzleMatrix puzzle) {
    int expected = 1;

    if(puzzle.size < 2){
      System.out.println("Puzzle size is too small");
      return false;
    }

    for(int i = 0; i < puzzle.getSize(); i++) {
      for(int j = 0; j < puzzle.getSize(); j++) {
        if(i == this.puzzle.getSize() - 1 && j == this.puzzle.getSize() - 1){
          return puzzle.getValue(j, i) == 0;
        }
        if(puzzle.getValue(i, j) != expected++) {
          return false;
        }
      }
    }
    return true;
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
          System.out.print("|   "); // Casella vuota
        } else {
          System.out.printf("|%2d ", i); // Stampa numeri con formato allineato
        }
      }
      System.out.println("|");
      System.out.println("-----------------");
    }
    System.out.print("Enter move (UP, DOWN, LEFT, RIGHT)");
  }
}
