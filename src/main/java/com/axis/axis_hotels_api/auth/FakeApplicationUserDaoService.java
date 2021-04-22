package com.axis.axis_hotels_api.auth;

import com.axis.axis_hotels_api.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.axis.axis_hotels_api.security.ApplicationUserRole.*;

@Repository("fake")
@AllArgsConstructor
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserbyUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser("Ricardo", passwordEncoder.encode("pass"), ADMIN.getGrantedAuthorities(), true, true, true, true),
                new ApplicationUser("Anna", passwordEncoder.encode("pass"), STUDENT.getGrantedAuthorities(), true, true, true, true),
                new ApplicationUser("Linda", passwordEncoder.encode("pass"), STUDENT.getGrantedAuthorities(), true, true, true, true)
        );
        return applicationUsers;
    }
}
