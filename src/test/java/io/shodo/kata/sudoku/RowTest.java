package io.shodo.kata.sudoku;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RowTest {

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("io.shodo.kata.sudoku.TestDSL#provideRowWithInvalidNumbers")
  void row_should_contains_only_numbers_1_to_9(Row row, boolean expected) {

    final boolean isValid = row.isValid();

    assertThat(isValid).isEqualTo(expected);
  }

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("io.shodo.kata.sudoku.TestDSL#provideRowWithNumbersTwice")
  void row_should_not_contains_an_number_twice(Row row, boolean expected) {

    final boolean isValid = row.isValid();

    assertThat(isValid).isEqualTo(expected);
  }
}
