package examples.AdvancedUsage;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.api.*;
import examples.Constants;
import java.util.List;

/**
 * This example demonstrates how to get changes coordinates
 */
public class GetChangesCoordinates {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Constants.GetConfiguration());
		try {
			FileInfo sourceFileInfo = new FileInfo();
			sourceFileInfo.setFilePath("source_files/word/source.docx");
			FileInfo targetFileInfo = new FileInfo();
			targetFileInfo.setFilePath("target_files/word/target.docx");

			Settings settings = new Settings();
			settings.setCalculateComponentCoordinates(true);

			ComparisonOptions options = new ComparisonOptions();
			options.setSourceFile(sourceFileInfo);
			options.addTargetFilesItem(targetFileInfo);
			options.setSettings(settings);

			PostChangesRequest request = new PostChangesRequest(options);

			List<ChangeInfo> changes = apiInstance.postChanges(request);
			for(int i=0; i<2; i++) {
				ChangeInfo change = changes.get(i);
				Rectangle box = change.getBox();
				System.out.println("Change Type: "+ change.getType().getValue() + ", X: "
					+ box.getX() + ", Y: "+ box.getY() +
					", Text: " + change.getText());
			}

			System.out.println("...");
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}