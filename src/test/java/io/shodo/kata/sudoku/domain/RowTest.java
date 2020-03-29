package io.shodo.kata.sudoku.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {

  private static Stream<Arguments> provideRowWithNumbersTwice() {
    return Stream.of(
            Arguments.of(Row.from(1, 1), false),
            Arguments.of(Row.from(2, 2), false),
            Arguments.of(Row.from(3, 3), false),
            Arguments.of(Row.from(4, 4), false),
            Arguments.of(Row.from(5, 5), false),
            Arguments.of(Row.from(6, 6), false),
            Arguments.of(Row.from(7, 7), false),
            Arguments.of(Row.from(8, 8), false),
            Arguments.of(Row.from(9, 9), false),
            Arguments.of(Row.from(1, 2), true)
    );
  }

  private static Stream<Arguments> provideRowWithInvalidNumbers() {
    return Stream.of(
            Arguments.of(Row.from(0, 1), false),
            Arguments.of(Row.from(0, 1), false),
            Arguments.of(Row.from(0, 2), false),
            Arguments.of(Row.from(0, 3), false),
            Arguments.of(Row.from(0, 4), false),
            Arguments.of(Row.from(0, 5), false),
            Arguments.of(Row.from(0, 6), false),
            Arguments.of(Row.from(0, 7), false),
            Arguments.of(Row.from(0, 8), false),
            Arguments.of(Row.from(0, 9), false),
            Arguments.of(Row.from(1, 2, 3, 4, 5, 6, 7, 8, 9), true)
    );
  }

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("provideRowWithInvalidNumbers")
  void row_should_contains_only_numbers_1_to_9(Row row, boolean expected) {

    final boolean isValid = row.isValid();

    assertThat(isValid).isEqualTo(expected);
  }

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("provideRowWithNumbersTwice")
  void row_should_not_contains_an_number_twice(Row row, boolean expected) {

    final boolean isValid = row.isValid();

    assertThat(isValid).isEqualTo(expected);
  }
}
