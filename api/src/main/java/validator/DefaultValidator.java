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

import environment.SetPuzzleMatrix;

public class DefaultValidator implements PuzzleValidate {

  @Override
  public boolean isSolvable(SetPuzzleMatrix puzzle) {
    int expected = 1;

    if(puzzle.getSize() < 2){
      System.out.println("Puzzle size is too small");
      return false;
    }

    for(int i = 0; i < puzzle.getSize(); i++) {
      for(int j = 0; j < puzzle.getSize(); j++) {
        if(i == puzzle.getSize() - 1 && j == puzzle.getSize() - 1){
          return puzzle.getValue(j, i) == 0;
        }
        if(puzzle.getValue(i, j) != expected++) {
          return false;
        }
      }
    }
    return true;
  }


}
