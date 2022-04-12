package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.UfficioStaffSindaco;
import io.swagger.api.flora.Repository.UfficioStaffSindacoRepository;
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
public class UfficioStaffSindacoService {
    @Autowired
    private UfficioStaffSindacoRepository ufficioStaffSindacoRepository;

    public UfficioStaffSindaco save(UfficioStaffSindaco ufficioStaffSindaco){
        return ufficioStaffSindacoRepository.save(ufficioStaffSindaco);
    }

    public void MetodoUffStaffSindaco() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/segreteria-del-sindaco";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);
        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_h3nFo97JR07m_163518\"]/div/div/div[1]/div/h1")).asNormalizedText();
            String nominativo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_h3nFo97JR07m_163518\"]/div/div/div[1]/div/h3")).asNormalizedText();
            String telefono = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_h3nFo97JR07m_163518\"]/div/div/div[2]/div/p[1]")).asNormalizedText();
            String email = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_h3nFo97JR07m_163518\"]/div/div/div[2]/div/p[2]")).asNormalizedText();

            UfficioStaffSindaco ufficioStaffSindaco = new UfficioStaffSindaco();
            ufficioStaffSindaco.setTitolo(titolo);
            ufficioStaffSindaco.setNominativo(nominativo);
            ufficioStaffSindaco.setTelefono(telefono);
            ufficioStaffSindaco.setEmail(email);

            ufficioStaffSindacoRepository.save(ufficioStaffSindaco);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<UfficioStaffSindaco> findAll(){
        return ufficioStaffSindacoRepository.findAll();

    }
}
