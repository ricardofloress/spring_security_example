package com.axis.axis_hotels_api.auth;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserbyUsername(String username);
}
