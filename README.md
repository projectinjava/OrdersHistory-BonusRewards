# OrdersHistory-BonusRewards

end point uri = http://localhost:8080/OrderHistorySvc-war/rest/orderhistory/v1/orders

Req JSON :

{
  "clientContext" : {
    "clientId" : "WEB",
    "channelId" : "online",
    "requestId" : "23453"
  },
  "cardDetails" : {
    "cardNumber" : "45673839038373",
    "cvvNum" : "36",
    "expDate" : "12102018",
    "nameOnCard" : "XYZ"
  },
  "dateRange" : {
    "startDate" : "12102018",
    "endDate" : "31122019"
  },
  "ordersInfo" : {
    "typeOfOrder" : "electronic",
    "price" : 1234556.0
  },
  "serviceDetails" : {
    "serviceName" : "OrderHistory",
    "apiName" : "OrderHistoryService",
    "version" : "1.1"
  }
}
