package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "minoranza")
public class Minoranza {
    @Id
    private String partito;
    @Field(targetType = FieldType.STRING)
    private String nominativo;

    public String getPartito() {
        return partito;
    }

    public void setPartito(String partito) {
        this.partito = partito;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }
}
