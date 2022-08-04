package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.entity.Users;
import com.examly.springapp.exceptions.BusinessException;
import com.examly.springapp.model.JwtResponse;
import com.examly.springapp.model.LoginForm;
import com.examly.springapp.repo.UserRepository;
import com.examly.springapp.service.impl.JwtUserDetailsService;
import com.examly.springapp.utility.JwtUtil;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class JwtController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/authenticate")
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody LoginForm authenticationRequest) throws Exception{

    	log.debug("New user authentication started");
    	
    	authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
       
        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

        final Users users = userRepository.findByEmail(authenticationRequest.getEmail());
        final String token = jwtUtil.generateToken(userDetails);

        log.debug("User authentication successfully complete for user: {1} with token {2}",userDetails.getUsername(),token);
        
        return ResponseEntity.ok(new JwtResponse(users,token));
    }
    
    
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
        	log.debug("Authentication failed: User is disabled ");
            throw new BusinessException("USER_DISABLED");
        } catch (BadCredentialsException e) {
        	log.debug("Exception occured: User entered bad credentials" + e);
            throw new BusinessException("INVALID_CREDENTIALS");
        }
    }
}
