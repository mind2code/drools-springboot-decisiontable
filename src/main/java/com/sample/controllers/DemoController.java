package com.sample.controllers;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.models.Souscription;
import com.sample.models.Souscription.EnergieType;

@RestController
public class DemoController {

	@PostMapping("/souscription")
	public Souscription getSouscription(@RequestBody Souscription sous) {
		
		Souscription souscription = new Souscription();
		 try {
	            // load up the knowledge base
		        KieServices ks = KieServices.Factory.get();
	    	    KieContainer kContainer = ks.getKieClasspathContainer();
	        	KieSession kSession = kContainer.newKieSession("ksession-dtables");

	
	        	souscription.setEnergieType(sous.getEnergieType());
	        	souscription.setPuissanceFiscale(sous.getPuissanceFiscale());
	            // go !
	            //Message message = new Message();
	//	            message.setMessage("Hello World");
	//	            message.setStatus(Message.HELLO);
	            kSession.insert(souscription);
	            kSession.fireAllRules();
	            //System.out.println(souscription.getMontantRC());
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
		 
		 return souscription;
	}
}
