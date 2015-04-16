package com.rvcode.examples.csvmessageconverter.converters;

import com.rvcode.examples.csvmessageconverter.data.Country;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Volodymyr Rudyi
 */
@Component
public class SuperCSVMessageConverter extends AbstractHttpMessageConverter<Object> {

    private static final String [] header = {"name", "capital", "population", "totalArea"};
    private static final String TEXT_CSV = "text/csv";

    public SuperCSVMessageConverter() {
        super(MediaType.valueOf(TEXT_CSV));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return Country.class.isAssignableFrom(aClass) || Collection.class.isAssignableFrom(aClass);
    }

    @Override
    protected Country readInternal(Class<?> aClass,
                                   HttpInputMessage message) throws IOException, HttpMessageNotReadableException {
        throw new UnsupportedOperationException("readInternal() is not supported yet");
    }

    @Override
    protected void writeInternal(Object object,
                                 HttpOutputMessage message) throws IOException, HttpMessageNotWritableException {

        message.getHeaders().add(HttpHeaders.CONTENT_TYPE, TEXT_CSV);

        try (final Writer writer = new OutputStreamWriter(message.getBody())){
            final CsvBeanWriter beanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
            beanWriter.writeHeader(header);

            writeItems(beanWriter, object, header);

            beanWriter.flush();
        }



    }

    private void writeItems(CsvBeanWriter beanWriter, Object object, String[] header) throws IOException {
        final Collection<Object> items;
        if (object instanceof Country){
            items = Arrays.asList(object);
        } else {
            items  = (Collection)object;
        }

        for(final Object item: items){
            beanWriter.write(item, header);
        }
    }
}
