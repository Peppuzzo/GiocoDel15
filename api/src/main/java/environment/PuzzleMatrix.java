package environment;

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
  public int getSize(){
    return this.matrix.length;
  }

  @Override
  protected void setSize(int size){
    this.matrix = new int[size][size];
  }

  @Override
  public int getValue(int row, int column){
    return this.matrix[row][column];
  }

  @Override
  protected void setValue(int row, int col, int value){
    this.matrix[row][col] = value;
  }


}
