package examples.Working_With_Files;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.requests.*;
import examples.Utils;

public class Comparison_Java_Delete_File {

	public static void main(String[] args) {

		FileApi apiInstance = new FileApi(Utils.AppSID, Utils.AppKey);
		try {

			DeleteFileRequest request = new DeleteFileRequest("Comparisondocs1\\one-page1.docx", Utils.MYStorage, null);
			apiInstance.deleteFile(request);
			System.out.println("Expected response type is Void: 'Comparisondocs1/one-page1.docx' deleted.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FileApi:");
			e.printStackTrace();
		}
	}
}