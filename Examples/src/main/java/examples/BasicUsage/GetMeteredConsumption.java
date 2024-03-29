package examples.BasicUsage;

import com.groupdocs.cloud.comparison.client.*;
import com.groupdocs.cloud.comparison.model.*;

import com.groupdocs.cloud.comparison.api.LicenseApi;
import examples.Constants;

/**
 * This example demonstrates how to get metered license consumption information
 */
public class GetMeteredConsumption {

	public static void main(String[] args) {
		
		LicenseApi apiInstance = new LicenseApi(Constants.GetConfiguration());
		
		try {
			ConsumptionResult response = apiInstance.getConsumptionCredit();

			System.out.println("Credit: " + response.getCredit());
			System.out.println("Quantity: " + response.getQuantity());
		} catch (ApiException e) {
			System.err.println("Exception while calling LicenseApi:");
			e.printStackTrace();
		}
	}
}