package com.coaching2live.service.aws.s3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coaching2live.service.aws.s3.bucket.BucketServices;
import com.coaching2live.service.aws.s3.object.ObjectServices;

@Service
public class AmazonS3Services {

	@Autowired
	private ObjectServices objectServices;
	
	@Autowired
	private BucketServices bucketServices;

	public ObjectServices objectServices() {
		return objectServices;
	}

	public BucketServices bucketServices() {
		return bucketServices;
	}
	
	
}


