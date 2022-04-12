package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import io.swagger.api.flora.model.Affittacamere;
import io.swagger.api.flora.Repository.AffittacamereRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AffittacamereDamare1Service {
    @Autowired
    private AffittacamereRepository affittacamereRepository;

    public Affittacamere save(Affittacamere affittacamere){
        return affittacamereRepository.save(affittacamere);
    }

    public void MetodoAffDamare1() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/affittacamere";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_rrklMm0MelyU_\"]/div/div/div/h3")).asNormalizedText();

            Long id = 4L;
            String denominazione = "Denominazione Esercente: Affittacamere CASADAMARE Conenna Maria S.C.I.A. n. 13892 del 21/06/2017";
            String indirizzo = "Indirizzo: Via G. Bovio n. 62-64-66 Piano terra 1° e 2°";
            String contatti = "Contatti: 3292929035";
            String camere = "Camere: 5";
            String postiletto = "Posti letto: 10";
            String bagni = "Bagni: 5";
            String ristorazione = "Ristorazione: no";
            String periodo = "Periodo apertura: Annuale";
            String stato = "Stato: Approvato";

            Affittacamere affittacamere = new Affittacamere();
            affittacamere.setId(id);
            affittacamere.setTitolo(titolo);
            affittacamere.setDenominazione(denominazione);
            affittacamere.setIndirizzo(indirizzo);
            affittacamere.setContatti(contatti);
            affittacamere.setCamere(camere);
            affittacamere.setPostiLetto(postiletto);
            affittacamere.setBagni(bagni);
            affittacamere.setRistorazione(ristorazione);
            affittacamere.setPeriodo(periodo);
            affittacamere.setApprovazione(stato);

            affittacamereRepository.save(affittacamere);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }
    public Optional<Affittacamere> findById(Long id){
        return affittacamereRepository.findById(id);
    }

}
