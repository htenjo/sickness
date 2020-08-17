package co.zero.sickness.repository;

import co.zero.sickness.model.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends ReactiveCrudRepository<Event, Long> {
}