package com.shubham.Nexwent.Repository;

import com.shubham.Nexwent.Entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepo extends JpaRepository<Venue,Long> {
}
