package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.models.Souscription;
import com.sample.models.Souscription.EnergieType;

/**
 * This is a sample class to launch a rule.
 */
public class DecisionTableTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-dtables");

        	Souscription sous = new Souscription();
        	
        	sous.setEnergieType(EnergieType.ESSENCE);
        	sous.setPuissanceFiscale(14);
            // go !
            //Message message = new Message();
//            message.setMessage("Hello World");
//            message.setStatus(Message.HELLO);
            kSession.insert(sous);
            kSession.fireAllRules();
            System.out.println(sous.getMontantRC());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }

}
