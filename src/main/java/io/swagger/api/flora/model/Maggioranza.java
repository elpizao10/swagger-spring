package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "maggioranza")
public class Maggioranza {
    @Id
    private String partito;
    @Field(targetType = FieldType.STRING)
    private String nominativo1;
    @Field(targetType = FieldType.STRING)
    private String nominativo2;
    @Field(targetType = FieldType.STRING)
    private String nominativo3;

    public String getPartito() {
        return partito;
    }

    public void setPartito(String partito) {
        this.partito = partito;
    }

    public String getNominativo1() {
        return nominativo1;
    }

    public void setNominativo1(String nominativo1) {
        this.nominativo1 = nominativo1;
    }

    public String getNominativo2() {
        return nominativo2;
    }

    public void setNominativo2(String nominativo2) {
        this.nominativo2 = nominativo2;
    }

    public String getNominativo3() {
        return nominativo3;
    }

    public void setNominativo3(String nominativo3) {
        this.nominativo3 = nominativo3;
    }
}
