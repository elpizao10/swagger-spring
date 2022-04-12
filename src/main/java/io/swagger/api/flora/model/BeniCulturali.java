package io.swagger.api.flora.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "beniCulturali")
public class BeniCulturali {
    @Id
    private String titolo;
    @Field(targetType = FieldType.STRING)
    private String chiesaMatriceTesto;
    @Field(targetType = FieldType.STRING)
    private String ilCastelloAngioinoTesto;
    @Field(targetType = FieldType.STRING)
    private String teatroVanWesterhouttesto;
    @Field(targetType = FieldType.STRING)
    private String laChiesaMaddalenatesto;
    @Field(targetType = FieldType.STRING)
    private String ilPalazzoRobertitesto;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getChiesaMatriceTesto() {
        return chiesaMatriceTesto;
    }

    public void setChiesaMatriceTesto(String chiesaMatriceTesto) {
        this.chiesaMatriceTesto = chiesaMatriceTesto;
    }

    public String getIlCastelloAngioinoTesto() {
        return ilCastelloAngioinoTesto;
    }

    public void setIlCastelloAngioinoTesto(String ilCastelloAngioinoTesto) {
        this.ilCastelloAngioinoTesto = ilCastelloAngioinoTesto;
    }

    public String getTeatroVanWesterhouttesto() {
        return teatroVanWesterhouttesto;
    }

    public void setTeatroVanWesterhouttesto(String teatroVanWesterhouttesto) {
        this.teatroVanWesterhouttesto = teatroVanWesterhouttesto;
    }

    public String getLaChiesaMaddalenatesto() {
        return laChiesaMaddalenatesto;
    }

    public void setLaChiesaMaddalenatesto(String laChiesaMaddalenatesto) {
        this.laChiesaMaddalenatesto = laChiesaMaddalenatesto;
    }

    public String getIlPalazzoRobertitesto() {
        return ilPalazzoRobertitesto;
    }

    public void setIlPalazzoRobertitesto(String ilPalazzoRobertitesto) {
        this.ilPalazzoRobertitesto = ilPalazzoRobertitesto;
    }
}
