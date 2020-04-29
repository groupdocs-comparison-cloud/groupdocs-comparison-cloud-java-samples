package examples.AdvancedUsage.SaveOptions;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.Settings.PasswordSaveOptionEnum;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;

/**
 * This example demonstrates how to set custom password for output document
 */
public class SetPassword {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source.docx");
			FileInfo targetFileInfo = new FileInfo();
			targetFileInfo.setFilePath("target_files/word/target.docx");

			Settings settings = new Settings();
			settings.setPasswordSaveOption(PasswordSaveOptionEnum.USER);
			settings.setPassword("3333");

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