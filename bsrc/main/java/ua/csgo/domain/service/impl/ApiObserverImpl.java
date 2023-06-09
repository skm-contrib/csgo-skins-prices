package ua.csgo.domain.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.csgo.domain.model.api.SkinPrice;
import ua.csgo.domain.service.ApiObserver;

import java.util.Arrays;

@Component
public class ApiObserverImpl implements ApiObserver {

    final private RestTemplate template;
    final static int observeRate = 60000 * 60;
    @Value("${api.lootfarm.url}")
    private String lootfarmApiUrl;

    public ApiObserverImpl() {
        this.template = new RestTemplate();
    }

    @Override
    @Scheduled(fixedRate = observeRate)
    public void observeApi() {
        System.out.println("Send");
        SkinPrice[] skinPrices = template.getForObject(lootfarmApiUrl, SkinPrice[].class);

        Arrays.stream(skinPrices).forEach(System.out::println);
    }
}
