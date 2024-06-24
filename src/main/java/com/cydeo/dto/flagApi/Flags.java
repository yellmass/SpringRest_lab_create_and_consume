
package com.cydeo.dto.flagApi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "png",
    "svg",
    "alt"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class Flags {

    @JsonProperty("png")
    public String png;
    @JsonProperty("svg")
    public String svg;
    @JsonProperty("alt")
    public String alt;

}
