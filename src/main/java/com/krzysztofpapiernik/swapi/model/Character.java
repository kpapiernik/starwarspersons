package com.krzysztofpapiernik.swapi.model;

import com.krzysztofpapiernik.swapi.controller.dto.GetCharacterDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter

@Entity
@Table(name = "characters")
public class Character {
    @Id
    protected Long id;
    protected String name;
    protected Integer height;
    protected Integer mass;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        if(height.equals("unknown")){
            this.height = null;
        }else {
            this.height = Integer.valueOf(height);
        }
    }

    public void setMass(String mass) {
        if(mass.equals("unknown")){
            this.mass = null;
        }else {
            this.mass = Integer.valueOf(mass);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Character character = (Character) o;
        return id != null && Objects.equals(id, character.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Character withId(Long id){
        return new Character(id, name, height, mass);
    }

    public GetCharacterDto getCharacterDto(){
        return new GetCharacterDto(id, name, height, mass);
    }
}
