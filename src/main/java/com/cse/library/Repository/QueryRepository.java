package com.cse.library.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.Query;

public interface QueryRepository extends JpaRepository<Query, Long> {
    // Custom methods can be added here if needed
}
