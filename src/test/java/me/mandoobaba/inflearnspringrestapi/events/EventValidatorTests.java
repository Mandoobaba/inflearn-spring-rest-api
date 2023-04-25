package me.mandoobaba.inflearnspringrestapi.events;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventValidatorTests {

    @Test
    public void priceValidate() {
        // Given
        EventDto event = EventDto.builder()
                .name("Spring")
                .description("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2023, 4, 20, 1, 54, 00))
                .closeEnrollmentDateTime(LocalDateTime.of(2023, 4, 21, 1, 54, 00))
                .beginEventDateTime(LocalDateTime.of(2023, 4, 22, 1, 54, 00))
                .endEventDateTime(LocalDateTime.of(2023, 4, 23, 1, 54, 00))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .build();

        // When
        boolean isBasePriceGreaterThenMaxPrice = event.getBasePrice() > event.getMaxPrice();
        boolean isMaxPriceGreaterThanZero = event.getMaxPrice() > 0;

        // Then
        assertThat(isBasePriceGreaterThenMaxPrice).isEqualTo(false);
        assertThat(isMaxPriceGreaterThanZero).isEqualTo(true);
        assertThat(isBasePriceGreaterThenMaxPrice && isMaxPriceGreaterThanZero).isEqualTo(false);

    }

    @Test
    public void dateTimeValidate() {
        // Given
        EventDto event = EventDto.builder()
                .name("Spring")
                .description("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2023, 4, 20, 1, 54, 00))
                .closeEnrollmentDateTime(LocalDateTime.of(2023, 4, 21, 1, 54, 00))
                .beginEventDateTime(LocalDateTime.of(2023, 4, 22, 1, 54, 00))
                .endEventDateTime(LocalDateTime.of(2023, 4, 23, 1, 54, 00))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타텁 팩토리")
                .build();

        // When
        LocalDateTime endEventDateTime = event.getEndEventDateTime();
        boolean isEndEventIsBeforeBeginEvent = endEventDateTime.isBefore(event.getBeginEventDateTime());
        boolean isEndEventIsBeforeBeginEnrollment = endEventDateTime.isBefore(event.getBeginEnrollmentDateTime());
        boolean isEndEventIsBeforeCloseEnrollment = endEventDateTime.isBefore(event.getCloseEnrollmentDateTime());

        // Then
        assertThat(isEndEventIsBeforeBeginEvent).isEqualTo(false);
        assertThat(isEndEventIsBeforeBeginEnrollment).isEqualTo(false);
        assertThat(isEndEventIsBeforeCloseEnrollment).isEqualTo(false);
        assertThat(isEndEventIsBeforeBeginEvent ||
                isEndEventIsBeforeBeginEnrollment ||
                isEndEventIsBeforeCloseEnrollment).isEqualTo(false);
    }
}
