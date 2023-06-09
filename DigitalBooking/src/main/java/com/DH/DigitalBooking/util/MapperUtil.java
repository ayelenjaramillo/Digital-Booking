/*
package com.DH.DigitalBooking.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//NO ES EL MAPPER DE SWAGGER ES EL MODEL MAPPER DE LA DEPENDENCIA


@Component
public class MapperUtil {

    @Autowired(required = true)
    private ModelMapper modelMapper;

    public <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

    //MAPEO DE LISTAS!!
    public  <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    public <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {
        return entities.map(objectEntity -> modelMapper.map(objectEntity, dtoClass));
    }


}*/

