package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.UfficioNotifichePubblicazioni;
import io.swagger.api.flora.Repository.UfficioNotifichePubblicazioniRepository;
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
public class UfficioNotifichePubblicazioniService {
    @Autowired
    private UfficioNotifichePubblicazioniRepository ufficioNotifichePubblicazioniRepository;

    public UfficioNotifichePubblicazioni save(UfficioNotifichePubblicazioni ufficioNotifichePubblicazioni){
        return ufficioNotifichePubblicazioniRepository.save(ufficioNotifichePubblicazioni);
    }

    public void MetodoUffNotifichePubbli() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/uffici-e-orari/-/asset_publisher/G0zCWqt7a2HH/content/uffico-per-le-relazioni-con-il-pubblico?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fuffici-e-orari%3Fp_p_id%3D101_INSTANCE_G0zCWqt7a2HH%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_101_INSTANCE_G0zCWqt7a2HH_advancedSearch%3Dfalse%26_101_INSTANCE_G0zCWqt7a2HH_keywords%3D%26_101_INSTANCE_G0zCWqt7a2HH_delta%3D50%26p_r_p_564233524_resetCur%3Dfalse%26_101_INSTANCE_G0zCWqt7a2HH_cur%3D2%26_101_INSTANCE_G0zCWqt7a2HH_andOperator%3Dtrue";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/h1")).asNormalizedText();
            String nominativo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[1]")).asNormalizedText();
            String ufficio = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[2]")).asNormalizedText();
            String telefono = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[3]")).asNormalizedText();
            String email = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[4]")).asNormalizedText();

            String orario = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/h3")).asNormalizedText();
            String lunedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[5]")).asNormalizedText();
            String martedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[6]")).asNormalizedText();
            String mercoledi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[7]")).asNormalizedText();
            String giovedi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[8]")).asNormalizedText();
            String venerdi = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64575\"]/div/div/p[9]")).asNormalizedText();

            UfficioNotifichePubblicazioni ufficioNotifichePubblicazioni = new UfficioNotifichePubblicazioni();
            ufficioNotifichePubblicazioni.setTitolo(titolo);
            ufficioNotifichePubblicazioni.setNominativo(nominativo);
            ufficioNotifichePubblicazioni.setUfficio(ufficio);
            ufficioNotifichePubblicazioni.setTelefono(telefono);
            ufficioNotifichePubblicazioni.setEmail(email);
            ufficioNotifichePubblicazioni.setOrario(orario);
            ufficioNotifichePubblicazioni.setLunedi(lunedi);
            ufficioNotifichePubblicazioni.setMartedi(martedi);
            ufficioNotifichePubblicazioni.setMercoledi(mercoledi);
            ufficioNotifichePubblicazioni.setGiovedi(giovedi);
            ufficioNotifichePubblicazioni.setVenerdi(venerdi);

            ufficioNotifichePubblicazioniRepository.save(ufficioNotifichePubblicazioni);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<UfficioNotifichePubblicazioni> findAll(){
        return ufficioNotifichePubblicazioniRepository.findAll();

    }
}
