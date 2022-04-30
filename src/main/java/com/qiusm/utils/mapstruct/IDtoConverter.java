package com.qiusm.utils.mapstruct;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author qiushengming
 */
@Mapper(uses = {TypeConversionWorker.class})
public interface IDtoConverter {
    IDtoConverter INSTANCE = Mappers.getMapper(IDtoConverter.class);

    @Mappings({
            @Mapping(target = "date", qualifiedByName = "dataToStr"),
            @Mapping(target = "ignore", ignore = true)
    })
    Dto toDto(Domain domain);

}