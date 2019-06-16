package examples.Working_With_Files;

import java.io.File;
import java.nio.file.Paths;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import examples.Utils;

public class Comparison_Java_Upload_File {

	public static void main(String[] args) {

		FileApi apiInstance = new FileApi(Utils.AppSID, Utils.AppKey);
		try {
			File fileStream = new File(
					Paths.get("src\\main\\resources").toAbsolutePath().toString() + "\\Comparisondocs\\one-page.docx");
			UploadFileRequest request = new UploadFileRequest("Comparisondocs\\one-page1.docx", fileStream,
					Utils.MYStorage);
			FilesUploadResult response = apiInstance.uploadFile(request);
			System.out.println("Expected response type is FilesUploadResult: " + response.getUploaded().size());
		} catch (ApiException e) {
			System.err.println("Exception while calling FileApi:");
			e.printStackTrace();
		}
	}
}