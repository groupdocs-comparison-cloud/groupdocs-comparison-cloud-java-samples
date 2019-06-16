package examples;

import com.groupdocs.cloud.comparison.api.FolderApi;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.FilesList;
import com.groupdocs.cloud.comparison.model.StorageFile;
import com.groupdocs.cloud.comparison.model.requests.GetFilesListRequest;

public class Utils {

	// TODO: Get your AppSID and AppKey at https://dashboard.groupdocs.cloud (free
	// registration is required).

	public static String AppSID = "XXXXX-XXXXX-XXXXX";
	public static String AppKey = "XXXXXXX";
	public static String MYStorage = "XXXXX";

	public static void getFolderFilesPath(String path) {
		FolderApi apiInstance = new FolderApi(Utils.AppSID, Utils.AppKey);
		try {
			GetFilesListRequest request = new GetFilesListRequest(path, Utils.MYStorage);
			FilesList response = apiInstance.getFilesList(request);
			for (StorageFile storageFile : response.getValue()) {
				System.out.println("Files: " + storageFile.getPath());
			}
		} catch (ApiException e) {
			System.err.println("Exception while calling getFolderFilesPath with FolderApi:");
			e.printStackTrace();
		}
	}
}