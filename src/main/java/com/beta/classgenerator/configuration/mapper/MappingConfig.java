package com.beta.classgenerator.configuration.mapper;

import lombok.Data;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "mapping")
@PropertySource(value = "classpath:/mapping/mappings.yml", factory = YamlPropertySourceFactory.class)
@Data
public class MappingConfig {
    private final List<MapperField> fields = new ArrayList<>();
}
