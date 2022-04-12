package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.AssessoreBerlen;
import io.swagger.api.flora.Repository.AssessoreBerlenRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AssessoreBerlenService {
    @Autowired
    private AssessoreBerlenRepository assessoreBerlenRepository;

    public AssessoreBerlen save(AssessoreBerlen assessoreBerlen){
        return assessoreBerlenRepository.save(assessoreBerlen);
    }

    public void MetodoAssBerlen() throws IOException {
        String BASE_URL = "https://www.comune.moladibari.ba.it/giunta-comunale1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String nomina = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121761\"]/div/div/div[1]/div/h1")).asNormalizedText();
            String nome = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121761\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String email = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121761\"]/div/div/div[2]/div/p")).asNormalizedText();
            String mandate = ((HtmlDivision) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121761\"]/div/div/div[3]")).asNormalizedText();
            String descrizione = ((HtmlDivision) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121761\"]/div/div/div[4]")).asNormalizedText();

            AssessoreBerlen assessoreBerlen = new AssessoreBerlen();
            assessoreBerlen.setNomina(nomina);
            assessoreBerlen.setNome(nome);
            assessoreBerlen.setEmail(email);
            assessoreBerlen.setMandate(mandate);
            assessoreBerlen.setDescrizione(descrizione);

            assessoreBerlenRepository.save(assessoreBerlen);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<AssessoreBerlen> findAll(){
        return assessoreBerlenRepository.findAll();
    }
}
