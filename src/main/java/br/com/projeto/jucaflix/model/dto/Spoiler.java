package br.com.projeto.jucaflix.model.dto;

import lombok.Data;

@Data
public class Spoiler {

    private String description;

    @Override
    public String toString() {
        return description;
    }
}
