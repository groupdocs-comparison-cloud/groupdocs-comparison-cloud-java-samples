package examples.AdvancedUsage.Revisions;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.RevisionInfo.ActionEnum;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;
import java.util.List;

/**
 * This example demonstrates how to accept/reject revisions of DOCX document
 */
public class ApplyRevisions {

	public static void main(String[] args) {

		ReviewApi apiInstance = new ReviewApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source_with_revs.docx");

			ApplyRevisionsOptions options = new ApplyRevisionsOptions();
			options.setSourceFile(sourceFileInfo);
			options.setOutputPath("output/result.docx");

			GetRevisionsRequest request = new GetRevisionsRequest(sourceFileInfo);
			List<RevisionInfo> rInfos = apiInstance.getRevisions(request);

			for (RevisionInfo rInfo : rInfos) {
				rInfo.setAction(ActionEnum.ACCEPT);
			}
			options.setRevisions(rInfos);
			Link response = apiInstance.applyRevisions(new ApplyRevisionsRequest(options));

			System.out.println("Output file link: " + response.getHref());
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}
