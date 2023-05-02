package cogent.infotech.com.DoConnect.jwt;

import java.util.ArrayList;

//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import cogent.infotech.com.DoConnect.entity.User;
import cogent.infotech.com.DoConnect.repository.UserRepository;
import cogent.infotech.com.DoConnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cogent.infotech.com.DoConnect.entity.Admin;
import cogent.infotech.com.DoConnect.repository.AdminRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

//    public UserDetailsServiceImpl(AdminRepository adminRepository) {
//        this.adminRepository = adminRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Admin user = adminRepository.findByUsername(username);
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
