package com.groupdocs.cloud.comparison.examples.Document_Resources;

import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.ResponseMessage;
import com.groupdocs.cloud.comparison.api.ComparisonApi;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.examples.Utils;
import com.groupdocs.cloud.comparison.model.requests.ComparisonImagesStreamRequest;

import java.io.File;

import static com.groupdocs.cloud.comparison.examples.Helper.GetComparisonRequest;

/**
 * Created by Home on 12/19/2018.
 */
public class Get_Comparison_Images_Stream {

    public static void main(String[] args) throws ApiException {

        /**
         * Returns images streams of document with the result of comparison
         *
         * @throws ApiException if the Api call fails
         */

        String sourceName = "source.docx",
                targetName = "target.docx";

        StorageApi storageApi = Utils.getStorageApiInstance();

        // Upload files to Cloud Storage
        File file = new File("src/main/resources/" + sourceName);
        ResponseMessage storageresponse = storageApi.PutCreate("comparison/" + sourceName, null, null, file);
        file = new File("src/main/resources/" + targetName);
        storageresponse = storageApi.PutCreate("comparison/" + targetName, null, null, file);

        ComparisonApi comparisonApi = Utils.getComparisonApiInstance();
        ComparisonImagesStreamRequest request = new ComparisonImagesStreamRequest();
        request.setRequest(GetComparisonRequest(sourceName, targetName));
        File response = comparisonApi.comparisonImagesStream(request);
        System.out.println(response);

    }
}
