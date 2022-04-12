package io.swagger.api.flora.Service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import io.swagger.api.flora.Repository.AssistenzaEducativaRepository;
import io.swagger.api.flora.model.AssistenzaEducativa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class AssistenzaEducativaService {
    @Autowired
    private AssistenzaEducativaRepository assistenzaEducativaRepository;

    public AssistenzaEducativa save(AssistenzaEducativa assistenzaEducativa){
        return assistenzaEducativaRepository.save(assistenzaEducativa);
    }

    public void MetodoAssistenzaEducativa() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/uffici-e-orari/-/asset_publisher/G0zCWqt7a2HH/content/servizio-di-assistenza-domiciliare-educativa?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fuffici-e-orari%3Fp_p_id%3D101_INSTANCE_G0zCWqt7a2HH%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1%26_101_INSTANCE_G0zCWqt7a2HH_advancedSearch%3Dfalse%26_101_INSTANCE_G0zCWqt7a2HH_keywords%3D%26_101_INSTANCE_G0zCWqt7a2HH_delta%3D50%26p_r_p_564233524_resetCur%3Dfalse%26_101_INSTANCE_G0zCWqt7a2HH_cur%3D1%26_101_INSTANCE_G0zCWqt7a2HH_andOperator%3Dtrue";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        HtmlPage page1 = client.getPage(BASE_URL);
        try {
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64887\"]/div/div/h1")).asNormalizedText();
            String nominativo = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64887\"]/div/div/p[1]")).asNormalizedText();
            String ufficio = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64887\"]/div/div/p[2]")).asNormalizedText();
            String telefono = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_64887\"]/div/div/p[3]")).asNormalizedText();

            AssistenzaEducativa assistenzaEducativa = new AssistenzaEducativa();
            assistenzaEducativa.setTitolo(titolo);
            assistenzaEducativa.setNominativo(nominativo);
            assistenzaEducativa.setUfficio(ufficio);
            assistenzaEducativa.setTelefono(telefono);

            assistenzaEducativaRepository.save(assistenzaEducativa);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

    public List<AssistenzaEducativa> findAll(){
        return assistenzaEducativaRepository.findAll();
    }
}
