# oanda-rest-client
Simple way to programmatically access the [OANDA REST-v20](https://developer.oanda.com/rest-live-v20/introduction/ "OANDA's Docs Page") API

# Usage
Interaction with the various endpoints provided by OANDA are done through services. For example, making calls to the *Instrument* endpoint is done through various methods available on the `InstrumentService`.

Services are instantiated through the `ServiceFactory`, which takes a POJO describing the API details (the API and the token) that you want to use.
