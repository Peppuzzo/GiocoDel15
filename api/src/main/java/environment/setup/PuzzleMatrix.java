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

package environment.setup;

import utils.IllegalSizeMatrixException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleMatrix extends SetPuzzleMatrix {

  private int[][] matrix;

  public PuzzleMatrix(int size) {
    super(size);
  }


  @Override
  protected void initializeBoard(){
    List<Integer> numbers = generateRandomNumbers();
    Collections.shuffle(numbers); // to shuffle numbers randomly
    fillBoard(numbers);
  }


  @Override
  protected void fillBoard(List<Integer> numbers){
    if(numbers.isEmpty()){
      throw new IllegalSizeMatrixException("The size of a puzzle matrix" +
        "cannot be zero.");
    }
    // the first cell is always empty
    this.matrix[0][0] = 0;
    int index = 0;

    for(int row = 0; row < size; row++){
      for(int column = 0; column < size; column++){
        if(row == 0 && column == 0) continue;
        this.matrix[row][column] = numbers.get(index++);
      }
    }
  }


  @Override
  public List<Integer> generateRandomNumbers() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i < size * size; i++) {
      numbers.add(i);
    }
    return numbers;
  }


  @Override
  public int[][] getMatrix() {
    return this.matrix;
  }


  @Override
  public int getSize() {
    return this.size;
  }

  @Override
  protected void setSize(int size){
    //if(this.getSize() != 4)
      //throw new IllegalSizeMatrixException("The length of matrix not is valid.");
    this.matrix = new int[size][size];
  }

  @Override
  public int getValue(int row, int column){
    if(row < 0 || column < 0){
      throw new IllegalSizeMatrixException("The row or the column number is invalid.");
    }
    return this.matrix[row][column];
  }

  @Override
  public void setValue(int row, int col, int value){
    if(row < 0 || col < 0 || value < 0)
      throw new IllegalSizeMatrixException("The row or the column number is invalid.");
    this.matrix[row][col] = value;
  }


}
