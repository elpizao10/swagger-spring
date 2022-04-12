package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.Sindaco;
import io.swagger.api.flora.Repository.SindacoRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SindacoService {
    @Autowired
    private SindacoRepository sindacoRepository;

    public Sindaco save(Sindaco sindaco) {
        return sindacoRepository.save(sindaco);
    }

    public void MetodoSindaco() throws IOException {
        String BASE_URL = "https://www.comune.moladibari.ba.it/giunta-comunale1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String nomina = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121591\"]/div/div/div[1]/div/h1")).asNormalizedText();
            String nome = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121591\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String ufficio = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121591\"]/div/div/div[2]/div[2]/p[1]")).asNormalizedText();
            String email = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_121591\"]/div/div/div[2]/div[2]/p[2]")).asNormalizedText();

            Sindaco sindaco = new Sindaco();
            sindaco.setNomina(nomina);
            sindaco.setNome(nome);
            sindaco.setUfficio(ufficio);
            sindaco.setEmail(email);

            sindacoRepository.save(sindaco);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<Sindaco> findAll(){
        return sindacoRepository.findAll();

    }
}
