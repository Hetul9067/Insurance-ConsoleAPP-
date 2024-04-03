## Insurance Buying Software Prototype

This program simulates an insurance buying software where users can receive insurance applications, choose whether to accept them, and manage their financial transactions accordingly.

### Insurance Agreement Features

- Users can store up to 20 insurance agreements.
- Each insurance agreement includes the following attributes:
  - Client name
  - Yearly fee
  - Risk (Yearly chance of accident, ranging from 5% to 100%)
  - Insurance amount (Amount received if an accident occurs, ranging from 5x to 20x yearly fee)
- A constructor randomly generates these values for each agreement.

### Menu Options

- **Display Menu:**
  - Shows the total amount of money.
  - Offers options to:
    - Receive new applications.
    - View all current insurance agreements.
    - See financial breakdown.
    - Break insurance agreement.
    - Move time forward.

- **Menu to See New Insurance Applications:**
  - Six applications are generated and displayed.
  - Users can select and accept an application, which removes it from the menu.

- **Menu to See All Insurance Agreements:**
  - Displays all insurance agreements in a nicely formatted manner.
  - Shows the net profit for each agreement.

- **Option to See Financial Breakdown:**
  - Displays:
    - Total payouts from claims.
    - Total payouts from canceled agreements.
    - Total income made.
    - Breakdown of net profit per year.
    - Average net profit.

- **Option to Break Agreements:**
  - Displays all agreements.
  - Users can choose an agreement to break.
  - Breaking an agreement incurs a cost of 10x the yearly fee.
  - The broken agreement is removed from the user's collection.

- **Option to Move Time Forward:**
  - Advances time by one year, increasing the year value.
  - All agreements pay their annual fee, increasing the user's money.
  - Each agreement is checked for claim probability based on the risk value.
    - If a claim is made, the corresponding amount must be paid.
    - Displays a list of claims paid and money made.

This readme serves as a guide for understanding and utilizing the features of the insurance buying software prototype.
