package com.cicd.sdp.cfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cicd.sdp.cfp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    
    // Used for login
    public Admin findByUsernameAndPassword(String username, String password);
}
