package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

@ValueType
final class Columns {
  private final List<Column> values;

  private Columns(List<Column> columns) {
    this.values = columns;
  }

  static Columns from(String[] numbers) {
    return new Columns(Stream.of(numbers)
            .map(value -> value.split(" "))
            .map(array -> stream(array).map(Integer::valueOf).collect(toList()))
            .map(Column::from)
            .collect(toList()));
  }

  static Columns from(Rows rows, int startColumn) {
    ArrayList<Column> newColumns = new ArrayList<>();
    range(startColumn, rows.size() + startColumn)
            .forEach(index -> newColumns.add(Column.from(rows.getAllInIndex(index))));
    return new Columns(newColumns);
  }

  static Columns from(Rows rows) {
    return from(rows, 0);
  }

  boolean allValid() {
    return values.stream().allMatch(Column::isValid);
  }

  List<Integer> getAllInIndex(int index) {
    return values.stream().map(column -> column.get(index)).collect(toList());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Columns columns = (Columns) o;
    return Objects.equals(values, columns.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
