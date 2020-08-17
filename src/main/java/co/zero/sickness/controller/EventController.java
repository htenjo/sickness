package co.zero.sickness.controller;

import co.zero.sickness.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping("/loadEvents")
    public Mono<Void> loadEvents() {
        return Mono.empty();
    }

    @PostMapping("/splitEventsByMonths")
    public Mono<Void> splitEventsByMonths() {
        return eventService.splitRegistersByMonth();
    }
}