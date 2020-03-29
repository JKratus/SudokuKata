package io.shodo.kata.sudoku.usecases;

import io.shodo.kata.sudoku.domain.SudokuGrid;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class SudokuGridValidatorTest {

  private SudokuGridValidator sudokuGridValidator = new SudokuGridValidator();

  @Test
  void grid_empty_is_not_finish() {

    final boolean isFinished = sudokuGridValidator.isValid(SudokuGrid.EMPTY);

    assertThat(isFinished).isFalse();
  }

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("io.shodo.kata.sudoku.domain.TestDSL#provideSudokuGrid")
  void sudoku_grid_validation(SudokuGrid sudokuGrid, boolean expected) {

    final boolean isValid = sudokuGridValidator.isValid(sudokuGrid);

    assertThat(isValid).isEqualTo(expected);
  }
}
