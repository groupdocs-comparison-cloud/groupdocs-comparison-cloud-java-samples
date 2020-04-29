package examples.AdvancedUsage;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;

/**
 * This example demonstrates how to compare documents with comparison sensitivity option
 */
public class CompareSensitivity {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source.docx");
			FileInfo targetFileInfo = new FileInfo();
			targetFileInfo.setFilePath("target_files/word/target.docx");

			Settings settings = new Settings();
			settings.setSensitivityOfComparison(100);			

			ComparisonOptions options = new ComparisonOptions();
			options.setSourceFile(sourceFileInfo);
			options.addTargetFilesItem(targetFileInfo);
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