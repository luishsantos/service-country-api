package com.example.countryinfo.mapper;

import com.example.countryinfo.dto.CountryDTO;
import com.example.countryinfo.entity.CountryEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-17T19:26:59+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.21 (Amazon.com Inc.)"
)
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryEntity toCountryEntity(CountryDTO countryDTO) {
        if ( countryDTO == null ) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();

        countryEntity.setOfficialLanguage( countryDTO.getLanguage() );
        countryEntity.setName( countryDTO.getName() );
        countryEntity.setPopulation( countryDTO.getPopulation() );
        countryEntity.setCurrency( countryDTO.getCurrency() );
        countryEntity.setCapital( countryDTO.getCapital() );
        countryEntity.setLatitude( countryDTO.getLatitude() );
        countryEntity.setLongitude( countryDTO.getLongitude() );

        return countryEntity;
    }

    @Override
    public CountryDTO toCountryDTO(CountryEntity countryEntity) {
        if ( countryEntity == null ) {
            return null;
        }

        CountryDTO.CountryDTOBuilder countryDTO = CountryDTO.builder();

        countryDTO.language( countryEntity.getOfficialLanguage() );
        countryDTO.name( countryEntity.getName() );
        countryDTO.capital( countryEntity.getCapital() );
        countryDTO.currency( countryEntity.getCurrency() );
        countryDTO.latitude( countryEntity.getLatitude() );
        countryDTO.longitude( countryEntity.getLongitude() );
        countryDTO.population( countryEntity.getPopulation() );

        return countryDTO.build();
    }

    @Override
    public List<CountryDTO> toCountryDTOList(List<CountryEntity> countryEntityList) {
        if ( countryEntityList == null ) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>( countryEntityList.size() );
        for ( CountryEntity countryEntity : countryEntityList ) {
            list.add( toCountryDTO( countryEntity ) );
        }

        return list;
    }

    @Override
    public List<CountryEntity> toCountryEntityList(List<CountryDTO> countryEntityList) {
        if ( countryEntityList == null ) {
            return null;
        }

        List<CountryEntity> list = new ArrayList<CountryEntity>( countryEntityList.size() );
        for ( CountryDTO countryDTO : countryEntityList ) {
            list.add( toCountryEntity( countryDTO ) );
        }

        return list;
    }
}
