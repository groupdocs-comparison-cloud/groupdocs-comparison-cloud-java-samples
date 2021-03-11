package examples.AdvancedUsage;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.ChangeInfo.ComparisonActionEnum;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;
import java.util.List;

/**
 * This example demonstrates how to accept/reject changes after documents compare
 */
public class AcceptOrRejectChanges {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source.docx");
			FileInfo targetFileInfo = new FileInfo();
			targetFileInfo.setFilePath("target_files/word/target.docx");

			UpdatesOptions options = new UpdatesOptions();
			options.setSourceFile(sourceFileInfo);
			options.addTargetFilesItem(targetFileInfo);
			options.setOutputPath("output/result.docx");

			PostChangesRequest request = new PostChangesRequest(options);

			List<ChangeInfo> changes = apiInstance.postChanges(request);
			for (ChangeInfo change : changes) {
				change.setComparisonAction(ComparisonActionEnum.REJECT);
			}
			changes.get(0).setComparisonAction(ComparisonActionEnum.REJECT);
			options.setChanges(changes);
			Link response = apiInstance.putChangesDocument(new PutChangesDocumentRequest(options));

			System.out.println("Output file link: " + response.getHref());
		} catch (ApiException e) {
			System.err.println("Exception while calling CompareApi:");
			e.printStackTrace();
		}
	}
}