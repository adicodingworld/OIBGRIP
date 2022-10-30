
/*

		Developed by -> Aditya Govinda Kalaskar
		Task 1 - ATM Interface
		
*/

import java.util.Scanner;

class atminterface
{
	
	Scanner sc = new Scanner(System.in);
	int user_id;
	int user_pin;
	int amount = 20000;
	int[] arr = new int[100];
	int i = 0;
	int counter = 0;

	
	int flag = 0;

	void validation()
	{

		System.out.print("Enter your user Id: ");
		user_id = sc.nextInt();

		System.out.print("Enter your Pin: ");         
		user_pin = sc.nextInt();		
			
		if(user_id == 98765 && user_pin == 753)
		{
			System.out.println("\n\tLogined Successfully(@-@)");
			
		}
		else
		{
			System.out.println("\tInvalid Details\n\tPlease Re-entere your details ------> ");		
			validation();	

		}
		
	}	

	void transaction_history()
	{
		int k =1;
		if(flag == 0)
			System.out.println("No transaction till now");
		else
		{
			for(int j=0; j<counter; j++)               
			{

				System.out.println("\n**** Transaction: " + k++ + "*****");                
				System.out.print("Transaction type: ");
				if(arr[j] == 0 || arr[j] == -1)
				{
					System.out.println("Withdrwal");
					
					if(arr[j]==0)
					{	
						System.out.println("Amount withdrawed: " + arr[++j]);
						System.out.println("Available balance: "+ arr[++j]);
					}
					else
					{
						System.out.println("Transaction failed due to unsufficient balance\nAmount trying to withdraw: " + arr[++j]);
						
						System.out.println("Available balance: "+ arr[++j]);
						
					}				
			
				}
				else if(arr[j] == 1)
				{
					System.out.println("Deposite");
					System.out.println("Amount Deposited: " + arr[++j]);
					System.out.println("Available balance: "+ arr[++j]);
					
				}
				else
				{
				   	System.out.println("Transfer");
		
					
					System.out.println("To account : " + arr[j++]);
					System.out.println("Transfer balance: "+ arr[j++]);	
					System.out.println("Available balance: "+ arr[j++]);

				}

			}		

	
		}


	}


	void withdraw()
	{
		flag = 1;
		System.out.print("\nEnter the amount : ");
		int wamount = sc.nextInt();
		
	        if(wamount <= 0)
			System.out.println("Please enter withdrawal amount more than zero");
		else if(amount>=wamount)	
		{
			amount = amount - wamount;
			System.out.println("\tAmount debited ");
			arr[i] = 0; i++;counter++;  
			arr[i] = wamount;i++;counter++;   
			arr[i] = amount;i++;counter++;  
		}
		else 
		{	
			System.out.println("Un-sufficient bank-balance");
			arr[i] = -1; i++;counter++;
			arr[i] = wamount;i++;counter++;
			arr[i] = amount;i++;counter++;			
		}
		
	}



	void deposite()
	{
		flag = 1;
		System.out.print("Enter the amount: ");
		int damount = sc.nextInt();
		
		if(damount<=0)
			System.out.println("Please enter amount more than zero");
		else
		{
			amount = amount + damount;
			System.out.println("\tAmount Credited");
			arr[i] = 1;i++;counter++;
			arr[i] = damount;i++;counter++;
			arr[i] = amount;i++;counter++;
		}
	}


	void available()
	{
		System.out.println("\n\t| Available balance : " + amount + " |");		

	}

	void transfer()
	{
		flag = 1;
	
		

		System.out.print("Enter accounter number: ");
		int accno = sc.nextInt();                
		arr[i] = accno;i++;counter++;

		
		System.out.print("Enter amount need to transfer: ");
		int tamount = sc.nextInt();
		arr[i] = tamount;i++;counter++;

		if(amount>=tamount)
		{
			amount = amount - tamount;
			System.out.println("\tAmount transfer Successfully");
			arr[i] = amount;i++;counter++;
		}	
		else
		{
			System.out.println("Un-sufficient balance");
			arr[i] = amount;i++;counter++;	
		}

	}


}


class atm{

	public static void main(String args[])
	{
		
		Scanner sc = new Scanner(System.in);
		int ch;
		atminterface obj1 = new atminterface();
	
		
		System.out.println("*********************************************");
		obj1.validation();
		System.out.println("*********************************************");
		
		do
		{
			System.out.println("\n#### MENU ####");
			System.out.println("1) Transation history \n2) Withdraw \n3) Deposite \n4) Transfer \n5) Available Balance \n6) Quit");

			System.out.print("Enter your choice:: ");
			ch = sc.nextInt();

			if(ch<=0 || ch>6)
				System.out.println("Please enter valid choice\n");

			switch(ch)
			{
				case 1:
					obj1.transaction_history();
					break;
				case 2:
					obj1.withdraw();
					break;
				case 3:
					obj1.deposite();
					break;
				case 4:
					obj1.transfer();
					break;
				case 5:
					obj1.available();
					break;
				case 6:
					  System.out.println("*** Byee ****\n");     
			}

		}while(ch!=6);   			

	}

}