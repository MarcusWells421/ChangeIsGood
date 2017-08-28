import java.util.Scanner;

public class ChangeIsGood { 

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		changeBack(scanner);
		scanner.close();
	}

	public static void changeBack(Scanner change) {
		System.out.println("Please enter an integer below, between 1 and 99, to represent how many cents I will give you, then press 'Enter'. Based upon the number you enter,");
		System.out.println("I will tell you, using U.S. currency, how many of each coin I would need to give you, in the largest coinage possible, to give you the change you");
		System.out.println("are expecting. Give it a try! Change is good!");
		int userNum; //Declared separately in case the code goes into the 'while' loop just below.
		userNum = change.nextInt(); //Gets user input.		
			while (userNum < 1 || userNum > 99) { //Loops the user to reenter an integer if the number entered is less than 1 or greater than 99.
				System.out.println("");
				System.out.println("Oops! It looks like there's been a misunderstanding. I'm sorry, but I can only accept numbers between 1 and 99. Please enter a new number now.");
				userNum = change.nextInt(); //Gets user input again and again (if necessary) until the user enters an integer between 1 and 99.
			}
		int remainder = userNum; //Initially set to the user input, but will become the remainder after dividing out the largest coin available.
		int coins; //Used to display the result of how many of each coin is returned. 
		int coinCountdown = 3; //Used as a part of the 'switch' code below to change the divisor and denomination name.
		int denomValue = 25; //Initial denomination divisor. Changes with the 'switch' code below.
		int coinTypeCounter = 0; //Used to count how many different coin types are used.
		String denomLabel = "quarter"; //Initial denomination label. Changes with the 'switch code below.
		System.out.println("");
		System.out.print("Thank you! If you want " + userNum + "¢ change, I will give you ");// Using print instead of println to concatenate the result into one line.
		while(coinCountdown > 0) {	
			if(remainder >= denomValue) {	
				
				if(remainder % denomValue == 0 && remainder != userNum) {
					System.out.print("and ");
				}
				
				coins = remainder / denomValue;
				remainder = remainder % denomValue;
				System.out.print(coins + " " + denomLabel);
				
					if(coins > 1) {
						System.out.print("s");
					}

					coinTypeCounter++;

					if(remainder > 0) {
							if(coinTypeCounter == 1) {
									if(remainder == 20) {
										System.out.print(" ");
									} else if (remainder == 10) {
										System.out.print(" ");
									} else if (remainder == 5) {
										System.out.print(" ");
									} else if (remainder < 5) {	
										System.out.print(" ");
									} else {
										System.out.print(", ");
									} 
									}
							else if (coinTypeCounter != 1) {
							System.out.print(", ");
							}		
					}		
			}

			coinCountdown--;

			switch(coinCountdown) {
			case 2:
				denomValue = 10;
				denomLabel = "dime";
				break;
			case 1:
				denomValue = 5;
				denomLabel = "nickel";
				break;
			}	
		}
		
		if(remainder > 0) {
			
				if(remainder != userNum) {
					System.out.print("and ");
				}
			
			System.out.print(remainder + " penn");
				if(remainder > 1) {
					System.out.print("ies");
				} else {
					System.out.print("y");
				}
		}
		System.out.print(".");
	}

}