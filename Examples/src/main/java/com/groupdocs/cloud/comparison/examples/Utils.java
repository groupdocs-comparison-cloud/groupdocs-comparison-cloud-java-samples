package com.groupdocs.cloud.comparison.examples;

import com.aspose.storage.api.StorageApi;
import com.groupdocs.cloud.comparison.api.ChangesApi;
import com.groupdocs.cloud.comparison.api.ComparisonApi;
import com.groupdocs.cloud.comparison.client.Configuration;

import java.nio.file.Paths;

/**
 * Created by Home on 12/12/2018.
 */
public class Utils {
    /*
     * Get your AppSID and AppKey at https://dashboard.groupdocs.cloud/ (free
     * registration is required)
     */
    public static String AppSID = "xxxxxxxxx";
    public static String AppKey = "xxxxxxxxxx";
    public static String BaseApiUrl = "https://api.groupdocs.cloud";


    public static ChangesApi getChangesApiInstance()
    {
        Configuration configuration = new Configuration(AppSID, AppKey);
        configuration.setApiBaseUrl(BaseApiUrl);
        ChangesApi changesApi= new ChangesApi(configuration);
        changesApi.getApiClient().setConnectTimeout(300 * 1000);
        changesApi.getApiClient().setReadTimeout(300 * 1000);
        return changesApi;
    }

    public static ComparisonApi getComparisonApiInstance()
    {
        Configuration configuration = new Configuration(AppSID, AppKey);
        configuration.setApiBaseUrl(BaseApiUrl);
        ComparisonApi comparisonApi= new ComparisonApi(configuration);
        comparisonApi.getApiClient().setConnectTimeout(300 * 1000);
        comparisonApi.getApiClient().setReadTimeout(300 * 1000);
        return comparisonApi;
    }

    public static StorageApi getStorageApiInstance()
    {
        StorageApi storageApi;
        storageApi = new StorageApi(BaseApiUrl + "/v1", AppKey, AppSID);

        return storageApi;
    }
}
