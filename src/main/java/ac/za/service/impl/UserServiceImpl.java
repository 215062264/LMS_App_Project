package ac.za.service.impl;

import ac.za.domain.users.User;
import ac.za.repository.repoInterface.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//@Component
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private   UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(s);
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null){
            builder = org.springframework.security.core.userdetails.User.withUsername(s);
            builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
            List<String> roles = user.getRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList());
            builder.authorities(new SimpleGrantedAuthority("ADMIN"));
        }
        return builder.build();
    }
}
