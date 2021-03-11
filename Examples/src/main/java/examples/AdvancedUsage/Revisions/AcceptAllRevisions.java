package examples.AdvancedUsage.Revisions;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;

/**
 * This example demonstrates how to accept all revisions of DOCX document
 */
public class AcceptAllRevisions {

	public static void main(String[] args) {

		ReviewApi apiInstance = new ReviewApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source_with_revs.docx");

			ApplyRevisionsOptions options = new ApplyRevisionsOptions();
			options.setSourceFile(sourceFileInfo);
			options.setAcceptAll(true);
			options.setOutputPath("output/result.docx");

			Link response = apiInstance.applyRevisions(new ApplyRevisionsRequest(options));

			System.out.println("Output file link: " + response.getHref());
		} catch (ApiException e) {
			System.err.println("Exception while calling ReviewApi:");
			e.printStackTrace();
		}
	}
}
