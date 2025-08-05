package com.shubham.Nexwent.Controller;

import com.shubham.Nexwent.Dto.AttendeeDto;
import com.shubham.Nexwent.Service.AttendeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendee")
@AllArgsConstructor
public class AttendeeController {

    private AttendeeService attendeeService;

    @GetMapping("/get")
    public ResponseEntity<Page<AttendeeDto>> getAllAttendee(
            @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "3")int pageSize,
            @RequestParam(defaultValue = "attendeeId")String sortBy
    ){
        return new ResponseEntity<>(attendeeService.getAllAttendeeData(pageNum-1,pageSize,sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/byId/{attendeeId}")
    public ResponseEntity<AttendeeDto> getAttendeeById(@PathVariable Long attendeeId){
        return new ResponseEntity<>(attendeeService.getAttendeeDataById(attendeeId),HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<String> createAttendee(@RequestBody AttendeeDto attendeeDto){
        if(attendeeDto!=null){
            return new ResponseEntity<>(attendeeService.createAttendeeData(attendeeDto),HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Attendee data must be empty!",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/put/{attendeeId}")
    public ResponseEntity<String> updateAttendee(@PathVariable Long attendeeId,@RequestBody AttendeeDto attendeeDto){
        return new ResponseEntity<>(attendeeService.updateAttendeeData(attendeeId,attendeeDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{attendeeId}")
    public ResponseEntity<String> deleteAttendee(@PathVariable Long attendeeId){
        return new ResponseEntity<>(attendeeService.deleteAttendeeData(attendeeId),HttpStatus.NO_CONTENT);
    }
}
