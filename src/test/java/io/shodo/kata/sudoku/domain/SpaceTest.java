package io.shodo.kata.sudoku.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpaceTest {

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("io.shodo.kata.sudoku.domain.TestDSL#provideSpaceWithInvalidNumbers")
  void space_should_contains_only_numbers_1_to_9(Space space, boolean expected) {

    final boolean isValid = space.isValid();

    assertThat(isValid).isEqualTo(expected);
  }

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("io.shodo.kata.sudoku.domain.TestDSL#provideSpaceWithNumbersTwice")
  void space_should_not_contains_an_number_twice(Space space, boolean expected) {

    final boolean isValid = space.isValid();

    assertThat(isValid).isEqualTo(expected);
  }

}
