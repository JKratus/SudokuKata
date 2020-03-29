package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@ValueType
public final class SudokuGrid {
  public static final SudokuGrid EMPTY = new SudokuGrid();
  private final Rows rows;

  private SudokuGrid() {
    this.rows = Rows.EMPTY;
  }

  private SudokuGrid(List<Row> rows) {
    this.rows = Rows.from(rows);
  }

  public static SudokuGrid from(String[] numbers) {
    return new SudokuGrid(Stream.of(numbers)
            .map(value -> value.split(" "))
            .map(array -> stream(array).map(Integer::valueOf).collect(toList()))
            .map(Row::from)
            .collect(toList()));
  }

  public boolean allRowsAreValid() {
    return rows.allValid();
  }

  public boolean allColumnsAreValid() {
    return getColumns().allValid();
  }

  Columns getColumns() {
    return Columns.from(rows);
  }

  public boolean allSpacesAreValid() {
    return getSpaces().allValid();
  }

  Spaces getSpaces() {
    return Spaces.from(rows);
  }

  public boolean isNotEmpty() {
    return !this.equals(EMPTY);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final SudokuGrid that = (SudokuGrid) o;
    return Objects.equals(rows, that.rows);
  }

  @Override
  public int hashCode() {
    return Objects.hash(rows);
  }
}
