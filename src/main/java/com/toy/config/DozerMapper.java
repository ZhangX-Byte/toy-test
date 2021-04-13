package com.toy.config;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhang_Xiang
 * @since 2021/04/09 13:59:06
 */
@Configuration
public class DozerMapper {

    @Bean
    Mapper getMapper() {
        return DozerBeanMapperBuilder.buildDefault();
    }
}
