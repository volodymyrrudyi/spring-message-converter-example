package com.rvcode.examples.csvmessageconverter.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvcode.examples.csvmessageconverter.data.Country;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Volodymyr Rudyi (vladimir.rudoy@gmail.com)
 */
@RequestMapping("/countries")
@Controller
public class CountriesController {

    private static final String PATH_TO_FIXTURES = "/fixtures/countries.json";

    @RequestMapping(method = RequestMethod.GET, produces = "text/csv")
    @ResponseBody
    public List<Country> getCountries() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final InputStream fixturesStream = this.getClass().getResourceAsStream(PATH_TO_FIXTURES);

        final List<Country> result = mapper.readValue(fixturesStream,
                mapper.getTypeFactory().constructCollectionType(List.class, Country.class));

        return result;
    }
}
