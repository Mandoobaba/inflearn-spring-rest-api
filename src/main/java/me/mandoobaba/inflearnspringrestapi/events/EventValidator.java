package me.mandoobaba.inflearnspringrestapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors) {
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            errors.reject("wrongPrices", "Value for Prices are wrong");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
                endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime()) ||
                endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())
        ) {
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrong.");
        }

        // BeginEventDateTime
        LocalDateTime beginEventDateTime = eventDto.getBeginEventDateTime();
        if (beginEventDateTime.isAfter(eventDto.getEndEventDateTime()) ||
                beginEventDateTime.isAfter(eventDto.getCloseEnrollmentDateTime()) ||
                beginEventDateTime.isAfter(eventDto.getBeginEnrollmentDateTime())
        ) {
            errors.rejectValue("beginEventDateTime", "wrongValue", "beginEventDateTime is wrong.");
        }

        // BeginEventDateTime
        LocalDateTime closeEnrollmentDateTime = eventDto.getCloseEnrollmentDateTime();
        if (closeEnrollmentDateTime.isBefore(eventDto.getBeginEventDateTime()) ||
                beginEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime()) ||
                beginEventDateTime.isAfter(eventDto.getBeginEnrollmentDateTime())
        ) {
            errors.rejectValue("beginEventDateTime", "wrongValue", "beginEventDateTime is wrong.");
        }
    }

}
