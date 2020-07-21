package com.ironhack.authservice.service;

import com.ironhack.authservice.exception.UserAlreadyExistsException;
import com.ironhack.authservice.model.SecurityUser;
import com.ironhack.authservice.repository.SecurityUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserService {
    /**
     * Logger
     */
    private static final Logger LOGGER = LogManager.getLogger(SecurityUserService.class);
    @Autowired
    private SecurityUserRepository securityUserRepository;

    /**
     * Create SecurityUser
     * @param securityUser SecurityUser
     * @return SecurityUser
     */
    public SecurityUser save(SecurityUser securityUser){
        SecurityUser foundUser = securityUserRepository.findByUsername(securityUser.getUsername());
        if (foundUser != null){
            LOGGER.info("[WARN] - User with username " + securityUser.getUsername() + " already exists");
            throw new UserAlreadyExistsException("User with username " + securityUser.getUsername() + " already exists");
        }
        LOGGER.info("[INFO] - New User with ID: " + securityUser.getId());
        return securityUserRepository.save(securityUser);
    }
}
