package examples.Working_With_Files;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.requests.*;
import examples.Utils;

public class Comparison_Java_Copy_File {

	public static void main(String[] args) {

		FileApi apiInstance = new FileApi(Utils.AppSID, Utils.AppKey);
		try {

			CopyFileRequest request = new CopyFileRequest("Comparisondocs\\one-page.docx",
					"Comparisondocs\\one-page-copied.docx", Utils.MYStorage, Utils.MYStorage, null);
			apiInstance.copyFile(request);
			System.out.println(
					"Expected response type is Void: 'Comparisondocs/one-page1.docx' file copied as 'Comparisondocs/one-page-copied.docx'.");
		} catch (ApiException e) {
			System.err.println("Exception while calling FileApi:");
			e.printStackTrace();
		}
	}
}