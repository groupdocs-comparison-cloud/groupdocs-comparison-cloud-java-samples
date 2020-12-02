package examples.AdvancedUsage.Revisions;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;
import java.util.List;

/**
 * This example demonstrates how to get list of revisions of DOCX document
 */
public class GetListOfRevisions {

	public static void main(String[] args) {

		ReviewApi apiInstance = new ReviewApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source_with_revs.docx");

			GetRevisionsRequest request = new GetRevisionsRequest(sourceFileInfo);

			List<RevisionInfo> rInfos = apiInstance.getRevisions(request);

			System.out.println("Revisions count: " + rInfos.size());
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}
