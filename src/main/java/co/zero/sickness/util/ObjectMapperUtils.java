package co.zero.sickness.util;

import org.modelmapper.ModelMapper;

public class ObjectMapperUtils {
    private static final ModelMapper modelMapper;
    
    static {
        modelMapper = new ModelMapper();
    }
    
    private ObjectMapperUtils() {
    }
    
    public static <S, D> D map(final S entityToMap, Class<D> expectedClass) {
        return modelMapper.map(entityToMap, expectedClass);
    }
    
    public static <S, D> void map(final S entityToMap, D expectedObject) {
        modelMapper.map(entityToMap, expectedObject);
    }
}
