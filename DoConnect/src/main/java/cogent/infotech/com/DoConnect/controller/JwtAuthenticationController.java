package cogent.infotech.com.DoConnect.controller;
/*
import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cogent.infotech.com.DoConnect.jwt.JwtRequest;
import cogent.infotech.com.DoConnect.jwt.JwtResponse;
import cogent.infotech.com.DoConnect.jwt.JwtUtil;

@RestController
public class JwtAuthenticationController {

	   @Autowired
	    private JwtUtil jwtUtil;
	    @Autowired
	    private AuthenticationManager authenticationManager;

	    @GetMapping("/")
	    public String welcome() {
	        return "Welcome to Great learning !!";
	    }

	    @PostMapping("/authenticate")
	    public String generateToken(@RequestBody JwtRequest authRequest) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	            );
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        return jwtUtil.generateToken(authRequest.getUsername());
	    }
}
*/