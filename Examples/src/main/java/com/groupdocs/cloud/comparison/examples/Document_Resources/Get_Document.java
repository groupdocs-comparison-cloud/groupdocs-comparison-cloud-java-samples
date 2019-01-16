package com.groupdocs.cloud.comparison.examples.Document_Resources;

import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.ResponseMessage;
import com.groupdocs.cloud.comparison.api.ComparisonApi;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.examples.Utils;
import com.groupdocs.cloud.comparison.model.Link;
import com.groupdocs.cloud.comparison.model.requests.ComparisonRequest;

import java.io.File;

import static com.groupdocs.cloud.comparison.examples.Helper.GetComparisonRequest;

/**
 * Created by Home on 12/19/2018.
 */
public class Get_Document {

    public static void main(String[] args) throws ApiException {

        /**
         * Returns document with the result of comparison
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

        ComparisonApi comparisonApi = Utils.getComparisonApiInstance();
        ComparisonRequest request = new ComparisonRequest();
        request.setRequest(GetComparisonRequest(sourceName, targetName));
        request.setOutPath(outPath);
        Link response = comparisonApi.comparison(request);
        System.out.println(response);

    }
}
