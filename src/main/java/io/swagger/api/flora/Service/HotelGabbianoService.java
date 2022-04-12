package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.Hotel;
import io.swagger.api.flora.Repository.HotelGabbianoRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HotelGabbianoService {
    @Autowired
    private HotelGabbianoRepository hotelGabbianoRepository;

    public Hotel save(Hotel hotelGabbiano){
        return hotelGabbianoRepository.save(hotelGabbiano);
    }

    public void MetodoHotelGabbiano() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/hotel";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_169_INSTANCE_mUFOIqfsATa3_\"]/div/div/div/h3")).asNormalizedText();
            String denominazione = "Denominazione Esercente: Hotel GABBIANO - Concrea 2014 s.r.l.";
            String indirizzo = "Indirizzo: Via P.D. Pesce, 24";
            String contatti = "Contatti: 080/4732331 - 080/4733441 - 3913122581 - info@hotelgabbiano.biz";
            String camere = "Camere/Appartementi: 48";
            String postiletto = "Posti letto: 75";
            String bagni = "Bagni: 48";
            String classi = "Classificazione Stelle: 3";
            String ristorazione = "Ristorazione: SI";
            String periodo = "Periodo apertura: Annuale";
            String stato = "Stato: Approvato";


            Hotel hotelGabbiano = new Hotel();
            hotelGabbiano.setTitolo(titolo);
            hotelGabbiano.setDenominazione(denominazione);
            hotelGabbiano.setIndirizzo(indirizzo);
            hotelGabbiano.setContatti(contatti);
            hotelGabbiano.setCamere(camere);
            hotelGabbiano.setPostiLetto(postiletto);
            hotelGabbiano.setBagni(bagni);
            hotelGabbiano.setClassificazione(classi);
            hotelGabbiano.setRistorazione(ristorazione);
            hotelGabbiano.setPeriodo(periodo);
            hotelGabbiano.setApprovazione(stato);

            hotelGabbianoRepository.save(hotelGabbiano);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<Hotel> findAll(){
        return hotelGabbianoRepository.findAll();

    }
}
