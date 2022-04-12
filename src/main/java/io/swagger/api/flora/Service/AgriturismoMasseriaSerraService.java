package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.Affittacamere;
import io.swagger.api.flora.model.Agriturismo;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.swagger.api.flora.Repository.AgriturismoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@Service
public class AgriturismoMasseriaSerraService {
    @Autowired
    private AgriturismoRepository agriturismoRepository;

    public Agriturismo save(Agriturismo agriturismo){
        return agriturismoRepository.save(agriturismo);
    }

    public void MetodoAgriMasseriaSerra() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/agriturismo";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_SYNpKaaL6bOM_\"]/div/div/div/h3")).asNormalizedText();
            Long id = 2L;
            String denominazione = "Denominazione Esercente: MASSERIA SERRA DELL’ISOLA  Az. Agrituristica  -  Guastamacchia Rita";
            String indirizzo = "Indirizzo: S.P. 165 Mola-Conversano, 35";
            String contatti = "Contatti: 3495311256";
            String camere = "Camere/Appartamenti: ";
            String postiletto = "Posti letto: 10";
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
