package com.pradeepverse.__factor.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommonUtil {

    private final ModelMapper modelMapper;

    public <S, T> List<T> mapList(List<S> sourceList, Class<T> targetClass) {
        return sourceList
                .stream()
                .map(s -> modelMapper.map(s, targetClass))
                .toList();
    }

}
