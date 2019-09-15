
	
	class Weapon extends Item {
		private int damage;
		private int worth;
		Weapon(String name, int damage, int heal, int worth){
			super(name, heal);
			this.setDamage(damage);
			this.setWorth(worth);
		}
		public int getDamage() {
			return damage;
		}
		public void setDamage(int damage) {
			this.damage = damage;
		}
		public int getWorth() {
			return worth;
		}
		public void setWorth(int worth) {
			this.worth = worth;
		}
	}
	
	class Potion extends Item {
		private int attackBonus;
		Potion(String name, int heal, int attackBonus){
			super(name, heal);
			this.setAttackBonus(attackBonus);
		}
		public int getAttackBonus() {
			return attackBonus;
		}
		public void setAttackBonus(int attackBonus) {
			this.attackBonus = attackBonus;
		}
		
		
	}
public class Item {
	private String name;
	private int heal;
	
	Item(String name, int heal){
		this.name = name;
		this.heal = heal;
	}
	
	public static Item randomItem() {
		switch(Game.randomNumber(6,1)) { //Create the items (2 potions, 4 weapons)
		case 1:
			return new Potion("Health Potion", 5,0);
		case 2:
			return new Potion("Extra-Damage Potion",0,5);
		case 3:
			return new Weapon("Fire Sword", 15, 0,100);
		case 4: 
			return new Weapon("Ice Sword", 10, 0,20);
		case 5:
			return new Weapon("Water Sword", 7, 0,10);
		case 6:
			return new Weapon("Health Sword", 5, 15,50);
		}
		return null; //unreachable code, number will always be 1-6 and all cases are accounted for
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHeal() {
		return heal;
	}
	public void setHeal(int heal) {
		this.heal=heal;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
