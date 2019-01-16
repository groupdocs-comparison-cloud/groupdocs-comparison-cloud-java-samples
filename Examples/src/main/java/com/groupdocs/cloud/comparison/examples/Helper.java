package com.groupdocs.cloud.comparison.examples;

import com.groupdocs.cloud.comparison.model.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Home on 12/12/2018.
 */
public class Helper {
    public static com.groupdocs.cloud.comparison.model.ComparisonRequest GetComparisonRequest(String sourceName, String targetName) {
        com.groupdocs.cloud.comparison.model.ComparisonRequest comparisonRequest = new com.groupdocs.cloud.comparison.model.ComparisonRequest();
        ComparisonRequestSettings comparisonRequestSettings = new ComparisonRequestSettings();
        comparisonRequestSettings.setGenerateSummaryPage(true);
        comparisonRequestSettings.setShowDeletedContent(true);
        comparisonRequestSettings.setStyleChangeDetection(true);
        comparisonRequestSettings.setUseFramesForDelInsElements(false);
        comparisonRequestSettings.setDetailLevel("Low");
        //Set style values
        //delete items style
        StyleSettingsValues deletedItemsStyle = new StyleSettingsValues();
        deletedItemsStyle.color(new Color().getRed());
        deletedItemsStyle.setBeginSeparatorString("");
        deletedItemsStyle.setEndSeparatorString("");
        comparisonRequestSettings.deletedItemsStyle(deletedItemsStyle);

        //inserted items style
        StyleSettingsValues insertedItemsStyle = new StyleSettingsValues();
        insertedItemsStyle.color(new Color().getBlue());
        insertedItemsStyle.setBeginSeparatorString("");
        insertedItemsStyle.setEndSeparatorString("");
        comparisonRequestSettings.insertedItemsStyle(insertedItemsStyle);

        //style change style
        StyleSettingsValues styleChangedStyle = new StyleSettingsValues();
        styleChangedStyle.color(new Color().getGreen());
        styleChangedStyle.setBeginSeparatorString("");
        styleChangedStyle.setEndSeparatorString("");
        comparisonRequestSettings.styleChangedItemsStyle(styleChangedStyle);

        comparisonRequestSettings.setCalculateComponentCoordinates(false);
        comparisonRequestSettings.setCloneMetadata("Source");
        comparisonRequestSettings.markDeletedInsertedContentDeep(false);

        ComparisonMetadataValues comparisonMetadataValues = new ComparisonMetadataValues();
        comparisonMetadataValues.author("GroupDocs");
        comparisonMetadataValues.company("GroupDocs");
        comparisonMetadataValues.lastSaveBy("GroupDocs");

        comparisonRequestSettings.metaData(comparisonMetadataValues);

        comparisonRequestSettings.password("");
        comparisonRequestSettings.passwordSaveOption("");

        ComparisonFileInfo sourceFileInfo = new ComparisonFileInfo();

        sourceFileInfo.folder("comparison");
        sourceFileInfo.name(sourceName);
        sourceFileInfo.password("");

        comparisonRequest.addTargetFilesItem(sourceFileInfo);

        ComparisonFileInfo targetFile = new ComparisonFileInfo();

        targetFile.folder("comparison");
        targetFile.name(targetName);
        targetFile.password("");

        List<ComparisonFileInfo> targetFiles = Arrays.asList(targetFile);

        comparisonRequest.targetFiles(targetFiles);
        //Set Comparison settings
        comparisonRequest.settings(comparisonRequestSettings);

        ComparisonChange[] change = new ComparisonChange[2];
        change[0] = new ComparisonChange();
        change[0].id(0);
        change[0].action("Accept");
        change[1] = new ComparisonChange();
        change[1].id(1);
        change[1].action("Reject");
        comparisonRequest.changes(Arrays.asList(change));
        comparisonRequest.sourceFile(sourceFileInfo);

        return comparisonRequest;
    }
}
