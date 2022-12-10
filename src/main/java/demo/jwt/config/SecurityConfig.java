package demo.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;


    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/api/v1/resources/admin").hasAuthority("ADMIN")
                .requestMatchers("/api/v1/resources/user").hasAuthority("USER")
                .anyRequest().authenticated()
                // Login Form Details
                .and()
                .formLogin()
                .defaultSuccessUrl("/", true)

                // Logout Form Details
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                // Exception Details
                .and()
                .exceptionHandling()
                //.accessDeniedPage("/accessDenied")
                .and()
                .httpBasic(Customizer.withDefaults())
                ;


//            http.csrf(AbstractHttpConfigurer::disable)
//            .authorizeHttpRequests( auth -> auth
//                    .anyRequest().authenticated()
//            )
//            //.oauth2ResourceServer().jwt()
//            //.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .httpBasic(Customizer.withDefaults())
//            ;

        //http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

//    @Bean
//    protected InMemoryUserDetailsManager configAuthentication() {
//
//        List<UserDetails> users = new ArrayList<>();
//        List<GrantedAuthority> adminAuthority = new ArrayList<>();
//        adminAuthority.add(new SimpleGrantedAuthority("ADMIN"));
//        UserDetails admin= new User("admin", "{noop}admin", adminAuthority);
//        users.add(admin);
//
//        List<GrantedAuthority> employeeAuthority = new ArrayList<>();
//        adminAuthority.add(new SimpleGrantedAuthority("USER"));
//        UserDetails employee= new User("user", "{noop}password", employeeAuthority);
//        users.add(employee);
//
//        return new InMemoryUserDetailsManager(users);
//    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/", "/login");
    }

    @Bean
    public UserDetailsManager authenticateUsers() {

        UserDetails user = User
                .withUsername("foo")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder()
                        .encode("foo"))
                .authorities("USER")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setAuthoritiesByUsernameQuery("select id,username,password from users where username=?");
        users.setUsersByUsernameQuery("select username, roles from users where username=?");
        users.createUser(user);
        return users;
    }

}
