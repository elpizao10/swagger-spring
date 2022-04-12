package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.ServizioSegretariatoSociale;
import io.swagger.api.flora.Repository.ServizioSegretariatoSocialeRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlParagraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ServizioSegretariatoSocialeService {
    @Autowired
    private ServizioSegretariatoSocialeRepository servizioSegretariatoSocialeRepository;

    public ServizioSegretariatoSociale save (ServizioSegretariatoSociale servizioSegretariatoSociale){
        return servizioSegretariatoSocialeRepository.save(servizioSegretariatoSociale);
    }

    public void MetodoServizioSegrSociale() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/uffici-e-orari/-/asset_publisher/G0zCWqt7a2HH/content/servizio-di-segretariato-sociale?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fuffici-e-orari%3Fp_p_id%3D101_INSTANCE_G0zCWqt7a2HH%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64794\"]/div/div/h1")).asNormalizedText();
            String nominativo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64794\"]/div/div/p[1]")).asNormalizedText();
            String ufficio = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64794\"]/div/div/p[2]")).asNormalizedText();
            String telefono = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64794\"]/div/div/p[3]")).asNormalizedText();
            String email =((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64794\"]/div/div/p[4]")).asNormalizedText();
            String pec =((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64794\"]/div/div/p[5]")).asNormalizedText();

            ServizioSegretariatoSociale servizioSegretariatoSociale = new ServizioSegretariatoSociale();
            servizioSegretariatoSociale.setTitolo(titolo);
            servizioSegretariatoSociale.setNominativo(nominativo);
            servizioSegretariatoSociale.setUfficio(ufficio);
            servizioSegretariatoSociale.setTelefono(telefono);
            servizioSegretariatoSociale.setEmail(email);
            servizioSegretariatoSociale.setPec(pec);

            servizioSegretariatoSocialeRepository.save(servizioSegretariatoSociale);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<ServizioSegretariatoSociale> findAll(){
        return servizioSegretariatoSocialeRepository.findAll();

    }
}
