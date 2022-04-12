package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.B_B;
import io.swagger.api.flora.Repository.B_BRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class B_BAbatangeloService {
    @Autowired
    private B_BRepository b_bRepository;

    public B_B save(B_B b_b){
        return b_bRepository.save(b_b);
    }

    public void MetodoB_BAbatangelo() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/b-b";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_ZNxovGirbCyq_\"]/div/div/div/h3")).asNormalizedText();

            Long id = 7L;
            String denominazione = "Denominazione Esercente: ABATANGELO Debora Giusy “Citofonare A.D.” S.C.I.A. N. 9673 del 04/05/2017";
            String indirizzo = "Indirizzo: Corso Umberto I, 136   1° piano";
            String contatti = "Contatti: 3493958841";
            String email = "Email: rucola.uccia@gmail.com";
            String camere = "Camere: 2";
            String postiletto = "Posti letto: 5";
            String bagni = "Bagni: 2";
            String ristorazione = "Ristorazione: ";
            String periodo = "Periodo apertura: dal 04/05 al 30/11";
            String stato = "Stato: Approvato";

            B_B b_b = new B_B();
            b_b.setId(id);
            b_b.setTitolo(titolo);
            b_b.setDenominazione(denominazione);
            b_b.setIndirizzo(indirizzo);
            b_b.setContatti(contatti);
            b_b.setEmail(email);
            b_b.setCamere(camere);
            b_b.setPostiLetto(postiletto);
            b_b.setBagni(bagni);
            b_b.setRistorazione(ristorazione);
            b_b.setPeriodo(periodo);
            b_b.setApprovazione(stato);

            b_bRepository.save(b_b);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public Optional<B_B> findById(Long id){
        return b_bRepository.findById(id);
    }
}
