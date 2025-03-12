package org.example.app;

import environment.GameEngine;
import environment.PuzzleMatrix;

public class App {
  public static void main(String[] args) {
    PuzzleMatrix puzzle = new PuzzleMatrix(4, new int[4][4]);
    GameEngine game = new GameEngine(puzzle);
    game.play();
  }
}
