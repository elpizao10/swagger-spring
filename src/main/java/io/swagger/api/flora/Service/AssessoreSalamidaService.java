package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.AssessoreSalamida;
import io.swagger.api.flora.Repository.AssessoreSalamidaRepository;
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
public class AssessoreSalamidaService {
    @Autowired
    private AssessoreSalamidaRepository assessoreSalamidaRepository;

    public AssessoreSalamida save(AssessoreSalamida assessoreSalamida){
        return assessoreSalamidaRepository.save(assessoreSalamida);
    }

    public void MetodoAsseSalamida() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/giunta-comunale1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String nomina = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206640\"]/div/div/div[1]/div/h1")).asNormalizedText();
            String nome = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206640\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String descrizione = ((HtmlDivision) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206640\"]/div/div/div[3]")).asNormalizedText();

            AssessoreSalamida assessoreSalamida = new AssessoreSalamida();
            assessoreSalamida.setNomina(nomina);
            assessoreSalamida.setNome(nome);
            assessoreSalamida.setDescrizione(descrizione);

            assessoreSalamidaRepository.save(assessoreSalamida);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<AssessoreSalamida> findAll(){
        return assessoreSalamidaRepository.findAll();

    }
}
