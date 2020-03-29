package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static io.shodo.kata.sudoku.usecases.SudokuGridValidator.SUDOKU_VALID_NUMBERS;
import static java.util.stream.Collectors.toList;

@ValueType
public final class Row {
  private final List<Integer> values;

  public Row(Integer... values) {
    this.values = Arrays.stream(values).collect(toList());
  }

  public static Row from(List<Integer> rowValues) {
    return new Row(rowValues.toArray(Integer[]::new));
  }

  public boolean isValid() {
    return this.containsOnlyValidNumbers() && this.containsAllNumbersJustOnce();
  }

  private boolean containsOnlyValidNumbers() {
    return SUDOKU_VALID_NUMBERS.containsAll(values);
  }

  private boolean containsAllNumbersJustOnce() {
    return values.stream().noneMatch(this::isPresentTwice);
  }

  private boolean isPresentTwice(Integer number) {
    return values.stream().filter(Predicate.isEqual(number)).count() > 1;
  }

  public Integer getIndex(int index) {
    return values.get(index);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Row row = (Row) o;
    return Objects.equals(values, row.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Row{" +
            "values=" + values +
            '}';
  }
}
