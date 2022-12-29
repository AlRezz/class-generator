package com.beta.classgenerator.service;

import com.beta.classgenerator.configuration.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MappingService {
    private final MappingConfig mappingConfig;
    private final MappingUtil mappingUtil;

    public void map(final Object from, final Object to) {
        Map<String, String> entityToReportMapping = mappingConfig.getFields().stream()
                .collect(Collectors.toMap(MapperField::getEntityField, MapperField::getReportField));
        System.out.println("Mapping:");
        System.out.println(entityToReportMapping);

        entityToReportMapping.forEach((k, v) -> mappingUtil.callSetter(to, v, mappingUtil.callGetter(from, (k))));

        System.out.println(to);
    }
}
