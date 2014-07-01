#### Get most active stocks on the NYSE

```java
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

```

#### Output

1. BAC (Bank of America Corp) Last: 15.52
2. TWTR (Twitter Inc) Last: 42.77
3. F (Ford Motor Company) Last: 17.24
4. HSH (Hillshire Brands Company) Last: 62.65
5. GE (General Electric Company) Last: 26.33
6. T (AT&T Inc) Last: 35.38
7. GM (General Motors Company) Last: 37.09
8. AMD (Advanced Micro Devices) Last: 4.22
9. PFE (Pfizer Inc) Last: 29.9
10. RAD (Rite Aid Corp) Last: 7.18
11. VALE (Vale S.A.) Last: 13.5
12. CBS (CBS Corp) Last: 63.29
13. FCX (Freeport-Mcmoran Copper & Gold) Last: 37.05

#### More information

* [Running the Example](https://github.com/barchart/barchart-ondemand-example-java/wiki/Getting-Started)
* [Source for the client](https://github.com/barchart/barchart-ondemand-client-java)



