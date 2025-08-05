package com.shubham.Nexwent.Service;

import com.shubham.Nexwent.Dto.AttendeeDto;
import com.shubham.Nexwent.Entity.Attendee;
import com.shubham.Nexwent.Exception.AttendeeNotFoundException;
import com.shubham.Nexwent.Repository.AttendeeRepo;
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
public class AttendeeService {

    private AttendeeRepo attendeeRepo;

    private ModelMapper modelMapper;

    private EmailService emailService;

    public Page<AttendeeDto> getAllAttendeeData(int pageNum,int pageSize,String sortBy){
        Pageable pageable = PageRequest.of(pageNum,pageSize, Sort.by(sortBy));
        Page<Attendee> attendeePage = attendeeRepo.findAll(pageable);
        return attendeePage.map(Attendee->modelMapper.map(Attendee, AttendeeDto.class));
    }

    public AttendeeDto getAttendeeDataById(Long attendeeId){
        Attendee attendee = attendeeRepo.findById(attendeeId)
                .orElseThrow(()->new AttendeeNotFoundException("Attendee does not exist!"));
        return modelMapper.map(attendee,AttendeeDto.class);
    }

    public String createAttendeeData(AttendeeDto attendeeDto){
        Attendee attendee = modelMapper.map(attendeeDto,Attendee.class);
        attendeeRepo.save(attendee);
        emailService.AttendeeEmail(attendeeDto.getEmail(),attendeeDto.getAttendeeName());
        return "Attendee registered successfully!";
    }

    public String updateAttendeeData(Long attendeeId,AttendeeDto attendeeDto){
        Attendee attendee = attendeeRepo.findById(attendeeId)
                .orElseThrow(()->new AttendeeNotFoundException("Attendee does not exist!"));
        if(attendeeDto.getAttendeeName()!=null){
            attendee.setAttendeeName(attendeeDto.getAttendeeName());
        }
        if(attendeeDto.getEmail()!=null){
            attendee.setEmail(attendeeDto.getEmail());
        }
        if(attendeeDto.getPhone()!=null){
            attendee.setPhone(attendeeDto.getPhone());
        }
        if(attendeeDto.getGender()!=null){
            attendee.setGender(attendeeDto.getGender());
        }
        if(attendeeDto.getAge()!=0){
            attendee.setAge(attendeeDto.getAge());
        }
        attendeeRepo.save(attendee);
        return "Attendee updated successfully!";
    }

    public String deleteAttendeeData(Long attendeeId){
        Attendee attendee = attendeeRepo.findById(attendeeId)
                .orElseThrow(()->new AttendeeNotFoundException("Attendee does not exist!"));
        attendeeRepo.deleteById(attendeeId);
        return "Attendee data deleted successfully!";
    }
}
