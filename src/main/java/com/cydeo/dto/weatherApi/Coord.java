
package com.cydeo.dto.weatherApi;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lon",
    "lat"
})

public class Coord {

    @JsonProperty("lon")
    public Double lon;
    @JsonProperty("lat")
    public Double lat;

}
