package com.groupdocs.cloud.comparison.examples.Changes_Resources;

import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.ResponseMessage;
import com.groupdocs.cloud.comparison.api.ChangesApi;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.examples.Utils;
import com.groupdocs.cloud.comparison.model.ComparisonChange;
import com.groupdocs.cloud.comparison.model.requests.PostChangesRequest;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.util.List;

import static com.groupdocs.cloud.comparison.examples.Helper.GetComparisonRequest;

/**
 * Created by Home on 12/12/2018.
 */
public class Get_Changes {
    public static void main(String[] args) throws ApiException {

        /**
         * Returns json result with set of changes between documents
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
        PostChangesRequest request = new PostChangesRequest();
        request.setRequest(GetComparisonRequest(sourceName, targetName));
        List<ComparisonChange> response = changesApi.postChanges(request);
        System.out.println(response);
        for (ComparisonChange comparisonChange : response) {
            System.out.println(comparisonChange.getAction());
            //  Assert.assertTrue(comparisonChange instanceof ComparisonChange);
        }
    }

}
