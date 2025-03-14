package environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PuzzleMatrix extends SetPuzzleMatrix {

  public PuzzleMatrix(int size, int[][] board) {
    super(size, board);
  }


  protected void initializeBoard(){
    List<Integer> numbers = generateRandomNumbers();
    Collections.shuffle(numbers); // per rimescolare i numeri in modo casuale
    fillBoard(numbers);
  }


  protected void fillBoard(List<Integer> numbers){
    // la prima cella è sempre vuota
    this.matrix[0][0] = 0;
    int index = 0;

    for(int row = 0; row < size; row++){
      for(int column = 0; column < size; column++){
        if(row == 0 && column == 0) continue;
        this.matrix[row][column] = numbers.get(index++);
      }
    }
  }


  public List<Integer> generateRandomNumbers() {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 1; i < size * size; i++) {
      numbers.add(i);
    }
    return numbers;
  }

  public int[][] getMatrix(){return this.matrix;}

  protected int getSize(){
    return this.matrix.length;
  }

  protected int getValue(int row, int column){
    return this.matrix[row][column];
  }

  protected void setValue(int row, int col, int value){
    this.matrix[row][col] = value;
  }

}
