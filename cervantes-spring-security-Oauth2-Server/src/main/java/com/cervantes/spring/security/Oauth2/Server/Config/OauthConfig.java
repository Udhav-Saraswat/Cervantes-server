package com.cervantes.spring.security.Oauth2.Server.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class OauthConfig extends AuthorizationServerConfigurerAdapter {

//	private final PasswordEncoder passwordEncoder;
//	@Value("abcd")
//	private String ClientID;
//	@Value("xyz")
//	private String ClientSecret;
	
	/**
	 * Off for now
	 */
//	@Value("${user.oauth.redirectUris}")
//	private String RedirectURLs;


    @Autowired
    private AuthenticationManager authenticationManager;
    
//	public OauthConfig(PasswordEncoder passwordEncoder) {
//		this.passwordEncoder = passwordEncoder;
//	}

	@Override
	public void configure(
			AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");

	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("abcd")
		.secret("xyz")
//		.secret(passwordEncoder.encode(ClientSecret))
		.authorizedGrantTypes("authorization_code")
		.scopes("user_info")
		.autoApprove(true);
//		.redirectUris(RedirectURLs);
	}
	
	   @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

			endpoints.authenticationManager(authenticationManager);
	    }
}
