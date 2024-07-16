package com.example.practisewithoutsequrity.config;

//import com.example.practisewithoutsequrity.model.AuthProvider;

import com.example.practisewithoutsequrity.model.RoleBasedAuthenticationSuccessHandler;
import com.example.practisewithoutsequrity.repository.UserRepo;
import com.example.practisewithoutsequrity.service.CustomUserDetailService;
import com.example.practisewithoutsequrity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private AuthenticationManagerBuilder auth;
    private UserService userService;
    private UserRepo userRepo;
    //private AuthProvider autht;
    private CustomUserDetailService cUDS;

    @Autowired
    public SecurityConfig(UserService us,
                          AuthenticationManagerBuilder aUMB,
                          UserRepo uR,
                          CustomUserDetailService customUDS
                          //AuthProvider auP
    )
    {
        this.userService = us;
        this.auth=aUMB;
        this.userRepo=uR;
        this.cUDS=customUDS;
       // this.autht=auP;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        //return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(cUDS);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                   .antMatchers("/test/**").permitAll()
                   .antMatchers("/resources/**").permitAll()
                   .antMatchers("/LoginPage").permitAll()
                   .antMatchers("/admin/**").hasRole("ADMIN")
                   .antMatchers("/user/**").hasRole("USER")
                   //.antMatchers("/templates/GlobalHome").permitAll()
                   .antMatchers("/*").permitAll()
                .and()
                   .formLogin()
                   .loginPage("/LoginPage")
                   .loginProcessingUrl("/LoginPage")
                   .usernameParameter("username")
                   .passwordParameter("password")
                    .successHandler(new RoleBasedAuthenticationSuccessHandler())
                .and()
                   .logout()
                   .logoutUrl("/Logout")
                   .logoutSuccessUrl("/LoginPage")
                .and()
                   .httpBasic()
                   .disable();

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/css/**","/images/**");
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

}







//////////////////  ПАНЕЛЬ СВЕРХУ САЙТА ДЛЯ ПЕРЕКЛЮЧЕНИЯ ФУНКЦИЙ

// Admin

       //Создание (задач)(машин)(локации) -поочереди
       //Формирование поездки (отправка запросу пользователю, на согласие)(добавление на карте точку А и В) --одним окном все элементы
       //Просмотр статуса поездки (динамическая шкала % выполнения)
       //Получения отчета, по истечению срока поздки (message)
       //Получение запроса на участие от пользователя (принятие)(отказ)



// User

       //Получение уведомления о готовности к командировке (согласие)(отказ) --отдельное окно с уведомлением
       //Просмотр предстоящих командировок (запрос админу на участие)
       //Выполнение задачи в командировке (галочка напротив задачи)(оставление комментария)
       //Просмотр статуса командировки (динамическа шкала % выполнения) --только своей поездки


//сущности 1)user  2)task  3)location  4)auto  5)Drive  6)message  7)статус

//   (7)* --- загружает в свою map задачи(ключ) поездки и степень выполнения и по формуле процентовки
//   вычисляет степень совершенности , так же загружает дату и вычисляет степень завершенности поездки (2 круговые диаграммы)










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


