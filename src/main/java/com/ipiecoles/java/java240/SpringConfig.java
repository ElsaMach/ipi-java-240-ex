package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringConfig {
    //beans

    @Value("${bitcoinService.forceRefresh}")
    Boolean forceRefresh;

    @Bean(name = "bitcoinServiceWithoutCache")
    @Qualifier("withoutCache")
    @Scope("singleton")//Facultatif car par défaut
    public BitcoinService bitcoinServiceWithoutCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(true);
        //bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }


    public static void main(String[] args){
        System.out.println("Avant initialisation du contexte");
        SpringApplication.run(SpringConfig.class, args);
        System.out.println("Après initialisation du contexte");


    }
 /*   @Bean(name = "bitcoinServiceWithCache")
    public BitcoinService bitcoinServiceWithCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(false);
      //  bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }*/


   /* @Bean
    public WebPageManager webPageManager(){
        return new WebPageManager();
    }

    @Bean(initMethod = "initialiserCatalogue")
    public ProduitManager produitManager(){
        ProduitManager produitManager = new ProduitManager();
        produitManager.setBitcoinService(bitcoinServiceWithoutCache());
        produitManager.setWebPageManager(webPageManager());
        return produitManager;
    }*/
}
