package io.shodo.kata.sudoku.domain;

import io.shodo.kata.sudoku.ValueType;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.platform.commons.util.ClassFilter;
import org.junit.platform.commons.util.ReflectionUtils;

import java.util.List;
import java.util.stream.Stream;

public class EqualsAndHashcodeTest {

  @ParameterizedTest
  @ArgumentsSource(DomainValueTypesClassesProvider.class)
  public void equalsHashCodeContracts(Class<?> classname) {
    EqualsVerifier.forClass(classname).verify();
  }

  private static class DomainValueTypesClassesProvider implements ArgumentsProvider {

    List<Class<?>> domainValueTypes = ReflectionUtils.findAllClassesInPackage(
            "io.shodo.kata.sudoku",
            ClassFilter.of(aClass -> aClass.isAnnotationPresent(ValueType.class)));

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return domainValueTypes.stream().map(Arguments::of);
    }
  }
}
