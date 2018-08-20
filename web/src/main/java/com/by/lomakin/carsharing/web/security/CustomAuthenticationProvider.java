
package com.by.lomakin.carsharing.web.security;

import com.by.lomakin.carsharing.dao.api.model.IUserData;
import com.by.lomakin.carsharing.service.IUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUserDataService userService;

    @Override
    public Authentication authenticate(final Authentication authentication)
            throws AuthenticationException {
        final String username = authentication.getPrincipal() + "";
        final String password = authentication.getCredentials() + "";

        int userId = 0;
        List<SimpleGrantedAuthority> role = null;
        IUserData user = userService.getByEmail(username);

        if (user != null) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                userId = user.getId();
                role = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            }

        }

        if (role == null) {
            throw new BadCredentialsException("1000");
        }
        return new ExtendedUsernamePasswordAuthenticationToken(userId, username, password,
                role);

    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
