package com.coaching2live.service.aws.s3.bucket;

import java.util.List;

import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;

/**
 * Cada objeto (arquivo) no Amazon S3 deve residir em um bucket, que representa um conjunto (contêiner) de objetos. 
 * Cada bucket é conhecido por uma chave (nome), que deve ser exclusiva.
 * 
 * */

@Component
public class BucketBusiness implements BucketServices {
	 
	/**
	 * 
	 * */
	 public Bucket createBucket(final String BUCKET_NAME) {

		 try {

			 final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
			 Bucket b = null;

			 if (s3.doesBucketExistV2(BUCKET_NAME)) {

			    System.out.format("Bucket %s already exists.\n", BUCKET_NAME);
			    b = getBucket(BUCKET_NAME);
			 } else {

				 try {

					 b = s3.createBucket(BUCKET_NAME);
				 } catch (AmazonS3Exception e) {

					 System.err.println(e.getErrorMessage());
				 }
			 }

			 return b;
		} catch (Exception e) {

			throw e;
		}
	 }
	 
	 /**
	  * 
	  * */
	 public Bucket getBucket(String bucket_name) {
		 
		 final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
		 Bucket named_bucket = null;
		 List<Bucket> buckets = s3.listBuckets();
		 for (Bucket b : buckets) {

		    if (b.getName().equals(bucket_name)) {

		        named_bucket = b;
		    }
		 }
		 	return named_bucket;
	    }
}
