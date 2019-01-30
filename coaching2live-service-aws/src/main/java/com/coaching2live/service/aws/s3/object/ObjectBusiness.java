package com.coaching2live.service.aws.s3.object;

import java.io.File;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.coaching2live.model.enums.BucketFolderNameEnum;
import com.coaching2live.model.enums.BucketNameEnum;
import com.coaching2live.model.exception.Coaching2liveException;

@Component
public class ObjectBusiness implements ObjectServices {
	
	/**
	 * Upload de um objeto.
	 *	Use o método putObject de cliente do AmazonS3 fornecendo um nome de bucket, 
	 *		um nome de chave e um arquivo para upload.
 	 * 	O bucket deve existir ou isso resultará em um erro.
 	 * 
 	 * @param BUCKET_NAME {@link BucketNameEnum}
 	 * @param BUCKET_FOLDER_NAME {@link BucketFolderNameEnum}
 	 * @param KEY_NAME {@link String}
 	 * @param FILE_PATH {@link String} 
	 * */
	public PutObjectResult putObject(
			final BucketNameEnum BUCKET_NAME,
			final BucketFolderNameEnum BUCKET_FOLDER_NAME, 
			final String KEY_NAME,
			final String FILE_PATH) throws Coaching2liveException {

        System.out.format("Uploading %s to S3 bucket %s...\n", FILE_PATH, BUCKET_NAME);
        final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
        try {

        	final String DESTINO = BUCKET_NAME.getName() + "/" + BUCKET_FOLDER_NAME.getName();

        	PutObjectRequest request = new PutObjectRequest (DESTINO, KEY_NAME, new File(FILE_PATH)); 
        	request.setCannedAcl (CannedAccessControlList.PublicRead); 
        	PutObjectResult result = s3Client.putObject (request);

        	return result;
        } catch (AmazonServiceException e) {

            System.err.println(e.getErrorMessage());         
            throw new Coaching2liveException(e);
        }
	}
	
	/**
	 * Upload de um objeto.
	 *	Use o método putObject de cliente do AmazonS3 fornecendo um nome de bucket, 
	 *		um nome de chave e um arquivo para upload.
 	 * 	O bucket deve existir ou isso resultará em um erro.
 	 * 
 	 * @param BUCKET_NAME {@link BucketNameEnum}
 	 * @param BUCKET_FOLDER_NAME {@link BucketFolderNameEnum}
 	 * @param KEY_NAME {@link String}
 	 * @param FILE_PATH {@link String} 
	 * */
	public URL getUrl(
			final BucketNameEnum BUCKET_NAME,
			final BucketFolderNameEnum BUCKET_FOLDER_NAME, 
			final String KEY_NAME) throws Coaching2liveException {

        System.out.format("getUrl %s to S3 bucket...\n", BUCKET_NAME);
        try {

        	final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
        	final String DESTINO = BUCKET_NAME.getName() + "/" + BUCKET_FOLDER_NAME.getName();
        	URL url = s3Client.getUrl(DESTINO, KEY_NAME);

        	return url;
        } catch (AmazonServiceException e) {

            System.err.println(e.getErrorMessage());         
            throw new Coaching2liveException(e);
        }
	}
	
	/**
	 * 
	 * @param BUCKET_NAME {@link BucketNameEnum}
 	 * @param BUCKET_FOLDER_NAME {@link BucketFolderNameEnum}
 	 * @param KEY_NAME {@link String}
	 * */
	public S3Object getObject(
			final BucketNameEnum BUCKET_NAME,
			final BucketFolderNameEnum BUCKET_FOLDER_NAME,
			final String KEY_NAME) throws Coaching2liveException {

        System.out.format("getObject %s from S3 bucket ...\n", BUCKET_NAME.getName());
        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        try {

        	String DESTINO = BUCKET_NAME.getName().concat("/").concat(BUCKET_FOLDER_NAME.getName());
        	S3Object result = s3.getObject(DESTINO, KEY_NAME);
        	return result;
        } catch (AmazonServiceException e) {

            System.err.println(e.getErrorMessage());         
            throw new Coaching2liveException(e);
        }
	}
	
	@Override
	public URL generatePresignedURL(BucketNameEnum BUCKET_NAME, BucketFolderNameEnum BUCKET_FOLDER_NAME,
			String KEY_NAME) throws Exception {
		
		System.out.format("getObject %s from S3 bucket ...\n", BUCKET_NAME.getName());
		final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
		  
		java.util.Date expiration = new java.util.Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 60;
        expiration.setTime(expTimeMillis);
         
        String DESTINO = BUCKET_NAME.getName().concat("/").concat(BUCKET_FOLDER_NAME.getName());
         
        //Generate the presigned URL.
        System.out.println("Generating pre-signed URL.");
        GeneratePresignedUrlRequest generatePresignedUrlRequest = 
                 new GeneratePresignedUrlRequest(DESTINO, KEY_NAME)
                 .withMethod(HttpMethod.GET)
                 .withExpiration(expiration);
        URL url = s3.generatePresignedUrl(generatePresignedUrlRequest);

        System.out.println("Pre-Signed URL: " + url.toString());

        return url;
	} 
}
