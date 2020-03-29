package io.shodo.kata.sudoku.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static io.shodo.kata.sudoku.usecases.SudokuGridChecker.SUDOKU_VALID_NUMBERS;

public abstract class Valideable {
  protected final List<Integer> values;

  protected Valideable(List<Integer> numbers) {
    this.values = numbers;
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
    if (!(o instanceof Valideable)) return false;
    final Valideable that = (Valideable) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }
}
