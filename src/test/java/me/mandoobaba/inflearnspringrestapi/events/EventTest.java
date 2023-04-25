package me.mandoobaba.inflearnspringrestapi.events;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        Event event = new Event();
        String name = "Event";
        String description = "Spring";
        event.setName(name);
        event.setDescription(description);

        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @ParameterizedTest
    @MethodSource("parametersForTestFree")
    public void testFree(int basePrice, int maxPrice, boolean isFree) {
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        // When
        event.update();

        // Then
        AssertionsForClassTypes.assertThat(event.isFree()).isEqualTo(isFree);
    }

    private static Stream<Arguments> parametersForTestFree() {
        return Stream.of(
                Arguments.of(0, 0, true),
                Arguments.of(100, 0, false),
                Arguments.of(0, 100, false),
                Arguments.of(100, 200, false)
        );
    }

    @ParameterizedTest
    @MethodSource("parametersForTestOffline")
    public void testOffline(String location, boolean isOffline) {
        // Given
        Event event = Event.builder()
                .location(location)
                .build();

        // When
        event.update();

        // Then
        AssertionsForClassTypes.assertThat(event.isOffline()).isEqualTo(isOffline);
    }

    private static Stream<Arguments> parametersForTestOffline() {
        return Stream.of(
                Arguments.of("강남", true),
                Arguments.of(null, false),
                Arguments.of("", false)
        );
    }

}