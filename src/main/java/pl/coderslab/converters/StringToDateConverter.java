package pl.coderslab.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by dell on 17.08.17.
 */
@Component
public class StringToDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String s) {
        return LocalDate.parse(s);
    }
}
