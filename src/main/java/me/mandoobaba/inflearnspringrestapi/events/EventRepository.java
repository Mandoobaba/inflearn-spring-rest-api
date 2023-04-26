package me.mandoobaba.inflearnspringrestapi.events;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository("EventRepository")
public interface EventRepository extends JpaRepository<Event, Integer> {
    Page<Event> findByBasePriceBetween(int min, int max, Pageable pageable);
    Page<Event> findByEventStatus(EventStatus eventStatus, Pageable pageable);

}
