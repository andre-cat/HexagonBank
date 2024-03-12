# To do

## Structure

### User interface

  - **Driver adapters (entry point)**
      - [X] API REST: `gradle generateEntryPoint --type=restmvc`

### Domain

  - **Driver ports**
    - [X] Execute transaction interface: `gradle generateUseCase --name=ExecuteTransaction`
  - **Uses cases**
    - [X] Execute transaction (generic): `gradle generateUseCase --name=ExecuteAccount`
    - [X] Deposit from account: `gradle generateUseCase --name=DepositFromAccount`
    - [X] Deposit from ATM: `gradle generateUseCase --name=DepositFromATM`
    - [X] Deposit from branch: `gradle generateUseCase --name=DepositFromBranch`
    - [X] Purchase in store with card: `gradle generateUseCase --name=PurchaseInStoreWithCard`
    - [X] Purchase online with card: `gradle generateUseCase --name=PurchaseOnlineWithCard`
    - [X] Withdraw from ATM: `gradle generateUseCase --name=WithdrawWithATM`
    - [X] See transaction: `gradle generateUseCase --name=SeeTransaction`
    - [X] See transactions by account: `gradle generateUseCase --name=SeeTransactionByAccount`
    - [X] See user: `gradle generateUseCase --name=SeeUser`
    - [X] Create user: `gradle generateUseCase --name=CreateUser`
    - [X] See account: `gradle generateUseCase --name=SeeAccount`
    - [X] Create account: `gradle generateUseCase --name=CreateAccount`
  - **Models**
    - [X] Transaction: `gradle generateModel --name=Transaction`
    - [X] Account: `gradle generateModel --name=Account`
    - [X] User: `gradle generateModel --name=User`
  - **Driven ports (gateways)**
    - [X] Transaction repository
    - [X] Account repository
    - [X] User repository
- [ ] **Helpers**: `gradle generateHelper --name=Mappers`

### Infrastructure

- **Driven adapters**
  - JPA: `gradle generateDrivenAdapter --type=jpa`
    - [X] Transaction
    - [X] Account
    - [X] User
  - MongoDB: `gradle generateDrivenAdapter --type=mongodb`
    - [ ] Transaction
    - [ ] Account
    - [ ] User

## Implementation

### User interface

- **Driver adapters (entry point)**
    - Transaction API REST
      - [X] Deposit from account
      - [X] Deposit from ATM
      - [X] Deposit from branch
      - [X] Purchase in store with card
      - [X] Purchase online with card
      - [X] Withdraw with ATM
      - [X] See transaction
    - Account API REST
      - [X] Create account
      - [X] See account
      - [X] See account transactions
    - User API REST
      - [X] Create user
      - [X] See user

### Domain

- **Uses cases**
    - [X] Create transaction
    - Implementation
      - [X] Deposit from account
      - [X] Deposit from ATM
      - [X] Deposit from branch
      - [X] Purchase in store with card
      - [X] Purchase online with card
      - [X] Withdraw from ATM
- **Models**
    - [X] Transaction
    - [X] TransactionDTO
    - [X] Account
    - [X] AccountDTO
    - [X] User
    - [X] UserDTO
- **Driven ports (gateways)**
    - [X] Transaction repository
    - [X] Account repository
    - [X] User repository

### Infrastructure

- **Driven adapters**
    - **JPA**
        - [X] Transaction repository
        - [X] Transaction repository adapter
        - [X] Account repository
        - [X] Account repository adapter
        - [X] User repository
        - [X] User repository adapter
    - **MongoDB**
        - [ ] Transaction repository
        - [ ] Transaction repository adapter
        - [ ] Account repository
        - [ ] Account repository adapter
        - [ ] User repository
        - [ ] User repository adapter 

- **MySQL database**
  - [X] Transaction table
  - [X] Account table
  - [X] User table
- **MongoDB database**
  - [ ] Transaction table
  - [ ] Account table
  - [ ] User table
