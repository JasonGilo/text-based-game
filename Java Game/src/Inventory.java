import java.util.ArrayList;

public class Inventory {

	private int capacity;
	private ArrayList<Item> items;
	private int coins;
	
	Inventory() {
		coins=0;
		capacity = 5; //There may only be 5 slots in the inventory.
		items = new ArrayList<Item>(); //Creates the inventory. (Empty)
	}
	
	public void showItems() {
		if(items.isEmpty()) {
			System.out.println("Inventory is empty!");
		}
		System.out.println("==============================");
		for(Item item : items) {
			System.out.print(item.getName()+ " ||");
		}
		System.out.println("\n==============================");
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins+=coins;
	}
	
	public void addItem(Item item) {
		if(items.size()==capacity-1) {
			return; //Cannot exceed 5 inventory slots.
		}else 
		items.add(item); //adds the item
	}
	public Item getItem(Item item) {
		if(!items.contains(item)) {
			return null; //Item does not exist.
		}
		return items.get(items.indexOf(item)); //return the item
	}
	
	public void removeItem(Item item) {
		if(!items.contains(item)) {
			return; //Item does not exist.
		}
		items.remove(items.indexOf(item)); //removes the item
	}
	

}
