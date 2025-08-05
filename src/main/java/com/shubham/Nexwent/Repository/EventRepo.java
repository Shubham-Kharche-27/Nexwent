package com.shubham.Nexwent.Repository;

import com.shubham.Nexwent.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event,Long> {
    boolean existsByEventTitle(String eventTitle);
}
