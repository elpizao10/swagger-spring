package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomText;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.swagger.api.flora.Repository.BeniCulturaliRepository;
import io.swagger.api.flora.model.BeniCulturali;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BeniCulturaliService {
    @Autowired
    private BeniCulturaliRepository beniCulturaliRepository;

    public BeniCulturali save(BeniCulturali beniCulturali){
        return beniCulturaliRepository.save(beniCulturali);
    }

    public void MetodoBeniCulturali() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/i-beni-culturali";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_kIzH0B0A671C_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
            String chiesaMatriceTesto = ((DomText) page1.getFirstByXPath("//*[@id=\"aggregatore-elenco-notizie\"]/div/div/div[1]/div[2]/div[2]/p/text()")).asNormalizedText();
            String ilCastelloAngioinoTesto = ((DomText) page1.getFirstByXPath("//*[@id=\"aggregatore-elenco-notizie\"]/div/div/div[2]/div[2]/div[2]/p/text()")).asNormalizedText();
            String teatroVanWesterhouttesto = ((DomText) page1.getFirstByXPath("//*[@id=\"aggregatore-elenco-notizie\"]/div/div/div[3]/div[2]/div[2]/p/text()")).asNormalizedText();
            String laChiesaMaddalenatesto = ((DomText) page1.getFirstByXPath("//*[@id=\"aggregatore-elenco-notizie\"]/div/div/div[4]/div[2]/div[2]/p/text()")).asNormalizedText();
            String ilPalazzoRobertitesto = ((DomText) page1.getFirstByXPath("//*[@id=\"aggregatore-elenco-notizie\"]/div/div/div[5]/div[2]/div[2]/p/text()")).asNormalizedText();

            BeniCulturali beniCulturali = new BeniCulturali();
            beniCulturali.setTitolo(titolo);
            beniCulturali.setChiesaMatriceTesto(chiesaMatriceTesto);
            beniCulturali.setIlCastelloAngioinoTesto(ilCastelloAngioinoTesto);
            beniCulturali.setTeatroVanWesterhouttesto(teatroVanWesterhouttesto);
            beniCulturali.setLaChiesaMaddalenatesto(laChiesaMaddalenatesto);
            beniCulturali.setIlPalazzoRobertitesto(ilPalazzoRobertitesto);

            beniCulturaliRepository.save(beniCulturali);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<BeniCulturali> findAll(){
        return beniCulturaliRepository.findAll();
    }
}
