package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.Agriturismo;
import io.swagger.api.flora.Repository.AgriturismoRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AgriturismoTerramareService {
    @Autowired
    private AgriturismoRepository agriturismoRepository;

    public Agriturismo save(Agriturismo agriturismo){
        return agriturismoRepository.save(agriturismo);
    }

    public void MetodoAgriTerramare() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/agriturismo";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_SYNpKaaL6bOM_\"]/div/div/div/h3")).asNormalizedText();
            Long id = 1L;
            String denominazione = "Denominazione Esercente: TERRAMARE BIO Az. Agrituristica  -  Aquaro Maria";
            String indirizzo = "Indirizzo: Strada comunale Tre Fulturi, 22";
            String contatti = "Contatti: ";
            String camere = "Camere/Appartamenti: ";
            String postiletto = "Posti letto: ";
            String bagni = "Bagni: ";
            String classi = "Classificazione Stelle: ";
            String ristorazione = "Ristorazione: SI";
            String periodo = "Periodo apertura: Annuale";
            String stato = "Stato: Approvato";

            Agriturismo agriturismo = new Agriturismo();
            agriturismo.setId(id);
            agriturismo.setTitolo(titolo);
            agriturismo.setDenominazione(denominazione);
            agriturismo.setIndirizzo(indirizzo);
            agriturismo.setContatti(contatti);
            agriturismo.setCamere(camere);
            agriturismo.setPostiLetto(postiletto);
            agriturismo.setBagni(bagni);
            agriturismo.setClassificazione(classi);
            agriturismo.setRistorazione(ristorazione);
            agriturismo.setPeriodo(periodo);
            agriturismo.setApprovazione(stato);

            agriturismoRepository.save(agriturismo);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public Optional<Agriturismo> findById(Long id){
        return agriturismoRepository.findById(id);
    }
}
