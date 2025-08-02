package com.shubham.Nexwent.Repository;

import com.shubham.Nexwent.Entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepo extends JpaRepository<Tickets,Long> {
}
