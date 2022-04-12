package io.swagger.api.flora.Service;

import io.swagger.api.flora.model.Biblioteca;
import io.swagger.api.flora.Repository.BibliotecaRepository;
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
public class BibliotecaService {
    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public Biblioteca save(Biblioteca biblioteca){
        return bibliotecaRepository.save(biblioteca);
    }

    public void MetodoBiblioteca() throws IOException{
        String BASE_URL = "https://www.comune.moladibari.ba.it/uffici-e-orari/-/asset_publisher/G0zCWqt7a2HH/content/biblioteca-g-desantis-?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fuffici-e-orari%3Fp_p_id%3D101_INSTANCE_G0zCWqt7a2HH%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_count%3D1";
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        HtmlPage page1 = client.getPage(BASE_URL);
        try{
            String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/h1")).asNormalizedText();
            String nominativo = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[1]")).asNormalizedText();
            String ufficio = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[2]")).asNormalizedText();
            String telefono = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[3]")).asNormalizedText();
            String email = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[4]")).asNormalizedText();
            String pec = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[5]")).asNormalizedText();

            String orario = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/h3")).asNormalizedText();
            String lunedi = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[6]")).asNormalizedText();
            String martedi = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[7]")).asNormalizedText();
            String mercoledi = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[8]")).asNormalizedText();
            String giovedi = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[9]")).asNormalizedText();
            String venerdi = ((HtmlElement) page1.getFirstByXPath("//*[@id=\"_101_INSTANCE_G0zCWqt7a2HH_65155\"]/div/div/p[10]")).asNormalizedText();

            Biblioteca biblioteca = new Biblioteca();
            biblioteca.setTitolo(titolo);
            biblioteca.setNominativo(nominativo);
            biblioteca.setUfficio(ufficio);
            biblioteca.setTelefono(telefono);
            biblioteca.setEmail(email);
            biblioteca.setPec(pec);
            biblioteca.setOrario(orario);
            biblioteca.setLunedi(lunedi);
            biblioteca.setMartedi(martedi);
            biblioteca.setMercoledi(mercoledi);
            biblioteca.setGiovedi(giovedi);
            biblioteca.setVenerdi(venerdi);

            bibliotecaRepository.save(biblioteca);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }

//    public List<Biblioteca> findByTitolo(String titolo){
//        return bibliotecaRepository.findByTitolo(titolo);
//
//    }

    public List<Biblioteca> findAll(){
        return bibliotecaRepository.findAll();

    }

}
