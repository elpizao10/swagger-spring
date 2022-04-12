package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.UfficioTosapCosap;
import io.swagger.api.flora.Repository.UfficioTosapCosapRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UfficioTosapCosapService {
    @Autowired
    private UfficioTosapCosapRepository ufficioTosapCosapRepository;

    public UfficioTosapCosap save(UfficioTosapCosap ufficioTosapCosap){
        return ufficioTosapCosapRepository.save(ufficioTosapCosap);
    }

    public void MetodoUffTosapCosap() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/uffici-e-orari/-/asset_publisher/G0zCWqt7a2HH/content/ufficio-tosap-cosap-pubblicita-e-affisioni?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fuffici-e-orari%3Fp_p_id%3D101_INSTANCE_G0zCWqt7a2HH%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64783\"]/div/div/h1")).asNormalizedText();
            String nominativo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64783\"]/div/div/p[1]")).asNormalizedText();

            String orario = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64783\"]/div/div/h3")).asNormalizedText();
            String lunedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64783\"]/div/div/p[2]")).asNormalizedText();
            String martedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64783\"]/div/div/p[3]")).asNormalizedText();
            String mercoledi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64783\"]/div/div/p[4]")).asNormalizedText();
            String giovedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64783\"]/div/div/p[5]")).asNormalizedText();
            String venerdi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64783\"]/div/div/p[6]")).asNormalizedText();

            UfficioTosapCosap ufficioTosapCosap = new UfficioTosapCosap();
            ufficioTosapCosap.setTitolo(titolo);
            ufficioTosapCosap.setNominativo(nominativo);
            ufficioTosapCosap.setOrario(orario);
            ufficioTosapCosap.setLunedi(lunedi);
            ufficioTosapCosap.setMartedi(martedi);
            ufficioTosapCosap.setMercoledi(mercoledi);
            ufficioTosapCosap.setGiovedi(giovedi);
            ufficioTosapCosap.setVenerdi(venerdi);

            ufficioTosapCosapRepository.save(ufficioTosapCosap);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<UfficioTosapCosap> findAll(){
        return ufficioTosapCosapRepository.findAll();

    }
}
