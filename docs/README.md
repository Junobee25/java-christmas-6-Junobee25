## 미션 - 🎄 크리스마스 프로모션

### ⭐ 핵심 기능
사용자의 총 주문 금액과 해당 방문 날짜에 받을 수 있는 할인 금액을 계산 한다.

### 🛠️ 구현 해야 할 기능 목록
- ⌨️ 입력
  - [x] 예상 날짜를 입력 받는 기능
  - [x] 주문 메뉴와 개수를 입력 받는 기능
- 💻 출력
  - [x] 입력 받은 주문 메뉴와 개수를 출력하는 기능
  
- 📒 계산
  - [x] 입력 받은 주문의 가격을 계산하는 기능
  - [x] 날짜에 받을 수 있는 할인 금액 계산
   
- 🧑🏻‍⚖️ 판단
  - [x] 크리스마스 이벤트 날짜인지 
  - [x] 평일 날짜인지
  - [x] 주말 날짜인지
  - [x] 특별 날짜인지
  - [x] 증정 선물 줄건지
  - [x] 주문 금액이 10,000 원 이상인지
  - [x] 음료만 주문 했는지
  - [x] 20개 까지만 주문 했는지
 

```⚠️ 예외 케이스 ```

### ⌨️ 입력

- 식당 예상 방문 날짜
  - [x] 아무 것도 입력 하지 않았을 경우
  - [x] 숫자가 아닌 값을 입력 했을 경우
  - [x] 1보다 작거나 31 보다 큰 값을 입력 했을 경우


- 주문할 메뉴와 개수
  - [x] 아무 것도 입력 하지 않았을 경우
  - [x] ','로 나눈 후 각 ```메뉴-개수``` 를 '-'로 나눴을 때 2가지로 나뉘지 않은 경우
  - [x] '-'기준 2가지 요소로 나뉘어 졌을 때 왼쪽의 요소가 메뉴판에 없는 문자열일 경우
  - [x] '-'기준 2가지 요소로 나뉘어 졌을 때 오른쪽의 요소가 공백일 경우
  - [x] '-'기준 2가지 요소로 나뉘어 졌을 때 오른쪽의 요소가 숫자가 아닌 문자의 경우
  - [x] '-'기준 2가지 요소로 나뉘어 졌을 때 오른쪽의 요소가 숫자 0 인경우
  - [x] 메뉴가 중복 될 경우
  - 음료만 주문 한 경우
  - [x] 20개 초과로 주문하는 경우