package com.axis.axis_hotels_api.jwt;

import com.google.common.net.HttpHeaders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

//This class is responsible for the config of jwt properties, such as, secretkey for encode and decode the tokens, the Bearer prefix and the expiration of the token session
//This class automatically fill is properties my mapping with our properties file with the line bellow this comment
@ConfigurationProperties(prefix = "application.jwt")
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JwtConfig {
    private String secretKey;
    private String tokenPrefix;
    private Integer tokenExpirationAfterDays;

    /**
     * @description Get's the AUTHORIZATION header label
     * @return HTTP HEADER AUTHORIZATION
     */
    public String getAuthorizationHeader(){
        return HttpHeaders.AUTHORIZATION;
    }
}
