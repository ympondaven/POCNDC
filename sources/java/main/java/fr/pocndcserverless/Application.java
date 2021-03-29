package fr.pocndcserverless;


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.AmazonS3Exception;

import org.springframework.context.event.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import fr.pocndcserverless.Config;

@SpringBootApplication(exclude = ContextInstanceDataAutoConfiguration.class)
public class Application {

    private final AmazonS3Client amazonS3Client;
    
    @Autowired
    private Config config;

    public Application(AmazonS3Client amazonS3Client) {
        this.amazonS3Client = amazonS3Client;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener(classes = ApplicationReadyEvent.class)
    public void onApplicationReadyEvent(ApplicationReadyEvent event) {
        try {
            S3Object object = this.amazonS3Client.getObject(this.config.getBucket(), this.config.getObject());
            InputStreamReader streamReader = new InputStreamReader(object.getObjectContent(), StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);

            for (String line : reader.lines().collect(Collectors.toList())) {
                System.out.println("Found element : " + line);
                
                String url = this.config.getService().replace("<element>", line);
                System.out.println("Calling URL : " + url);
            
                HttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGetRequest = new HttpGet(url);
                httpClient.execute(httpGetRequest);
            }
        } catch (AmazonS3Exception exception) {
            System.out.println(exception.getMessage());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

