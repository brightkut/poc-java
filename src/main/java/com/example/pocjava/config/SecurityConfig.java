package com.example.pocjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    //Authentication
    @Bean
    public UserDetailsService userDetailsService(){
        /* สำหรับ กรณี hard code user โดยไม่ได้ดึงจาก DB*/
//        UserDetails admin = User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("Admin","Normal")
//                .build();
//
//        UserDetails normalUser = User.withUsername("John")
//                .password(passwordEncoder.encode("1234"))
//                .roles("Normal")
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,normalUser);

        return new UserInfoUserDetailService();
    }

    //Authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                // Allow endpoint นี้ไม่ต้อง authenticate
                .authorizeHttpRequests()
                .requestMatchers("/products/welcome","/products/new").permitAll()
                // Authenticate ด้วย form login
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/products/**").authenticated()
                .and().formLogin()

                .and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        /* สำหรับ set ว่าใช้ user detail ที่เราสร้างขึ้นให้ load user จาก db */
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }
}
