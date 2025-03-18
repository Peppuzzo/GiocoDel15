package org.example.app;

import environment.engine.GameEngine;
import environment.setup.PuzzleMatrix;
import validator.DefaultValidator;
import validator.PuzzleValidate;

public class App {
  public static void main(String[] args) {

    PuzzleMatrix puzzle = new PuzzleMatrix(4);
    PuzzleValidate val = new DefaultValidator();
    GameEngine game = new GameEngine(puzzle, val);

    game.play();
  }
}
