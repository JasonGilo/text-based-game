import java.util.Scanner;

public class Game {
	static Player mainPlayer;

	
	
	public static void main(String[] args) {
		intro();
		mainMenu();
	}
	
	public static void intro() {
		Scanner scanName = new Scanner(System.in);
		System.out.print("Welcome, Please type in your desired name: ");
		String name = scanName.next();
		mainPlayer=new Player();
		mainPlayer.setName(name);
		System.out.println("\nGreat Name, " + mainPlayer.getName() + "!");

		System.out.println("You have wandered off into the abyss into another dimension."
				+ " Be careful!, you might come across other players or even worst, MONSTERS!");
		System.out.println("My advice to you: Fight for your life");
	}
	
	public static void mainMenu() {
		System.out.println("**MAIN MENU**");
		System.out.println("Please select an option below from 1-3");
		System.out.println("1. Explore, 2. Inventory, 3. Exit");
		Scanner scanOption = new Scanner(System.in);
		int option=0;
		try {
			while(true) {
			option = scanOption.nextInt();
			if(option>3||option<=0) {
				System.out.println("Invalid option, please pick a number between 1-3");
				continue;
			}else {
				break;
			}
			}
		}catch(Exception e) {
			System.out.println("Invalid option, please pick a number between 1-3");
		}
		if(option==1) {
			explore();
		}else if(option==2) {
			mainPlayer.getInv().showItems();
			mainMenu();
		}else {
			System.exit(0);
		}
			
	}
	
	public static int randomNumber(int max, int min) {
		return (int)(Math.random() * ((max - min) + 1)) + min;
	}
	
	private static int totalDamage(int damageOne, int damageTwo) {
		return damageOne+damageTwo;
	}
	
	private static void fightLoop(Living enemy) {
		int health = mainPlayer.getHealth();
		int totalDamage;
		System.out.println("You came across a " + enemy.getName() + "!");
		System.out.println("the goblin has hit you with his "+ enemy.getWeapon().getName());
		System.out.println("He has dealt " + 
		totalDamage(randomNumber(0,enemy.getDamage()),randomNumber(0,enemy.getWeapon().getDamage())));

		while(enemy.getHealth()>0&&mainPlayer.getHealth()>0) {
			totalDamage=totalDamage(randomNumber(0,mainPlayer.getDamage()),
					randomNumber(0,mainPlayer.getWeapon().getDamage()));
			System.out.println(enemy.getName() +" dealt " + totalDamage);
			
			mainPlayer.setHealth(mainPlayer.getHealth()-totalDamage);
			System.out.println("You have health: "+mainPlayer.getHealth());
			
			if(mainPlayer.getHealth()<=0) {
				System.out.println("You have died");
				System.exit(0);
			}
			totalDamage=totalDamage(randomNumber(0,mainPlayer.getDamage()),
					randomNumber(0,mainPlayer.getWeapon().getDamage()));
			System.out.println("You dealt " + totalDamage);
			
			enemy.setHealth(enemy.getHealth()-totalDamage);
			System.out.println(enemy.getName()+ " health: " + enemy.getHealth());

		}
		
		if(enemy.getHealth()<=0) {
			System.out.println("You have killed the "+ enemy.getName());
			mainPlayer.getInv().setCoins(mainPlayer.getInv().getCoins()+10);
			mainPlayer.setHealth(health);
		}
		mainMenu();
		
	}
	
	private static void explore() {
		System.out.println("You have chosen to explore");
		int randomValue = randomNumber(4,1); //Random number between 1-4
		switch(randomValue) {
			case 1: 
				Item typeOfItem = Item.randomItem();
				System.out.println("You came across an item!");
				System.out.println("**AQUIRED "+ typeOfItem.getName()+"**");
				mainPlayer.getInv().addItem(typeOfItem);
				mainMenu();
				break;
			case 2:
				Item typeOfItem2 = Item.randomItem();
				System.out.println("You came across an item!");
				System.out.println("**AQUIRED "+ typeOfItem2.getName()+"**");
				mainPlayer.getInv().addItem(typeOfItem2);
				mainMenu();
				break;
			case 3:
				Living goblin = new Monster("Goblin", 15, 2, new Weapon("Dagger",1,0,5));
				fightLoop(goblin);
				break;
			case 4:
				Living dwarf = new Monster("Dwarf", 25, 5, new Weapon("PickAxe", 2,0,10));
				fightLoop(dwarf);
				break;
				
		}
	}
	
}
