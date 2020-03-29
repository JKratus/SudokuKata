package io.shodo.kata.sudoku.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SpaceTest {

  private static Stream<Arguments> provideSpaceWithInvalidNumbers() {
    return Stream.of(
            Arguments.of(Space.from(new String[]{
                    "0 1 1",
                    "2 5 4",
                    "5 6 7"
            }), false),
            Arguments.of(Space.from(new String[]{
                    "6 1 1",
                    "2 0 4",
                    "5 6 9"
            }), false),
            Arguments.of(Space.from(new String[]{
                    "6 1 1",
                    "2 3 4",
                    "5 6 0"
            }), false),
            Arguments.of(Space.from(new String[]{
                    "1 2 3",
                    "4 5 6",
                    "7 8 9"
            }), true)
    );
  }

  private static Stream<Arguments> provideSpaceWithNumbersTwice() {
    return Stream.of(
            Arguments.of(Space.from(new String[]{
                    "3 1 1",
                    "2 3 4",
                    "5 6 7"
            }), false),
            Arguments.of(Space.from(new String[]{
                    "1 2 3",
                    "4 5 6",
                    "7 8 9"
            }), true)
    );
  }

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("provideSpaceWithInvalidNumbers")
  void space_should_contains_only_numbers_1_to_9(Space space, boolean expected) {

    final boolean isValid = space.isValid();

    assertThat(isValid).isEqualTo(expected);
  }

  @ParameterizedTest(name = "{index} {0} validity is {1}")
  @MethodSource("provideSpaceWithNumbersTwice")
  void space_should_not_contains_an_number_twice(Space space, boolean expected) {

    final boolean isValid = space.isValid();

    assertThat(isValid).isEqualTo(expected);
  }
}
