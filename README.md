# 키친포스

## 퀵 스타트

```sh
cd docker
docker compose -p kitchenpos up -d
```

## 요구 사항

### 상품

- 상품을 등록할 수 있다.
- 상품의 가격이 올바르지 않으면 등록할 수 없다.
    - 상품의 가격은 0원 이상이어야 한다.
- 상품의 이름이 올바르지 않으면 등록할 수 없다.
    - 상품의 이름에는 비속어가 포함될 수 없다.
- 상품의 가격을 변경할 수 있다.
- 상품의 가격이 올바르지 않으면 변경할 수 없다.
    - 상품의 가격은 0원 이상이어야 한다.
- 상품의 가격이 변경될 때 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 크면 메뉴가 숨겨진다.
- 상품의 목록을 조회할 수 있다.

### 메뉴 그룹

- 메뉴 그룹을 등록할 수 있다.
- 메뉴 그룹의 이름이 올바르지 않으면 등록할 수 없다.
    - 메뉴 그룹의 이름은 비워 둘 수 없다.
- 메뉴 그룹의 목록을 조회할 수 있다.

### 메뉴

- 1 개 이상의 등록된 상품으로 메뉴를 등록할 수 있다.
- 상품이 없으면 등록할 수 없다.
- 메뉴에 속한 상품의 수량은 0 이상이어야 한다.
- 메뉴의 가격이 올바르지 않으면 등록할 수 없다.
    - 메뉴의 가격은 0원 이상이어야 한다.
- 메뉴에 속한 상품 금액의 합은 메뉴의 가격보다 크거나 같아야 한다.
- 메뉴는 특정 메뉴 그룹에 속해야 한다.
- 메뉴의 이름이 올바르지 않으면 등록할 수 없다.
    - 메뉴의 이름에는 비속어가 포함될 수 없다.
- 메뉴의 가격을 변경할 수 있다.
- 메뉴의 가격이 올바르지 않으면 변경할 수 없다.
    - 메뉴의 가격은 0원 이상이어야 한다.
- 메뉴에 속한 상품 금액의 합은 메뉴의 가격보다 크거나 같아야 한다.
- 메뉴를 노출할 수 있다.
- 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 높을 경우 메뉴를 노출할 수 없다.
- 메뉴를 숨길 수 있다.
- 메뉴의 목록을 조회할 수 있다.

### 주문 테이블

- 주문 테이블을 등록할 수 있다.
- 주문 테이블의 이름이 올바르지 않으면 등록할 수 없다.
    - 주문 테이블의 이름은 비워 둘 수 없다.
- 빈 테이블을 해지할 수 있다.
- 빈 테이블로 설정할 수 있다.
- 완료되지 않은 주문이 있는 주문 테이블은 빈 테이블로 설정할 수 없다.
- 방문한 손님 수를 변경할 수 있다.
- 방문한 손님 수가 올바르지 않으면 변경할 수 없다.
    - 방문한 손님 수는 0 이상이어야 한다.
- 빈 테이블은 방문한 손님 수를 변경할 수 없다.
- 주문 테이블의 목록을 조회할 수 있다.

### 주문

- 1개 이상의 등록된 메뉴로 배달 주문을 등록할 수 있다.
- 1개 이상의 등록된 메뉴로 포장 주문을 등록할 수 있다.
- 1개 이상의 등록된 메뉴로 매장 주문을 등록할 수 있다.
- 주문 유형이 올바르지 않으면 등록할 수 없다.
- 메뉴가 없으면 등록할 수 없다.
- 매장 주문은 주문 항목의 수량이 0 미만일 수 있다.
- 매장 주문을 제외한 주문의 경우 주문 항목의 수량은 0 이상이어야 한다.
- 배달 주소가 올바르지 않으면 배달 주문을 등록할 수 없다.
    - 배달 주소는 비워 둘 수 없다.
- 빈 테이블에는 매장 주문을 등록할 수 없다.
- 숨겨진 메뉴는 주문할 수 없다.
- 주문한 메뉴의 가격은 실제 메뉴 가격과 일치해야 한다.
- 주문을 접수한다.
- 접수 대기 중인 주문만 접수할 수 있다.
- 배달 주문을 접수되면 배달 대행사를 호출한다.
- 주문을 서빙한다.
- 접수된 주문만 서빙할 수 있다.
- 주문을 배달한다.
- 배달 주문만 배달할 수 있다.
- 서빙된 주문만 배달할 수 있다.
- 주문을 배달 완료한다.
- 배달 중인 주문만 배달 완료할 수 있다.
- 주문을 완료한다.
- 배달 주문의 경우 배달 완료된 주문만 완료할 수 있다.
- 포장 및 매장 주문의 경우 서빙된 주문만 완료할 수 있다.
- 주문 테이블의 모든 매장 주문이 완료되면 빈 테이블로 설정한다.
- 완료되지 않은 매장 주문이 있는 주문 테이블은 빈 테이블로 설정하지 않는다.
- 주문 목록을 조회할 수 있다.

## 용어 사전

### 공통

| 한글명 | 영문명        | 설명                                              |
|-----|------------|-------------------------------------------------|
| 고객  | user       | - 키친포스 서비스 이용자의 총칭이다. <br> - 손님/사장님으로 구분할 수 있다. |
| 손님  | customer   | - 주문을 하는 모든 키친포스 고객을 뜻한다.                       |
| 사장님 | manager    | - 키친포스 내 매장의 메뉴를 관리하는 고객을 뜻한다.                  |
| 매장  | restaurant | - 손님이 방문하여 매장 주문을 할 수 있는 장소                     |
| 비속어 | slang      | - 욕설과 외설성을 포함하는 단어. (은어를 포함하지 않음)               |
| 수량  | quantity   | - 수량을 의미하는 단어                                   |
| 이름  | name       | - 이름을 표현하는 단어                                   |

### 상품

| 한글명   | 영문명           | 설명                                                                                                            |
|-------|---------------|---------------------------------------------------------------------------------------------------------------|
| 상품    | product       | - 메뉴의 단위 요리를 표현한다. (음식의 재료를 표현하는 것은 아님). <br> - 사장님인 경우에 등록이 가능하다.                                            |
| 상품 이름 | product name  | - 상품을 표현하는 이름으로, 등록할 때 필요하다. (단, 비속어 포함 불가)                                                                   |
| 상품 가격 | product price | - 상품 가격으로, 0원 이상 등록이 되어야 한다. <br> - 가격은 상품 등록 후 변경이 가능하다. (단, 메뉴에 속한 경우 메뉴 가격이 메뉴에 속한 상품 금액의 합보다 크면 메뉴가 숨겨짐.) |

### 메뉴 그룹

| 한글명   | 영문명        | 설명                    |
|-------|------------|-----------------------|
| 메뉴 그룹 | menu group | - 메뉴들을 묶어서 표현하는 단위이다. |

### 메뉴

| 한글명      | 영문명                 | 설명                                                                                                 |
|----------|---------------------|----------------------------------------------------------------------------------------------------|
| 메뉴       | menu                | - 사장님이 등록 후 손님이 주문할 수 있는 단위이며, 한 개 이상 상품으로 구성된다. <br> - 한 개 이상 상품으로 구성된다. <br> - 한 개의 메뉴 그룹에 속해있다. |
| 메뉴 이름    | menu name           | - 메뉴를 표현하는 이름으로, 등록할 때 필요하다. (단, 비속어 포함 불가)                                                        |
| 메뉴 가격    | menu price          | - 사장님이 등록할 수 있는 메뉴의 가격이다.<br> - 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 높을 경우 메뉴를 노출할 수 없다.                      |
| 메뉴 노출 상태 | menu display status | - 메뉴의 노출 여부를 의미하며, 노출되거나 숨겨질 수 있다.                                                                 |
| 노출된 메뉴   | displayed menu      | - 손님이 메뉴에 대한 정보를 볼 수 있다는 것을 의미한다.                                                                  |
| 숨겨진 메뉴   | undisplayed menu    | - 손님이 메뉴에 대한 정보를 볼 수 없다는 것을 의미한다.                                                                  |
| 메뉴 상품    | menu product        | - 메뉴를 구성하는 상품으로, 하나의 상품과 개수로 구성된다.                                                                 |

### 주문테이블

| 한글명          | 영문명              | 설명                                                                   |
|--------------|------------------|----------------------------------------------------------------------|
| 주문 테이블       | order table      | - 매장에서 관리되는 테이블로 매장 식사 손님용. <br> - 매장 식사 손님이 모든 식사를 마치는 경우 테이블을 치운다. |
| 주문 테이블 착석 여부 | occupied         | - 손님의 착석 여부를 표현한다.                                                   |
| 착석 테이블       | occupying table  | - 손님이 앉아있는 테이블을 표현한다.                                                |      |
| 빈 테이블        | cleared table    | - 테이블을 치운 상태를 빈 테이블이라고 표현한다.                                         |
| 손님 수         | number of guests | - 매장 내 한 테이블에 있는 손님의 수                                               |

### 주문

| 한글명  | 영문명             | 설명                                                                               |
|------|-----------------|----------------------------------------------------------------------------------|
| 주문항목 | order line item | - 주문을 구성하는 메뉴로, 하나의 메뉴와 개수, 가격으로 구성된다.                                           |
| 주문유형 | order type      | - 주문의 유형을 표현한다. 배달주문(`DELIEVERY_ORDER`), 포장주문(`TAKEOUT`), 매장주문(`EAT_IN`)으로 구성된다. |

#### 배달주문

| 한글명         | 영문명                      | 설명                                                              |
|-------------|--------------------------|-----------------------------------------------------------------|
| 배달 주문       | delivery order           | - 손님이 입력한 배달 주소로 배달 대행사를 통해 배달해주는 주문.                           |
| 배달 주소       | delivery address         | - 배달 주문한 손님이 설정한 배달 목적지.                                        |
| 배달 대행사      | delivery rider           | - 배달 주소로 메뉴를 전달해주는 대행사. <br> - 배달 대행사 수락이 안되는 경우, 배달 수락이 불가능하다. |
| 배달 주문 접수    | delivery order waiting   | - 주문을 접수한 상태를 말한다.                                              |
| 배달 주문 수락    | delivery order accepted  | - 주문을 수락해 배달 대행사 요청이 완료된 상태를 말한다.                               |
| 배달 주문 서빙 완료 | delivery order served    | - 음식 조리 및 포장까지 완료된 상태를 말한다.                                     |
| 배달 중        | delivering               | - 배달을 시작한 상태를 말한다.                                              |
| 배달 완료       | delivered                | - 배달이 완료된 상태를 말한다.                                              |
| 배달 주문 완료    | delivery order completed | - 주문이 완료된 상태를 말한다.                                              |

#### 포장주문

| 한글명      | 영문명                     | 설명                          |
|----------|-------------------------|-----------------------------|
| 포장 주문    | takeout order           | - 손님이 매장에 방문하여 포장해가는 주문.    |
| 포장 주문 접수 | takeout order waiting   | - 주문을 접수한 상태를 말한다.          |
| 포장 주문 수락 | takeout order accepted  | - 주문을 수락한 상태를 말한다.          |
| 포장 서빙 완료 | takeout order served    | - 음식 조리 및 포장까지 완료된 상태를 말한다. |
| 포장 주문 완료 | takeout order completed | - 주문이 완료된 상태를 말한다.          |

#### 매장주문

| 한글명      | 영문명                    | 설명                                                                                                       |
|----------|------------------------|----------------------------------------------------------------------------------------------------------|
| 매장 주문    | eat in order           | - 손님이 매장에 방문하여 주문 테이블에 앉아 식사하는 주문. <br> - 비어있는 주문 테이블이 없는 경우 주문이 불가능하다. <br> - - 주문 항목의 수량이 0개 미만일 수 있다. |
| 매장 주문 접수 | eat-in order waiting   | - 주문을 접수한 상태를 말한다.                                                                                       |
| 매장 주문 수락 | eat-in order accepted  | - 주문을 수락한 상태를 말한다.                                                                                       |
| 매장 서빙 완료 | eat-in order served    | - 음식 조리가 끝나 손님에게 전달할 수 있는 상태를 말한다.                                                                       |
| 매장 주문 완료 | eat-in order completed | - 주문이 완료된 상태를 말한다.                                                                                       |


## 모델링

### 상품

#### 속성
- `Product` 는 식별자, `ProductName`, `ProductPrice` 을 가진다.

#### 행위
- `Product`를 등록할 수 있다.
  - `ProductPrice`가 올바르지 않으면 등록할 수 없다.
  - `ProductPrice`는 0원 이상이어야 한다.
  - `ProductName`가 올바르지 않으면 등록할 수 없다. 
  - `ProductName`에는 비속어가 포함될 수 없다.
- `Product`에서 `ProductPrice`를 변경할 수 있다.
  - `ProductPrice`가 올바르지 않으면 변경할 수 없다. 
  - `ProductPrice`는 0원 이상이어야 한다.  

  

### 메뉴 그룹

#### 속성
- `MenuGroup` 은 식별자, `MenuGroupName` 을 가진다.

#### 행위 
- `MenuGroup`을 등록할 수 있다. 
  - `MenuGroupName`이 올바르지 않으면 등록할 수 없다.
  - `MenuGroupName`은 존재해야 한다.



### 메뉴

#### 속성
- `Menu` 는 식별자, `MenuName`, `MenuPrice`, `MenuGroup`, `MenuDisplayStatus`, `MenuProducts` 를 가진다.
- `MenuProduct` 는 `Product`, `Quantity` 을 가진다.
- `MenuProduct` 에서 `Product` 의 총 `Price` 을 계산한다.

#### 행위
- `MenuProducts`의 `Quantity`는 0 이상이어야 한다.
- `Menu`에서 `MenuProducts`를 생성한다.
- `Menu`를 등록할 수 있다.
  - `MenuGroup`이 없으면 등록할 수 없다.
  - `MenuProducts`가 없으면 등록할 수 없다.
  - `MenuName`이 올바르지 않으면 등록할 수 없다. 
    - `MenuName`에는 비속어가 포함될 수 없다. 
  - `MenuPrice`가 올바르지 않으면 등록할 수 없다. 
    - `MenuPrice`는 0원 이상이어야 한다. 
    - `MenuPrice`는 `MenuProducts`의 총합보다 작거나 같아야 한다. 
- `Menu`에서 `MenuPrice`를 변경할 수 있다. 
  - `MenuPrice`가 올바르지 않으면 변경할 수 없다.
    - `MenuPrice`는 0원 이상이어야 한다.
  - `MenuPrice`는 `MenuProducts`의 총합보다 작거나 같아야 한다.
- `Menu`에서 `MenuDisplayStatus` 를 변경할 수 있다.
  - `MenuPrice`가 `MenuProducts`의 총합보다 클 경우 `DisplayedMenu`가 될 수 없다.
- `Menu`에서 `MenuProduct` 가격의 총 `Price`을 계산한다.



### 주문 테이블

#### 속성
- `OrderTable` 은 식별자, `OrderTableName`, `NumberOfGuests`, `Occupied` 를 가진다.

#### 행위
- `OrderTable`를 등록할 수 있다. 
  - `OrderTableName`이 존재하지 않으면 등록할 수 없다.
- `OrderTable` 에서 `Occupied`를 변경할 수 있다.
  - `OrderTabe`을 사용하는 `EatInOrder`가 있을 경우 `ClearedTable` 상태로 변경할 수 없다. 
- `OrderTable` 에서 `NumberOfGuests`를 변경할 수 있다.
  - `NumberOfGuest`가 0 미만이면 변경할 수 없다.
  - `ClearedTable`은 `NumberOfGuests`를 변경할 수 없다.




### 배달 주문
#### 속성
- `DeliveryOrder` 는 `OrderType` 중 `DELIVERY_ORDER` 를 가진다.
- `DeliveryOrder` 는 식별자, `DeliveryOrderStatus`, 주문 일시, `DeliveryAddress`, `OrderLineItems` 을 가진다.
- `OrderLineItems`은 선택한 `Menu`와 `Quantity`과 총 `Price`을 가진다.

#### 행위 
- `DeliveryOrder` 에서 `OrderLineItems` 를 생성한다.
  - `OrderLineItems`는 `Menu`가 존재하지 않으면 생성할 수 없다. 
  - `OrderLineItems`의 `Menu`가 `DisplayedMenu`가 아니면 생성할 수 없다.
  - `OrderLineItems`는 `Quantity`가 0 미만이면 생성할 수 없다. 
  - `DeliveryOrder`는 1개 이상의 `OrderLineItems`가 존재하지 않으면 등록할 수 없다.
  - `DeliveryOrder`는 `DeliveryAddress`가 존재하지 않으면 등록할 수 없다.
- `DeliveryOrder` 에서 `DeliveryOrderStatus` 를 `Waiting`로 변경할 수 있다.
- `DeliveryOrder` 에서 `DeliveryOrderStatus` 를 `Accepted`로 변경할 수 있다.
  - 변경 시 배달 대행사를 호출한다.
- `DeliveryOrder` 에서 `DeliveryOrderStatus` 를 `Served`로 변경할 수 있다.
- `DeliveryOrder` 에서 `DeliveryOrderStatus` 를 `Delivering`로 변경할 수 있다.
- `DeliveryOrder` 에서 `DeliveryOrderStatus` 를 `Delivered`로 변경할 수 있다.
- `DeliveryOrder` 에서 `DeliveryOrderStatus` 를 `Completed`로 변경할 수 있다.
- `DeliveryOrder` 에서 `DeliveryOrderStatus` 변경 시 순차적이어야 한다.
    ```mermaid
    ---
    title: OrderStatus
    ---
    flowchart LR
      A[Waiting] --> D(Accepted)
      D --> E(Served)
      E --> F(Delivering)
      F --> G(Delivered)
      G --> H[Completed]
    ```

### 포장 주문

#### 속성
- `TakeoutOrder` 는 `OrderType` 중 `TAKEOUT` 를 가진다.
- `TakeoutOrder` 는 식별자, `TakeoutOrderStatus`, 주문 일시, `OrderLineItems` 을 가진다.
- `OrderLineItems`은 선택한 `Menu`와 `Quantity` 과 총 `Price` 을 가진다.

#### 행위
- `TakeoutOrder` 에서 `OrderLineItems` 를 생성한다.
  - `OrderLineItems`는 `Menu`가 존재하지 않으면 생성할 수 없다.
  - `OrderLineItems`의 `Menu`가 `DisplayedMenu`가 아니면 생성할 수 없다.
  - `OrderLineItems`는 `Quantity`가 0 미만이면 생성할 수 없다.
  - `TakeoutOrder`는 1개 이상의 `OrderLineItems`가 존재하지 않으면 등록할 수 없다.
- `TakeoutOrder` 에서 `TakeoutOrderStatus` 를 `Waiting`로 변경할 수 있다.
- `TakeoutOrder` 에서 `TakeoutOrderStatus` 를 `Accepted`로 변경할 수 있다.
- `TakeoutOrder` 에서 `TakeoutOrderStatus` 를 `Served`로 변경할 수 있다.
- `TakeoutOrder` 에서 `TakeoutOrderStatus` 를 `Completed`로 변경할 수 있다.
- `TakeoutOrder` 에서 `TakeoutOrderStatus` 변경 시 순차적이어야 한다.

  ```mermaid
  ---
  title: OrderStatus
  ---
  flowchart LR
    A[Waiting] --> D(Accepted)
    D --> E(Served)
    E --> H[Completed]
  ```


### 매장 주문

#### 속성
- `EatInOrder` 는 `OrderType` 중 `EAT_IN` 를 가진다.
- `EatInOrder` 는 식별자, `EatInOrderStatus`, 주문 일시, `OrderLineItems`, `OrderTable`을 가진다.
- `OrderLineItems`은 선택한 `Menu`와 `Quantity` 과 총 `Price` 을 가진다.

#### 행위
- `EatInOrder` 에서 `OrderLineItems` 를 생성한다.
  - `OrderLineItems`는 `Menu`가 존재하지 않으면 생성할 수 없다.
  - `OrderLineItems`의 `Menu`가 `DisplayedMenu`가 아니면 생성할 수 없다.
  - `EatInOrder`는 1개 이상의 `OrderLineItems`가 존재하지 않으면 등록할 수 없다.
  - `EatInOrder`는 `OrderTable`이 `ClearedTable` 상태가 아니면 등록할 수 없다.
- `EatInOrder` 에서 `EatInOrderStatus` 를 `Waiting`로 변경할 수 있다.
- `EatInOrder` 에서 `EatInOrderStatus` 를 `Accepted`로 변경할 수 있다.
- `EatInOrder` 에서 `EatInOrderStatus` 를 `Served`로 변경할 수 있다.
- `EatInOrder` 에서 `EatInOrderStatus` 를 `Completed`로 변경할 수 있다.
  - `OrderTable`에게 `EatInOrderStatus`가 `Completed` 되었음을 알린다. 
- `EatInOrder` 에서 `EatInOrderStatus` 변경 시 순차적이어야 한다.
  ```mermaid
  ---
  title: OrderStatus
  ---
  flowchart LR
    A[Waiting] --> D(Accepted)
    D --> E(Served)
    E --> H[Completed]
  ```
