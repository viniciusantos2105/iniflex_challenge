package com.iniflex.adapters;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class Adapter {

    @Inject
    ModelMapper mapper;

    public <S, T> T map(S source, Class<T> targetClass) {
        return mapper.map(source, targetClass);
    }

    public <T> void updateTargetFromSource(T source, T target) {
        mapper.map(source, target);
    }
}