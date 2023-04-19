package me.mandoobaba.inflearnspringrestapi.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("EventRepository")
public interface EventRepository extends JpaRepository<Event, Integer> {
}
