package com.coaching2live.service.aws.s3.object;

import java.net.URL;

import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.coaching2live.model.enums.BucketFolderNameEnum;
import com.coaching2live.model.enums.BucketNameEnum;
import com.coaching2live.model.exception.Coaching2liveException;

public interface ObjectServices {

	PutObjectResult putObject(final BucketNameEnum BUCKET_NAME, final BucketFolderNameEnum BUCKET_FOLDER_NAME, final String KEY_NAME, final String FILE_PATH) throws Exception;
	S3Object getObject(final BucketNameEnum BUCKET_NAME, final BucketFolderNameEnum BUCKET_FOLDER_NAME, final String KEY_NAME) throws Exception;
	URL generatePresignedURL(final BucketNameEnum BUCKET_NAME, final BucketFolderNameEnum BUCKET_FOLDER_NAME, String KEY_NAME) throws Exception;
	URL getUrl(final BucketNameEnum BUCKET_NAME, final BucketFolderNameEnum BUCKET_FOLDER_NAME, final String KEY_NAME) throws Coaching2liveException;
}
