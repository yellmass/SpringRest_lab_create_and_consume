package com.cydeo.controller;

import com.cydeo.client.FlagClient;
import com.cydeo.client.WeatherClient;
import com.cydeo.config.ApiKeyConfig;
import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.flagApi.FlagApus;
import com.cydeo.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;
    private final WeatherClient weatherClient;
    private final ApiKeyConfig apiKeyConfig;
    private final FlagClient flagClient;
    private final RestTemplate restTemplate;

    public AddressController(AddressService addressService, WeatherClient weatherClient, ApiKeyConfig apiKeyConfig, FlagClient flagClient, RestTemplate restTemplate) {
        this.addressService = addressService;
        this.weatherClient = weatherClient;
        this.apiKeyConfig = apiKeyConfig;
        this.flagClient = flagClient;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{addressNo}")
    public ResponseEntity<ResponseWrapper> getAddressByNo(@PathVariable("addressNo") String addressNo) {

        AddressDTO addressDTO = addressService.findByAddressNo(addressNo);

        Integer currentTemp = weatherClient
                .getWeatherData(addressDTO.getCity(), apiKeyConfig.getAppid())
                .main.temp.intValue();

        String flagUrl = flagClient.getFlagData(addressDTO.getCountry()).get(0).flags.png;
        //String flagURL = restTemplate.getForObject("https://restcountries.com/v3.1/name/{countryName}", FlagApus[].class,addressDTO.getCountry())[0].flags.png;

        addressDTO.setCurrentTemperature(currentTemp);
        addressDTO.setFlag(flagUrl);

        return ResponseEntity.ok(
                ResponseWrapper.builder()
                        .data(addressDTO)
                        .message("Address " + addressNo + " is successfully retrieved.")
                        .code(HttpStatus.OK.value())
                        .success(true)
                        .build()
        );
    }

    /*
     Endpoint: /api/v1/address/{addressNo}
     HTTP Status Code: 200

     JSON Response Body:
     "success": true
     "message": "Address <addressNo> is successfully retrieved."
     "code":200
     "data":<address data>
    */

    @PutMapping("/{addressNo}")
    public AddressDTO updateAddress(@PathVariable("addressNo") String addressNo,
                                    @RequestBody AddressDTO addressDTO) {

        return addressService.update(addressNo, addressDTO);

    }


    /*
      Endpoint: /api/v1/address/{addressNo}

      JSON Response Body:
      <updated address data>
     */

}
