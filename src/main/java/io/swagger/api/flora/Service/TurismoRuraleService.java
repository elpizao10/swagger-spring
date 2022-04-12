package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.TurismoRurale;
import io.swagger.api.flora.Repository.TurismoRuraleRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TurismoRuraleService {
    @Autowired
    private TurismoRuraleRepository turismoRuraleRepository;

    public TurismoRurale save(TurismoRurale turismoRurale){
        return turismoRuraleRepository.save(turismoRurale);
    }

    public void MetodoTurismoRusarel() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/turismo-rurale";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_9gPhMv2Eh8O2_\"]/div/div/div/h3")).asNormalizedText();
            String denominazione = "Denominazione Esercente: PLENILUNIO ALLA FORTEZZA Pedone Ferdinando";
            String indirizzo = "Indirizzo: Contrada S. Egidio s.n.";
            String contatti = "Contatti: ";
            String camere = "Camere/Appartamenti: 2";
            String postiletto = "Posti letto: 4";
            String bagni = "Bagni: ";
            String classi = "Classificazione Stelle: 2";
            String ristorazione = "Ristorazione: SI";
            String periodo = "Periodo apertura: ";
            String stato = "Stato: Approvato";

            TurismoRurale turismoRurale = new TurismoRurale();
            turismoRurale.setTitolo(titolo);
            turismoRurale.setDenominazione(denominazione);
            turismoRurale.setIndirizzo(indirizzo);
            turismoRurale.setContatti(contatti);
            turismoRurale.setCamere(camere);
            turismoRurale.setPostiLetto(postiletto);
            turismoRurale.setBagni(bagni);
            turismoRurale.setClassificazione(classi);
            turismoRurale.setRistorazione(ristorazione);
            turismoRurale.setPeriodo(periodo);
            turismoRurale.setApprovazione(stato);

            turismoRuraleRepository.save(turismoRurale);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<TurismoRurale> findAll(){
        return turismoRuraleRepository.findAll();

    }
}
