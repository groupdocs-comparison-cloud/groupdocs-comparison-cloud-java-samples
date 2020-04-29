package examples.BasicUsage;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;

/**
 * This example demonstrates how to get document information
 */
public class GetDocumentInformation {

	public static void main(String[] args) {

		InfoApi apiInstance = new InfoApi(Constants.GetConfiguration());
		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("source_files/word/source.docx");
			GetDocumentInfoRequest request = new GetDocumentInfoRequest(fileInfo);

			InfoResult response = apiInstance.getDocumentInfo(request);

			System.out.println("Pages Count: " + response.getPageCount());
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}