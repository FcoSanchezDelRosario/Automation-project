package org.exercises.api.pet;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PetDetails {

    private final int id;
    private final String category_id;
    private final String category_name ;
    private final String name ;
    private final String  status;

}
