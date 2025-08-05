package com.shubham.Nexwent.Controller;

import com.shubham.Nexwent.Dto.EventDto;
import com.shubham.Nexwent.Service.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {

    private EventService eventService;

    @GetMapping("/get")
    public ResponseEntity<Page<EventDto>> getEvents(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "eventId") String sortBy
    ) {
        return new ResponseEntity<>(eventService.getAllEventData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Long eventId) {
        return new ResponseEntity<>(eventService.getEventById(eventId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createEvent(@Valid @RequestBody EventDto eventDto) {
        if (eventDto != null) {
            return new ResponseEntity<>(eventService.createEventData(eventDto), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Event data must be empty!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/put/{eventId}")
    public ResponseEntity<String> updateEvent(@PathVariable Long eventId, @Valid @RequestBody EventDto eventDto) {
        return new ResponseEntity<>(eventService.updateEventData(eventId, eventDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long eventId) {
        return new ResponseEntity<>(eventService.deleteEventData(eventId), HttpStatus.NO_CONTENT);
    }
}
