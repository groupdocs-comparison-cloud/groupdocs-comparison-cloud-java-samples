package examples.Working_With_Storage;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import examples.Utils;

public class Comparison_Java_Get_Disc_Usage {

	public static void main(String[] args) {

		StorageApi apiInstance = new StorageApi(Utils.AppSID, Utils.AppKey);
		try {
			GetDiscUsageRequest request = new GetDiscUsageRequest(Utils.MYStorage);
			DiscUsage response = apiInstance.getDiscUsage(request);
			System.out.println("Expected response type is DiscUsage: " + response.getUsedSize());
		} catch (ApiException e) {
			System.err.println("Exception while calling StorageApi:");
			e.printStackTrace();
		}
	}
}