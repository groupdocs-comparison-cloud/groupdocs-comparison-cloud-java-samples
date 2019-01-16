package com.groupdocs.cloud.comparison.examples.Changes_Resources;

import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.ResponseMessage;
import com.groupdocs.cloud.comparison.api.ChangesApi;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.examples.Utils;
import com.groupdocs.cloud.comparison.model.requests.PutChangesImagesStreamRequest;

import java.io.File;

import static com.groupdocs.cloud.comparison.examples.Helper.GetComparisonRequest;

/**
 * Created by Home on 12/19/2018.
 */
public class Get_Changes_Images_Stream {
    public static void main(String[] args) throws ApiException {

        /**
         * Applies changes to the document and returns image&#39;s streams of document with the result of comparison
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

        ChangesApi changesApi = Utils.getChangesApiInstance();
        PutChangesImagesStreamRequest request = new PutChangesImagesStreamRequest();
        request.setRequest(GetComparisonRequest(sourceName, targetName));
        Object response = changesApi.putChangesImagesStream(request);
        System.out.println(response);
    }
}
