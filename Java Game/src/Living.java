class Monster extends Living {
		Monster(String name, int health, int damage, Weapon weapon) {
			super(name, health, damage, weapon);
		}
	}

	class Player extends Living {
		Inventory inv= new Inventory();
		int level;
		
		Player(){
			super("null", 50, 7, new Weapon("Ice Sword", 5, 0, 20));
			this.inv= new Inventory();
			this.level=1;
		}
		Player(String name, int health, int damage, Weapon weapon, int level) {
			super(name, health, damage, weapon);
			this.inv = inv;
			this.level= level;
		}
		
		public Inventory getInv() {
			return inv;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level=level;
		}
		
	}
public class Living {
	private String name = "";
	private int health;
	private int damage;
	private Weapon weapon;

	Living(String name, int health, int damage, Weapon weapon){
		this.name=name;
		this.health = health;
		this.damage = damage;
		this.weapon = weapon;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	

}
