package com.schoolbooks.bookManagement.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //Configuration class ekak kiyala pennanna me annotation eka danawa.
//Spring beans නැ ත්තම් POJO Definitions වලට source එකක්.
//ApplicationContext එකකට එක configure class එකක් හරි තීන්න ඕන. ඒක Convention එකක්.
//Meke responsibility eka thamaa, Beans scan කරල  දෙන එක.
//ඒ කියන්නෙඅපි ලියල දෙන POJOs අපේ codes ඔක්කො ම scan කරල දෙන්නෙ container එකට මේ configuration class එකක් හරහා.
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper (){
        return new ModelMapper();
    }
}
