package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@ValueType
final class Column extends Valideable {

  private Column(Integer... values) {
    super(Arrays.stream(values).collect(toList()));
  }

  static Column from(List<Integer> columnValues) {
    return new Column(columnValues.toArray(Integer[]::new));
  }

  static Column from(Integer... numbers) {
    return new Column(numbers);
  }

  Integer get(int index) {
    return values.get(index);
  }

  @Override
  public String toString() {
    return "Column{" +
            "values=" + values +
            '}';
  }
}
