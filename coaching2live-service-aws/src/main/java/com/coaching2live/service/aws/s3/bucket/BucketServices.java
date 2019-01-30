package com.coaching2live.service.aws.s3.bucket;

import com.amazonaws.services.s3.model.Bucket;

public interface BucketServices {
	
	Bucket createBucket(final String BUCKET_NAME) throws Exception;
}
