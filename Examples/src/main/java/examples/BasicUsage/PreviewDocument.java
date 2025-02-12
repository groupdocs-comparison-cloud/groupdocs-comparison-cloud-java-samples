package examples.BasicUsage;

import java.util.List;
import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.PreviewOptions.FormatEnum;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;

/**
 * This example demonstrates how to preview document
 */
public class PreviewDocument {

	public static void main(String[] args) {

		PreviewApi apiInstance = new PreviewApi(Constants.GetConfiguration());
		try {
			FileInfo fileInfo = new FileInfo();
			fileInfo.setFilePath("source_files/word/source.docx");

			PreviewOptions options = new PreviewOptions();
			options.setFileInfo(fileInfo);
			options.setFormat(FormatEnum.JPEG);
			options.setOutputFolder("output");

			PreviewRequest request = new PreviewRequest(options);

			List<Link> response = apiInstance.preview(request);

			System.out.println("Output pages count: " + response.size());
		} catch (ApiException e) {
			System.err.println("Exception while calling CompareApi:");
			e.printStackTrace();
		}
	}
}
