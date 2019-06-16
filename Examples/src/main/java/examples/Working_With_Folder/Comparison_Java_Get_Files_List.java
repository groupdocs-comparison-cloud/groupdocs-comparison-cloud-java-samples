package examples.Working_With_Folder;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.FilesList;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import examples.Utils;

public class Comparison_Java_Get_Files_List {

	public static void main(String[] args) {

		FolderApi apiInstance = new FolderApi(Utils.AppSID, Utils.AppKey);
		try {
			GetFilesListRequest request = new GetFilesListRequest("Comparisondocs", Utils.MYStorage);
			FilesList response = apiInstance.getFilesList(request);
			System.out.println("Expected response type is FilesList.");
			for (StorageFile storageFile : response.getValue()) {
				System.out.println("Files: " + storageFile.getPath());
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling FolderApi:");
			e.printStackTrace();
		}
	}
}