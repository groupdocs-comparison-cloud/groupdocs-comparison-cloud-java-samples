package examples.AdvancedUsage.SaveOptions;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.Settings.CloneMetadataEnum;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;

/**
 * This example demonstrates how to set custom metadata for output document
 */
public class SetMetadata {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source.docx");
			FileInfo targetFileInfo = new FileInfo();
			targetFileInfo.setFilePath("target_files/word/target.docx");

			Metadata metadata = new Metadata();
			metadata.setAuthor("Tom");
			metadata.setCompany("GroupDocs");
			metadata.setLastSaveBy("Jack");
			Settings settings = new Settings();
			settings.setCloneMetadata(CloneMetadataEnum.FILEAUTHOR);
			settings.setMetaData(metadata);			

			ComparisonOptions options = new ComparisonOptions();
			options.setSourceFile(sourceFileInfo);
			options.addTargetFilesItem(targetFileInfo);
			options.setSettings(settings);
			options.setOutputPath("output/result.docx");

			ComparisonsRequest request = new ComparisonsRequest(options);

			Link response = apiInstance.comparisons(request);

			System.out.println("Output file link: " + response.getHref());
		} catch (ApiException e) {
			System.err.println("Exception while calling CompareApi:");
			e.printStackTrace();
		}
	}
}