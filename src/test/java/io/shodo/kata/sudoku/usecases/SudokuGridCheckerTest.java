package io.shodo.kata.sudoku.usecases;

import io.shodo.kata.sudoku.domain.SudokuGrid;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SudokuGridCheckerTest {

  private SudokuGridChecker sudokuGridChecker = new SudokuGridChecker();

  private static Stream<Arguments> provideSudokuGrid() {
    return Stream.of(
            Arguments.of(SudokuGrid.from(new String[]{
                    "7 2 6 4 9 3 8 1 5",
                    "3 1 5 7 2 8 9 4 6",
                    "4 8 9 6 5 1 2 3 7",
                    "8 5 2 1 4 7 6 9 3",
                    "6 7 3 9 8 5 1 2 4",
                    "9 4 1 3 6 2 7 5 8",
                    "1 9 4 8 3 6 5 7 2",
                    "5 6 7 2 1 4 3 8 9",
                    "2 3 8 5 7 9 4 6 1",

            }), true)
    );
  }

  @Test
  void grid_empty_is_not_finish() {

    final boolean isFinished = sudokuGridChecker.isValid(SudokuGrid.EMPTY);

    assertThat(isFinished).isFalse();
  }

  @ParameterizedTest()
  @MethodSource("provideSudokuGrid")
  void sudoku_grid_validation(SudokuGrid sudokuGrid, boolean expected) {

    final boolean isValid = sudokuGridChecker.isValid(sudokuGrid);

    assertThat(isValid).isEqualTo(expected);
  }
}
