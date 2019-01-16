package com.groupdocs.cloud.comparison.examples.Changes_Resources;

import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.ResponseMessage;
import com.groupdocs.cloud.comparison.api.ChangesApi;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.examples.Utils;
import com.groupdocs.cloud.comparison.model.Link;
import com.groupdocs.cloud.comparison.model.requests.PutChangesDocumentRequest;
import com.groupdocs.cloud.comparison.model.requests.PutChangesImagesRequest;

import java.io.File;
import java.util.List;

import static com.groupdocs.cloud.comparison.examples.Helper.GetComparisonRequest;

/**
 * Created by Home on 12/19/2018.
 */
public class Get_Changes_Document {

    public static void main(String[] args) throws ApiException {

        /**
         * Applies changes to the document and returns document with the result of comparison
         *
         * @throws ApiException if the Api call fails
         */

        String outPath = "result.docx",
                sourceName = "source.docx",
                targetName = "target.docx";

        StorageApi storageApi = Utils.getStorageApiInstance();

        // Upload files to Cloud Storage
        File file = new File("src/main/resources/" + sourceName);
        ResponseMessage storageresponse = storageApi.PutCreate("comparison/" + sourceName, null, null, file);
        file = new File("src/main/resources/" + targetName);
        storageresponse = storageApi.PutCreate("comparison/" + targetName, null, null, file);

        ChangesApi changesApi = Utils.getChangesApiInstance();
        PutChangesDocumentRequest request = new PutChangesDocumentRequest();
        request.setRequest(GetComparisonRequest(sourceName, targetName));
        request.setOutPath(outPath);
        Link response = changesApi.putChangesDocument(request);
        System.out.println(response);
    }
}
