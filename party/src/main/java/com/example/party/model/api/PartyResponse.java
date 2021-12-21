package com.example.party.model.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PartyResponse {

    private String code;

    private String description;
}
