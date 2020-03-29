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
    Columns columns = Columns.EMPTY;
    for (int i = 0; i < rows.size(); i++) {
      columns = columns.add(Column.from(rows.getAllInIndex(i)));
    }
    return columns;
  }

  public boolean allSpacesAreValid() {
    return getSpaces().allValid();
  }

  Spaces getSpaces() {
    Spaces spaces = Spaces.EMPTY;

    spaces = spaces.add(getSpace(0, 2, 0));
    spaces = spaces.add(getSpace(0, 2, 3));
    spaces = spaces.add(getSpace(0, 2, 6));

    spaces = spaces.add(getSpace(3, 5, 0));
    spaces = spaces.add(getSpace(3, 5, 3));
    spaces = spaces.add(getSpace(3, 5, 6));

    spaces = spaces.add(getSpace(6, 8, 0));
    spaces = spaces.add(getSpace(6, 8, 3));
    spaces = spaces.add(getSpace(6, 8, 6));

    return spaces;
  }

  private Space getSpace(int startLine, int endLine, int spaceNumber) {
    Rows subRows = rows.getLineBetween(startLine, endLine);
    Columns subColumns = Columns.from(subRows, spaceNumber);

    List<String> cells = subColumns.getAllInIndex(0).stream().map(String::valueOf).collect(toList());
    List<String> cells1 = subColumns.getAllInIndex(1).stream().map(String::valueOf).collect(toList());
    List<String> cells2 = subColumns.getAllInIndex(2).stream().map(String::valueOf).collect(toList());

    String value = String.join(" ", cells);
    String value1 = String.join(" ", cells1);
    String value2 = String.join(" ", cells2);

    return Space.from(new String[]{value, value1, value2});
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

  @Override
  public String toString() {
    return "SudokuGrid{" +
            "values=" + rows +
            '}';
  }
}
