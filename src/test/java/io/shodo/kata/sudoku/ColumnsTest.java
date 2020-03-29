package io.shodo.kata.sudoku;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class ColumnsTest {

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("io.shodo.kata.sudoku.TestDSL#provideColumnWithInvalidNumbers")
  void row_should_contains_only_numbers_1_to_9(Column column, boolean expected) {

    final boolean isValid = column.isValid();

    assertThat(isValid).isEqualTo(expected);
  }

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("io.shodo.kata.sudoku.TestDSL#provideColumnWithNumbersTwice")
  void row_should_not_contains_an_number_twice(Column column, boolean expected) {

    final boolean isValid = column.isValid();

    assertThat(isValid).isEqualTo(expected);
  }
}
