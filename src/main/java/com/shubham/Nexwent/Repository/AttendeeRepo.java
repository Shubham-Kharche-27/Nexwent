package com.shubham.Nexwent.Repository;

import com.shubham.Nexwent.Entity.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepo extends JpaRepository<Attendee,Long> {
}
