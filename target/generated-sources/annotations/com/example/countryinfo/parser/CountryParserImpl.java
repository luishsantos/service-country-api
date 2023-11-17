package com.example.countryinfo.parser;

import com.example.countryinfo.dto.CountryApiDTO;
import com.example.countryinfo.dto.CountryDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-17T19:27:00+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.21 (Amazon.com Inc.)"
)
public class CountryParserImpl implements CountryParser {

    @Override
    public CountryDTO toCountryDTO(CountryApiDTO countryApiDTO) {
        if ( countryApiDTO == null ) {
            return null;
        }

        CountryDTO.CountryDTOBuilder countryDTO = CountryDTO.builder();

        countryDTO.name( parseCurrencies( countryApiDTO.getName() ) );
        countryDTO.population( countryApiDTO.getPopulation() );

        countryDTO.capital( !countryApiDTO.getCapital().isEmpty() ? countryApiDTO.getCapital().get(0) : null );
        countryDTO.language( !countryApiDTO.getLanguages().isEmpty() ? countryApiDTO.getLanguages().values().iterator().next() : null );
        countryDTO.latitude( countryApiDTO.getLatlng().size() == 2 ? countryApiDTO.getLatlng().get(0) : null );
        countryDTO.longitude( countryApiDTO.getLatlng().size() == 2 ? countryApiDTO.getLatlng().get(1) : null );
        countryDTO.currency( parseCurrencies(countryApiDTO.getCurrencies()) );

        return countryDTO.build();
    }

    @Override
    public List<CountryDTO> toCountryDTOList(List<CountryApiDTO> countryApiDTOList) {
        if ( countryApiDTOList == null ) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>( countryApiDTOList.size() );
        for ( CountryApiDTO countryApiDTO : countryApiDTOList ) {
            list.add( toCountryDTO( countryApiDTO ) );
        }

        return list;
    }
}
