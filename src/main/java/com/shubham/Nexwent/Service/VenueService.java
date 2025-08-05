package com.shubham.Nexwent.Service;

import com.shubham.Nexwent.Dto.VenueDto;
import com.shubham.Nexwent.Entity.Venue;
import com.shubham.Nexwent.Exception.VenueAlreadyExistException;
import com.shubham.Nexwent.Exception.VenueNotFoundException;
import com.shubham.Nexwent.Repository.VenueRepo;
import com.shubham.Nexwent.Service.Email.EmailService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VenueService {

    private VenueRepo venueRepo;

    private ModelMapper modelMapper;

    private EmailService emailService;

    public Page<VenueDto> getAllVenueData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Venue> venuePage = venueRepo.findAll(pageable);
        return venuePage.map(Venue -> modelMapper.map(Venue, VenueDto.class));
    }

    public VenueDto getVenueById(Long venueId) {
        Venue venue = venueRepo.findById(venueId)
                .orElseThrow(() -> new VenueNotFoundException("Venue does not exist!"));
        return modelMapper.map(venue, VenueDto.class);
    }

    public String createVenueData(VenueDto venueDto) {
        if (venueRepo.existsByVenueName(venueDto.getVenueName())) {
            throw new VenueAlreadyExistException("Venue already exist!");
        }
        Venue venue = modelMapper.map(venueDto, Venue.class);
        venueRepo.save(venue);
        emailService.pendingVenueEmail(venueDto.getContactEmail(), venueDto.getVenueOwnerName());
        return "Venue registration initiated after verification we will send you confirmation mail!";
    }

    public String updateVenueData(Long venueId, VenueDto venueDto) {
        Venue venue = venueRepo.findById(venueId)
                .orElseThrow(() -> new VenueNotFoundException("Venue does not exist!"));
        if(venueDto.getVenueName()!=null){
            venue.setVenueName(venueDto.getVenueName());
        }
        if(venueDto.getVenueAddress()!=null){
            venue.setVenueAddress(venueDto.getVenueAddress());
        }
        if(venueDto.getCity()!=null){
            venue.setCity(venueDto.getCity());
        }
        if(venueDto.getState()!=null){
            venue.setState(venueDto.getState());
        }
        if(venueDto.getZipcode()!=0){
            venue.setZipcode(venueDto.getZipcode());
        }
        if(venueDto.getCountry()!=null){
            venue.setCountry(venueDto.getCountry());
        }
        if(venueDto.getVenueCapacity()!=null){
            venue.setVenueCapacity(venueDto.getVenueCapacity());
        }
        if(venueDto.getParkingAvailable()!=null){
            venue.setParkingAvailable(venueDto.getParkingAvailable());
        }
        if(venueDto.getContactEmail()!=null){
            venue.setContactEmail(venueDto.getContactEmail());
        }
        if(venueDto.getContactPhone()!=null){
            venue.setContactPhone(venueDto.getContactPhone());
        }
        if(venueDto.getVenueStatus()!=null){
            venue.setVenueStatus(venueDto.getVenueStatus());
            emailService.venueStatusEmail(venue.getContactEmail(),venueDto,venue.getVenueOwnerName());
        }
        venueRepo.save(venue);
        return "Venue data updated successfully!";
    }

    public String deleteVenueData(Long venueId){
        Venue venue = venueRepo.findById(venueId)
                .orElseThrow(()->new VenueNotFoundException("Venue does not exist!"));
        venueRepo.deleteById(venueId);
        return "Venue deleted successfully!";
    }
}
