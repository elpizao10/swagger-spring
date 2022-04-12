package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "personaggiIllustri")
public class PersonaggiIllustri {
    @Id
    private String titolo;
    @Field(targetType = FieldType.STRING)
    private String niccolo;
    @Field(targetType = FieldType.STRING)
    private String niccoloStoria;
    @Field(targetType = FieldType.STRING)
    private String bruno;
    @Field(targetType = FieldType.STRING)
    private String brunoStoria;
    @Field(targetType = FieldType.STRING)
    private String onofrio;
    @Field(targetType = FieldType.STRING)
    private String onofrioStoria;
    @Field(targetType = FieldType.STRING)
    private String piero;
    @Field(targetType = FieldType.STRING)
    private String pieroStoria;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getNiccolo() {
        return niccolo;
    }

    public void setNiccolo(String niccolo) {
        this.niccolo = niccolo;
    }

    public String getNiccoloStoria() {
        return niccoloStoria;
    }

    public void setNiccoloStoria(String niccoloStoria) {
        this.niccoloStoria = niccoloStoria;
    }

    public String getBruno() {
        return bruno;
    }

    public void setBruno(String bruno) {
        this.bruno = bruno;
    }

    public String getBrunoStoria() {
        return brunoStoria;
    }

    public void setBrunoStoria(String brunoStoria) {
        this.brunoStoria = brunoStoria;
    }

    public String getOnofrio() {
        return onofrio;
    }

    public void setOnofrio(String onofrio) {
        this.onofrio = onofrio;
    }

    public String getOnofrioStoria() {
        return onofrioStoria;
    }

    public void setOnofrioStoria(String onofrioStoria) {
        this.onofrioStoria = onofrioStoria;
    }

    public String getPiero() {
        return piero;
    }

    public void setPiero(String piero) {
        this.piero = piero;
    }

    public String getPieroStoria() {
        return pieroStoria;
    }

    public void setPieroStoria(String pieroStoria) {
        this.pieroStoria = pieroStoria;
    }
}
