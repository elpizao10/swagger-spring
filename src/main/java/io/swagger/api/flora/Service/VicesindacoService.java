package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.Vicesindaco;
import io.swagger.api.flora.Repository.VicesindacoRepository;
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
public class VicesindacoService {
    @Autowired
    private VicesindacoRepository vicesindacoRepository;

    public Vicesindaco save(Vicesindaco vicesindaco){
        return vicesindacoRepository.save(vicesindaco);
    }

    public void MetodoVicesindaco() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/giunta-comunale1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String nomina = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206573\"]/div/div/div[1]/div/h1")).asNormalizedText();
            String nome = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206573\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String mandate = ((HtmlDivision) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206573\"]/div/div/div[3]")).asNormalizedText();
            String descrizione = ((HtmlDivision) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_aXxV5x6I4Paz_206573\"]/div/div/div[4]")).asNormalizedText();

            Vicesindaco vicesindaco = new Vicesindaco();
            vicesindaco.setNomima(nomina);
            vicesindaco.setNome(nome);
            vicesindaco.setMandate(mandate);
            vicesindaco.setDescrizione(descrizione);

            vicesindacoRepository.save(vicesindaco);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<Vicesindaco> findAll(){
        return vicesindacoRepository.findAll();

    }
}
