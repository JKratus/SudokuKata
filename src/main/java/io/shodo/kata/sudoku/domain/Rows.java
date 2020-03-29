package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@ValueType
final class Rows {
  static final Rows EMPTY = new Rows(emptyList());
  private final List<Row> values;

  Rows(List<Row> rows) {
    this.values = rows;
  }

  static Rows from(List<Row> values) {
    return new Rows(values);
  }

  boolean allValid() {
    return values.stream().allMatch(Row::isValid);
  }

  List<Integer> getAllInIndex(int index) {
    return values.stream().map(row -> row.getIndex(index)).collect(toList());
  }

  Rows getLineBetween(int start, int end) {
    List<Row> lines = new ArrayList<>();
    IntStream.range(start, end).forEach(index -> lines.add(values.get(index)));
    return Rows.from(lines);
  }

  int size() {
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
