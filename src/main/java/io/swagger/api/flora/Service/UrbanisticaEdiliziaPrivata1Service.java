package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.UrbanisticaEdiliziaPrivata1;
import io.swagger.api.flora.Repository.UrbanisticaEdiliziaPrivata1Repository;
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
public class UrbanisticaEdiliziaPrivata1Service {
    @Autowired
    private UrbanisticaEdiliziaPrivata1Repository urbanisticaEdiliziaPrivata1Repository;

    public UrbanisticaEdiliziaPrivata1 save(UrbanisticaEdiliziaPrivata1 urbanisticaEdiliziaPrivata1){
        return urbanisticaEdiliziaPrivata1Repository.save(urbanisticaEdiliziaPrivata1);
    }

    public void MetodoUrbanisticaEdilPrivata() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/uffici-e-orari/-/asset_publisher/G0zCWqt7a2HH/content/urbanistica-edilizia-privata?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fuffici-e-orari%3Fp_p_id%3D101_INSTANCE_G0zCWqt7a2HH%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65182\"]/div/div/h1")).asNormalizedText();
            String nominativo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65182\"]/div/div/p[1]")).asNormalizedText();
            String ufficio = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65182\"]/div/div/p[2]")).asNormalizedText();
            String telefono = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65182\"]/div/div/p[3]")).asNormalizedText();
            String fax = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65182\"]/div/div/p[4]")).asNormalizedText();

            String orario = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65182\"]/div/div/h3")).asNormalizedText();
            String martedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65182\"]/div/div/p[5]")).asNormalizedText();
            String giovedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65182\"]/div/div/p[6]")).asNormalizedText();

            UrbanisticaEdiliziaPrivata1 urbanisticaEdiliziaPrivata1 = new UrbanisticaEdiliziaPrivata1();
            urbanisticaEdiliziaPrivata1.setTitolo(titolo);
            urbanisticaEdiliziaPrivata1.setNominativo(nominativo);
            urbanisticaEdiliziaPrivata1.setUfficio(ufficio);
            urbanisticaEdiliziaPrivata1.setTelefono(telefono);
            urbanisticaEdiliziaPrivata1.setFax(fax);
            urbanisticaEdiliziaPrivata1.setOrario(orario);
            urbanisticaEdiliziaPrivata1.setMartedi(martedi);
            urbanisticaEdiliziaPrivata1.setGiovedi(giovedi);

            urbanisticaEdiliziaPrivata1Repository.save(urbanisticaEdiliziaPrivata1);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<UrbanisticaEdiliziaPrivata1> findAll(){
        return urbanisticaEdiliziaPrivata1Repository.findAll();

    }
}
