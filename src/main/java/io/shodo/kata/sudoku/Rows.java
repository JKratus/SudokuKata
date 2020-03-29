package io.shodo.kata.sudoku;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public final class Rows {
  public static final Rows EMPTY = new Rows(emptyList());
  private final List<Row> values;

  public Rows(List<Row> rows) {
    this.values = rows;
  }

  public static Rows from(List<Row> values) {
    return new Rows(values);
  }

  public boolean allValid() {
    return values.stream().allMatch(Row::isValid);
  }

  public List<Integer> getAllInIndex(int index) {
    return values.stream().map(row -> row.getIndex(index)).collect(toList());
  }

  public int size() {
    return values.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Rows rows = (Rows) o;
    return Objects.equals(values, rows.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Rows{" +
            "values=" + values +
            '}';
  }
}
