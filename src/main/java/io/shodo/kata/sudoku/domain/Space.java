package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.shodo.kata.sudoku.usecases.SudokuGridValidator.SUDOKU_VALID_NUMBERS;

@ValueType
public final class Space {
  private final List<Integer> values;

  public Space(String[] numbers) {
    this.values = Stream.of(numbers)
            .map(value -> value.split(" "))
            .flatMap(Arrays::stream)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Space space = (Space) o;
    return Objects.equals(values, space.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Space{" +
            "values=" + values +
            '}';
  }
}
