package com.shubham.Nexwent.Controller;

import com.shubham.Nexwent.Dto.VenueDto;
import com.shubham.Nexwent.Service.VenueService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venue")
@AllArgsConstructor
public class VenueController {

    private VenueService venueService;

    @GetMapping("/get")
    public ResponseEntity<Page<VenueDto>> getAllVenues(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")int pageSize,
            @RequestParam(defaultValue = "venueId")String sortBy
    ){
        return new ResponseEntity<>(venueService.getAllVenueData(pageNum-1,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{venueId}")
    public ResponseEntity<VenueDto> getVenueById(@PathVariable Long venueId){
        return new ResponseEntity<>(venueService.getVenueById(venueId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createVenue(@RequestBody VenueDto venueDto){
        return new ResponseEntity<>(venueService.createVenueData(venueDto),HttpStatus.CREATED);
    }

    @PutMapping("/put/{venueId}")
    public ResponseEntity<String> updateVenue(@PathVariable Long venueId,@RequestBody VenueDto venueDto){
        return new ResponseEntity<>(venueService.updateVenueData(venueId,venueDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{venueId}")
    public ResponseEntity<String> deleteVenue(@PathVariable Long venueId){
        return new ResponseEntity<>(venueService.deleteVenueData(venueId),HttpStatus.NO_CONTENT);
    }
}
