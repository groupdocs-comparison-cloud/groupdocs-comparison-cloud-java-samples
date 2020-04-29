package examples.BasicUsage;
import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;
import com.groupdocs.cloud.comparison.api.InfoApi;
import examples.Constants;

/**
 * This example demonstrates how to obtain all supported document formats
 */
public class GetSupportedFormats {

	public static void main(String[] args) {
		
		InfoApi apiInstance = new InfoApi(Constants.GetConfiguration());
		
		try {
			FormatsResult response = apiInstance.getSupportedFileFormats();

			System.out.println("Formats count: " + response.getFormats().size());
		} catch (ApiException e) {
			System.err.println("Exception while calling InfoApi:");
			e.printStackTrace();
		}
	}
}