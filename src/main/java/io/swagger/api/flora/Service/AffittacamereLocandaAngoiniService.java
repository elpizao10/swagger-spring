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
public class AffittacamereLocandaAngoiniService {
    @Autowired
    private AffittacamereRepository affittacamereRepository;

    public Affittacamere save(Affittacamere affittacamere){
        return affittacamereRepository.save(affittacamere);
    }

    public void MetodoAffLocandaAngoini() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/affittacamere";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_rrklMm0MelyU_\"]/div/div/div/h3")).asNormalizedText();

            Long id = 5L;
            String denominazione = "Denominazione Esercente: Affittacamere LOCANDA degli ANGIOINI Rotondi Pasqua S.C.I.A. n. 16340 del 03/07/2015";
            String indirizzo = "Indirizzo: Via Castello n. 27 1° e 2° piano";
            String contatti = "Contatti: 3496339956";
            String camere = "Camere: 4";
            String postiletto = "Posti letto: 12";
            String bagni = "Bagni: 4";
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
