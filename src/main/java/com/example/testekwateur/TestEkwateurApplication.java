package com.example.testekwateur;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import com.example.testekwateur.model.Offer;
import com.example.testekwateur.model.PromoCode;

@SpringBootApplication
public class TestEkwateurApplication implements CommandLineRunner{
	
	public boolean isPromoCodeValid = false;
	public String promoCodetoTest = null;
	
    private static Logger LOG = LoggerFactory
    	      .getLogger(TestEkwateurApplication.class);

	public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(TestEkwateurApplication.class, args);
        LOG.info("APPLICATION FINISHED");
	}
	

	@Override
	public void run(String... args) throws Exception {
		// Get promo code to test from command line from args
		// TODO : Need a much more cleaner way to get args (error handling etc...)
        promoCodetoTest = args[0];
        if(promoCodetoTest != null) {
            //Get promoCodeList to verify that the promo code provided through is valid
    		ArrayList<PromoCode> promoCodeList = new ArrayList<PromoCode>();
    		promoCodeList = getPromoCodeList();
    		isPromoCodeValid = testPromoCode(promoCodeList, promoCodetoTest);
    		
    		// TODO :use try catch block and proper error handling
    		if(isPromoCodeValid) {
    			// If the promo code is valid then we can fetch the offersAPI to get the offersList to put in the json file
        		ArrayList<Offer> offerList = new ArrayList<Offer>();
        		offerList = getOfferList(promoCodetoTest);
    			if(!offerList.isEmpty()) {
    				// TODO : generate json with 
    			} else {
    				System.out.println("Aucune offre compatible trouvée");
    			}
    		} else if(!isPromoCodeValid) {
    				System.out.println("Le code promo fournit est invalide");
    		} else {
    			System.out.println("Une erreur a eu lieu");
    		}
        }
		
	}
	
	// TODO: Might unite the getPromoCodeList && getOfferList through a same method since that the only change seems
	// to be the URI call & and the object settled
	private ArrayList<PromoCode> getPromoCodeList() {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<PromoCode> promoCodeList = new ArrayList<PromoCode>();

		// TODO : Either use webclient or restTemplate from spring boot to fetch api
		restTemplate.getForObject("https://601025826c21e10017050013.mockapi.io/ekwatest/promoCodeList", PromoCode.class);
		// TODO :Need some errors handling and to transform it into an PromoCode object or PromoCode object List
		
		return promoCodeList;
		
	}

	private ArrayList<Offer> getOfferList(String promoCodetoTest) {
		RestTemplate restTemplate = new RestTemplate();
		ArrayList<Offer> offerList = new ArrayList<Offer>();

		// TODO :Either use webclient or restTemplate from spring boot to fetch api
		restTemplate.getForObject("https://601025826c21e10017050013.mockapi.io/ekwatest/offerList", Offer.class);
		// TODO :Need some errors handling and to transform it into an Offer object or Offer object List
		
		// TODO : use stream library to collect offers from validPromoCodeList array which contains promoCodetoTest
		offerList.stream().collect(null);

		return offerList;
		
	}
	
	private boolean testPromoCode(ArrayList<PromoCode> promoCodeList, String promoCodetoTest) {
		// Fetch code field && endDate to verify the validity of the promoCode
        for(PromoCode promoCodeinList:promoCodeList) {
            System.out.println(promoCodeinList);
            // If the promoCode exist then look if the date is still valid
            if(promoCodeinList.getCode().equals(promoCodetoTest)) {
            	if(!promoCodeinList.isDatePast(promoCodeinList.getEndDate(), "yyyy-MM-dd")) {
            		return true;
            	}
            }
        }
		return false;
		
	}

	
}
