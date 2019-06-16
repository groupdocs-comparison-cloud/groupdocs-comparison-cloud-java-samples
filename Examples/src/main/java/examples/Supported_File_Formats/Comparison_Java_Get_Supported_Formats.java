package examples.Supported_File_Formats;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import java.util.List;
import com.groupdocs.cloud.comparison.client.Configuration;
import com.groupdocs.cloud.comparison.api.*;
import examples.Utils;

public class Comparison_Java_Get_Supported_Formats {

	public static void main(String[] args) {

		Configuration configuration = new Configuration(Utils.AppSID, Utils.AppKey);
		InfoApi apiInstance = new InfoApi(configuration);

        try {
            FormatsResult response = apiInstance.getSupportedFileFormats();
            for (Format format : response.getFormats()) {
                System.out.println(format.getFileFormat());
            }
        } catch (ApiException e) {
            System.err.println("Exception while calling InfoApi:");
            e.printStackTrace();
        }
	}
}
