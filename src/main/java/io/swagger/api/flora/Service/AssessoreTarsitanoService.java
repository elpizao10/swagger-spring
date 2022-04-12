package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.AssessoreTarsitano;
import io.swagger.api.flora.Repository.AssessoreTarsitanoRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AssessoreTarsitanoService {
    @Autowired
    private AssessoreTarsitanoRepository assessoreTarsitanoRepository;

    public AssessoreTarsitano save(AssessoreTarsitano assessoreTarsitano){
        return assessoreTarsitanoRepository.save(assessoreTarsitano);
    }

    public void MetodoAssTarsitano() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/giunta-comunale1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String nomina = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206650\"]/div/div/div[1]/div/h1")).asNormalizedText();
            String nome = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206650\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String email = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206650\"]/div/div/div[2]/div[2]/p")).asNormalizedText();
            String descrizione = ((HtmlDivision) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206650\"]/div/div/div[3]")).asNormalizedText();

            AssessoreTarsitano assessoreTarsitano = new AssessoreTarsitano();
            assessoreTarsitano.setNomina(nomina);
            assessoreTarsitano.setNome(nome);
            assessoreTarsitano.setEmail(email);
            assessoreTarsitano.setDescrizione(descrizione);

            assessoreTarsitanoRepository.save(assessoreTarsitano);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<AssessoreTarsitano> findAll(){
        return assessoreTarsitanoRepository.findAll();
    }
}
