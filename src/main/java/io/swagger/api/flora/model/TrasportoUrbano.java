package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "trasportoUrbano")
public class TrasportoUrbano {
    @Id
    private String titolo;
    @Field(targetType = FieldType.STRING)
    private String ufficio;
    @Field(targetType = FieldType.STRING)
    private String telefono;
    @Field(targetType = FieldType.STRING)
    private String orario;
    @Field(targetType = FieldType.STRING)
    private String lunedi;
    @Field(targetType = FieldType.STRING)
    private String giovedi;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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

    public String getGiovedi() {
        return giovedi;
    }

    public void setGiovedi(String giovedi) {
        this.giovedi = giovedi;
    }
}
