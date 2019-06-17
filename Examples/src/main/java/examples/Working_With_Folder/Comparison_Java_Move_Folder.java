package examples.Working_With_Folder;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.requests.*;
import examples.Utils;

public class Comparison_Java_Move_Folder {

	public static void main(String[] args) {

		FolderApi apiInstance = new FolderApi(Utils.AppSID, Utils.AppKey);
		try {
			MoveFolderRequest request = new MoveFolderRequest("Comparisondocs1", "Comparisondocs\\Comparisondocs1",
					Utils.MYStorage, Utils.MYStorage);
			apiInstance.moveFolder(request);
			System.out.println(
					"Expected response type is Void: 'Comparisondocs1' folder moved to 'Comparisondocs/Comparisondocs1'.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FolderApi:");
			e.printStackTrace();
		}
	}
}