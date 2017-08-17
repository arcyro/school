package pl.coderslab.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.entities.City;
import pl.coderslab.repository.CityRepository;

/**
 * Created by dell on 17.08.17.
 */
@Component
public class CityConverter implements Converter<String, City> {
    @Autowired
    CityRepository cityRepository;

    @Override
    public City convert(String s) {
        return cityRepository.findOne(Long.parseLong(s));
    }
}
