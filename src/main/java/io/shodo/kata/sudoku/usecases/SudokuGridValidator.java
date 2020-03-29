package io.shodo.kata.sudoku.usecases;

import io.shodo.kata.sudoku.domain.SudokuGrid;

import java.util.List;

import static java.util.Arrays.asList;

public class SudokuGridValidator {
  public static final List<Integer> SUDOKU_VALID_NUMBERS = asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

  public boolean isValid(SudokuGrid sudokuGrid) {
    return sudokuGrid.isNotEmpty() &&
            sudokuGrid.allRowsAreValid() &&
            sudokuGrid.allColumnsAreValid() &&
            sudokuGrid.allSpacesAreValid();
  }
}
