@Invoice
  Feature: User goes through invoice details
    @Positive
    Scenario: Validate if user invoice details match with expected
      Given User navigate to the application Login Page
      When User "user.demo" enter username and password
      And User click on "Rendezvous Hotel" Invoice information
      And User open Invoice Details tab
      Then The Hotel Name is "Rendezvous Hotel"
      And The Invoice Date is "14/01/2018"
      And The Due Date is "15/01/2018"
      And The Invoice Number is "110"
      And The BookingCode is "0875"
      And The Customer Details is "JOHNY SMITH - R2, AVENUE DU MAROC - 123456"
      And The Room is "Superior Double"
      And The Check-in is "14/01/2018"
      And The Check-out is "15/01/2018"
      And The Total Stay Count is "1"
      And The Total Stay Amount is "$150"
      And The Deposit Now is "USD $20.90"
      And The Tax&VAT is "USD $19"
      And The Total Amount is "USD $209"
      And User Close Invoice Details tab
      And User logout from the system