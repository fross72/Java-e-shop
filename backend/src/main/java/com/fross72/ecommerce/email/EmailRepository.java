package com.fross72.ecommerce.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {
    @Query("SELECT e FROM email e WHERE e.email=?1")
    Optional<Email> findIdByEmail(String email);
}
