package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlListItem;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.swagger.api.flora.Repository.MaggioranzaRepository;
import io.swagger.api.flora.model.Maggioranza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ScelgoMolaService {
    @Autowired
    private MaggioranzaRepository maggioranzaRepository;

    public Maggioranza save(Maggioranza maggioranza){
        return maggioranzaRepository.save(maggioranza);
    }

    public void MetodoScelgoMola() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/consiglio-comunale1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String partito = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_i6Dypv6w4L3K_121164\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String nominativo1 = ((HtmlListItem) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_i6Dypv6w4L3K_121164\"]/div/div/div[2]/div[2]/ul/li[1]")).asNormalizedText();
            String nominativo2 = ((HtmlListItem) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_i6Dypv6w4L3K_121164\"]/div/div/div[2]/div[2]/ul/li[2]")).asNormalizedText();
            String nominativo3 = ((HtmlListItem) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_i6Dypv6w4L3K_121164\"]/div/div/div[2]/div[2]/ul/li[3]")).asNormalizedText();

            Maggioranza maggioranza = new Maggioranza();
            maggioranza.setPartito(partito);
            maggioranza.setNominativo1(nominativo1);
            maggioranza.setNominativo2(nominativo2);
            maggioranza.setNominativo3(nominativo3);

            maggioranzaRepository.save(maggioranza);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<Maggioranza> findByPartito(String partito){
       return maggioranzaRepository.findByPartito(partito);
    }
}
