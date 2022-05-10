package com.example.async_method_05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner{
    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
    private final GitHubLookupService gitHubLookupService;

    public AppRunner(GitHubLookupService gitHubLookupService) {
        this.gitHubLookupService = gitHubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Start the clock
        long start = System.currentTimeMillis();

        // Fire multiple asynchronous lookups
        CompletableFuture<User> page01 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page02 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page03 = gitHubLookupService.findUser("Spring-Projects");
        CompletableFuture<User> page04 = gitHubLookupService.findUser("Microsoft");

        // Wait until all done
        CompletableFuture.allOf(page01, page02, page03, page04).join();

        // Print results and elapsed time
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + page01.get());
        logger.info("--> " + page02.get());
        logger.info("--> " + page03.get());
        logger.info("--> " + page04.get());
    }
}
