package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.swagger.api.flora.Repository.MinoranzaRepository;
import io.swagger.api.flora.model.Minoranza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;

@Service
public class NoiConMolaService {
    @Autowired
    private MinoranzaRepository minoranzaRepository;

    public Minoranza save(Minoranza minoranza){
        return minoranzaRepository.save(minoranza);
    }

    public void MetodoNoiConMola() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/consiglio-comunale1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {

            String partito = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_ebXnc3wLmH19_121945\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String nominativo = ((HtmlListItem) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_ebXnc3wLmH19_121945\"]/div/div/div[2]/div[2]/ul/li")).asNormalizedText();

            Minoranza minoranza = new Minoranza();
            minoranza.setPartito(partito);
            minoranza.setNominativo(nominativo);

            minoranzaRepository.save(minoranza);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<Minoranza> findByPartito(String partito){
        return minoranzaRepository.findByPartito(partito);
    }
}

