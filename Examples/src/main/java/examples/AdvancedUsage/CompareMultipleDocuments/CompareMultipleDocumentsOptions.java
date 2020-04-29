package examples.AdvancedUsage.CompareMultipleDocuments;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;

/**
 * This example demonstrates how to compare multiple documents with options
 */
public class CompareMultipleDocumentsOptions {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source.docx");
			FileInfo targetFileInfo1 = new FileInfo();
			targetFileInfo1.setFilePath("target_files/word/target.docx");
			FileInfo targetFileInfo2 = new FileInfo();
			targetFileInfo2.setFilePath("target_files/word/target_1.docx");
			FileInfo targetFileInfo3 = new FileInfo();
			targetFileInfo3.setFilePath("target_files/word/target_2.docx");

			ItemsStyle insertedItemsStyle = new ItemsStyle();
			insertedItemsStyle.setFontColor("16711680");
			Settings settings = new Settings();
			settings.setInsertedItemsStyle(insertedItemsStyle);

			ComparisonOptions options = new ComparisonOptions();
			options.setSourceFile(sourceFileInfo);
			options.addTargetFilesItem(targetFileInfo1);
			options.addTargetFilesItem(targetFileInfo2);
			options.addTargetFilesItem(targetFileInfo3);
			options.setSettings(settings);
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