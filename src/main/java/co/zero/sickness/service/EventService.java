package co.zero.sickness.service;

import co.zero.sickness.repository.EventRepository;
import co.zero.sickness.model.Event;
import co.zero.sickness.util.ObjectMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static co.zero.sickness.util.DateUtils.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class EventService {
    private final EventRepository repository;
    
    public Mono<Void> splitRegistersByMonth() {
        return repository.findAll()
                .limitRate(1)
                .filter(event -> !isSameMonth(event.getDesde(), event.getHasta()))
                .flatMap(event -> complexProcess(event))
                .then();
    }
    
    private Flux<Void> complexProcess(Event event) {
        return splitEventByMonths(event)
                .flatMap(p -> repository.save(p))
                .flatMap(p -> repository.delete(event));
    }
    
    private static Flux<Event> splitEventByMonths(Event event) {
        log.info("::: Splitting person [id={}][start={}][end={}]", event.getId(), event.getDesde(),
                event.getHasta());
        LocalDate start = event.getDesde(); //2019-12-31
        LocalDate end = event.getHasta(); //2020-01-29
        LocalDate current = start;
        List<Event> eventList = new ArrayList<>();
        
        while (current.isBefore(end) || current.isEqual(end)) {
            Event currentEventByMonth = new Event();
            ObjectMapperUtils.map(event, currentEventByMonth);
            currentEventByMonth.setDesde(current);
            currentEventByMonth.setId(null);
            
            if (getLastDayOfMonth(current).isAfter(end)) {
                currentEventByMonth.setHasta(end);
            } else {
                currentEventByMonth.setHasta(getLastDayOfMonth(current));
            }
            
            long absDays = getDaysCountBetween(currentEventByMonth.getDesde(), currentEventByMonth.getHasta()) + 1;
            currentEventByMonth.setDiaNat((int)absDays);
            eventList.add(currentEventByMonth);
            current = getFirstDayOfMonth(current.plusMonths(1));
        }
        
        return Flux.fromIterable(eventList);
    }
}