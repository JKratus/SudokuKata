package io.shodo.kata.sudoku;

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
  @MethodSource("io.shodo.kata.sudoku.TestDSL#provideSudokuGrid")
  void sudoku_grid_validation(SudokuGrid sudokuGrid, boolean expected) {

    final boolean isValid = sudokuGridValidator.isValid(sudokuGrid);

    assertThat(isValid).isEqualTo(expected);
  }

  @Test
  void should_build_columns_for_rows() {
    SudokuGrid sudokuGrid = SudokuGrid.from(new String[]{
            "7 2 6 4 9 3 8 1 5",
            "3 1 5 7 2 8 9 4 6",
            "4 8 9 6 5 1 2 3 7",
            "8 5 2 1 4 7 6 9 3",
            "6 7 3 9 8 5 1 2 4",
            "9 4 1 3 6 2 7 5 8",
            "1 9 4 8 3 6 5 7 2",
            "5 6 7 2 1 4 3 8 9",
            "2 3 8 5 7 9 4 6 1",
    });

    Columns columns = sudokuGrid.getColumns();

    Columns expectedColumns = Columns.from(new String[]{
            "7 3 4 8 6 9 1 5 2",
            "2 1 8 5 7 4 9 6 3",
            "6 5 9 2 3 1 4 7 8",
            "4 7 6 1 9 3 8 2 5",
            "9 2 5 4 8 6 3 1 7",
            "3 8 1 7 5 2 6 4 9",
            "8 9 2 6 1 7 5 3 4",
            "1 4 3 9 2 5 7 8 6",
            "5 6 7 3 4 8 2 9 1"
    });

    assertThat(columns).isEqualTo(expectedColumns);
  }
}
