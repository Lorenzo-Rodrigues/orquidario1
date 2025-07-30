package com.lorenzo.orquidario1.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
public class OrquidarioS3 {

    private final S3Client s3Client;
    private final String bucketName;
    private final String region;

    public OrquidarioS3(@Value("${aws.bucket-name}")String bucketName,
                        @Value("${aws.s3.region}") String region) {
        this.bucketName = bucketName;
        this.region = region;
        this.s3Client = S3Client.builder()
                .region(Region.of(this.region))
                .build();
    }

    public String salvarImagemNoS3(byte[] bytes, String nomeArquivo){
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(nomeArquivo)
                .contentType("image/png")
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(bytes));

        return String.format("https://%s.s3.%s.amazonaws.com/%s",bucketName, region, nomeArquivo);
    }
}
