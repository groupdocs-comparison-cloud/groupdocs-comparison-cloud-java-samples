package com.groupdocs.cloud.comparison.examples.Changes_Resources;

import com.aspose.storage.api.StorageApi;
import com.aspose.storage.model.ResponseMessage;
import com.groupdocs.cloud.comparison.api.ChangesApi;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.examples.Utils;
import com.groupdocs.cloud.comparison.model.ComparisonChangesCategoryDto;
import com.groupdocs.cloud.comparison.model.requests.PostCategoriesChangesRequest;
import net.sf.json.JSONObject;

import java.io.File;
import java.util.List;

import static com.groupdocs.cloud.comparison.examples.Helper.GetComparisonRequest;


/**
 * Created by Home on 12/12/2018.
 */
public class Get_Changes_Categories {
    public static void main(String[] args) throws ApiException {

        /**
         * Posts the categories changes.
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
        PostCategoriesChangesRequest request = new PostCategoriesChangesRequest();
        request.setRequest(GetComparisonRequest(sourceName, targetName));
        request.setCategoriesType("ByNodeType");

        List<ComparisonChangesCategoryDto> response = changesApi.postCategoriesChanges(request);
        System.out.println(response);
        for (ComparisonChangesCategoryDto comparisonChangesCategoryDto : response) {
            //Assert.assertNotNull(comparisonChangesCategoryDto);
            //Assert.assertTrue(comparisonChangesCategoryDto instanceof ComparisonChangesCategoryDto);
        }
    }
}
