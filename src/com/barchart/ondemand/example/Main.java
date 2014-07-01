package com.barchart.ondemand.example;

import com.barchart.ondemand.BarchartOnDemandClient;
import com.barchart.ondemand.api.LeadersRequest;
import com.barchart.ondemand.api.LeadersRequest.LeadersAssetType;
import com.barchart.ondemand.api.LeadersRequest.LeadersRequestType;
import com.barchart.ondemand.api.OnDemandRequest;
import com.barchart.ondemand.api.responses.Leader;
import com.barchart.ondemand.api.responses.Leaders;

public class Main {

	public Main() throws Exception {

		/* create the onDemand client with your API key */
		
		final BarchartOnDemandClient onDemand = new BarchartOnDemandClient.Builder().apiKey("change-me").build();

		/* get active stocks on NYSE */
		
		final OnDemandRequest leadersRequest = new LeadersRequest.Builder().exchanges(new String[] { "NYSE" })
				.assetType(LeadersAssetType.STOCK).type(LeadersRequestType.ACTIVE).build();

		final Leaders leaders = (Leaders) onDemand.fetch(leadersRequest);

		/* output the results */

		int count = 1;

		for (Leader leader : leaders.all()) {

			final String symbol = leader.getSymbol();
			final String name = leader.getSymbolName();
			final double last = leader.getLastPrice();

			System.out.println(count + " " + symbol + " (" + name + ") Last: " + last);

			count++;
		}
		
		/* save the results and update them at a later time */
		
		leaders.refresh();
		
		/* output the results again */

	}

	public static void main(String[] args) throws Exception {
		new Main();
	}

}
