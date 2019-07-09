package examples.Working_With_Changes;

import com.groupdocs.cloud.comparison.api.*;
import com.groupdocs.cloud.comparison.client.ApiException;
import com.groupdocs.cloud.comparison.model.requests.*;
import com.groupdocs.cloud.comparison.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import examples.Utils;

public class Comparison_Java_Update_Changes_Single_Document {

	public static void main(String[] args) {

		CompareApi apiInstance = new CompareApi(Utils.AppSID, Utils.AppKey);
		try {
			
			UpdatesOptions comparisonOptions = new UpdatesOptions();

			FileInfo sourceFile = new FileInfo();
			sourceFile.setFilePath("Comparisondocs\\source_protected.docx");
			sourceFile.setPassword("1231");
			sourceFile.setStorageName(Utils.MYStorage);

			comparisonOptions.setSourceFile(sourceFile);

			List<FileInfo> tarFiles = new ArrayList<>();

			FileInfo targetFile1 = new FileInfo();
			targetFile1.setFilePath("Comparisondocs\\target_protected.docx");
			targetFile1.setPassword("5784");
			targetFile1.setStorageName(Utils.MYStorage);

			tarFiles.add(targetFile1);

			comparisonOptions.setTargetFiles(tarFiles);

			List<ChangeInfo> changes = new ArrayList<>();

			ChangeInfo acceptInfo = new ChangeInfo();
			acceptInfo.setId(0);
			acceptInfo.setComparisonAction("Accept");

			ChangeInfo rejectInfo = new ChangeInfo();
			rejectInfo.setId(1);
			rejectInfo.setComparisonAction("Reject");

			changes.add(acceptInfo);
			changes.add(rejectInfo);

			comparisonOptions.setChanges(changes);

			Settings settings = new Settings();
			settings.setGenerateSummaryPage(Boolean.TRUE);
			settings.setShowDeletedContent(Boolean.TRUE);
			settings.setStyleChangeDetection(Boolean.TRUE);
			settings.setUseFramesForDelInsElements(Boolean.FALSE);
			settings.setCalculateComponentCoordinates(Boolean.FALSE);
			settings.setMarkDeletedInsertedContentDeep(Boolean.FALSE);
			settings.setDetailLevel("Low");
			settings.setCloneMetadata("Default");
			settings.setPassword("1111");
			settings.setPasswordSaveOption("User");

			ItemsStyle deletedItemsStyle = new ItemsStyle();
			deletedItemsStyle.setBeginSeparatorString("");
			deletedItemsStyle.setEndSeparatorString("");
			deletedItemsStyle.setFontColor("16711680");
			deletedItemsStyle.setHighlightColor("16711680");
			deletedItemsStyle.setBold(Boolean.FALSE);
			deletedItemsStyle.setItalic(Boolean.FALSE);
			deletedItemsStyle.setStrikeThrough(Boolean.FALSE);

			ItemsStyle insertedItemsStyle = new ItemsStyle();
			insertedItemsStyle.setBeginSeparatorString("");
			insertedItemsStyle.setEndSeparatorString("");
			insertedItemsStyle.setFontColor("255");
			insertedItemsStyle.setHighlightColor("255");
			insertedItemsStyle.setBold(Boolean.FALSE);
			insertedItemsStyle.setItalic(Boolean.FALSE);
			insertedItemsStyle.setStrikeThrough(Boolean.FALSE);

			ItemsStyle styleChangedItemsStyle = new ItemsStyle();
			styleChangedItemsStyle.setBeginSeparatorString("");
			styleChangedItemsStyle.setEndSeparatorString("");
			styleChangedItemsStyle.setFontColor("65280");
			styleChangedItemsStyle.setHighlightColor("65280");
			styleChangedItemsStyle.setBold(Boolean.FALSE);
			styleChangedItemsStyle.setItalic(Boolean.FALSE);
			styleChangedItemsStyle.setStrikeThrough(Boolean.FALSE);

			comparisonOptions.setSettings(settings);

			PutChangesDocumentRequest request = new PutChangesDocumentRequest(comparisonOptions);
			
			Link response = apiInstance.putChangesDocument(request);
			System.out.println("Expected response type is Link: " + response.getHref());
		} catch (ApiException e) {
			System.err.println("Exception while calling CompareApi:");
			e.printStackTrace();
		}
	}
}