package io.swagger.api.flora;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.gargoylesoftware.htmlunit.html.*;


import io.swagger.api.flora.model.*;
import io.swagger.api.flora.Service.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


import io.swagger.annotations.ApiParam;
import io.swagger.model.FormAdmissibileValue;
import io.swagger.model.FormAnswer;
import io.swagger.model.FormField;
import io.swagger.model.FormFieldValidationRequest;
import io.swagger.model.FormFieldValidationResponse;
import io.swagger.model.FormFieldValuesRequest;
import io.swagger.model.FormFieldValuesResponse;
import io.swagger.model.FormSubmitRequest;
import io.swagger.model.FormSubmitResponse;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-10-18T12:39:28.338Z")

@Controller
public class FloraApiController implements FloraApi {

	private static final Logger log = LoggerFactory.getLogger(FloraApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Autowired
	private CentralinoService centralinoService;
	@Autowired
	private AssistenzaDomiciliareAnzianiService assistenzaDomiciliareAnzianiService;
	@Autowired
	private BibliotecaService bibliotecaService;
	@Autowired
	private AttivitaProduttiveService attivitaProduttiveService;
	@Autowired
	private AssistenzaDomiciliareIntegrataService assistenzaDomiciliareIntegrataService;
	@Autowired
	private CentroFamigliaService centroFamigliaService;
	@Autowired
	private CircolareUrbanaService circolareUrbanaService;
	@Autowired
	private CondonoEdilizioService condonoEdilizioService;
	@Autowired
	private ContenitoriCulturaliService contenitoriCulturaliService;
	@Autowired
	private EdiliziaResidenzialePubblicaService ediliziaResidenzialePubblicaService;
	@Autowired
	private EspropriService espropriService;
	@Autowired
	private MunicipiaService municipiaService;
	@Autowired
	private PoliziaAmministrativaService poliziaAmministrativaService;
	@Autowired
	private PoliziaMunicipaleService poliziaMunicipaleService;
	@Autowired
	private RefezioneScolasticaService refezioneScolasticaService;
	@Autowired
	private SegreteriaGeneraleService segreteriaGeneraleService;
	@Autowired
	private ServizioAnagrafeService servizioAnagrafeService;
	@Autowired
	private ServiziCimiterialiService serviziCimiterialiService;
	@Autowired
	private ServiziLavoriPubbliciService serviziLavoriPubbliciService;
	@Autowired
	private ServizioDomiciliareEducativaService servizioDomiciliareEducativaService;
	@Autowired
	private ServizioElettoraleService servizioElettoraleService;
	@Autowired
	private ServizioLegaleService servizioLegaleService;
	@Autowired
	private ServizioProgrammazioneControlloService servizioProgrammazioneControlloService;
	@Autowired
	private ServizioSegretariatoSocialeService servizioSegretariatoSocialeService;
	@Autowired
	private ServizioSocialeProfessionaleService servizioSocialeProfessionaleService;
	@Autowired
	private ServizioStatoCivileService servizioStatoCivileService;
	@Autowired
	private SportelloArtigianatoService sportelloArtigianatoService;
	@Autowired
	private SportelloUnicoAttivitaProduttiveService sportelloUnicoAttivitaProduttiveService;
	@Autowired
	private StruttureSportviveComunaliService struttureSportviveComunaliService;
	@Autowired
	private TrasportoScolasticoService trasportoScolasticoService;
	@Autowired
	private TrasportoUrbanoService trasportoUrbanoService;
	@Autowired
	private UfficioAccertamentiService ufficioAccertamentiService;
	@Autowired
	private UfficioEconomatoService ufficioEconomatoService;
	@Autowired
	private UfficioIciTarsuService ufficioIciTarsuService;
	@Autowired
	private UfficioImpegniService ufficioImpegniService;
	@Autowired
	private UfficioLevaMilitareService ufficioLevaMilitareService;
	@Autowired
	private UfficioMandatiService ufficioMandatiService;
	@Autowired
	private UfficioNotifichePubblicazioniService ufficioNotifichePubblicazioniService;
	@Autowired
	private UfficioPensioniService ufficioPensioniService;
	@Autowired
	private UfficioPersonaleService ufficioPersonaleService;
	@Autowired
	private UfficioProtocolloService ufficioProtocolloService;
	@Autowired
	private UfficioRagioneriaService ufficioRagioneriaService;
	@Autowired
	private UfficioRelazioniPubblicoService ufficioRelazioniPubblicoService;
	@Autowired
	private UfficioStaffSindacoService ufficioStaffSindacoService;
	@Autowired
	private UfficioStatisticaService ufficioStatisticaService;
	@Autowired
	private UfficioTosapCosapService ufficioTosapCosapService;
	@Autowired
	private UrbanisticaEdiliziaPrivata1Service urbanisticaEdiliziaPrivata1Service;
	@Autowired
	private SindacoService sindacoService;
	@Autowired
	private VicesindacoService vicesindacoService;
	@Autowired
	private AssessoreSalamidaService assessoreSalamidaService;
	@Autowired
	private AssessoreBerlenService assessoreBerlenService;
	@Autowired
	private AssessoreTarsitanoService assessoreTarsitanoService;
	@Autowired
	private AssessoreDituriService assessoreDituriService;
	@Autowired
	private HotelGabbianoService hotelGabbianoService;
	@Autowired
	private CaseEappartamentiBellaPugliaService caseEappartamentiBellaPugliaService;
	@Autowired
	private CaseEappartamentiBellaPuglia1Service caseEappartamentiBellaPuglia1Service;
	@Autowired
	private CaseEappartamentiSottoventoService caseEappartamentiSottoventoService;
	@Autowired
	private B_BDimoreStelleService b_bDimoreStelleService;
	@Autowired
	private B_BPansiniService b_bPansiniService;
	@Autowired
	private B_BFurioService b_bFurioService;
	@Autowired
	private B_BGridiiService b_bGridiiService;
	@Autowired
	private B_BIacovielloService b_bIacovielloService;
	@Autowired
	private B_BLaeraService b_bLaeraService;
	@Autowired
	private B_BAbatangeloService b_bAbatangeloService;
	@Autowired
	private B_BASoldaniService b_baSoldaniService;
	@Autowired
	private B_BLasorsaService b_bLasorsaService;
	@Autowired
	private B_BAPesceService b_baPesceService;
	@Autowired
	private B_BBarnocchiService b_bBarnocchiService;
	@Autowired
	private B_BIacoviello1Service b_bIacoviello1Service;
	@Autowired
	private B_BDePalmaService b_bDePalmaService;
	@Autowired
	private B_BAloisioService b_bAloisioService;
	@Autowired
	private B_BPaceService b_bPaceService;
	@Autowired
	private CampeggioAcquaMarinaService campeggioAcquaMarinaService;
	@Autowired
	private CampeggioPinocchioService campeggioPinocchioService;
	@Autowired
	private TurismoRuraleService turismoRuraleService;
	@Autowired
	private AgriturismoTerramareService agriturismoTerramareService;
	@Autowired
	private AgriturismoMasseriaSerraService agriturismoMasseriaSerraService;
	@Autowired
	private AgriturismoTenutaPintoService agriturismoTenutaPintoService;
	@Autowired
	private AffittacamereDamareService affittacamereDamareService;
	@Autowired
	private AffittacamereDelSoleService affittacamereDelSoleService;
	@Autowired
	private AffittacamereSanGiovanniService affittacamereSanGiovanniService;
	@Autowired
	private AffittacamereDamare1Service affittacamereDamare1Service;
	@Autowired
	private AffittacamereLocandaAngoiniService affittacamereLocandaAngoiniService;
	@Autowired
	private AffittacamereTerraDiPugliaService affittacamereTerraDiPugliaService;
	@Autowired
	private AffittacamereSanDomenicoService affittacamereSanDomenicoService;
	@Autowired
	private AffittacamereMasseriaSerraService affittacamereMasseriaSerraService;
	@Autowired
	private AffittacamereLaForesteriaService affittacamereLaForesteriaService;
	@Autowired
	private AffittacamereDennyKingService affittacamereDennyKingService;
	@Autowired
	private AffittacamereDalCanonicoService affittacamereDalCanonicoService;
	@Autowired
	private AffittacamereIacovielloService affittacamereIacovielloService;
	@Autowired
	private MensaScolasticaService mensaScolasticaService;
	@Autowired
    private StruttureSportiveService struttureSportiveService;
	@Autowired
    private AssistenzaEducativaService assistenzaEducativaService;
	@Autowired
	private PersonaggiIllustriService personaggiIllustriService;
	@Autowired
	private ScelgoMolaService scelgoMolaService;
	@Autowired
	private AlleanzaService alleanzaService;
	@Autowired
	private LaVoceService laVoceService;
	@Autowired
	private FratelliDitaliaService fratelliDitaliaService;
	@Autowired
	private ForzaItaliaService forzaItaliaService;
	@Autowired
	private Movimento5StelleService movimento5StelleService;
	@Autowired
	private NoiConMolaService noiConMolaService;
	@Autowired
	private ProspettivaComuneService prospettivaComuneService;
	@Autowired
	private DiRutiglianoService diRutiglianoService;
	@Autowired
	private BeniCulturaliService beniCulturaliService;


	@org.springframework.beans.factory.annotation.Autowired
	public FloraApiController(final ObjectMapper objectMapper, final HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<FormSubmitResponse> submit(
			@RequestParam(value = "page", required = false, defaultValue = "") final String page,
			@ApiParam(value = "Json data", required = true) @Valid @RequestBody final FormSubmitRequest data,
			@ApiParam(value = "Algho-Token") @RequestHeader(value = "Algho-Token", required = false) final String alghoToken) throws IOException {

		final String accept = "application/json"; // request.getHeader("Accept");

		if (accept != null && accept.contains("application/json")) {

			String scelta = "";

			for (final FormField field : data.getFields()) {

				if (field.getName().equals("Amministrazione"))
					scelta = field.getValue();
				if (field.getName().equals("Giunta Comunale"))
					scelta = field.getValue();
				if (field.getName().equals("Consiglio Comunale"))
					scelta = field.getValue();
				if(field.getName().equals("Maggioranza"))
					scelta = field.getValue();
				if(field.getName().equals("Minoranza"))
					scelta = field.getValue();
				if(field.getName().equals("Ambiente"))
					scelta = field.getValue();
				if (field.getName().equals("SUAP"))
					scelta = field.getValue();
				if (field.getName().equals("Comune"))
					scelta = field.getValue();
				if (field.getName().equals("Cultura"))
					scelta = field.getValue();
				if (field.getName().equals("Politiche Giovanili"))
					scelta = field.getValue();
				if (field.getName().equals("Uffici"))
					scelta = field.getValue();
				if (field.getName().equals("Pagamenti"))
					scelta = field.getValue();
				if (field.getName().equals("Demografici"))
					scelta = field.getValue();
				if (field.getName().equals("Politiche Sociali"))
					scelta = field.getValue();
				if(field.getName().equals("Piano sociale di zona"))
					scelta = field.getValue();
				if (field.getName().equals("Piano sociale"))
					scelta = field.getValue();
				if (field.getName().equals("Refezione scolastica"))
					scelta = field.getValue();
				if (field.getName().equals("Modulistica"))
					scelta = field.getValue();
				if (field.getName().equals("Urbanistica"))
					scelta = field.getValue();
				if (field.getName().equals("Salute"))
					scelta = field.getValue();
				if (field.getName().equals("Vivere"))
					scelta = field.getValue();
				if (field.getName().equals("Storia e cultura"))
					scelta = field.getValue();
				if (field.getName().equals("Strutture ricettive"))
					scelta = field.getValue();
				if (field.getName().equals("Case e Appartamenti"))
					scelta = field.getValue();
				if (field.getName().equals("Agriturismo"))
					scelta = field.getValue();
				if(field.getName().equals("Campeggio"))
					scelta = field.getValue();
				if (field.getName().equals("B&B"))
					scelta = field.getValue();
				if (field.getName().equals("Affittacamere"))
					scelta = field.getValue();
				if (field.getName().equals("Notizie"))
					scelta = field.getValue();
				if (field.getName().equals("Deleghe"))
					scelta = field.getValue();
				if (field.getName().equals("Denunce"))
					scelta = field.getValue();

			}
			log.info("Scelta: " + scelta);


			final FormSubmitResponse response = new FormSubmitResponse();

			switch (scelta){

				case "Sindaco":{
					try{
						List<Sindaco> result = sindacoService.findAll();

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							answer1.setAnswerText(result.get(0).getNomina());
							answer2.setAnswerText(result.get(0).getNome());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getEmail());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}

				//Vice Sindaco - Angelo ROTOLO
				case "Vicesindaco":{

					try{
						List<Vicesindaco> result = vicesindacoService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							answer1.setAnswerText(result.get(0).getNomima());
							answer2.setAnswerText(result.get(0).getNome());
							answer3.setAnswerText(result.get(0).getMandate());
							answer4.setAnswerText(result.get(0).getDescrizione());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Marketing territoriale
				case "Marketing territoriale":{
					try{
						List<Vicesindaco> result = vicesindacoService.findAll();
						try{

							assessoreMarketingTerritorialeextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Assessore SUAP
				case "Assessore SUAP":{
					try{
						List<Vicesindaco> result = vicesindacoService.findAll();
						try{

							assessoreSUAPextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;

				}
				//Assessore al commercio
				case "Assessore al commercio":{
					try{
						List<Vicesindaco> result = vicesindacoService.findAll();
						try{

							assessoreCommercioextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;

				}
				//D.U.C
				case "DUC":{
					try{
						List<Vicesindaco> result = vicesindacoService.findAll();
						try{

							DUCextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;

				}
				//Assessore servizi cimiteriali
				case "Assessore ai servizi cimiteriali":{
					try{
						List<Vicesindaco> result = vicesindacoService.findAll();
						try{

							assessoreServiziCimiterialiextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;

				}
				//Assessore al turismo
				case "Assessore al turismo":{
					try{
						List<Vicesindaco> result = vicesindacoService.findAll();
						try{

							assessoreTurismoextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;

				}
				//Assessore potiche culturali
				case "Assessore alle politiche culturali":{

					try{
						List<Vicesindaco> result = vicesindacoService.findAll();
						try{

							assessorePoliticheCulturaliextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}


				//Assessore Caterina Salamida
				case "Assessore Caterina Salamida":{

					try{
						List<AssessoreSalamida> result = assessoreSalamidaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							answer1.setAnswerText(result.get(0).getNomina());
							answer2.setAnswerText(result.get(0).getNome());
							answer3.setAnswerText(result.get(0).getDescrizione());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							response.setAnswers(answerlist);
							

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Bilancio":{

					try{
						List<AssessoreSalamida> result = assessoreSalamidaService.findAll();
						try{

							AssessoreBilancioextracted(response, result);
							

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Tributi":{

					try{
						List<AssessoreSalamida> result = assessoreSalamidaService.findAll();
						try{

							AssessoreTributiextracted(response, result);
							
							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Programmazione economico":{

					try{
						List<AssessoreSalamida> result = assessoreSalamidaService.findAll();
						try{

							AssessoreProgrammazioneEconomatoextracted(response, result);
							
							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Programmazione finanziaria":{

					try{
						List<AssessoreSalamida> result = assessoreSalamidaService.findAll();
						try{

							AssessoreProgrammazioneFinanziariaextracted(response, result);
							
							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Patrimonio":{

					try{
						List<AssessoreSalamida> result = assessoreSalamidaService.findAll();
						try{

							AssessorePatrimonioextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}


				//Assessore Nicola Berlen
				case "Assessore Nicola Berlen":{

					try{
						List<AssessoreBerlen> result = assessoreBerlenService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							answer1.setAnswerText(result.get(0).getNomina());
							answer2.setAnswerText(result.get(0).getNome());
							answer3.setAnswerText(result.get(0).getEmail());
							answer4.setAnswerText(result.get(0).getMandate());
							answer5.setAnswerText(result.get(0).getDescrizione());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Pianificazione territoriale":{

					try{
						List<AssessoreBerlen> result = assessoreBerlenService.findAll();
						try{

							AssessorePianificazioneTerritorialeextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Qualità dell'abitare":{

					try{
						List<AssessoreBerlen> result = assessoreBerlenService.findAll();
						try{

							AssessoreQualitaAbitareextracted(response, result);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Mobilità sostenibile":{

					try{
						List<AssessoreBerlen> result = assessoreBerlenService.findAll();
						try{

							AssessoreMobilitaSostenibileextracted(response, result);
							
							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Demanio":{

					try{
						List<AssessoreBerlen> result = assessoreBerlenService.findAll();
						try{


							assessoreDemanioextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Opere pubbliche":{

					try{
						List<AssessoreBerlen> result = assessoreBerlenService.findAll();
						try{

							assessoreOperePubblicheextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}



				//Assessore Elvira Tarsitano
				case "Assessore Elvira Tarsitano":{

					try{
						List<AssessoreTarsitano> result = assessoreTarsitanoService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							answer1.setAnswerText(result.get(0).getNomina());
							answer2.setAnswerText(result.get(0).getNome());
							answer3.setAnswerText(result.get(0).getEmail());
							answer4.setAnswerText(result.get(0).getDescrizione());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Politiche ambientali":{

					try{
						List<AssessoreTarsitano> result = assessoreTarsitanoService.findAll();
						try{

							assessorePoliticheAmbientaliextracted(response, result);
							
							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Agricoltura":{

					try{
						List<AssessoreTarsitano> result = assessoreTarsitanoService.findAll();
						try{

							assessoreAgricolturaextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Pesca":{

					try{
						List<AssessoreTarsitano> result = assessoreTarsitanoService.findAll();
						try{

							assessorePescaextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Bioeconomia":{

					try{
						List<AssessoreTarsitano> result = assessoreTarsitanoService.findAll();
						try{

							assessoreBioeconomiaextracted(response, result);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Politiche comunitarie":{

					try{
						List<AssessoreTarsitano> result = assessoreTarsitanoService.findAll();
						try{

							assessorePoliticheComunitarieextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}



				//Assessore Domenica Dituri
				case "Assessore Domenica Dituri":{

					try{
						List<AssessoreDituri> result = assessoreDituriService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							answer1.setAnswerText(result.get(0).getNomina());
							answer2.setAnswerText(result.get(0).getNome());
							answer3.setAnswerText(result.get(0).getDescrizione());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Città solidale":{

					try{
						List<AssessoreDituri> result = assessoreDituriService.findAll();
						try{

							assessoreCittaSolidaleextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Città inclusiva":{

					try{
						List<AssessoreDituri> result = assessoreDituriService.findAll();
						try{

							assessoreCittaInclusivaextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Pubblica istruzione":{

					try{
						List<AssessoreDituri> result = assessoreDituriService.findAll();
						try{

							assessorePubblicaIstruzioneextracted(response, result);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				case "Politiche abitative":{

					try{
						List<AssessoreDituri> result = assessoreDituriService.findAll();
						try{

							assessorePoliticheAbitativeextracted(response, result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}

				//Scelgo Mola
				case "Scelgo Mola":{

					try{
						List<Maggioranza> result = scelgoMolaService.findByPartito("SCELGO MOLA");

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo1());
							answer3.setAnswerText(result.get(0).getNominativo2());
							answer4.setAnswerText(result.get(0).getNominativo3());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Popolo Idea Libertà
				case "Popolo Idea Libertà":{

					try{
						List<Maggioranza> result = scelgoMolaService.findByPartito("POPOLO IDEA LIBERTA'");

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo1());
							answer3.setAnswerText(result.get(0).getNominativo2());
							answer4.setAnswerText(result.get(0).getNominativo3());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Alleanza
				case "Alleanza":{

					try{
						List<Maggioranza> result = alleanzaService.findByPartito("ALLEANZA PER MOLA");
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo1());
							answer3.setAnswerText(result.get(0).getNominativo2());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//La Voce
				case "La Voce":{
					try{
						List<Maggioranza> result = laVoceService.findByPartito("LA VOCE");

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo1());
							answer3.setAnswerText(result.get(0).getNominativo2());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}

				//Fratelli D'italia
				case "Fratelli D'italia":{

					try{
						List<Minoranza> result = fratelliDitaliaService.findByPartito("FRATELLI D'ITALIA");
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Forza Italia
				case "Forza Italia":{

					try{
						List<Minoranza> result = forzaItaliaService.findByPartito("FORZA ITALIA");
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Movimento 5 Stelle
				case "Movimento 5 Stelle":{

					try{
						List<Minoranza> result = movimento5StelleService.findByPartito("MOVIMENTO 5 STELLE");
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Noi con Mola
				case "Noi con Mola":{

					try{
						List<Minoranza> result = noiConMolaService.findByPartito("NOI CON MOLA");
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Prospettiva Comune
				case "Prospettiva Comune":{

					try{
						List<Minoranza> result = prospettivaComuneService.findByPartito("PROSPETTIVA COMUNE");
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Di Rutigliano - Rinascita
				case "Di Rutigliano - Rinascita":{

					try{
						List<Minoranza> result = diRutiglianoService.findByPartito("DI RUTIGLIANO - RINASCITA");
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getPartito());
							answer2.setAnswerText(result.get(0).getNominativo());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}

				//Il Portale Ambiente della Regione Puglia
				case "Il Portale Ambiente della Regione Puglia": {
					String BASE_URL = "https://www.comune.moladibari.ba.it/ambiente";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try {
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = "Il Portale Ambientale della Regione Puglia ";
						String infoLink = "Per maggiori informazioni a riguardo puoi visitare la pagina dedicata: ";

						try {

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(infoLink);
							answer2.setMedia("http://sit.puglia.it/portal/ambiente");
							answer2.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						} catch (final Exception e) {
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						client.close();
					}
					break;
				}

				//Adotta uno spazio verde
				case "Adotta uno spazio verde":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/adotta-uno-spazio-verde";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_Z7QvJMleVk6j_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String titolo1 = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_Z7QvJMleVk6j_\"]/div/div/div/div/div/div/div[2]/h3")).asNormalizedText();
						String link = "Adotta uno spazio verde";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();

							answer1.setAnswerText(titolo + ": ");
							answer2.setAnswerText(titolo1);
							answer3.setAnswerText(link);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72222/Adotta+uno+spazio+verde/9254e163-1d51-4d27-9bf1-ab1f40179ad6");
							answer3.setMediaType("link");



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Mettiamola al posto giusto
				case "Mettiamola al posto giusto":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/mettiamola-al-posto-giusto";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo1 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"titolo\"]/span")).asNormalizedText();
						String body = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_BR38a9wM3XSg_\"]/div/div/div/div/div/div/div[2]/p[1]")).asNormalizedText();
						String numero = "Info numero verde: \n" + "800 597 689";

						String ResiduoZona1 = "Calendario lavaggio carrelati RESIDUO - Zona 1: ";
						String ResiduoZona2 = "Calendario lavaggio carrelati RESIDUO - Zona 2-3: ";
						String UmidoZona1 = "Calendario lavaggio carrelati UMIDO - Zona 1: ";
						String UmidoZona2 = "Calendario lavaggio carrelati UMIDO - Zona 2-3: ";
						String VetroZona = "Calendario lavaggio carrelati VETRO - Zona 1-2-3: ";
						String UDomesticheZona1 = "Pieghevole utenze domestiche - Zona 1: ";
						String UDomesticheZona2 = "Pieghevole utenze domestiche - Zona 2: ";
						String UDomesticheZona3 = "Pieghevole utenze domestiche - Zona 3: ";
						String Nativa = "Per maggiori informazioni sulla raccolta differenziata puoi scaricare l'app dal seguente sito: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();
							final FormAnswer answer12 = new FormAnswer();

							answer1.setAnswerText(titolo1 + ": ");
							answer2.setAnswerText(body);
							answer3.setAnswerText(numero);
							answer4.setAnswerText(ResiduoZona1);
							answer4.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72353/Calendario+lavaggio+carrelati+RESIDUO+-+Zona+1/44b7b200-fd0b-4436-aa65-d3ec5ef47077?t=1494922784000");
							answer4.setMediaType("link");
							answer5.setAnswerText(ResiduoZona2);
							answer5.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72353/Calendario+lavaggio+carrelati+RESIDUO+-+Zona+2-3/7276d81e-7cba-4243-b58d-a46a60aa20ee?t=1494922848000");
							answer5.setMediaType("link");
							answer6.setAnswerText(UmidoZona1);
							answer6.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72353/Calendario+lavaggio+carrelati+UMIDO+-+Zona+1/e290090f-1208-4638-b6ed-fa0781120638?t=1494922880000");
							answer6.setMediaType("link");
							answer7.setAnswerText(UmidoZona2);
							answer7.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72353/Calendario+lavaggio+carrelati+UMIDO+-+Zona+1/e290090f-1208-4638-b6ed-fa0781120638?t=1494922880000");
							answer7.setMediaType("link");
							answer8.setAnswerText(VetroZona);
							answer8.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72353/Calendario+lavaggio+carrelati+VETRO+-+Zona+1-2-3/0f7b24e0-b763-4ec9-8f19-c5059189a77a?t=1494922715000");
							answer8.setMediaType("link");
							answer9.setAnswerText(UDomesticheZona1);
							answer9.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72353/Pieghevole+utenze+domestiche+-+Zona+1/f7c6bee7-1266-4ac1-97b0-a1254e4a471d");
							answer9.setMediaType("link");
							answer10.setAnswerText(UDomesticheZona2);
							answer10.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72353/Pieghevole+utenze+domestiche+-+Zona+2/8938029e-03a1-4bbe-99ec-c25f4a0d9f66");
							answer10.setMediaType("link");
							answer11.setAnswerText(UDomesticheZona3);
							answer11.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72353/Pieghevole+utenze+domestiche+-+Zona+3/333574d8-b36f-4809-a7a3-c3d4977c8986");
							answer11.setMediaType("link");
							answer12.setAnswerText(Nativa);
							answer12.setMedia("https://www.aroba8.it/mola-di-bari/");
							answer12.setMediaType("link");



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							answerlist.add(answer12);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Piano Regionale Amianto (PRA)
				case "Piano Regionale Amianto (PRA)":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/piano-regionale-amianto-pra-";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_h0Tp2c1nieTl_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String corpo = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_h0Tp2c1nieTl_\"]/div/div/div/div/div/div/div[2]/text()")).asNormalizedText();
						String documenti = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_h0Tp2c1nieTl_\"]/div/div/div/div/div/div/div[5]/h3")).asNormalizedText();
						String comuneAvviso = "Documenti collegati: ";
						String linkUtili = "Link utili: ";


						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();


							answer1.setAnswerText(titolo);
							answer2.setAnswerText(corpo);
							answer3.setAnswerText(documenti);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/86326/COMUNE+DI+MOLA+DI+BARI+avviso.pdf/e5105d82-1817-4916-8b14-c950d5ff2ad5");
							answer3.setMediaType("link");
							answer4.setAnswerText(linkUtili);
							answer4.setMedia("http://www.sit.puglia.it/portal/portale_orp/Piano+Amianto");
							answer4.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;

				}
				//Xylella fastidiosa
				case "Xylella fastidiosa":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/xylella-fastidiosa-misure-di-contenimento-e-prevenzione";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_b2WRwYd1ayt3_\"]/div/div/div/div/div/div[1]/div[1]/h1")).asNormalizedText();
						String titolo1 = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_b2WRwYd1ayt3_\"]/div/div/div/div/div/div[2]/div/h3")).asNormalizedText();
						String link1 = "Piani azione approvato: ";
						String link2 ="Misure di contenimento e approvazione: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(titolo1);
							answer3.setAnswerText(link1);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/196134/piano_azione_approvato/b18bdc51-0859-4473-bce8-3baf41107707");
							answer3.setMediaType("link");
							answer4.setAnswerText(link2);
							answer4.setMedia("https://www.comune.moladibari.ba.it/documents/20182/196134/Misure+di+contenimento+e+prevenzione+2021/5a5bdc7d-4df8-4d24-8d95-2fdc8736625f");
							answer4.setMediaType("link");



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;

				}
				//Ufficio Attività Produttive
				case "Ufficio Attività Produttive":{

					try{
						List<AttivitaProduttive> result = attivitaProduttiveService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getEmail());
							answer7.setAnswerText(result.get(0).getOrario());
							answer8.setAnswerText(result.get(0).getMartedi());
							answer9.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Modulistica autorizzazione unica ambientale
				case "Modulistica autorizzazione unica ambientale":{

					try{

						String documento = "Modulistica autorizzazione unica ambientale: ";

						try{

							final FormAnswer answer1 = new FormAnswer();

							answer1.setAnswerText(documento);
							answer1.setMedia("https://www.comune.moladibari.ba.it/documents/20182/21392/MODULISTICA+AUTORIZZAZIONE+UNICA+AMBIENTALE/45fec9a2-da19-4c60-aee3-fed6d130f197");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Domanda Di-Spunta-Mercato Settimale-Giornaliero
				case "Domanda Di-Spunta-Mercato Settimale-Giornaliero":{

					try{

						String documento = "Domanda Di-Spunta-Mercato Settimale-Giornaliero: ";

						try{

							final FormAnswer answer1 = new FormAnswer();

							answer1.setAnswerText(documento);
							answer1.setMedia("https://www.comune.moladibari.ba.it/documents/20182/21392/DOMANDA+DI+-+SPUNTA+-+MERCATO+SETTIMALE-GIORNALIERO/710b33d2-0ae8-4f70-86a2-23a7af30a072");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ufficio Relazioni Con Il Pubblico //CONTROLLARE ANSWER 8
				case "Ufficio Relazioni Con Il Pubblico":{

					try{
						List<UfficioRelazioniPubblico> result = ufficioRelazioniPubblicoService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getEmail());
							answer6.setAnswerText(result.get(0).getOrario());
							answer7.setAnswerText(result.get(0).getLunedi());
							answer8.setAnswerText(result.get(0).getMartedi());
							answer9.setAnswerText(result.get(0).getMercoledi());
							answer10.setAnswerText(result.get(0).getGiovedi());
							answer11.setAnswerText(result.get(0).getVenerdi());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Statuto Comune
				case "Statuto del Comune":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/statuto-del-comune";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_G26Q1nOjelH7_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String titolo1 = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_G26Q1nOjelH7_\"]/div/div/div/div/div/div/div[3]/h3")).asNormalizedText();
						String statuto = "Statuto del Comune di Mola di Bari";
						String link_1 = "https://www.comune.moladibari.ba.it/documents/20182/72742/Statuto+del+Comune+di+Mola+di+Bari/49dffdb8-2d4c-4a7f-b910-3e9feab3fe75";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();



							answer1.setAnswerText(titolo);
							answer2.setAnswerText(titolo1);
							answer3.setAnswerText(statuto);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72742/Statuto+del+Comune+di+Mola+di+Bari/49dffdb8-2d4c-4a7f-b910-3e9feab3fe75");
							answer3.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Europe Direct Puglia
				case "Europe Direct Puglia":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/comune";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlAnchor) page1.getFirstByXPath("//*[@id=\"p_p_id_85_INSTANCE_jmU2YKh3yVun_\"]/div/div/div/ul/li[3]/a")).getVisibleText();

						try{

							final FormAnswer answer1 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer1.setMedia("http://www.europedirectpuglia.eu/");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Regolamenti
				case "Regolamenti":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/comune";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = "Regolamenti: ";

						try{

							final FormAnswer answer1 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer1.setMedia("https://www.comune.moladibari.ba.it/regolamenti-fino-al-2021");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Consultazioni Elettorali
				case "Consultazioni Elettorali":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/comune";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = "Consultazioni Elettorali: ";

						try{

							final FormAnswer answer1 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer1.setMedia("https://www.comune.moladibari.ba.it/consultazioni-elettorali");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Albo Pretorio Online
				case "Albo Pretorio Online":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/albo-pretorio-online";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_jc2QmxtSVaPO_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						try{

							final FormAnswer answer1 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer1.setMedia("https://www.comune.moladibari.ba.it/albo-pretorio-online");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//CUG
				case "CUG":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/comitato-unico-di-garanzia-per-le-pari-opportunita-la-valorizzazione-del-benessere-di-chi-lavora-e-contro-le-discriminazioni";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_TpjBZ5hkeC8A_\"]/div/div/div[1]/div/div/div/div/h1")).asNormalizedText();
						String corpo = "Nella seguente pagina troverai bollettini e verbali: ";
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(corpo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/comitato-unico-di-garanzia-per-le-pari-opportunita-la-valorizzazione-del-benessere-di-chi-lavora-e-contro-le-discriminazioni");
							answer2.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
                //Cultura
				//Beni Culturali
				case "Beni Culturali":{

					try{
						List<BeniCulturali> result = beniCulturaliService.findAll();
						try{

							BeniCulturaliRespondeextracted(response,result);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}

				//Foto d'epoca
				case "Foto d'epoca":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/foto-d-epoca";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_P7Z5VFZEoQtZ_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();

						try{

							FotoResponseextracted(response, titolo);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Personaggi Illustri
				case "Personaggi Illustri":{

					try{
						List<PersonaggiIllustri> result = personaggiIllustriService.findAll();
						try{
							String NicolòCompleto = result.get(0).getNiccolo().concat("\t" + result.get(0).getNiccoloStoria());
							String BrunoCompleto = result.get(0).getBruno().concat("\t" + result.get(0).getBrunoStoria());
							String OnofrioCompleto = result.get(0).getOnofrio().concat("\t" + result.get(0).getOnofrioStoria());
							String PieroCompleto = result.get(0).getPiero().concat("\t" + result.get(0).getPieroStoria());

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(NicolòCompleto);
							answer3.setAnswerText(BrunoCompleto);
							answer4.setAnswerText(OnofrioCompleto);
							answer5.setAnswerText(PieroCompleto);

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);



							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Politiche giovanili, assicurazioni e sport
				//Albo comunale delle associazioni e degli enti no profit
				case "Albo comunale delle associazioni e degli enti no profit":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/politiche-giovanili-associazioni-e-sport";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = "Albo comunale delle associazioni e degli enti no profit";
						try{

							final FormAnswer answer1 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer1.setMedia("https://www.comune.moladibari.ba.it/politiche-giovanili-associazioni-e-sport");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Centro Famiglia
				case "Centro Famiglia":{
					try{
						List<CentroFamiglia> result = centroFamigliaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getEmail());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Concessione in uso strutture sportive comunali
				case "Concessione in uso strutture sportive comunali":{
					try{
						List<StruttureSportive> result = struttureSportiveService.findAll();
						String delibera = "Deliberazione di Giunta Comunale n. 118_2019: ";
						String avviso = "Avviso pubblico: ";
						String linkAvviso = "https://www.comune.moladibari.ba.it/documents/20182/118649/Avviso+pubblico/9adf3baa-f27b-4943-ac58-1d66c183e54d";
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getOrari());
							answer6.setAnswerText(result.get(0).getDodumenti());
							answer7.setAnswerText(delibera);
							answer7.setMediaType("https://www.comune.moladibari.ba.it/documents/20182/118649/Deliberazione+di+Giunta+Comunale+n.+118_2019/08e364e3-7753-45c9-9964-e11d57dbe15f");
							answer7.setMediaType("link");
							answer8.setAnswerText(avviso);
							answer8.setMedia("https://www.comune.moladibari.ba.it/documents/20182/118649/Avviso+pubblico/9adf3baa-f27b-4943-ac58-1d66c183e54d");
							answer8.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}

				//Centralino
				case "Centralino":{
					try{
						List<Centralino> result = centralinoService.findAll();
						try{
							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ufficio Attività Produttive
				//Ufficio Stato Civile
				case "Ufficio Stato Civile":{
					try{
						List<ServizioStatoCivile> result = servizioStatoCivileService.findAll();
						try{
							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getPec());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getLunedi());
							answer7.setAnswerText(result.get(0).getMartedi());
							answer8.setAnswerText(result.get(0).getMercoledi());
							answer9.setAnswerText(result.get(0).getGiovedi());
							answer10.setAnswerText(result.get(0).getVenerdi());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);

							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Polizia Amministrativa
				case "Polizia Amministrativa":{

					try{
						List<PoliziaAmministrativa> result = poliziaAmministrativaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();



							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getEmail());
							answer7.setAnswerText(result.get(0).getOrario());
							answer8.setAnswerText(result.get(0).getMartedi());
							answer9.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Edilizia Residenziale Pubblica
				case "Edilizia Residenziale Pubblica":{

					try{
						List<EdiliziaResidenzialePubblica> result = ediliziaResidenzialePubblicaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getOrario());
							answer7.setAnswerText(result.get(0).getMartedi());
							answer8.setAnswerText(result.get(0).getGiovedi());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Condono Edilizio
				case "Condono Edilizio":{

					try{
						List<CondonoEdilizio> result = condonoEdilizioService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getOrario());
							answer7.setAnswerText(result.get(0).getMartedi());
							answer8.setAnswerText(result.get(0).getGiovedi());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Edilizia privata e urbanistica
				case "Edilizia privata e urbanistica":{

					try{
						List<UrbanisticaEdiliziaPrivata1> result = urbanisticaEdiliziaPrivata1Service.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getOrario());
							answer7.setAnswerText(result.get(0).getMartedi());
							answer8.setAnswerText(result.get(0).getGiovedi());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ufficio Trasporto scolastico
				case "Ufficio Trasporto scolastico":{

					try{
						 List<TrasportoScolastico> result = trasportoScolasticoService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Servizio sociale professionale
				case "Servizio sociale professionale":{

					try{
						List<ServizioSocialeProfessionale> result = servizioSocialeProfessionaleService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getPec());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Pubblicità e affisioni
				case "Pubblicità e affissioni":{

					try{
						List<UfficioTosapCosap> result = ufficioTosapCosapService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getOrario());
							answer4.setAnswerText(result.get(0).getLunedi());
							answer5.setAnswerText(result.get(0).getMartedi());
							answer6.setAnswerText(result.get(0).getMercoledi());
							answer7.setAnswerText(result.get(0).getGiovedi());
							answer8.setAnswerText(result.get(0).getVenerdi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Assistenza anziani
				case "Assistenza anziani":{

					try{
						List<AssistenzaDomiciliareAnziani> result = assistenzaDomiciliareAnzianiService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ufficio ICI e TARSU
				case "Ufficio ICI e TARSU":{

					try{
						List<UfficioIciTarsu> result = ufficioIciTarsuService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Anagrafe
				case "Anagrafe":{

					try{
						List<ServizioAnagrafe> result = servizioAnagrafeService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getPec());
							answer6.setAnswerText(result.get(0).getOrario());
							answer7.setAnswerText(result.get(0).getLunedi());
							answer8.setAnswerText(result.get(0).getMartedi());
							answer9.setAnswerText(result.get(0).getMercoledi());
							answer10.setAnswerText(result.get(0).getGiovedi());
							answer11.setAnswerText(result.get(0).getVenerdi());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ufficio di staff sindaco
				case "Ufficio di staff sindaco":{

					try{
						List<UfficioStaffSindaco> result = ufficioStaffSindacoService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Utilizzo contenitori culturali
				case "Utilizzo contenitori culturali":{

					try{
						List<ContenitoriCulturali> result = contenitoriCulturaliService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getEmail());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Programmazione e controllo
				case "Programmazione e controllo":{

					try{
						List<ServizioProgrammazioneControllo> result = servizioProgrammazioneControlloService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getEmail());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ragioneria
				case "Ragioneria":{

					try{
						List<UfficioRagioneria> result = ufficioRagioneriaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getUfficio());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Economato
				case "Economato":{

					try{
						List<UfficioEconomato> result = ufficioEconomatoService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getEmail());
							answer7.setAnswerText(result.get(0).getOrario());
							answer8.setAnswerText(result.get(0).getMartedi());
							answer9.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Leva Militare
				case "Leva Militare":{

					try{
						List<UfficioLevaMilitare> result = ufficioLevaMilitareService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Protocollo
				case "Protocollo":{

					try{
						List<UfficioProtocollo> result = ufficioProtocolloService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10= new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();
							final FormAnswer answer12 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getPec());
							answer7.setAnswerText(result.get(0).getOrario());
							answer8.setAnswerText(result.get(0).getLunedi());
							answer9.setAnswerText(result.get(0).getMartedi());
							answer10.setAnswerText(result.get(0).getMercoledi());
							answer11.setAnswerText(result.get(0).getGiovedi());
							answer12.setAnswerText(result.get(0).getVenerdi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							answerlist.add(answer12);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Personale
				case "Personale":{

					try{
						List<UfficioPersonale> result = ufficioPersonaleService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getEmail());
							answer6.setAnswerText(result.get(0).getEmail1());
							answer7.setAnswerText(result.get(0).getPec());
							answer8.setAnswerText(result.get(0).getOrario());
							answer9.setAnswerText(result.get(0).getMartedi());
							answer10.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ufficio Relazioni Con Il Pubblico già presente
				//Espropri
				case "Espropri":{

					try{
						List<Espropri> result = espropriService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getUfficio());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getFax());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ufficio Elettorale
				case "Ufficio Elettorale":{

					try{
						List<ServizioElettorale> result = servizioElettoraleService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getPec());
							answer6.setAnswerText(result.get(0).getOrario());
							answer7.setAnswerText(result.get(0).getMartedi());
							answer8.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Ufficio Polizia Municipale
				case "Ufficio Polizia Municipale":{

					try{
						List<PoliziaMunicipale> result = poliziaMunicipaleService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getEmail());
							answer6.setAnswerText(result.get(0).getOrario());
							answer7.setAnswerText(result.get(0).getMartedi());
							answer8.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Lavori Pubblici
				case "Lavori Pubblici":{

					try{
						List<ServiziLavoriPubblici> result = serviziLavoriPubbliciService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Circolare Urbana
				case "Circolare Urbana":{

					try{
						List<CircolareUrbana> result = circolareUrbanaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getUfficio());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getOrario());
							answer5.setAnswerText(result.get(0).getLunedi());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Biblioteca G.Desantis
				case "Biblioteca":{
					try{
						List<Biblioteca> result = bibliotecaService.findAll(); //Importante da ricordare //da fare per tutti ESEMPIO

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();
							final FormAnswer answer12 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo()); //da fare per tutti ESEMPI
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getEmail());
							answer6.setAnswerText(result.get(0).getPec());
							answer7.setAnswerText(result.get(0).getOrario());
							answer8.setAnswerText(result.get(0).getLunedi());
							answer9.setAnswerText(result.get(0).getMartedi());
							answer10.setAnswerText(result.get(0).getMercoledi());
							answer11.setAnswerText(result.get(0).getGiovedi());
							answer12.setAnswerText(result.get(0).getVenerdi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							answerlist.add(answer12);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Strutture Sportive
				case "Strutture Sportive":{

					try{
						List<StruttureSportviveComunali> result = struttureSportviveComunaliService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Servizio di segretariato sociale
				case "Servizio di segretariato sociale":{

					try{
						List<ServizioSegretariatoSociale> result = servizioSegretariatoSocialeService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getEmail());
							answer6.setAnswerText(result.get(0).getPec());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Assistenza sanitaria
				case "Assistenza sanitaria":{

					try{
						List<AssistenzaDomiciliareIntegrata> result = assistenzaDomiciliareIntegrataService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Assistenza Educativa fare nel DB
				case "Assistenza Educativa":{

					try{
						List<AssistenzaEducativa> result = assistenzaEducativaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Sportello per l'artiganato //AGGIUSTARE
				case "Sportello per l'artigianato":{

					try{
						List<SportelloArtigianato> result = sportelloArtigianatoService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getEmail());
							answer7.setAnswerText(result.get(0).getOrario());
							answer8.setAnswerText(result.get(0).getMartedi());
							answer9.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Municipia
				case "Municipia":{

					try{
						List<Municipia> result = municipiaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();
							final FormAnswer answer12 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getFax());
							answer6.setAnswerText(result.get(0).getEmail());
							answer7.setAnswerText(result.get(0).getOrario());
							answer8.setAnswerText(result.get(0).getLunedi());
							answer9.setAnswerText(result.get(0).getMartedi());
							answer10.setAnswerText(result.get(0).getMercoledi());
							answer11.setAnswerText(result.get(0).getGiovedi());
							answer12.setAnswerText(result.get(0).getVenerdi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							answerlist.add(answer12);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Accertamenti
				case "Accertamenti":{

					try{
						List<UfficioAccertamenti> result = ufficioAccertamentiService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Mensa scolastica
				case "Mensa scolastica":{

					try{
						List<MensaScolastica> result = mensaScolasticaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Impegni
				case "Impegni":{

					try{
						List<UfficioImpegni> result = ufficioImpegniService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getUfficio());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getFax());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Mandati
				case "Mandati":{

					try{
						List<UfficioMandati> result = ufficioMandatiService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getUfficio());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Statistica
				case "Statistica":{

					try{
						List<UfficioStatistica> result = ufficioStatisticaService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getTelefono());
							answer4.setAnswerText(result.get(0).getEmail());
							answer5.setAnswerText(result.get(0).getPec());
							answer6.setAnswerText(result.get(0).getOrario());
							answer7.setAnswerText(result.get(0).getMartedi());
							answer8.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Servizio Legale
				case "Servizio Legale":{

					try{
						List<ServizioLegale> result = servizioLegaleService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getEmail());
							answer6.setAnswerText(result.get(0).getPec());
							answer7.setAnswerText(result.get(0).getOrario());
							answer8.setAnswerText(result.get(0).getMartedi());
							answer9.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Pensioni
				case "Pensioni":{

					try{
						List<UfficioPensioni> result = ufficioPensioniService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Segreteria Generale
				case "Segreteria Generale":{

					try{
						List<SegreteriaGenerale> result = segreteriaGeneraleService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getNominativo());
							answer3.setAnswerText(result.get(0).getUfficio());
							answer4.setAnswerText(result.get(0).getTelefono());
							answer5.setAnswerText(result.get(0).getOrario());
							answer6.setAnswerText(result.get(0).getMartedi());
							answer7.setAnswerText(result.get(0).getGiovedi());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}

				//Pagamenti e Tasse
				//Iban e Pagamenti Informatici
				case "Iban e Pagamenti Informatici":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/iban-e-pagamenti-informatici";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_qCxpwQVKbeau_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String documenti = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_qCxpwQVKbeau_\"]/div/div/div/div/div/div/div[3]/h3")).asNormalizedText();
						String link = "Documenti collegati: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();


							answer1.setAnswerText(titolo);
							answer2.setAnswerText(documenti);
							answer3.setAnswerText(link);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72591/1617393_000003021_iban+conti+correnti+Comune+di+Mola+di+Bari/23a198f3-485a-4e21-aea9-5468a194a957");
							answer3.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Fattura Elettronica
				case "Fattura elettronica":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/fattura-elettronica";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_LKFII4da4bIa_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String corpo = "Per le fatture elettroniche ti indirizzo ad una pagina molto esplicativa del sito del comune. Ecco il link";
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(corpo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/fattura-elettronica");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//IUC-IMU-TASI
				case "IUC-IMU-TASI":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/iuc-imu-tasi";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_NqLdFpICFtno_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String documenti = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_NqLdFpICFtno_\"]/div/div/div/div/div/div/div[2]/h3")).asNormalizedText();
						String link = "ALLEGATO 'B' DELIBERA C.C. n. 22-2016 - TARIFFE TARI ANNO 2016: ";
						String link1 = "DELIBERA C.C. n. 22-2016 - TARIFFE TARI ANNO 2016: ";
						String link2 = "DELIBERA C.C. n. 22-2016 - TARIFFE TARI ANNO 2016: ";
						String link3 = "ORARIO DI APERTURA UFFICI - DAL 13 FEBBRAIO 2017: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();


							answer1.setAnswerText(titolo);
							answer2.setAnswerText(documenti);
							answer3.setAnswerText(link);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72627/ALLEGATO+%27B%27+DELIBERA+C.C.+n.+22-2016+-+TARIFFE+TARI+ANNO+2016/e089599c-7053-4088-97e9-42ef33076e3b");
							answer3.setMediaType("link");
							answer4.setAnswerText(link1);
							answer4.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72627/DELIBERA+C.C.+n.+22-2016+-+TARIFFE+TARI+ANNO+2016/8e3481c9-67f1-4457-b14d-3bfce823a6ad");
							answer4.setMediaType("link");
							answer5.setAnswerText(link2);
							answer5.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72627/DELIBERA+C.C.+n.+26-2015+-+TARIFFE+TARI+ANNO+2015/2e8e3d4b-6d94-4124-8fd7-3ad7811dfdfb");
							answer5.setMediaType("link");
							answer6.setAnswerText(link3);
							answer6.setMedia("https://www.comune.moladibari.ba.it/documents/20182/72627/ORARIO+DI+APERTURA+UFFICI+-+DAL+13+FEBBRAIO+2017/6cfd2d3c-6d7e-4cfe-8dbe-d5ca4db310f2");
							answer6.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Calcolo IUC
				case "Calcolo IUC":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/pagamenti-e-tasse";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = "Per effettuare il calcolo IUC puoi andare su questo sito: ";
						try{

							final FormAnswer answer1 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer1.setMedia("https://www.riscotel.it/calcoloiuc2018/?comune=F280");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Calcolo della tasi
				case "Calcolo TASI":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/pagamenti-e-tasse";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = "Per effettuare il calcolo della tasi puoi visitare il sito: ";
						String link = "https://www.amministrazionicomunali.it/imu/calcolo_imu.php";
						try{

							final FormAnswer answer1 = new FormAnswer();


							answer1.setAnswerText(titolo);
							answer1.setMedia("https://www.amministrazionicomunali.it/imu/calcolo_imu.php");
							answer1.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}

				//Servizi Demografici
				//Ufficio Stato Civile già pesente
				//Anagrafe già presente
				//Ufficio Elettorale già presente
				//Servizi Cimiteriali
				case "Servizi cimiteriali":{

					try{
						List<ServiziCimiteriali> result = serviziCimiterialiService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getOrari());
							answer3.setAnswerText(result.get(0).getInverno());
							answer4.setAnswerText(result.get(0).getOrariinverno());
							answer5.setAnswerText(result.get(0).getFestiviinv());
							answer6.setAnswerText(result.get(0).getEstivo());
							answer7.setAnswerText(result.get(0).getOrariestivo());
							answer8.setAnswerText(result.get(0).getFestiviest());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Portale Resettami
				case "Portale Resettami":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/piano-sociale-di-zona";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String resettami = "Portale Resettami";
						String info = "Per maggiori informazioni ti consiglio di visitare il seguenti link :";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(resettami);
							answer2.setAnswerText(info);
							answer2.setMedia("http://www.resettamiweb.it/ambitomola/");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//ReD - Reddito di Dignità
				case "ReD - Reddito di Dignità":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/piano-sociale-di-zona";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String ReD = "ReD - Reddito di Dignità";
						String info = "Per maggiori informazioni ti consiglio di visitare il seguenti link :";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(ReD);
							answer2.setAnswerText(info);
							answer2.setMedia("https://www.comune.moladibari.ba.it/red-reddito-di-dignita");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Refezione scolastica
				//Manuali
				case "Manuali":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/gestione-informatizzata-servizio-di-refezione-scolastica";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_pSoaNHJihVkz_\"]/div/div/div[1]/div/div/div/div/h1")).asNormalizedText();
						String manuale1 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_GF1hBToMUwm1_objectsSearchContainerSearchContainer\"]/table/tbody/tr[1]/td/a/div/span")).asNormalizedText();
						String manuale2 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_GF1hBToMUwm1_objectsSearchContainerSearchContainer\"]/table/tbody/tr[2]/td/a/div/span")).asNormalizedText();
						String manuale3 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_GF1hBToMUwm1_objectsSearchContainerSearchContainer\"]/table/tbody/tr[3]/td/a/div/span")).asNormalizedText();


						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(manuale1);
							answer2.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104099/Manuale+Iscrizioni+Online/5a391e3a-5c66-4491-9a3d-23cb97fdaee4");
							answer2.setMediaType("link");
							answer3.setAnswerText(manuale2);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104099/Manuale+gestione+pasti/c8a787ac-a67f-453c-b0de-90c6111a7d05");
							answer3.setMediaType("link");
							answer4.setAnswerText(manuale3);
							answer4.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104099/Manuale+pagamento+pasti/a8949ca6-9301-43bc-8b47-89c3a5d8e64e");
							answer4.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Menù
				case "Menù":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/menu";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_o7AnaHayOlqT_\"]/div/div/div[1]/div/div/div/div/h1")).asNormalizedText();
						String menuestivo = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_P1amWBmIUzlF_objectsSearchContainerSearchContainer\"]/table/tbody/tr[1]/td/a/div/span")).asNormalizedText();
						String menuinvernale = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_P1amWBmIUzlF_objectsSearchContainerSearchContainer\"]/table/tbody/tr[1]/td/a/div/span")).asNormalizedText();


						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(menuestivo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104107/Men%C3%B9+estivo+2018_2019.pdf/1f054cb6-1fdf-4de8-8202-dca1b1a4bafd");
							answer2.setMediaType("link");
							answer3.setAnswerText(menuinvernale);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104107/Men%C3%B9+estivo+2018_2019.pdf/1f054cb6-1fdf-4de8-8202-dca1b1a4bafd");
							answer3.setMediaType("link");
	
							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Avvisi
				case "Avvisi":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/avvisi3";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_CsK6bLYtrhPf_\"]/div/div/div[1]/div/div/div/div/h1")).asNormalizedText();
						String avviso1 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_A1nzisEsGQJJ_objectsSearchContainerSearchContainer\"]/table/tbody/tr[1]/td/a/div/span")).asNormalizedText();

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(avviso1);
							answer2.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104111/Servizio+di+refezione+scolastica+certificazioni+spese+sostenute+anno+2020/dae7f795-fea7-4741-a536-27b5ed876b09");
							answer2.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Commissione mensa
				case "Commissione mensa":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/commissione-mensa";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_zO90LKYGmaNm_\"]/div/div/div[1]/div/div/div/div/h1")).asNormalizedText();
						String avviso1 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_8xyZOwOBXRMu_objectsSearchContainerSearchContainer\"]/table/tbody/tr[1]/td/a/div/span")).asNormalizedText();
						String avviso2 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_8xyZOwOBXRMu_objectsSearchContainerSearchContainer\"]/table/tbody/tr[2]/td/a/div/span")).asNormalizedText();
						String avviso3 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_8xyZOwOBXRMu_objectsSearchContainerSearchContainer\"]/table/tbody/tr[2]/td/a/div/span")).asNormalizedText();


						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(avviso1);
							answer2.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104115/Delibera+di+approvazione+disciplinare+Commissione+mensa/da5ecf68-ecee-4928-a3b1-8ba041de096d");
							answer2.setMediaType("link");
							answer3.setAnswerText(avviso2);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104115/Disciplinare+commissione+mensa/0b32135d-2e2a-4383-bb41-8454957ea5cb");
							answer3.setMediaType("link");
							answer4.setAnswerText(avviso3);
							answer4.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104115/Nomina+commissione+mensa+2019_2020/c77f700d-ada0-4b47-afaf-be61454f15a0");
							answer4.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Portale genitori
				case "Portale genitori":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/refezione-scolastica";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlAnchor) page1.getFirstByXPath("//*[@id=\"p_p_id_85_INSTANCE_4vWLtzz83R4W_\"]/div/div/div/ul/li[2]/a")).getVisibleText();
						String corpo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata. Al seguente link: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(corpo);
							answer2.setMedia("https://www.schoolesuite.it/default1/NSC_Login.aspx?installation_code=mola");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Contributi libri di testo scuole secondarie
				case "Contributi libri di testo scuole secondarie":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/contributi-libri-di-testo-scuole-secondarie-di-1-e-2-grado";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_4n5xNqrl9YiV_\"]/div/div/div[1]/div/div/div/div[1]/h1")).asNormalizedText();
						String corpo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_4n5xNqrl9YiV_\"]/div/div/div[1]/div/div/div/div[2]/p[1]")).asNormalizedText();
						String nominativo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_4n5xNqrl9YiV_\"]/div/div/div[1]/div/div/div/div[2]/p[2]")).asNormalizedText();
						String telefono = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_4n5xNqrl9YiV_\"]/div/div/div[1]/div/div/div/div[2]/p[3]")).asNormalizedText();
						String email = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_4n5xNqrl9YiV_\"]/div/div/div[1]/div/div/div/div[2]/p[4]")).asNormalizedText();

						String modulo1 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_W9v8CLqH31Yl_objectsSearchContainerSearchContainer\"]/table/tbody/tr[1]/td/a/div/span")).asNormalizedText();
						String modulo2 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_W9v8CLqH31Yl_objectsSearchContainerSearchContainer\"]/table/tbody/tr[2]/td/a/div/span")).asNormalizedText();
						String modulo3 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_W9v8CLqH31Yl_objectsSearchContainerSearchContainer\"]/table/tbody/tr[3]/td/a/div/span")).asNormalizedText();
						String modulo4 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_W9v8CLqH31Yl_objectsSearchContainerSearchContainer\"]/table/tbody/tr[4]/td/a/div/span")).asNormalizedText();
						String modulo5 = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_W9v8CLqH31Yl_objectsSearchContainerSearchContainer\"]/table/tbody/tr[5]/td/a/div/span")).asNormalizedText();

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(corpo);
							answer3.setAnswerText(nominativo);
							answer4.setAnswerText(telefono);
							answer5.setAnswerText(email);
							answer6.setAnswerText(modulo1);
							answer6.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104727/Informativa+libri+di+testo+scuola+primaria+2019_2020/4bb9096e-139d-4503-880e-e69edcf3cb0f");
							answer6.setMediaType("link");
							answer7.setAnswerText(modulo2);
							answer7.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104727/Avviso+regionale+libri+di+testo+scuole+secondarie/b28a8690-35c5-4619-b880-ac8c6240d628");
							answer7.setMediaType("link");
							answer8.setAnswerText(modulo3);
							answer8.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104727/Contributo+libri+di+testo.+Ulteriore+proroga+termini/41c77a5c-3f88-47b5-a769-249984a6c4ed");
							answer8.setMediaType("link");
							answer9.setAnswerText(modulo4);
							answer9.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104727/Avviso+integrativo+libri+di+testo/24d0b2d7-a800-495c-b232-6d57ac3f7f0c");
							answer9.setMediaType("link");
							answer10.setAnswerText(modulo5);
							answer10.setMedia("https://www.comune.moladibari.ba.it/documents/20182/104727/Testo+avviso+integrativo+libri+di+testo/117e6ae2-4761-4bd1-90e5-4f3791a22be3");
							answer10.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Trasporto scolastico modificare nome su algho
				case "Trasporto scolastico":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/trasporto-scolastico-a.s.-2018_2019";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_nmUgmwBJ4ual_\"]/div/div/div[1]/div/div/div/div/h1")).getVisibleText();
						String avviso = "Avviso trasporto scolastico: ";


						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(avviso);
							answer2.setMedia("https://www.comune.moladibari.ba.it/documents/20182/118790/Avviso+trasporto+scolastico.pdf/046c3adf-c1f9-4418-8ce8-9511e7b89da9");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Contributi canoni di locazione
				case "Contributi canoni di locazione":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/contributi-canoni-di-locazione-2018-anno-di-riferimento-2016";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_JwogDuTRLQ0J_\"]/div/div/div[1]/div/div/div/div[1]/h1")).asNormalizedText();
						String linkutili = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_JwogDuTRLQ0J_\"]/div/div/div[1]/div/div/div/div[2]/h3")).asNormalizedText();

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(linkutili);
							answer2.setMedia("https://www.comune.moladibari.ba.it/-/avviso-pubblico-per-la-concessione-di-contributi-straordinari-ad-integrazione-dei-canoni-di-locazione-per-le-abitazioni-anno-2019");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Libri di testo scuola primaria
				case "Libri di testo scuola primaria":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/libri-di-testo-scuola-primaria";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_MMyuzDzqenA7_\"]/div/div/div[1]/div/div/div/div/h1")).asNormalizedText();
						String liklibritesto = ((HtmlSpan) page1.getFirstByXPath("//*[@id=\"_110_INSTANCE_fFHmhyFtArlt_objectsSearchContainerSearchContainer\"]/table/tbody/tr[1]/td/a/div/span")).asNormalizedText();

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(liklibritesto);
							answer2.setMedia("https://www.comune.moladibari.ba.it/documents/20182/137525/Cedole+librarie+scuola+primaria+2019_2020/f5e1450c-8f83-4ec7-a3a8-7d83d581387c");
							answer2.setMediaType("link");
							
							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Finanziamento PON per la scuola
				case "Finanziamento PON per la scuola":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/finanziamento-pon-per-la-scuola";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);
						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_9wbKjhEfhZD2_\"]/div/div/div[1]/div/div/div/div[1]/h1")).asNormalizedText();
						String documenti = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_9wbKjhEfhZD2_\"]/div/div/div[1]/div/div/div/div[3]/h3")).asNormalizedText();
						String linkdoc1 = "Esito procedura: ";
						String linkdoc2 = "Determinazione a contrarre: ";
						String linkdoc3 = "Determina di affidamento: ";
						String linkdoc4 = "Affidamento incarico professionale. Determina a contrarre: ";
						String linkdoc5 = "Fornitura etichette. Determina a contrarre";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(documenti);
							answer3.setAnswerText(linkdoc1);
							answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/167226/Esito+procedura/74a86292-e39b-4953-a817-b316c6abe52d");
							answer3.setMediaType("link");
							answer4.setAnswerText(linkdoc2);
							answer4.setMedia("https://www.comune.moladibari.ba.it/documents/20182/167226/Determinazione+a+contrarre/97a646d4-dfa2-46a4-9ea5-82211efbb262");
							answer4.setMediaType("link");
							answer5.setAnswerText(linkdoc3);
							answer5.setMedia("https://www.comune.moladibari.ba.it/documents/20182/167226/Determina+di+affidamento/f52cbe01-44ed-40e5-af9b-27b5be3ddc32");
							answer5.setMediaType("link");
							answer6.setAnswerText(linkdoc4);
							answer6.setMedia("https://www.comune.moladibari.ba.it/documents/20182/173566/Affidamento+incarico+professionale.+Determina+a+contrarre/b1f0c0a2-2290-4ba9-b911-85dc529e3efb");
							answer6.setMediaType("link");
							answer7.setAnswerText(linkdoc5);
							answer7.setMedia("https://www.comune.moladibari.ba.it/documents/20182/173598/Fornitura+etichette.+Determina+a+contrarre/4e2ee673-5cc5-4645-b496-dc6497b48935");
							answer7.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Modulistica
				//Entrate tributarie
				case "Entrate tributarie":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/entrate-tributarie";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_NKzQsxdUDzxj_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/entrate-tributarie");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Polizia municipale
				case "Polizia municipale":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/polizia-municipale";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_k8eo28GUmXIP_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							
							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/polizia-municipale");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Servizi demografici
				case "Servizi demografici":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/servizi-demografici-1";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_g7zqFVRrGOE9_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/servizi-demografici-1");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Settore lavori pubblici
				case "Settore lavori pubblici":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/settore-lavori-pubblici";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_n7xYoDRY4y8k_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							


							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/settore-lavori-pubblici");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Settore urbanistico
				case "Settore urbanistico":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/settore-urbanistico";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_8ntI5nQQOfNe_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();


							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/settore-urbanistico");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//SUAP
				case "SUAP":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/suap";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_qPrMhwBCNpmn_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							
							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/suap");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//URP-Accesso agli atti
				case "URP-Accesso agli atti":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/urp-accesso-agli-atti";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_zKSnTn54ygwV_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/urp-accesso-agli-atti");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Servizi sociali culturali ed educativi
				case "Servizi sociali culturali ed educativi":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/servizi-sociali-culturali-ed-educativi";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_2IADj8dgrv0l_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/servizi-sociali-culturali-ed-educativi");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Patrimonio Appalti e Contratti
				case "Patrimonio Appalti e Contratti":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/patrimonio-appalti-e-contratti";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_s4WYaj8T4OOR_\"]/div/div/div/div/div/div/div/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/patrimonio-appalti-e-contratti");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Servizi finanziari
				case "Servizi finanziari":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/servizi-finanziari";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_KyxBgmkcvbMw_\"]/div/div/div[1]/div/div/div/div[1]/h1")).asNormalizedText();
						String modulo = "Per maggiori informazioni a riguardo può visitare la pagina dedicata: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(modulo);
							answer2.setMedia("https://www.comune.moladibari.ba.it/servizi-finanziari");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Bandi di gara e contratti
				case "Bandi di gara e contratti":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/lavori-pubblici-e-urbanistica";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlAnchor) page1.getFirstByXPath("//*[@id=\"p_p_id_85_INSTANCE_CbqHEjyEX7Ap_\"]/div/div/div/ul/li[1]/a")).asNormalizedText();
						String info = "Per maggiori informazioni ti consiglio di visitare il seguenti link :";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(info);
							answer2.setMedia("https://www.comune.moladibari.ba.it/bandi-ed-esiti-di-gara/avvisi");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Bacheca tecnica
				case "Bacheca tecnica":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/lavori-pubblici-e-urbanistica";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlAnchor) page1.getFirstByXPath("//*[@id=\"p_p_id_85_INSTANCE_CbqHEjyEX7Ap_\"]/div/div/div/ul/li[3]/a")).asNormalizedText();
						String info = "Per maggiori informazioni ti consiglio di visitare il seguenti link :";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(info);
							answer2.setMedia("https://www.comune.moladibari.ba.it/bacheca-tecnica");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}

				//Salute
				//Norme vigenti
				case "Norme vigenti":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/norme-vigenti";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_6Rm541bpJ9La_\"]/div/div/div[1]/div/div/div/div/h1")).asNormalizedText();
						String info = "Per maggiori informazioni a riguardo può visitare la pagina dedicata :";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(info);
							answer2.setMedia("https://www.comune.moladibari.ba.it/norme-vigenti");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Avvisi e notizie
				case "Avvisi e notizie":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/avvisi-e-notizie";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_12yNg3Ei1j4D_\"]/div/div/div[1]/div/div/div/div/h1")).asNormalizedText();
						String info = "Per maggiori informazioni a riguardo può visitare la pagina dedicata :";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(info);
							answer2.setMedia("https://www.comune.moladibari.ba.it/avvisi-e-notizie");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Link utili
				case "Link utili":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/link-utili";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_VZeeaWU3ELWe_\"]/div/div/div[1]/div/div/div/div[1]/h1")).asNormalizedText();
						String ministero = "Ministero della Salute: ";
						String puglia = "Regione Puglia: ";
						String oms = "Organizzazione Mondiale della Sanità (OMS): ";
						String ministeroInterno = "Ministero dell'interno: ";
						String domande = "Domande frequenti sulle misure adottate dal Governo: ";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();


							answer1.setAnswerText(titolo);
							answer2.setAnswerText(ministero);
							answer2.setMedia("https://www.salute.gov.it/portale/nuovocoronavirus/homeNuovoCoronavirus.jsp");
							answer2.setMediaType("link");
							answer3.setAnswerText(puglia);
							answer3.setMedia("https://regione.puglia.it/web/speciale-coronavirus");
							answer3.setMediaType("link");
							answer4.setAnswerText(oms);
							answer4.setMedia("https://www.who.int/westernpacific/emergencies/covid-19");
							answer4.setMediaType("link");
							answer5.setAnswerText(ministeroInterno);
							answer5.setMedia("https://www.interno.gov.it/it");
							answer5.setMediaType("link");
							answer6.setAnswerText(domande);
							answer6.setMedia("https://www.governo.it/it/articolo/decreto-iorestoacasa-domande-frequenti-sulle-misure-adottate-dal-governo/14278");
							answer6.setMediaType("link");

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}

				//Denuce
				//Segnala la buca
				case "Segnala la buca":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/segnala-la-buca";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_2td43EgTZ5wO_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String corpo = ((HtmlParagraph) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_2td43EgTZ5wO_\"]/div/div/div/div/div/div/div[2]/p")).asNormalizedText();

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(corpo);


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}


				//Storia e cultura
				//Ricorrenze
				case "Ricorrenze":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/ricorrenze";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);
					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String titolocarnevale = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[1]")).asNormalizedText();
						String infocarnevale = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[1]/text()")).asNormalizedText();
						String carnevale = titolocarnevale.concat("\t" + infocarnevale);

						String falogiuseppe = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[2]")).asNormalizedText();
						String infofalogiuseppe = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[3]/text()")).asNormalizedText();
						String falogiu = falogiuseppe.concat("\t" + infofalogiuseppe);

						String faloannunziata = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[3]")).asNormalizedText();
						String infofaloannunziata = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[5]/text()")).asNormalizedText();
						String faloann = faloannunziata.concat("\t" + infofaloannunziata);

						String santantonio = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[5]")).asNormalizedText();
						String infosantantonio = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[9]/text()")).asNormalizedText();
						String sant = santantonio.concat("\t" + infosantantonio);

						String estatemolese = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[6]")).asNormalizedText();
						String infoestatemolese = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[11]/text()")).asNormalizedText();
						String estate = estatemolese.concat("\t" + infoestatemolese);

						String festadellamadonnadaltomare = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[7]")).asNormalizedText();
						String infofestadellamadonnadaltomare = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[13]/text()")).asNormalizedText();
						String festa = festadellamadonnadaltomare.concat("\t" + infofestadellamadonnadaltomare);

						String sagrapolpo = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[8]")).asNormalizedText();
						String infosagrapolpo = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[15]/text()")).asNormalizedText();
						String sagra = sagrapolpo.concat("\t" + infosagrapolpo);

						String sanrocco = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[9]")).asNormalizedText();
						String infosanrocco = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[17]/text()")).asNormalizedText();
						String sanro = sanrocco.concat("\t" + infosanrocco);

						String terranostra = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[10]")).asNormalizedText();
						String infoterranostra = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[19]/text()")).asNormalizedText();
						String terra = terranostra.concat("\t" + infoterranostra);

						String addolorata = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[11]")).asNormalizedText();
						String infoaddolorata = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[21]/text()")).asNormalizedText();
						String add = addolorata.concat("\t" + infoaddolorata);

						String arcangeloRaffaele = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[12]")).asNormalizedText();
						String infoarcangeloRaffaele = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[23]/text()")).asNormalizedText();
						String arcangelo = arcangeloRaffaele.concat("\t" + infoarcangeloRaffaele);

						String natalemolese = ((HtmlHeading3) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/h3[13]")).asNormalizedText();
						String infonatalemolese = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_gMhbcti7UEUz_\"]/div/div/div/div/div/div/div[2]/p[25]/text()")).asNormalizedText();
						String natale = natalemolese.concat("\t" + infoestatemolese);

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();
							final FormAnswer answer12 = new FormAnswer();
							final FormAnswer answer13 = new FormAnswer();



							answer1.setAnswerText(titolo);
							answer2.setAnswerText(carnevale);
							answer3.setAnswerText(falogiu);
							answer4.setAnswerText(faloann);
							answer5.setAnswerText(sant);
							answer6.setAnswerText(estate);
							answer7.setAnswerText(festa);
							answer8.setAnswerText(sagra);
							answer9.setAnswerText(sanro);
							answer10.setAnswerText(terra);
							answer11.setAnswerText(add);
							answer12.setAnswerText(arcangelo);
							answer13.setAnswerText(natale);



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							answerlist.add(answer12);
							answerlist.add(answer13);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Eventi culturali
				case "Eventi culturali":{

					try{
						String titolo = "Eventi culturali";
						String link = "Per maggiori informazioni ti consiglio di visualizzare il seguente link.";

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();


							answer1.setAnswerText(titolo);
							answer2.setAnswerText(link);
							answer2.setMedia("https://www.facebook.com/comunemoladibari/?ref=page_internal");
							answer2.setMediaType("link");


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
				//Il Comune
				case "Il Comune":{
					String BASE_URL = "https://www.comune.moladibari.ba.it/il-comune";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);

					try{
						HtmlPage page1 = client.getPage(BASE_URL);

						String titolo = ((HtmlHeading1) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_32QtabATDofR_\"]/div/div/div/div/div/div/div[1]/h1")).asNormalizedText();
						String corpo = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_32QtabATDofR_\"]/div/div/div/div/div/div/div[2]/text()[1]")).asNormalizedText();
						String corpo1 = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_32QtabATDofR_\"]/div/div/div/div/div/div/div[2]/text()[2]")).asNormalizedText();
						String corpo2 = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_32QtabATDofR_\"]/div/div/div/div/div/div/div[2]/text()[3]")).asNormalizedText();
						String corpo3 = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_32QtabATDofR_\"]/div/div/div/div/div/div/div[2]/text()[4]")).asNormalizedText();
						String corpo4 = ((DomText) page1.getFirstByXPath("//*[@id=\"p_p_id_56_INSTANCE_32QtabATDofR_\"]/div/div/div/div/div/div/div[2]/text()[5]")).asNormalizedText();
						String corpoCompleto = corpo.concat("\t" + corpo1.concat("\t" + corpo2.concat("\t" + corpo3.concat("\t" + corpo4))));

						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();

							answer1.setAnswerText(titolo);
							answer2.setAnswerText(corpoCompleto);


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
						client.close();
					}
					break;
				}
				//Strutture ricettive
				//Hotel
				case "Hotel":{

					try{
						List<Hotel> result = hotelGabbianoService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getDenominazione()); //metodo per visualizzare i relativi link su algho
							answer3.setAnswerText(result.get(0).getIndirizzo());
							answer4.setAnswerText(result.get(0).getContatti());
							answer5.setAnswerText(result.get(0).getCamere());
							answer6.setAnswerText(result.get(0).getPostiLetto());
							answer7.setAnswerText(result.get(0).getBagni());
							answer8.setAnswerText(result.get(0).getClassificazione());
							answer9.setAnswerText(result.get(0).getRistorazione());
							answer10.setAnswerText(result.get(0).getPeriodo());
							answer11.setAnswerText(result.get(0).getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);

							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				//Case e Appartamenti per vacanze
				case "Bella Puglia":{

					try{
						Optional<CaseEappartamenti> result = caseEappartamentiBellaPugliaService.findById(1L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getClassificazione());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "BellaPuglia":{

					try{
						Optional<CaseEappartamenti> result = caseEappartamentiBellaPuglia1Service.findById(2L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getClassificazione());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Le case-di-sottovento":{

					try{
						Optional<CaseEappartamenti> result = caseEappartamentiSottoventoService.findById(3L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getClassificazione());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				//Agriturismo
				case "Terramare Bio":{

					try{
						Optional<Agriturismo> result = agriturismoTerramareService.findById(1L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getClassificazione());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Tenuta Pinto":{

					try{
						Optional<Agriturismo> result = agriturismoTenutaPintoService.findById(3L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getClassificazione());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Masseria Serra Dell'Isola":{

					try{
						Optional<Agriturismo> result = agriturismoMasseriaSerraService.findById(2L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getClassificazione());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				//Turismo rurale
				case "Turismo rurale":{

					try{
						List<TurismoRurale> result = turismoRuraleService.findAll();
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();


							answer1.setAnswerText(result.get(0).getTitolo());
							answer2.setAnswerText(result.get(0).getDenominazione());
							answer3.setAnswerText(result.get(0).getIndirizzo());
							answer4.setAnswerText(result.get(0).getContatti());
							answer5.setAnswerText(result.get(0).getCamere());
							answer6.setAnswerText(result.get(0).getPostiLetto());
							answer7.setAnswerText(result.get(0).getBagni());
							answer8.setAnswerText(result.get(0).getClassificazione());
							answer9.setAnswerText(result.get(0).getRistorazione());
							answer10.setAnswerText(result.get(0).getPeriodo());
							answer11.setAnswerText(result.get(0).getApprovazione());


							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);


							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				//Campeggio
				case "Acqua Marina":{

					try{
						Optional<Campeggio> result = campeggioAcquaMarinaService.findById(1L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getClassificazione());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Pinocchio":{

					try{
						Optional<Campeggio> result = campeggioPinocchioService.findById(2L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getClassificazione());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				//B&B
				case "Pesciolino":{

					try{
						Optional<B_B> result = b_baPesceService.findById(10L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Casa Crispi":{

					try{
						Optional<B_B> result = b_bPansiniService.findById(2L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "La torre di campagna":{

					try{
						Optional<B_B> result = b_baPesceService.findById(15L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Trentatrequarantatre":{

					try{
						Optional<B_B> result = b_baSoldaniService.findById(8L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Le Dimore Delle Stelle":{

					try{
						Optional<B_B> result = b_bDimoreStelleService.findById(1L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Tramonto":{

					try{
						Optional<B_B> result = b_bLasorsaService.findById(9L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Le Terrazze":{

					try{
						Optional<B_B> result = b_bLaeraService.findById(6L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Al Duomo":{

					try{
						Optional<B_B> result = b_bIacoviello1Service.findById(12L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Dimora della nonna":{

					try{
						Optional<B_B> result = b_bIacovielloService.findById(5L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Souvenir d’eté":{

					try{
						Optional<B_B> result = b_bFurioService.findById(15L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Doña Flor":{

					try{
						Optional<B_B> result = b_bDePalmaService.findById(13L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Al Castello":{

					try{
						Optional<B_B> result = b_bBarnocchiService.findById(11L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Le case di sottovento":{

					try{
						Optional<B_B> result = b_bAloisioService.findById(14L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "Citofonare A.D.":{

					try{
						Optional<B_B> result = b_bAbatangeloService.findById(7L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}

				case "106 Maison de charme":{

					try{
						Optional<B_B> result = b_bGridiiService.findById(4L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();
							final FormAnswer answer11 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getEmail());
							answer6.setAnswerText(result.get().getCamere());
							answer7.setAnswerText(result.get().getPostiLetto());
							answer8.setAnswerText(result.get().getBagni());
							answer9.setAnswerText(result.get().getRistorazione());
							answer10.setAnswerText(result.get().getPeriodo());
							answer11.setAnswerText(result.get().getApprovazione());



							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							answerlist.add(answer11);
							response.setAnswers(answerlist);


							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {

					}
					break;
				}


				//Affittacamere
				case "Terra di Puglia":{

					try{
						Optional<Affittacamere> result = affittacamereTerraDiPugliaService.findById(6L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "San Giovanni":{

					try{
						Optional<Affittacamere> result = affittacamereSanGiovanniService.findById(3L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Masseria111SerraDell'Isola":{

					try{
						Optional<Affittacamere> result = affittacamereMasseriaSerraService.findById(8L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Locanda degli Angioini":{

					try{
						Optional<Affittacamere> result = affittacamereLocandaAngoiniService.findById(5L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "La Foresteria":{

					try{
						Optional<Affittacamere> result = affittacamereLaForesteriaService.findById(9L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Iacoviello":{

					try{
						Optional<Affittacamere> result = affittacamereIacovielloService.findById(12L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Denny The King":{

					try{
						Optional<Affittacamere> result = affittacamereDennyKingService.findById(10L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);



							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Dal Canonico":{

					try{
						Optional<Affittacamere> result = affittacamereDalCanonicoService.findById(11L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();


							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "CasaDaMare":{
					try{
						Optional<Affittacamere> result = affittacamereDamareService.findById(1L);
						try{

							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Casa-Da-Mare":{
					try{
						Optional<Affittacamere> result = affittacamereDamare1Service.findById(4L);
						try{
							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "Casa Del Sole":{
					try{
						Optional<Affittacamere> result = affittacamereDelSoleService.findById(2L);
						try{
							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				case "A San Domenico":{
					try{
						Optional<Affittacamere> result = affittacamereSanDomenicoService.findById(7L);
						try{
							final FormAnswer answer1 = new FormAnswer();
							final FormAnswer answer2 = new FormAnswer();
							final FormAnswer answer3 = new FormAnswer();
							final FormAnswer answer4 = new FormAnswer();
							final FormAnswer answer5 = new FormAnswer();
							final FormAnswer answer6 = new FormAnswer();
							final FormAnswer answer7 = new FormAnswer();
							final FormAnswer answer8 = new FormAnswer();
							final FormAnswer answer9 = new FormAnswer();
							final FormAnswer answer10 = new FormAnswer();

							answer1.setAnswerText(result.get().getTitolo());
							answer2.setAnswerText(result.get().getDenominazione());
							answer3.setAnswerText(result.get().getIndirizzo());
							answer4.setAnswerText(result.get().getContatti());
							answer5.setAnswerText(result.get().getCamere());
							answer6.setAnswerText(result.get().getPostiLetto());
							answer7.setAnswerText(result.get().getBagni());
							answer8.setAnswerText(result.get().getRistorazione());
							answer9.setAnswerText(result.get().getPeriodo());
							answer10.setAnswerText(result.get().getApprovazione());

							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							answerlist.add(answer1);
							answerlist.add(answer2);
							answerlist.add(answer3);
							answerlist.add(answer4);
							answerlist.add(answer5);
							answerlist.add(answer6);
							answerlist.add(answer7);
							answerlist.add(answer8);
							answerlist.add(answer9);
							answerlist.add(answer10);
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e ){
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}

					}catch (Exception e){
						e.printStackTrace();
					}finally {
					}
					break;
				}

				//Notizie
				case "Notizie":{
					String baseUrl = "https://www.comune.moladibari.ba.it";
					WebClient client = new WebClient();
					client.getOptions().setCssEnabled(false);
					client.getOptions().setJavaScriptEnabled(false);

					Document doc = Jsoup.connect(baseUrl).get();
					HtmlPage page1 = client.getPage(baseUrl);
					try {
						final List<HtmlElement> eventi = page1.getByXPath("//*[@id=\"p_p_id_101_INSTANCE_AtwuC4SadzVS_\"]/div/div/div[2]/div[2]/div");
						try {
							final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
							String inizio1 = "Notizie: ";

							final FormAnswer answer1 = new FormAnswer();
							answer1.setAnswerText(inizio1);
							answerlist.add(answer1);

							for (HtmlElement evento : eventi) {
								String not1 = ((HtmlElement) evento.getFirstByXPath("//*[@id=\"p_p_id_101_INSTANCE_AtwuC4SadzVS_\"]/div/div/div[2]/div[2]/div/div/ul[1]/li/div[3]")).asNormalizedText();
								String url1 = ((HtmlAnchor) evento.getFirstByXPath("//*[@id=\"p_p_id_101_INSTANCE_AtwuC4SadzVS_\"]/div/div/div[2]/div[2]/div/div/ul[1]/li/div[3]/a")).getHrefAttribute();
								String not2 = ((HtmlElement) evento.getFirstByXPath("//*[@id=\"p_p_id_101_INSTANCE_AtwuC4SadzVS_\"]/div/div/div[2]/div[2]/div/div/ul[2]/li/div[3]")).asNormalizedText();
								String url2 = ((HtmlAnchor) evento.getFirstByXPath("//*[@id=\"p_p_id_101_INSTANCE_AtwuC4SadzVS_\"]/div/div/div[2]/div[2]/div/div/ul[2]/li/div[3]/a")).getHrefAttribute();
								String not3 = ((HtmlElement) evento.getFirstByXPath("//*[@id=\"p_p_id_101_INSTANCE_AtwuC4SadzVS_\"]/div/div/div[2]/div[2]/div/div/ul[3]/li/div[3]")).asNormalizedText();
								String url3 = ((HtmlAnchor) evento.getFirstByXPath("//*[@id=\"p_p_id_101_INSTANCE_AtwuC4SadzVS_\"]/div/div/div[2]/div[2]/div/div/ul[3]/li/div[3]/a")).getHrefAttribute();

								if (not1.equals("Vedi tutto") || not1.equals("Maggiori dettagli")) {
									not1 = "";
									continue;
								}

								final FormAnswer answer = new FormAnswer();
								final FormAnswer answer2 = new FormAnswer();
								final FormAnswer answer3 = new FormAnswer();
								answer.setAnswerText(not1);
								answer.setMedia(url1);
								answer.setMediaType("link");

								answer2.setAnswerText(not2);
								answer2.setMedia(url2);
								answer2.setMediaType("link");

								answer3.setAnswerText(not3);
								answer3.setMedia(url3);
								answer3.setMediaType("link");

								answerlist.add(answer);
								answerlist.add(answer2);
								answerlist.add(answer3);
							}
							response.setAnswers(answerlist);

							return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

						}catch (final Exception e) {
							log.error("Couldn't serialize response for content type application/json", e);
							return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
						}
					}catch (Exception e) {
						e.printStackTrace();
					} finally{
						client.close();
					}
				}

				//CARTA D'ITENTITA'
				case "Carta Identità Elettronica":{
					String moduli = "Per maggiori informazioni a riguardo ti consiglio di visitare il seguente link: ";
					try {
						final FormAnswer answer = new FormAnswer();
						answer.setAnswerText(moduli);
						answer.setMedia("https://www.cartaidentita.interno.gov.it/");
						answer.setMediaType("link");
						final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
						answerlist.add(answer);
						response.setAnswers(answerlist);

						return new ResponseEntity<FormSubmitResponse>(response, HttpStatus.OK);

					}catch (final Exception e) {
						log.error("Couldn't serialize response for content type application/json", e);
						return new ResponseEntity<FormSubmitResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
					}

				}

			}

		}

		return new ResponseEntity<FormSubmitResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	private void assessorePoliticheCulturaliextracted(FormSubmitResponse response, List<Vicesindaco> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è: ");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getMandate());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessoreTurismoextracted(FormSubmitResponse response, List<Vicesindaco> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getMandate());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessoreServiziCimiterialiextracted(FormSubmitResponse response, List<Vicesindaco> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getMandate());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void DUCextracted(FormSubmitResponse response, List<Vicesindaco> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getMandate());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessoreCommercioextracted(FormSubmitResponse response, List<Vicesindaco> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getMandate());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessoreSUAPextracted(FormSubmitResponse response, List<Vicesindaco> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getMandate());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessoreMarketingTerritorialeextracted(FormSubmitResponse response, List<Vicesindaco> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getMandate());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessorePoliticheAbitativeextracted(FormSubmitResponse response, List<AssessoreDituri> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void assessorePubblicaIstruzioneextracted(FormSubmitResponse response, List<AssessoreDituri> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void assessoreCittaSolidaleextracted(FormSubmitResponse response, List<AssessoreDituri> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void assessoreCittaInclusivaextracted(FormSubmitResponse response, List<AssessoreDituri> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void assessorePoliticheComunitarieextracted(FormSubmitResponse response, List<AssessoreTarsitano> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessoreBioeconomiaextracted(FormSubmitResponse response, List<AssessoreTarsitano> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessorePescaextracted(FormSubmitResponse response, List<AssessoreTarsitano> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessoreAgricolturaextracted(FormSubmitResponse response, List<AssessoreTarsitano> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessorePoliticheAmbientaliextracted(FormSubmitResponse response, List<AssessoreTarsitano> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		response.setAnswers(answerlist);
	}

	private void assessoreOperePubblicheextracted(FormSubmitResponse response, List<AssessoreBerlen> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		final FormAnswer answer5 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getMandate());
		answer5.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		answerlist.add(answer5);
		response.setAnswers(answerlist);
	}

	private void assessoreDemanioextracted(FormSubmitResponse response, List<AssessoreBerlen> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		final FormAnswer answer5 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getMandate());
		answer5.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		answerlist.add(answer5);
		response.setAnswers(answerlist);
	}

	private void AssessoreMobilitaSostenibileextracted(FormSubmitResponse response, List<AssessoreBerlen> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		final FormAnswer answer5 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getMandate());
		answer5.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		answerlist.add(answer5);
		response.setAnswers(answerlist);
	}

	private void AssessoreQualitaAbitareextracted(FormSubmitResponse response, List<AssessoreBerlen> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		final FormAnswer answer5 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getMandate());
		answer5.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		answerlist.add(answer5);
		response.setAnswers(answerlist);
	}

	private void AssessorePianificazioneTerritorialeextracted(FormSubmitResponse response, List<AssessoreBerlen> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		final FormAnswer answer5 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getEmail());
		answer4.setAnswerText(result.get(0).getMandate());
		answer5.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		answerlist.add(answer5);
		response.setAnswers(answerlist);
	}

	private void AssessorePatrimonioextracted(FormSubmitResponse response, List<AssessoreSalamida> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void AssessoreProgrammazioneFinanziariaextracted(FormSubmitResponse response, List<AssessoreSalamida> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void AssessoreProgrammazioneEconomatoextracted(FormSubmitResponse response, List<AssessoreSalamida> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void AssessoreTributiextracted(FormSubmitResponse response, List<AssessoreSalamida> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void AssessoreBilancioextracted(FormSubmitResponse response, List<AssessoreSalamida> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		answer1.setAnswerText("Il responsabile è:");
		answer2.setAnswerText(result.get(0).getNome());
		answer3.setAnswerText(result.get(0).getDescrizione());


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		response.setAnswers(answerlist);
	}

	private void FotoResponseextracted(FormSubmitResponse response, String titolo) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		final FormAnswer answer5 = new FormAnswer();
		final FormAnswer answer6 = new FormAnswer();
		final FormAnswer answer7 = new FormAnswer();
		final FormAnswer answer8 = new FormAnswer();
		final FormAnswer answer9 = new FormAnswer();
		final FormAnswer answer10 = new FormAnswer();
		final FormAnswer answer11 = new FormAnswer();
		final FormAnswer answer12 = new FormAnswer();


		answer1.setAnswerText(titolo);
		answer2.setAnswerText("Castello: ");
		answer2.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/Castello.jpg/047f6166-44ca-428f-a97d-d26905912abe?version=1.0&t=1493273744000&imagePreview=1");
		answer2.setMediaType("img");
		answer3.setAnswerText("Loreto: ");
		answer3.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/loreto_1.jpg/59469621-3210-46ec-a0e7-ca6b0dcf1ce5?version=1.0&t=1493275012000&imagePreview=1");
		answer3.setMediaType("img");
		answer4.setAnswerText("Lungomare: ");
		answer4.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/Lungomare.jpg/122c25d2-ebb9-4e82-bc94-490ec63c5469?version=1.0&t=1493275031000&imagePreview=1");
		answer4.setMediaType("img");
		answer5.setAnswerText("Mola Antica: ");
		answer5.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/mola_antica.jpg/b0c9a332-7e0d-4cb0-b2c1-17a1088b336d?version=1.0&t=1493275065000&imagePreview=1");
		answer5.setMediaType("img");
		answer6.setAnswerText("Lungomare1: ");
		answer6.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/Lungomare_1.jpg/8d720d75-eaad-4b53-8455-15154ee50480?version=1.0&t=1493275049000&imagePreview=1");
		answer6.setMediaType("img");
		answer7.setAnswerText("Piazzaxx: ");
		answer7.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/Piazzaxx_1.jpg/d2687aba-74ae-46bc-ae04-ff28ad0f7d4f?version=1.0&t=1493275084000&imagePreview=1");
		answer7.setMediaType("img");
		answer8.setAnswerText("Piazzaxx_10: ");
		answer8.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/Piazzaxx_1.jpg/d2687aba-74ae-46bc-ae04-ff28ad0f7d4f?version=1.0&t=1493275084000&imagePreview=1");
		answer8.setMediaType("img");
		answer9.setAnswerText("Piazzaxx_2: ");
		answer9.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/Piazzaxx_2.jpg/d7f3f4a9-ed89-4936-854a-4d6248b1b87c?version=1.0&t=1493275131000&imagePreview=1");
		answer9.setMediaType("img");
		answer10.setAnswerText("Piazzaxx_8: ");
		answer10.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/Piazzaxx_8.jpg/aed9d6ec-45f8-4b52-a31b-e21e92a9ec2d?version=1.0&t=1493275147000&imagePreview=1");
		answer10.setMediaType("img");
		answer11.setAnswerText("Via Cesare Battisti: ");
		answer11.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/ViaCesareBattisti.jpg/493a554c-ced0-4925-9399-1153c9e558a0?version=1.0&t=1493275165000&imagePreview=1");
		answer11.setMediaType("img");
		answer12.setAnswerText("Via Di Vagno: ");
		answer12.setMedia("https://www.comune.moladibari.ba.it/documents/20182/67967/ViaDiVagno.jpg/c938a2bd-1b90-4b3d-9961-2fea93f83d2a?version=1.0&t=1493275181000&imagePreview=1");
		answer12.setMediaType("img");


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		answerlist.add(answer5);
		answerlist.add(answer6);
		answerlist.add(answer7);
		answerlist.add(answer8);
		answerlist.add(answer9);
		answerlist.add(answer10);
		answerlist.add(answer11);
		answerlist.add(answer12);

		response.setAnswers(answerlist);
	}

	private void BeniCulturaliRespondeextracted(FormSubmitResponse response, List<BeniCulturali> result) {
		final FormAnswer answer1 = new FormAnswer();
		final FormAnswer answer2 = new FormAnswer();
		final FormAnswer answer3 = new FormAnswer();
		final FormAnswer answer4 = new FormAnswer();
		final FormAnswer answer5 = new FormAnswer();
		final FormAnswer answer6 = new FormAnswer();
		final FormAnswer answer7 = new FormAnswer();
		final FormAnswer answer8 = new FormAnswer();
		final FormAnswer answer9 = new FormAnswer();
		final FormAnswer answer10 = new FormAnswer();
		final FormAnswer answer11 = new FormAnswer();
		final FormAnswer answer12 = new FormAnswer();
		final FormAnswer answer13 = new FormAnswer();
		final FormAnswer answer14 = new FormAnswer();
		final FormAnswer answer15 = new FormAnswer();
		final FormAnswer answer16 = new FormAnswer();

		answer1.setAnswerText(result.get(0).getTitolo());
		answer2.setAnswerText("Chiesa Matrice: ");
		answer3.setAnswerText(result.get(0).getChiesaMatriceTesto());
		answer4.setAnswerText("Se vuoi saperne di più sulla storia inerente alla Chiesa Matrice visita il seguente link: ");
		answer4.setMedia("https://www.comune.moladibari.ba.it/i-beni-culturali/-/asset_publisher/y2OtjEdOtjZA/content/chiesa-matrice?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fi-beni-culturali%3Fp_p_id%3D101_INSTANCE_y2OtjEdOtjZA%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_pos%3D1%26p_p_col_count%3D2");
		answer4.setMediaType("link");

		answer5.setAnswerText("Il Castello Angioino: ");
		answer6.setAnswerText(result.get(0).getIlCastelloAngioinoTesto());
		answer7.setAnswerText("Se vuoi saperne di più sulla storia inerente al Castello Angioino visita il seguente link: ");
		answer7.setMedia("https://www.comune.moladibari.ba.it/i-beni-culturali/-/asset_publisher/y2OtjEdOtjZA/content/il-castello-angioino?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fi-beni-culturali%3Fp_p_id%3D101_INSTANCE_y2OtjEdOtjZA%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_pos%3D1%26p_p_col_count%3D2");
		answer7.setMediaType("link");

		answer8.setAnswerText("Teatro Van Westerhout: ");
		answer9.setAnswerText(result.get(0).getTeatroVanWesterhouttesto());
		answer10.setAnswerText("Se vuoi saperne di più sulla storia inerente al Teatro Van Westerhout visita il seguente link: ");
		answer10.setMedia("https://www.comune.moladibari.ba.it/i-beni-culturali/-/asset_publisher/y2OtjEdOtjZA/content/teatro-van-westerhout?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fi-beni-culturali%3Fp_p_id%3D101_INSTANCE_y2OtjEdOtjZA%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_pos%3D1%26p_p_col_count%3D2");
		answer10.setMediaType("link");

		answer11.setAnswerText("La Chiesa Maddalena: ");
		answer12.setAnswerText(result.get(0).getLaChiesaMaddalenatesto());
		answer13.setAnswerText("Se vuoi saperne di più sulla storia inerente alla La Chiesa Maddalena visita il seguente link: ");
		answer13.setMedia("https://www.comune.moladibari.ba.it/i-beni-culturali/-/asset_publisher/y2OtjEdOtjZA/content/la-chiesa-maddalena?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fi-beni-culturali%3Fp_p_id%3D101_INSTANCE_y2OtjEdOtjZA%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_pos%3D1%26p_p_col_count%3D2");
		answer13.setMediaType("link");

		answer14.setAnswerText("Il Palazzo Roberti: ");
		answer15.setAnswerText(result.get(0).getIlPalazzoRobertitesto());
		answer16.setAnswerText("Se vuoi saperne di più sulla storia inerente al Palazzo Roberti visita il seguente link: ");
		answer16.setMedia("https://www.comune.moladibari.ba.it/i-beni-culturali/-/asset_publisher/y2OtjEdOtjZA/content/il-palazzo-roberti?inheritRedirect=false&redirect=https%3A%2F%2Fwww.comune.moladibari.ba.it%2Fi-beni-culturali%3Fp_p_id%3D101_INSTANCE_y2OtjEdOtjZA%26p_p_lifecycle%3D0%26p_p_state%3Dnormal%26p_p_mode%3Dview%26p_p_col_id%3Dcolumn-1%26p_p_col_pos%3D1%26p_p_col_count%3D2");
		answer16.setMediaType("link");


		final List<FormAnswer> answerlist = new ArrayList<FormAnswer>();
		answerlist.add(answer1);
		answerlist.add(answer2);
		answerlist.add(answer3);
		answerlist.add(answer4);
		answerlist.add(answer5);
		answerlist.add(answer6);
		answerlist.add(answer7);
		answerlist.add(answer8);
		answerlist.add(answer9);
		answerlist.add(answer10);
		answerlist.add(answer11);
		answerlist.add(answer12);
		answerlist.add(answer13);
		answerlist.add(answer14);
		answerlist.add(answer15);
		answerlist.add(answer16);
		response.setAnswers(answerlist);
	}


	@Override
	public ResponseEntity<FormFieldValidationResponse> validate(
			@ApiParam(value = "Json data", required = true) @Valid @RequestBody final FormFieldValidationRequest data,
			@ApiParam(value = "Algho-Token") @RequestHeader(value = "Algho-Token", required = false) final String alghoToken) {

		final String accept = "application/json"; // request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
		}
		return new ResponseEntity<FormFieldValidationResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<FormFieldValuesResponse> values(
			@ApiParam(value = "Json data", required = true) @Valid @RequestBody final FormFieldValuesRequest data,
			@ApiParam(value = "JWT Algho-Token") @RequestHeader(value = "Algho-Token", required = false) final String alghoToken) {

		final String accept = "application/json"; // request.getHeader("Accept");

		if (accept != null && accept.contains("application/json")) {
			try {

				final FormFieldValuesResponse response = new FormFieldValuesResponse();
				if (data.getFieldName().equals("Giunta Comunale")){
					final List<FormAdmissibileValue> values = new ArrayList<FormAdmissibileValue>();
					values.add(new FormAdmissibileValue().name("Sindaco"));
					values.add(new FormAdmissibileValue().name("Vicesindaco"));
					values.add(new FormAdmissibileValue().name("Assessore Caterina Salamida"));
					values.add(new FormAdmissibileValue().name("Assessore Nicola Berlen"));
					values.add(new FormAdmissibileValue().name("Assessore Elvira Tarsitano"));
					values.add(new FormAdmissibileValue().name("Assessore Domenica Dituri"));
					response.setValues(values);
				}
				
				return new ResponseEntity<FormFieldValuesResponse>(response, HttpStatus.OK);

			} catch (final Exception e) {
				log.error("Couldn't serialize response for content type application/json", e);
				return new ResponseEntity<FormFieldValuesResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return new ResponseEntity<FormFieldValuesResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}