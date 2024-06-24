package com.cydeo.client;

import com.cydeo.dto.flagApi.FlagApus;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(url = "https://restcountries.com/v3.1/name", name = "FLAG-CLIENT")
public interface FlagClient {

    @GetMapping("/{countryName}")
    public List<FlagApus> getFlagData(@PathVariable("countryName") String countryName);

}
