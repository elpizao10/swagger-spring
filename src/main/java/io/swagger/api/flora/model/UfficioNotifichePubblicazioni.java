package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "ufficioNotifichePubblicazioni")
public class UfficioNotifichePubblicazioni {
    @Id
    private String titolo;
    @Field(targetType = FieldType.STRING)
    private String nominativo;
    @Field(targetType = FieldType.STRING)
    private String ufficio;
    @Field(targetType = FieldType.STRING)
    private String telefono;
    @Field(targetType = FieldType.STRING)
    private String email;
    @Field(targetType = FieldType.STRING)
    private String orario;
    @Field(targetType = FieldType.STRING)
    private String lunedi;
    @Field(targetType = FieldType.STRING)
    private String martedi;
    @Field(targetType = FieldType.STRING)
    private String mercoledi;
    @Field(targetType = FieldType.STRING)
    private String giovedi;
    @Field(targetType = FieldType.STRING)
    private String venerdi;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getUfficio() {
        return ufficio;
    }

    public void setUfficio(String ufficio) {
        this.ufficio = ufficio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getLunedi() {
        return lunedi;
    }

    public void setLunedi(String lunedi) {
        this.lunedi = lunedi;
    }

    public String getMartedi() {
        return martedi;
    }

    public void setMartedi(String martedi) {
        this.martedi = martedi;
    }

    public String getMercoledi() {
        return mercoledi;
    }

    public void setMercoledi(String mercoledi) {
        this.mercoledi = mercoledi;
    }

    public String getGiovedi() {
        return giovedi;
    }

    public void setGiovedi(String giovedi) {
        this.giovedi = giovedi;
    }

    public String getVenerdi() {
        return venerdi;
    }

    public void setVenerdi(String venerdi) {
        this.venerdi = venerdi;
    }
}
