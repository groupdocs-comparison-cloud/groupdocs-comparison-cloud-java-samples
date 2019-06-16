package examples.Working_With_Folder;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.requests.*;
import examples.Utils;

public class Comparison_Java_Create_Folder {

	public static void main(String[] args) {

		FolderApi apiInstance = new FolderApi(Utils.AppSID, Utils.AppKey);
		try {
			CreateFolderRequest request = new CreateFolderRequest("Comparisondocs", Utils.MYStorage);
			apiInstance.createFolder(request);
			System.out.println("Expected response type is Void: 'Comparisondocs' folder created.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FolderApi:");
			e.printStackTrace();
		}
	}
}