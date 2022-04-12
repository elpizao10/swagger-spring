package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.AssessoreDituri;
import io.swagger.api.flora.Repository.AssessoreDituriRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AssessoreDituriService {
    @Autowired
    private AssessoreDituriRepository assessoreDituriRepository;

    public AssessoreDituri save(AssessoreDituri assessoreDituri){
        return assessoreDituriRepository.save(assessoreDituri);
    }

    public void MetodoAssDituri() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/giunta-comunale1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String nomina = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206679\"]/div/div/div[1]/div/h1")).asNormalizedText();
            String nome = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206679\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String descrizione = ((HtmlDivision) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206679\"]/div/div/div[3]")).asNormalizedText();

            AssessoreDituri assessoreDituri = new AssessoreDituri();
            assessoreDituri.setNomina(nomina);
            assessoreDituri.setNome(nome);
            assessoreDituri.setDescrizione(descrizione);

            assessoreDituriRepository.save(assessoreDituri);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<AssessoreDituri> findAll(){
        return assessoreDituriRepository.findAll();
    }
}
