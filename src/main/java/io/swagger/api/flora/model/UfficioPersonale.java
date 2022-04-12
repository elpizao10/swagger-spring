package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "ufficioPersonale")
public class UfficioPersonale {
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
    private String email1;
    @Field(targetType = FieldType.STRING)
    private String pec;
    @Field(targetType = FieldType.STRING)
    private String orario;
    @Field(targetType = FieldType.STRING)
    private String martedi;
    @Field(targetType = FieldType.STRING)
    private String giovedi;

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

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPec() {
        return pec;
    }

    public void setPec(String pec) {
        this.pec = pec;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getMartedi() {
        return martedi;
    }

    public void setMartedi(String martedi) {
        this.martedi = martedi;
    }

    public String getGiovedi() {
        return giovedi;
    }

    public void setGiovedi(String giovedi) {
        this.giovedi = giovedi;
    }
}
