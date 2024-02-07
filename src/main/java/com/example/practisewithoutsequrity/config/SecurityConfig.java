package com.example.practisewithoutsequrity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;


    //@Autowired
    //private UserDetailsService userDetailsService;


    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/Registration").permitAll()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/LoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .successHandler(successHandler)
                .and()
                .csrf().ignoringAntMatchers("/Registration")
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/register");
    }
}
        //authorizeRequests()
//                //.antMatchers("/user/**").hasRole("USER")
//                //.antMatchers("/admin/**").hasRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .httpBasic();



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }











        //Employee
              //work
                 //my-profile
                    ///-{function-1}
                 //my-drives
                    ///-{function-2}
                 //choose-drive
                    ///-{function-3}

        //Admin
              //work-for-admin
                 //work-with-users
                    ///-{function-4}
                 //work-with-ride
                    ///-{function-5}
                 //work-with-car
                    ///-{function-6}
                 //my-profile
                    ///-{function-7}

        //Registration.html
        //Login
        //User



        //function-1: 1)edit_name 2)edit_login 3)edit_phone 4)edit_login 5)edit_wallpaper

        //function-2: 1)sort_by_date 2)watch_who_with_you 3)watch_tasks 4)after_start_can_choose_which_task_is_complete

        //function-3: 1)sort_by_a-z 2)sort_by_date 3)sort_by_only_my 4)filter_by_date 5)watch_tasks


        //function-4: 1)sort_by_a-z 2)sort_by_name 3)watch_profile 4)watch_which_now_drive 5)history

        //function-5: 1)sort_by_a-z 2)sort_by_date 3)get_ride_to_user(by_id) 4)filter_by_date 5)watch_tasks 6)add_task_to_ride 7)get_cat_to_ride

        //function-6: 1)sort_by_a-z 2)s 3)watch_which_free 4)add_car

        //function-7: 1)edit_name 2)edit_login 3)edit_phone 4)edit_login 5)edit_wallpaper


