package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import io.swagger.api.flora.Repository.StruttureSportiveRepository;
import io.swagger.api.flora.model.StruttureSportive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class StruttureSportiveService {
    @Autowired
    private StruttureSportiveRepository struttureSportiveRepository;

    public StruttureSportive save(StruttureSportive struttureSportive){
        return struttureSportiveRepository.save(struttureSportive);
    }

    public void MetodoStruttureSportive() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/utilizzo-strutture-sportive-comunali-palestre-e-aule-scolastiche1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        try {
            HtmlPage page1 = client.getPage(BASE_URL);

            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_Wy76sRQaOpn5_\"]/div/div/div[1]/div/div/div/div[1]/h1")).asNormalizedText();
            String nominativo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_Wy76sRQaOpn5_\"]/div/div/div[1]/div/div/div/div[2]/p[2]")).asNormalizedText();
            String telefono = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_Wy76sRQaOpn5_\"]/div/div/div[1]/div/div/div/div[2]/p[3]")).asNormalizedText();
            String email = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_Wy76sRQaOpn5_\"]/div/div/div[1]/div/div/div/div[2]/p[4]")).asNormalizedText();
            String orari = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_Wy76sRQaOpn5_\"]/div/div/div[1]/div/div/div/div[2]/p[5]")).asNormalizedText();
            String documenti = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_Wy76sRQaOpn5_\"]/div/div/div[1]/div/div/div/div[3]/h3")).asNormalizedText();

            StruttureSportive struttureSportive = new StruttureSportive();
            struttureSportive.setTitolo(titolo);
            struttureSportive.setNominativo(nominativo);
            struttureSportive.setTelefono(telefono);
            struttureSportive.setEmail(email);
            struttureSportive.setOrari(orari);
            struttureSportive.setDodumenti(documenti);

            struttureSportiveRepository.save(struttureSportive);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<StruttureSportive> findAll(){
        return struttureSportiveRepository.findAll();
    }
}
