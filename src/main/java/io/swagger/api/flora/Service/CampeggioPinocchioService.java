package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import io.swagger.api.flora.model.Campeggio;
import io.swagger.api.flora.Repository.CampeggioRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CampeggioPinocchioService {
    @Autowired
    private CampeggioRepository campeggioRepository;

    public Campeggio save(Campeggio campeggio){
        return campeggioRepository.save(campeggio);
    }

    public void MetodoCampPinocchio() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/campeggio";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_LVYxDVpcuJWf_\"]/div/div/div/h3")).asNormalizedText();
            Long id = 2L;
            String denominazione = "Denominazione Esercente: Campeggio / mini area  sosta “PINOCCHIO";
            String indirizzo = "Indirizzo: SS 16 Km 819-219 complanare est per Bari, 21";
            String contatti = "Contatti: ";
            String camere = "Camere/Appartamenti: 48";
            String postiletto = "Posti letto: 250";
            String bagni = "Bagni: ";
            String classi = "Classificazione Stelle: 1";
            String ristorazione = "Ristorazione: SI";
            String periodo = "Periodo apertura: Annuale";
            String stato = "Stato: Approvato";

            Campeggio campeggio = new Campeggio();
            campeggio.setId(id);
            campeggio.setTitolo(titolo);
            campeggio.setDenominazione(denominazione);
            campeggio.setIndirizzo(indirizzo);
            campeggio.setContatti(contatti);
            campeggio.setCamere(camere);
            campeggio.setPostiLetto(postiletto);
            campeggio.setBagni(bagni);
            campeggio.setClassificazione(classi);
            campeggio.setRistorazione(ristorazione);
            campeggio.setPeriodo(periodo);
            campeggio.setApprovazione(stato);

            campeggioRepository.save(campeggio);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }



    public Optional<Campeggio> findById(Long id){
        return campeggioRepository.findById(id);
    }
}
