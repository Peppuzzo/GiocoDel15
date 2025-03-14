package environment;

import java.util.ArrayList;
import java.util.List;

public abstract class SetPuzzleMatrix {

  protected final int size;
  protected final int[][] matrix;


  public SetPuzzleMatrix(int size, int[][] matrix) {
    if (size < 1) throw new IllegalArgumentException("La matrice non può essere più piccola di 1");
    this.size = size;
    this.matrix = matrix;
    initializeBoard();
  }


  /**
   * Metodo per generare i numeri casuali (da 1 a 15) per
   * tutta la matrice, tranne nella prima posizione
   *
   * @return la lista con numeri casuali da 1 a 15
   */
  protected abstract List<Integer> generateRandomNumbers();


  /**
   * Metodo per leggere il dato contenuto in una determinata riga e colonna.
   *
   * @param row la riga della matrice
   * @param col la colonna della matrice
   * @return il valore contenuto nella matrice
   */
  protected abstract int getValue(int row, int col);


  /**
   * Setta il valore in una posizione della matrice
   *
   * @param row la riga da dover settare
   * @param col la colonna da dover settare
   * @param value il valore settato nella matrice
   */
  protected abstract void setValue(int row, int col, int value);


  /**
   * Determina la lunghezza della matrice
   *
   * @return la lunghezza della matrice
   */
  protected abstract int getSize();


  /**
   * Inizializza la matrice di gioco
   */
  protected abstract void initializeBoard();


  /**
   * Metodo per inizializzare la matrice con num.
   *        casuali (tranne nella prima posizione)
   *
   * @param numbers <code> List </code> di numeri random
   */
  protected abstract void fillBoard(List<Integer> numbers);


  /**
   * Method to read the game representation matrix
   *
   * @return read the game representation matrix
   */
  protected int[][] getMatrix() { return matrix; }

}
