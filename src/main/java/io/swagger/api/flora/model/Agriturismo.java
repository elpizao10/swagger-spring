package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "agriturismo")
public class Agriturismo {
    @Id
    private Long id;
    @Field(targetType = FieldType.STRING)
    private String titolo;
    @Field(targetType = FieldType.STRING)
    private String denominazione;
    @Field(targetType = FieldType.STRING)
    private String indirizzo;
    @Field(targetType = FieldType.STRING)
    private String contatti;
    @Field(targetType = FieldType.STRING)
    private String camere;
    @Field(targetType = FieldType.STRING)
    private String postiLetto;
    @Field(targetType = FieldType.STRING)
    private String bagni;
    @Field(targetType = FieldType.STRING)
    private String classificazione;
    @Field(targetType = FieldType.STRING)
    private String ristorazione;
    @Field(targetType = FieldType.STRING)
    private String periodo;
    @Field(targetType = FieldType.STRING)
    private String approvazione;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getContatti() {
        return contatti;
    }

    public void setContatti(String contatti) {
        this.contatti = contatti;
    }

    public String getCamere() {
        return camere;
    }

    public void setCamere(String camere) {
        this.camere = camere;
    }

    public String getPostiLetto() {
        return postiLetto;
    }

    public void setPostiLetto(String postiLetto) {
        this.postiLetto = postiLetto;
    }

    public String getBagni() {
        return bagni;
    }

    public void setBagni(String bagni) {
        this.bagni = bagni;
    }

    public String getClassificazione() {
        return classificazione;
    }

    public void setClassificazione(String classificazione) {
        this.classificazione = classificazione;
    }

    public String getRistorazione() {
        return ristorazione;
    }

    public void setRistorazione(String ristorazione) {
        this.ristorazione = ristorazione;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getApprovazione() {
        return approvazione;
    }

    public void setApprovazione(String approvazione) {
        this.approvazione = approvazione;
    }
}
