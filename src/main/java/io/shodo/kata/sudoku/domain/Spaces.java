package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.List.copyOf;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

@ValueType
final class Spaces {
  static final Spaces EMPTY = new Spaces(emptyList());
  private final List<Space> values;

  private Spaces(List<Space> spaces) {
    this.values = copyOf(spaces);
  }

  static Spaces from(Space... spaces) {
    return new Spaces(Arrays.stream(spaces).collect(toList()));
  }

  static Spaces from(Rows rows) {
    Spaces spaces = Spaces.EMPTY;

    spaces = spaces.add(getSpace(rows, 0, 3, 0));
    spaces = spaces.add(getSpace(rows, 0, 3, 3));
    spaces = spaces.add(getSpace(rows, 0, 3, 6));

    spaces = spaces.add(getSpace(rows, 3, 6, 0));
    spaces = spaces.add(getSpace(rows, 3, 6, 3));
    spaces = spaces.add(getSpace(rows, 3, 6, 6));

    spaces = spaces.add(getSpace(rows, 6, 9, 0));
    spaces = spaces.add(getSpace(rows, 6, 9, 3));
    spaces = spaces.add(getSpace(rows, 6, 9, 6));

    return spaces;
  }

  private static Space getSpace(Rows rows, int startLine, int endLine, int spaceNumber) {
    Rows subRows = rows.getLineBetween(startLine, endLine);
    Columns subColumns = Columns.from(subRows, spaceNumber);

    List<List<String>> allCells = new ArrayList<>();
    range(0, subRows.size()).forEach(index ->
            allCells.add(subColumns
                    .getAllInIndex(index).stream()
                    .map(String::valueOf)
                    .collect(toList())
            )
    );

    List<String> values = allCells.stream().map(cells -> String.join(" ", cells)).collect(toList());
    return Space.from(values.toArray(String[]::new));
  }

  private Spaces add(Space space) {
    List<Space> newSpaces = new ArrayList<>(values);
    newSpaces.add(space);
    return new Spaces(newSpaces);
  }

  boolean allValid() {
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
}
