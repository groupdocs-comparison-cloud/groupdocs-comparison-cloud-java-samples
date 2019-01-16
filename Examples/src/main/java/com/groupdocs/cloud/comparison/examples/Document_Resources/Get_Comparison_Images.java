package com.groupdocs.cloud.comparison.examples.Document_Resources;

import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.ResponseMessage;
import com.groupdocs.cloud.comparison.api.ComparisonApi;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.examples.Utils;
import com.groupdocs.cloud.comparison.model.Link;
import com.groupdocs.cloud.comparison.model.requests.ComparisonImagesRequest;

import java.io.File;
import java.util.List;

import static com.groupdocs.cloud.comparison.examples.Helper.GetComparisonRequest;

/**
 * Created by Home on 12/19/2018.
 */
public class Get_Comparison_Images {

    public static void main(String[] args) throws ApiException {

        /**
         * Returns images of document with the result of comparison
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
        ComparisonImagesRequest request = new ComparisonImagesRequest();
        request.setRequest(GetComparisonRequest(sourceName, targetName));
        request.setOutFolder(outPath);
        List<Link> response = comparisonApi.comparisonImages(request);
        for (Link link : response) {
            System.out.println(link.getHref());
        }
    }
}
