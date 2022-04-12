package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "viceSindaco")
public class Vicesindaco {
    @Id
    private String nomina;
    @Field(targetType = FieldType.STRING)
    private String nome;
    @Field(targetType = FieldType.STRING)
    private String mandate;
    @Field(targetType = FieldType.STRING)
    private String descrizione;

    public String getNomima() {
        return nomina;
    }

    public void setNomima(String nomima) {
        this.nomina = nomima;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMandate() {
        return mandate;
    }

    public void setMandate(String mandate) {
        this.mandate = mandate;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
