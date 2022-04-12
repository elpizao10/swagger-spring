package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import io.swagger.api.flora.Repository.PersonaggiIllustriRepository;
import io.swagger.api.flora.model.PersonaggiIllustri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonaggiIllustriService {
    @Autowired
    private PersonaggiIllustriRepository personaggiIllustriRepository;

    public PersonaggiIllustri save(PersonaggiIllustri personaggiIllustri){
        return personaggiIllustriRepository.save(personaggiIllustri);
    }

    public void MetodoPersonaggiIllustri() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/personaggi-illustri";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
            String NiccolòvanWesterhout = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[2]/p[2]/strong/span")).asNormalizedText();
            String storiaNiccolò = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[2]/p[3]/text()")).asNormalizedText();


            String BrunoCalvani = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[2]/h3[1]")).asNormalizedText();
            String storiaCalvani = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[2]/p[5]")).asNormalizedText();

            String OnofrioMartinelli = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[2]/h3[2]")).asNormalizedText();
            String storiaMartinelli = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[2]/p[7]/text()")).asNormalizedText();

            String PieroDelfinoPesce = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[2]/h3[3]")).asNormalizedText();
            String storiaPesce = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nxSJntnk1LNd_\"]/div/div/div/div/div/div/div[2]/p[9]")).asNormalizedText();

            PersonaggiIllustri personaggiIllustri = new PersonaggiIllustri();
            personaggiIllustri.setTitolo(titolo);
            personaggiIllustri.setNiccolo(NiccolòvanWesterhout);
            personaggiIllustri.setNiccoloStoria(storiaNiccolò);
            personaggiIllustri.setBruno(BrunoCalvani);
            personaggiIllustri.setBrunoStoria(storiaCalvani);
            personaggiIllustri.setOnofrio(OnofrioMartinelli);
            personaggiIllustri.setOnofrioStoria(storiaMartinelli);
            personaggiIllustri.setPiero(PieroDelfinoPesce);
            personaggiIllustri.setPieroStoria(storiaPesce);

            personaggiIllustriRepository.save(personaggiIllustri);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<PersonaggiIllustri> findAll(){
        return personaggiIllustriRepository.findAll();
    }
}
