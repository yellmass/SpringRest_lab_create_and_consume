
package com.cydeo.dto.weatherApi;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "speed",
    "deg"
})

public class Wind {

    @JsonProperty("speed")
    public Double speed;
    @JsonProperty("deg")
    public Integer deg;

}
