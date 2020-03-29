package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@ValueType
public final class Space extends Valideable {

  private Space(String[] numbers) {
    super(Stream.of(numbers)
            .map(value -> value.split(" "))
            .flatMap(Arrays::stream)
            .map(Integer::valueOf)
            .collect(toList()));
  }

  static Space from(String[] numbers) {
    return new Space(numbers);
  }

  @Override
  public String toString() {
    return "Space{" +
            "values=" + values +
            '}';
  }
}
