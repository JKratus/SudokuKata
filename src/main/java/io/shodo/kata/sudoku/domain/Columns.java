package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@ValueType
public final class Columns {
  public static final Columns EMPTY = new Columns(emptyList());
  private final List<Column> values;

  private Columns(List<Column> columns) {
    this.values = columns;
  }

  public static Columns from(String[] numbers) {
    return new Columns(Stream.of(numbers)
            .map(value -> value.split(" "))
            .map(array -> stream(array).map(Integer::valueOf).collect(toList()))
            .map(Column::from)
            .collect(toList()));
  }

  public Columns add(Column newColumn) {
    ArrayList<Column> newColumns = new ArrayList<>(values);
    newColumns.add(newColumn);
    return new Columns(newColumns);
  }

  public boolean allValid() {
    return values.stream().allMatch(Column::isValid);
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

  @Override
  public String toString() {
    return "Columns{" +
            "values=" + values +
            '}';
  }
}
