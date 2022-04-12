package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.swagger.api.flora.model.Campeggio;
import io.swagger.api.flora.model.CaseEappartamenti;
import io.swagger.api.flora.Repository.CaseEappartamentiRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CaseEappartamentiBellaPuglia1Service {
    @Autowired
    private CaseEappartamentiRepository caseEappartamentiRepository;

    public CaseEappartamenti save(CaseEappartamenti caseEappartamenti){
        return caseEappartamentiRepository.save(caseEappartamenti);
    }

    public void MetodoCaseAppartamentiBellaPuglia2() throws IOException {
        String BASE_URL = "https://www.comune.moladibari.ba.it/case-e-appartamenti-per-vacanze";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            Long id = 2L;
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_mtCajA6l7eAM_\"]/div/div/div/h3")).asNormalizedText();
            String denominazione = "Denominazione Esercente: BELLA PUGLIA Annio Orsola";
            String indirizzo = "Indirizzo: Via Castello, 6 1° piano";
            String contatti = "Contatti: 3393416110";
            String camere = "Camere/Appartementi: 1";
            String postiletto = "Posti letto: 6";
            String bagni = "Bagni: 1";
            String classi = "Classificazione Stelle: ";
            String ristorazione = "Ristorazione: ";
            String periodo = "Periodo apertura: Annuale";
            String stato = "Stato: Approvato";

            CaseEappartamenti caseEappartamenti = new CaseEappartamenti();
            caseEappartamenti.setId(id);
            caseEappartamenti.setTitolo(titolo);
            caseEappartamenti.setDenominazione(denominazione);
            caseEappartamenti.setIndirizzo(indirizzo);
            caseEappartamenti.setContatti(contatti);
            caseEappartamenti.setCamere(camere);
            caseEappartamenti.setPostiLetto(postiletto);
            caseEappartamenti.setBagni(bagni);
            caseEappartamenti.setClassificazione(classi);
            caseEappartamenti.setRistorazione(ristorazione);
            caseEappartamenti.setPeriodo(periodo);
            caseEappartamenti.setApprovazione(stato);

            caseEappartamentiRepository.save(caseEappartamenti);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }



    public Optional<CaseEappartamenti> findById(Long id){

        return caseEappartamentiRepository.findById(id);
    }

}
