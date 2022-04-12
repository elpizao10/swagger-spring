package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.EdiliziaResidenzialePubblica;
import io.swagger.api.flora.Repository.EdiliziaResidenzialePubblicaRepository;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlHeading3;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EdiliziaResidenzialePubblicaService {
    @Autowired
    private EdiliziaResidenzialePubblicaRepository ediliziaResidenzialePubblicaRepository;

    public EdiliziaResidenzialePubblica save(EdiliziaResidenzialePubblica ediliziaResidenzialePubblica){
        return ediliziaResidenzialePubblicaRepository.save(ediliziaResidenzialePubblica);
    }

    public void MetodoEdiliziaResPubbli() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/uffici-e-orari/-/asset_publisher/G0zCWqt7a2HH/content/edilizia-residenziale-pubblica-e-r-p-?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fuffici-e-orari%3Fp_p_id%3D101_INSTANCE_G0zCWqt7a2HH%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65197\"]/div/div/h1")).asNormalizedText();
            String nominativo = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65197\"]/div/div/p[1]")).asNormalizedText();
            String ufficio = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65197\"]/div/div/p[2]")).asNormalizedText();
            String telefono = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65197\"]/div/div/p[3]")).asNormalizedText();
            String fax =((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65197\"]/div/div/p[4]")).asNormalizedText();

            String orario = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65197\"]/div/div/h3")).asNormalizedText();
            String martedi = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65197\"]/div/div/p[5]")).asNormalizedText();
            String giovedi = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65197\"]/div/div/p[6]")).asNormalizedText();

            EdiliziaResidenzialePubblica ediliziaResidenzialePubblica = new EdiliziaResidenzialePubblica();
            ediliziaResidenzialePubblica.setTitolo(titolo);
            ediliziaResidenzialePubblica.setNominativo(nominativo);
            ediliziaResidenzialePubblica.setUfficio(ufficio);
            ediliziaResidenzialePubblica.setTelefono(telefono);
            ediliziaResidenzialePubblica.setFax(fax);
            ediliziaResidenzialePubblica.setOrario(orario);
            ediliziaResidenzialePubblica.setMartedi(martedi);
            ediliziaResidenzialePubblica.setGiovedi(giovedi);

            ediliziaResidenzialePubblicaRepository.save(ediliziaResidenzialePubblica);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<EdiliziaResidenzialePubblica> findAll(){
        return ediliziaResidenzialePubblicaRepository.findAll();

    }
}
