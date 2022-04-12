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
public class B_BDePalmaService {
    @Autowired
    private B_BRepository b_bRepository;

    public B_B save(B_B b_b){
        return b_bRepository.save(b_b);
    }

    public void MetodoB_BDePalma() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/b-b";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_ZNxovGirbCyq_\"]/div/div/div/h3")).asNormalizedText();

            Long id = 13L;
            String denominazione = "Denominazione Esercente: DE PALMA Filomena “Doña  Flor” D.I.A. n.19494 del 08/11/2005";
            String indirizzo = "Indirizzo: Via R. Sanzio, 7 p. terra";
            String contatti = "Contatti: 0804743319";
            String email = "Email: info@dona-flor.it";
            String camere = "Camere: 2";
            String postiletto = "Posti letto: 6";
            String bagni = "Bagni: 1";
            String ristorazione = "Ristorazione: ";
            String periodo = "Periodo apertura: dal  07/03  al 31/10,  dal  01/12  al 31/12";
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
        }
    }

    public Optional<B_B> findById(Long id){
        return b_bRepository.findById(id);
    }
}
