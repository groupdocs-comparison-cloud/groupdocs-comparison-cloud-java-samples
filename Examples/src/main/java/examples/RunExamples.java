package examples;

import examples.AdvancedUsage.AcceptOrRejectChanges;


import examples.AdvancedUsage.*;
import examples.AdvancedUsage.CompareMultipleDocuments.*;
import examples.AdvancedUsage.Revisions.*;
import examples.AdvancedUsage.SaveOptions.*;
import examples.BasicUsage.*;
import examples.BasicUsage.CompareDifferentFormats.*;


public class RunExamples {

	public static void main(String[] args) {

		// Upload files
		UploadResources.main(args);

		// Basic usage examples
		GetSupportedFormats.main(args);
		GetDocumentInformation.main(args);
		CompareDocuments.main(args);
		ComparePdfDocuments.main(args);

		// Advanced usage examples
		CompareProtectedDocuments.main(args);
		CompareSensitivity.main(args);
		CustomizeChangesStyles.main(args);
		GetChangesCoordinates.main(args);
		GetListOfChanges.main(args);
		CompareMultipleProtectedDocuments.main(args);
		CompareMultipleDocumentsOptions.main(args);
		SetMetadata.main(args);
		SetPassword.main(args);
		AcceptOrRejectChanges.main(args);

		GetListOfRevisions.main(args);
		ApplyRevisions.main(args);
		AcceptAllRevisions.main(args);
		RejectAllRevisions.main(args);

		System.out.println("Completed");
	}	
}