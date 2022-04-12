package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.ServizioAnagrafe;
import io.swagger.api.flora.Repository.ServizioAnagrafeRepository;
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
public class ServizioAnagrafeService {
    @Autowired
    private ServizioAnagrafeRepository servizioAnagrafeRepository;

    public ServizioAnagrafe save(ServizioAnagrafe servizioAnagrafe){
        return servizioAnagrafeRepository.save(servizioAnagrafe);
    }

    public void MetodoServizioAnagrafe() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/uffici-e-orari/-/asset_publisher/G0zCWqt7a2HH/content/servizio-anagrafe?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fuffici-e-orari%3Fp_p_id%3D101_INSTANCE_G0zCWqt7a2HH%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_101_INSTANCE_G0zCWqt7a2HH_advancedSearch%3Dfalse%26_101_INSTANCE_G0zCWqt7a2HH_keywords%3D%26_101_INSTANCE_G0zCWqt7a2HH_delta%3D50%26p_r_p_564233524_resetCur%3Dfalse%26_101_INSTANCE_G0zCWqt7a2HH_cur%3D2%26_101_INSTANCE_G0zCWqt7a2HH_andOperator%3Dtrue";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/h1")).asNormalizedText();
            String nominativo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[1]")).asNormalizedText();
            String telefono = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[2]")).asNormalizedText();
            String email =((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[3]")).asNormalizedText();
            String pec =((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[4]")).asNormalizedText();

            String orario = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/h3")).asNormalizedText();
            String lunedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[5]")).asNormalizedText();
            String martedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[6]")).asNormalizedText();
            String mercoledi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[7]")).asNormalizedText();
            String giovedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[8]")).asNormalizedText();
            String venerdi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64587\"]/div/div/p[9]")).asNormalizedText();

            ServizioAnagrafe servizioAnagrafe = new ServizioAnagrafe();
            servizioAnagrafe.setTitolo(titolo);
            servizioAnagrafe.setNominativo(nominativo);
            servizioAnagrafe.setTelefono(telefono);
            servizioAnagrafe.setEmail(email);
            servizioAnagrafe.setPec(pec);
            servizioAnagrafe.setOrario(orario);
            servizioAnagrafe.setLunedi(lunedi);
            servizioAnagrafe.setMartedi(martedi);
            servizioAnagrafe.setMercoledi(mercoledi);
            servizioAnagrafe.setGiovedi(giovedi);
            servizioAnagrafe.setVenerdi(venerdi);

            servizioAnagrafeRepository.save(servizioAnagrafe);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<ServizioAnagrafe> findAll(){
        return servizioAnagrafeRepository.findAll();

    }
}
