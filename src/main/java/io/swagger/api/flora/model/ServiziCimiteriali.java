package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "serviziCimiteriali")
public class ServiziCimiteriali {
    @Id
    private String titolo;
    @Field(targetType = FieldType.STRING)
    private String orari;
    @Field(targetType = FieldType.STRING)
    private String inverno;
    @Field(targetType = FieldType.STRING)
    private String orariinverno;
    @Field(targetType = FieldType.STRING)
    private String festiviinv;
    @Field(targetType = FieldType.STRING)
    private String estivo;
    @Field(targetType = FieldType.STRING)
    private String orariestivo;
    @Field(targetType = FieldType.STRING)
    private String festiviest;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getOrari() {
        return orari;
    }

    public void setOrari(String orari) {
        this.orari = orari;
    }

    public String getInverno() {
        return inverno;
    }

    public void setInverno(String inverno) {
        this.inverno = inverno;
    }

    public String getOrariinverno() {
        return orariinverno;
    }

    public void setOrariinverno(String orariinverno) {
        this.orariinverno = orariinverno;
    }

    public String getFestiviinv() {
        return festiviinv;
    }

    public void setFestiviinv(String festiviinv) {
        this.festiviinv = festiviinv;
    }

    public String getEstivo() {
        return estivo;
    }

    public void setEstivo(String estivo) {
        this.estivo = estivo;
    }

    public String getOrariestivo() {
        return orariestivo;
    }

    public void setOrariestivo(String orariestivo) {
        this.orariestivo = orariestivo;
    }

    public String getFestiviest() {
        return festiviest;
    }

    public void setFestiviest(String festiviest) {
        this.festiviest = festiviest;
    }
}
