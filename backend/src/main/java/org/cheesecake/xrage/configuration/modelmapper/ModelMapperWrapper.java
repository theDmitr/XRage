package org.cheesecake.xrage.configuration.modelmapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ModelMapperWrapper {

    private final ModelMapper modelMapper;

    public <T> T map(Object object, Class<T> clazz) {
        return modelMapper.map(object, clazz);
    }

    public <T> List<T> mapCollection(List<?> collection, Class<T> clazz) {
        return collection.stream()
                .map(t -> modelMapper.map(t, clazz))
                .collect(Collectors.toList());
    }
}
