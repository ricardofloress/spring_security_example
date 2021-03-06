package com.axis.axis_hotels_api.auth;

import com.axis.axis_hotels_api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService implements UserDetailsService {
    @Autowired
    private final ApplicationUserDao applicationUserDao;


    @Autowired
    public ApplicationUserService(ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = applicationUserDao.findUserByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));
        return user.map(ApplicationUser::new).get();
    }
}
