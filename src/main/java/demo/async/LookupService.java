package demo.async;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class LookupService {
    private static final Logger logger = LoggerFactory.getLogger(LookupService.class);

    private final RestTemplate restTemplate;

    /// follow RestTemplateBuilder
    public LookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<GithubUser> findUser(String user) throws InterruptedException {
        logger.info("LookupService :Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        GithubUser results = restTemplate.getForObject(url, GithubUser.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(5000L);
        return CompletableFuture.completedFuture(results);
    }


}
