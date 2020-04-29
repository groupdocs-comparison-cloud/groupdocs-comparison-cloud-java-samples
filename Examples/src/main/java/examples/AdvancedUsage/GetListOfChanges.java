package examples.AdvancedUsage;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;
import java.util.List;

/**
 * This example demonstrates how to get list of changes of compared documents
 */
public class GetListOfChanges {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source.docx");
			FileInfo targetFileInfo = new FileInfo();
			targetFileInfo.setFilePath("target_files/word/target.docx");

			ComparisonOptions options = new ComparisonOptions();
			options.setSourceFile(sourceFileInfo);
			options.addTargetFilesItem(targetFileInfo);

			PostChangesRequest request = new PostChangesRequest(options);

			List<ChangeInfo> changes = apiInstance.postChanges(request);

			System.out.println("Changes count: " + changes.size());
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}