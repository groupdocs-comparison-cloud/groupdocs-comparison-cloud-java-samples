package examples.Working_With_Folder;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.requests.*;
import examples.Utils;

public class Comparison_Java_Delete_Folder {

	public static void main(String[] args) {

		FolderApi apiInstance = new FolderApi(Utils.AppSID, Utils.AppKey);
		try {
			DeleteFolderRequest request = new DeleteFolderRequest("Comparisondocs\\Comparisondocs1", Utils.MYStorage, true);
			apiInstance.deleteFolder(request);
			System.out
					.println("Expected response type is Void: 'Comparisondocs/Comparisondocs1' folder deleted recusrsively.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FolderApi:");
			e.printStackTrace();
		}
	}
}