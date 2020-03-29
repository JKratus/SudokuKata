package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@ValueType
final class Row extends Valideable {

  private Row(Integer... values) {
    super(Arrays.stream(values).collect(toList()));
  }

  static Row from(List<Integer> rowValues) {
    return new Row(rowValues.toArray(Integer[]::new));
  }

  static Row from(Integer... numbers) {
    return new Row(numbers);
  }

  protected Integer getIndex(int index) {
    return values.get(index);
  }

  @Override
  public String toString() {
    return "Row{" +
            "values=" + values +
            '}';
  }
}
