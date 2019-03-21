package api.proxy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties
public class Properties {

    @Value("${history-api}")
    private String historyApi;

    @Value("${token}")
    private String token;


    public String getHistoryApi() {
        return historyApi;
    }

    public String getToken() { return token; }

}
