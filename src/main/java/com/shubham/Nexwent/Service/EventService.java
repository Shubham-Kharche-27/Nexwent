package com.shubham.Nexwent.Service;

import com.shubham.Nexwent.Dto.EventDto;
import com.shubham.Nexwent.Entity.Event;
import com.shubham.Nexwent.Entity.Venue;
import com.shubham.Nexwent.Exception.EventAlreadyExistException;
import com.shubham.Nexwent.Exception.EventNotFoundException;
import com.shubham.Nexwent.Exception.VenueNotFoundException;
import com.shubham.Nexwent.Repository.EventRepo;
import com.shubham.Nexwent.Repository.VenueRepo;
import com.shubham.Nexwent.Service.Email.EmailService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventService {

    private EventRepo eventRepo;

    private VenueRepo venueRepo;

    private ModelMapper modelMapper;

    private EmailService emailService;

    public Page<EventDto> getAllEventData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Event> eventPage = eventRepo.findAll(pageable);
        return eventPage.map(Event -> modelMapper.map(Event, EventDto.class));
    }

    public EventDto getEventById(Long eventId) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event does not exist!"));
        return modelMapper.map(event, EventDto.class);
    }

    public String createEventData(EventDto eventDto) {
        if (eventRepo.existsByEventTitle(eventDto.getEventTitle())) {
            throw new EventAlreadyExistException("Event already exist!");
        }
        Event event = modelMapper.map(eventDto, Event.class);
        Venue venue = venueRepo.findById(eventDto.getVenueId())
                .orElseThrow(() -> new VenueNotFoundException("Venue does not exist!"));
        event.setVenue(venue);
        eventRepo.save(event);
        emailService.pendingEventEmail(eventDto.getOrganizerEmail(), eventDto.getOrganizerName());
        return "Event booked successfully!";
    }

    public String updateEventData(Long eventId, EventDto eventDto) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event does not exist!"));
        if (eventDto.getEventTitle() != null) {
            event.setEventTitle(eventDto.getEventTitle());
        }
        if (eventDto.getEventDesc() != null) {
            event.setEventDesc(eventDto.getEventDesc());
        }
        if (eventDto.getEventStartDateTime() != null) {
            event.setEventStartDateTime(eventDto.getEventStartDateTime());
        }
        if (eventDto.getEventEndDateTime() != null) {
            event.setEventEndDateTime(eventDto.getEventEndDateTime());
        }
        if (eventDto.getEventCategory() != null) {
            event.setEventCategory(eventDto.getEventCategory());
        }
        if (eventDto.getOrganizerName() != null) {
            event.setOrganizerName(eventDto.getOrganizerName());
        }
        if (eventDto.getOrganizerContact() != null) {
            event.setOrganizerName(eventDto.getOrganizerName());
        }
        if (eventDto.getOrganizerEmail() != null) {
            event.setOrganizerEmail(eventDto.getOrganizerEmail());
        }
        if (eventDto.getEventStatus() != null) {
            event.setEventStatus(eventDto.getEventStatus());
            emailService.eventStatusEmail(event.getOrganizerEmail(), eventDto, event.getOrganizerName());
        }
        eventRepo.save(event);
        return "Event data updated successfully!";
    }

    public String deleteEventData(Long eventId) {
        Event event = eventRepo.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event does not exist!"));
        eventRepo.findById(eventId);
        return "Event data deleted successfully!";
    }
}
