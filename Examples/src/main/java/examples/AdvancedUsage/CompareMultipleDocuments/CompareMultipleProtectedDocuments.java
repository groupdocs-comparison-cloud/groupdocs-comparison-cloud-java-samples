package examples.AdvancedUsage.CompareMultipleDocuments;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;

/**
 * This example demonstrates how to compare multiple password-protected documents
 */
public class CompareMultipleProtectedDocuments {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source_protected.docx");
			sourceFileInfo.setPassword("1231");
			FileInfo targetFileInfo1 = new FileInfo();
			targetFileInfo1.setFilePath("target_files/word/target_protected.docx");
			targetFileInfo1.setPassword("5784");
			FileInfo targetFileInfo2 = new FileInfo();
			targetFileInfo2.setFilePath("target_files/word/target_1_protected.docx");
			targetFileInfo2.setPassword("5784");
			FileInfo targetFileInfo3 = new FileInfo();
			targetFileInfo3.setFilePath("target_files/word/target_2_protected.docx");
			targetFileInfo3.setPassword("5784");

			ComparisonOptions options = new ComparisonOptions();
			options.setSourceFile(sourceFileInfo);
			options.addTargetFilesItem(targetFileInfo1);
			options.addTargetFilesItem(targetFileInfo2);
			options.addTargetFilesItem(targetFileInfo3);
			options.setOutputPath("output/result.docx");

			ComparisonsRequest request = new ComparisonsRequest(options);

			Link response = apiInstance.comparisons(request);

			System.out.println("Output file link: " + response.getHref());
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}