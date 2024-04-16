package com.example.practisewithoutsequrity.config;

import com.example.practisewithoutsequrity.entity.User;
import com.example.practisewithoutsequrity.repository.UserRepo;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{


    private AuthenticationManagerBuilder auth;
    private UserService userService;

    private UserRepo userRepo;
    @Autowired
    public SecurityConfig(UserService us, AuthenticationManagerBuilder aUMB, UserRepo uR)
    {
        this.userService = us;
        this.auth=aUMB;
        this.userRepo=uR;
    }


    //бин кодировки типа BCrypt. Определен в RegistrationForm
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    //Загрузка пользователя если он существует
    @Bean
    public UserDetailsService userDetailsService (UserRepo userRepo){
        return login -> {
            User user = userRepo.findByLogin(login);
            if (user != null) return (UserDetails) user;

            throw new UsernameNotFoundException("user" + login + " not Found !");
        };
    }

//    @Bean
//    public UserDetailsService userDetailsService(UserRepo userRepo) {
//        return new CustomUserDetailsServiceImpl(userRepo);
//    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService(userRepo));
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

//    @Autowired
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/Registration").permitAll()
                .antMatchers("/LoginPage").permitAll()
                .antMatchers("/AllUsers").permitAll()
                .antMatchers("/FirstLogin").permitAll()
                .and()
                .csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .logout().permitAll()
//                .and()
//                .authenticationProvider(authenticationProvider())
//                .userDetailsService(userDetailsService(userRepo))
//                .passwordEncoder(passwordEncoder())
                .and().build();
    }

}




    //настройка конфигурации безопасности
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/Registration").permitAll()
//                .antMatchers("/LoginPage").permitAll()
//                .antMatchers("/AllUsers").permitAll()
//                .and()
//                .csrf().disable()
//                .httpBasic().disable()
////                .formLogin()
////                .loginPage("/Login")
////                .loginProcessingUrl("/Login")
////                .usernameParameter("login")
////                .passwordParameter("password")
////                .defaultSuccessUrl("/")
//                .logout().permitAll();
//
//    }






//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance());
//    }













//Registration
//Login

        //Employee
              //work(общий)

                 //my-profile
                    ///-{function-1}
                 //my-drives.html
                    ///-{function-2}
                 //choose-drive.html
                    ///-{function-3}

        //Admin
              //work(общий)

                 //work-with-users
                    ///-{function-4}
                 //work-with-ride
                    ///-{function-5}
                 //work-with-car
                    ///-{function-6}
                 //my-profile
                    ///-{function-7}




        //function-1: 1)edit_name 2)edit_login 3)edit_phone 4)edit_login 5)edit_wallpaper

        //function-2: 1)sort_by_date 2)watch_who_with_you 3)watch_tasks 4)after_start_can_choose_which_task_is_complete

        //function-3: 1)sort_by_a-z 2)sort_by_date 3)sort_by_only_my 4)filter_by_date 5)watch_tasks


        //function-4: 1)sort_by_a-z 2)sort_by_name 3)watch_profile 4)watch_which_now_drive 5)history

        //function-5: 1)sort_by_a-z 2)sort_by_date 3)get_ride_to_user(by_id) 4)filter_by_date 5)watch_tasks 6)add_task_to_ride 7)get_cat_to_ride

        //function-6: 1)sort_by_a-z 2)s 3)watch_which_free 4)add_car

        //function-7: 1)edit_name 2)edit_login 3)edit_phone 4)edit_login 5)edit_wallpaper


