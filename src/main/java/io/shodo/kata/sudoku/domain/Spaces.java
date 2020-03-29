package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.List.copyOf;
import static java.util.stream.Collectors.toList;

@ValueType
public final class Spaces {
  public static final Spaces EMPTY = new Spaces(emptyList());
  private final List<Space> values;

  private Spaces(List<Space> spaces) {
    this.values = copyOf(spaces);
  }

  public static Spaces from(Space... spaces) {
    return new Spaces(Arrays.stream(spaces).collect(toList()));
  }

  public Spaces add(Space space) {
    List<Space> newSpaces = new ArrayList<>(values);
    newSpaces.add(space);
    return new Spaces(newSpaces);
  }

  public boolean allValid() {
    return values.stream().allMatch(Space::isValid);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final Spaces spaces = (Spaces) o;
    return Objects.equals(values, spaces.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "Spaces{" +
            "values=" + values +
            '}';
  }
}
