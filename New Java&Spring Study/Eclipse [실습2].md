### [실습2]

![캡처](https://user-images.githubusercontent.com/42603919/78734867-53651980-7984-11ea-84ce-e6aeec1749d5.PNG)

2. **src에 우측버튼 클릭 -> New -> Package**

![캡처](https://user-images.githubusercontent.com/42603919/78735057-cbcbda80-7984-11ea-9370-7ee40245893c.PNG)

1. **workshop.account.entity에 우측버튼 클릭 -> New -> Class**

   ![캡처](https://user-images.githubusercontent.com/42603919/78735202-27966380-7985-11ea-8b37-d9805f7bfd07.PNG)



**->** ![캡처](https://user-images.githubusercontent.com/42603919/78735239-3d0b8d80-7985-11ea-84ce-c385312f2975.PNG)



3. ```java
   package workshop.account.entity;
   
   public class Account {
   	//고객번호(custId), 계좌번호(acctId), 잔액(balance)에 해당하는 변수를 선언합니다. 
   	//모든 변수들을 다른 클래스에서 직접 사용하지 못하도록 private으로 선언하며, 
   	//고객번호, 계좌번호는 String type으로 , 잔액은 int type으로 합니다. 
   	private String custId;
   	private String acctId;
   	private int balance;
   	
   	//default constructor
   	public Account() {
   		
   	}
   ```

**이후 source -> Generate Constructor using Fields**

```java
package workshop.account.entity;

public class Account {
	//고객번호(custId), 계좌번호(acctId), 잔액(balance)에 해당하는 변수를 선언합니다. 
	//모든 변수들을 다른 클래스에서 직접 사용하지 못하도록 private으로 선언하며, 
	//고객번호, 계좌번호는 String type으로 , 잔액은 int type으로 합니다. 
	private String custId;
	private String acctId;
	private int balance;
	
	//default constructor
	public Account() {
		
	}

	//중복정의된(overloading) 생성자 선언
	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}
	
}
```



4,5,6,7.

**source -> Generate Getters and Setters**

![캡처](https://user-images.githubusercontent.com/42603919/78735738-7bee1300-7986-11ea-9278-c6fcf8cfea43.PNG)

```java
package workshop.account.entity;

public class Account {
	//고객번호(custId), 계좌번호(acctId), 잔액(balance)에 해당하는 변수를 선언합니다. 
	//모든 변수들을 다른 클래스에서 직접 사용하지 못하도록 private으로 선언하며, 
	//고객번호, 계좌번호는 String type으로 , 잔액은 int type으로 합니다. 
	private String custId;
	private String acctId;
	private int balance;
	
	//default constructor
	public Account() {
		
	}

	//중복정의된(overloading) 생성자 선언
	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
```



**getBalance + setBalance + 입금 + 출금**

getBal,  setBal (**ctrl + space bar**) -> 자동 생성

```java
package workshop.account.entity;

public class Account {
	//고객번호(custId), 계좌번호(acctId), 잔액(balance)에 해당하는 변수를 선언합니다. 
	//모든 변수들을 다른 클래스에서 직접 사용하지 못하도록 private으로 선언하며, 
	//고객번호, 계좌번호는 String type으로 , 잔액은 int type으로 합니다. 
	private String custId;
	private String acctId;
	private int balance;
	
	//default constructor
	public Account() {
		
	}

	//중복정의된(overloading) 생성자 선언
	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금
	public void deposite(int amount) {
		this.balance += amount;
	}
	
	//출금
	public void withdraw(int amount) {
		if(this.balance >= amount) {
		this.balance -= amount;
	}
	}
}
```



8.

**src에 우측버튼 클릭 -> New -> Class**

![캡처](https://user-images.githubusercontent.com/42603919/78736791-fc157800-7988-11ea-9f4b-8c94f19be3a1.PNG)

![캡처](https://user-images.githubusercontent.com/42603919/78736889-341cbb00-7989-11ea-8be1-8f7c77f7080f.PNG)

```java
package workshop.account.test;

import workshop.account.entity.Account;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account account = new Account("A1100", "221-22-347", 10000);
		System.out.println(account);
	}

}
```



**source -> Generate toString**

![캡처](https://user-images.githubusercontent.com/42603919/78738509-03d71b80-798d-11ea-8010-df56baf03125.PNG)

```java
package workshop.account.entity;

public class Account {
	//고객번호(custId), 계좌번호(acctId), 잔액(balance)에 해당하는 변수를 선언합니다. 
	//모든 변수들을 다른 클래스에서 직접 사용하지 못하도록 private으로 선언하며, 
	//고객번호, 계좌번호는 String type으로 , 잔액은 int type으로 합니다. 
	private String custId;
	private String acctId;
	private int balance;
	
	//default constructor
	public Account() {
		
	}

	//중복정의된(overloading) 생성자 선언
	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금
	public void deposite(int amount) {
		this.balance += amount;
	}
	
	//출금
	public void withdraw(int amount) {
		if(this.balance >= amount) {
		this.balance -= amount;
	}
	}

	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId + ", balance=" + balance + "]";
	}
	
}
```



**오류 발생하면 다음과 같이 설정**

마우스 우측버튼 클릭 -> Proprties 클릭 -> JRE System Library 더블클릭 ->  -> JavaSE-1.8 선택

![캡처](https://user-images.githubusercontent.com/42603919/78738809-bad39700-798d-11ea-8ae3-e82ed82864d6.PNG)

**TestAccount.java를 run 하면**

**결과**
**Account [custId=A1100, acctId=221-22-347, balance=10000]**



```java
package workshop.account.test;

import workshop.account.entity.Account;

public class TestAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Account account = new Account("A1100", "221-22-347", 10000);
		System.out.println(account);
		
		System.out.println(account.getBalance());
		account.deposite(1000);
		account.withdraw(2000);
		System.out.println("잔액" + account.getBalance());
	}
}

```

**TestAccount.java를 run 하면**

**결과**
**Account [custId=A1100, acctId=221-22-347, balance=10000]
10000
잔액9000**