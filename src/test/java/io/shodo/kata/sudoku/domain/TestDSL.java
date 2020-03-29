package io.shodo.kata.sudoku.domain;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDSL {

  public static Stream<Arguments> provideRowWithNumbersTwice() {
    return Stream.of(
            Arguments.of(new Row(1, 1), false),
            Arguments.of(new Row(2, 2), false),
            Arguments.of(new Row(3, 3), false),
            Arguments.of(new Row(4, 4), false),
            Arguments.of(new Row(5, 5), false),
            Arguments.of(new Row(6, 6), false),
            Arguments.of(new Row(7, 7), false),
            Arguments.of(new Row(8, 8), false),
            Arguments.of(new Row(9, 9), false),
            Arguments.of(new Row(1, 2), true)
    );
  }

  public static Stream<Arguments> provideRowWithInvalidNumbers() {
    return Stream.of(
            Arguments.of(new Row(0, 1), false),
            Arguments.of(new Row(0, 1), false),
            Arguments.of(new Row(0, 2), false),
            Arguments.of(new Row(0, 3), false),
            Arguments.of(new Row(0, 4), false),
            Arguments.of(new Row(0, 5), false),
            Arguments.of(new Row(0, 6), false),
            Arguments.of(new Row(0, 7), false),
            Arguments.of(new Row(0, 8), false),
            Arguments.of(new Row(0, 9), false),
            Arguments.of(new Row(1, 2, 3, 4, 5, 6, 7, 8, 9), true)
    );
  }

  public static Stream<Arguments> provideColumnWithNumbersTwice() {
    return Stream.of(
            Arguments.of(new Column(1, 1), false),
            Arguments.of(new Column(2, 2), false),
            Arguments.of(new Column(3, 3), false),
            Arguments.of(new Column(4, 4), false),
            Arguments.of(new Column(5, 5), false),
            Arguments.of(new Column(6, 6), false),
            Arguments.of(new Column(7, 7), false),
            Arguments.of(new Column(8, 8), false),
            Arguments.of(new Column(9, 9), false),
            Arguments.of(new Column(1, 2), true)
    );
  }

  public static Stream<Arguments> provideColumnWithInvalidNumbers() {
    return Stream.of(
            Arguments.of(new Column(0, 1), false),
            Arguments.of(new Column(0, 1), false),
            Arguments.of(new Column(0, 2), false),
            Arguments.of(new Column(0, 3), false),
            Arguments.of(new Column(0, 4), false),
            Arguments.of(new Column(0, 5), false),
            Arguments.of(new Column(0, 6), false),
            Arguments.of(new Column(0, 7), false),
            Arguments.of(new Column(0, 8), false),
            Arguments.of(new Column(0, 9), false),
            Arguments.of(new Column(1, 2, 3, 4, 5, 6, 7, 8, 9), true)
    );
  }

  public static Stream<Arguments> provideSpaceWithInvalidNumbers() {
    return Stream.of(
            Arguments.of(Space.from(new String[]{
                    "0 1 1",
                    "2 5 4",
                    "5 6 7"
            }), false),
            Arguments.of(Space.from(new String[]{
                    "6 1 1",
                    "2 0 4",
                    "5 6 9"
            }), false),
            Arguments.of(Space.from(new String[]{
                    "6 1 1",
                    "2 3 4",
                    "5 6 0"
            }), false),
            Arguments.of(Space.from(new String[]{
                    "1 2 3",
                    "4 5 6",
                    "7 8 9"
            }), true)
    );
  }

  public static Stream<Arguments> provideSpaceWithNumbersTwice() {
    return Stream.of(
            Arguments.of(Space.from(new String[]{
                    "3 1 1",
                    "2 3 4",
                    "5 6 7"
            }), false),
            Arguments.of(Space.from(new String[]{
                    "1 2 3",
                    "4 5 6",
                    "7 8 9"
            }), true)
    );
  }

  public static Stream<Arguments> provideSudokuGrid() {
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


}
