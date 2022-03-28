Participant User as U
Participant Render as R
Participant Presentation as P
Participant Business as B
Participant Domain as D
Participant Elasticsearch as ES
Participant Epost APIs as E



U -> R: Clicks Order Covid At-Home tests
R -> P: POST /component/member/covid-at-home 
P --> R: RoutePresentation with Component Links

R-> P: POST /order-supply/info
P --> R: OrderSupplyInfoPresentation

R ->P: POST /order-supply/address
P -> P: get user seletced member’s patientid
P -> B: memberService.getPatientAddresses(patientId)
B --> P: List<Address>
P --> R: OrderSupplyAddressInfoPresentation

R ->P: POST /checkout/component/shipping-options
P -> B: checkoutService.getShippingOptions()
B --> P: List<ShippingOption>
P --> R: OrderSupplyShippingOptionsPresentation

R -> P: POST /order-supply/payment-info
P -> P: get user seletced member’s patientid
P-> B:  memberService.getPatientSavedCards(patientId)
B --> P: List<Card> 
P -->R: OrderSupplyPaymentInforPresentation

U -> R: Selects qty,address,shipping and card. Clicks Place Order
R-> P: POST /order-supply/submit-order
P -> B: checkoutService.getShippingOptions()
B --> P: List<ShippingOption>
P -> P: get estimated delivery date for selected option
P -> B: OrderSupplyService.submitOrder(submitCovidHomeTestOrderRequest)
B -> D: /order-supply/create-order
D -> EpostDB: Get Family Id and Payment Id (read sql queries)
EPostDB --> D: family id and payment id
D -> E : POST /order-otc/order/otc/new
E --> D: OrderSupplyEpostResponse
D -> D: if messageStatus is false, 
D ->D: throw CreateOrderFailedException
D -->B: Error 500 
B -->P: BusinessException
P --> R: StandardFailurePresentation with ErrorText

D -> D: else
D --> B: order invoice number
B -> D: GET /orders/{orderid}
Note right of D: getOrderDetail API
D -> B: domainOrder
B -> B: orderService.createESOrder(Orderitem item, String orderNum, GlobalFilters globalFilters)
B -> B: orderService.upsertESOrder(order, domainOrder)
B -> ES: insert ESOrder
ES -->B: 200 OK
B -> B: prescriptionService.upsertPrescriptions(List<ESPrescription> esPrescription)
B -> ES: insert ESPrescription
ES --> B: 200 OK
B -->P: Order
P --> R: OrderSupplySubmitOrderPresentation

R-->U: Order Success Message with Order Invoice Number






