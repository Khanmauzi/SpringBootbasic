package com.example.demo.controllers;

import com.example.demo.hello.BeanData;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class FileteringController {

    /**
     * Here we are implementing filter
     * Sending bean with data with filtering
     * @return
     */

    @GetMapping("")
    public MappingJacksonValue  getBeanData(){
        BeanData beanData = new BeanData("value1", "value2", "value3");

        SimpleBeanPropertyFilter simpleBeanPropertyFilter =  SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("BeanDataFilter", simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(beanData);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
