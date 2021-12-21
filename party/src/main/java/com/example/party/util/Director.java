package com.example.party.util;



import com.example.party.model.api.PartyRequest;
import com.example.party.model.jpamodel.Person;

import java.time.LocalDate;

public class Director {

    public  static Person buildJpaModel(PartyRequest request){
        return Person.builder()
                .name(request.getName())
                .fatherLastName(request.getFatherName())
                .motherLastName(request.getMotherName())
                .dni(request.getDni())
                .createdDate(LocalDate.now())
                .build();

    }

    public static PartyRequest modelToResponse(Person response){
        return  PartyRequest.builder()
                .name(response.getName())
                .fatherName(response.getFatherLastName())
                .motherName(response.getMotherLastName())
                .dni(response.getDni())
                .build();

    }
}
