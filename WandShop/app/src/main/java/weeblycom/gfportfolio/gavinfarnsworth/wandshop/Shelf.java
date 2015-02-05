package weeblycom.gfportfolio.gavinfarnsworth.wandshop;

import java.util.ArrayList;

/**
 * 
 * @Gavin Farnsworth
 *
 */
public class Shelf {
	
	private Object [][]shelf;
	private int numberOfItemsWide;
	private int numberOfItemsTall;
	/**
	 * Create a shelf that can hold items
	 * 
	 * @param numberOfItemsWide
	 * @param numberOfItemsTall
	 * 
	 * GOTCHAS: Negative numbers, and 0, should set the appropriate dimension to 1 so that there is at least room for 1 item
	 */
	public Shelf(int numberOfItemsWide, int numberOfItemsTall){
		if(numberOfItemsWide<1){
			numberOfItemsWide=1;
		}
		if(numberOfItemsTall<1){
			numberOfItemsTall=1;
		}
		shelf = new Object[numberOfItemsWide][numberOfItemsTall];
		this.numberOfItemsWide = numberOfItemsWide;
		this.numberOfItemsTall =numberOfItemsTall;
	}

	/**
	 * @return the number of items wide the shelf it
	 */
	public int getNumberOfItemsWide(){
		return this.numberOfItemsWide;
	}

	/**
	 * @return the number of items tall the shelf is
	 */
	public int getNumberOfItemsTall(){
		return this.numberOfItemsTall;
	}
	
	
	/**
	 * This method should tell how many items are in the slot
	 * 
	 * @param slot
	 * @return the number of items in that slot
	 * 
	 * GOTCHAS:
	 * Don't crash on bad slot numbers, but return 0
	 */
	public int getNumberOfItemsAtSlot(int slot){
		if(slot>numberOfItemsWide||slot<0){
			return 0;
		}
		
		int count = 0;
			for(int i = 0; i < shelf[slot].length; i++)
			{
				if(shelf[slot][i]!=null){
					count++;
				}
			}
		return count;
	}

	/**
	 * This method should tell how many empty locations are in the slot
	 * 
	 * @param slot
	 * @return the number of empty locations in that slot
	 * 
	 * GOTCHAS:
	 * Don't crash on bad slot numbers, but return 0
	 */
	public int getNumberOfEmptySpotsAtSlot(int slot){
			if(slot>this.numberOfItemsWide||slot<0){
				return 0;
			}
		
		return numberOfItemsTall-getNumberOfItemsAtSlot(slot);
	}

	/**
	 * This should add an item to the shelf.
	 * It will probably be a wand, but we are going to program in the general
	 * 
	 * @param o the Item to add
	 * @param slot the slot number at which to add it
	 * @return true if you can add the item, false otherwise
	 * 
	 * GOTCHAS:
	 * Don't add null items
	 * Don't crash on bad slot numbers
	 * Slot's can fill up, so don't let too many items onto a slot
	 * 
	 */
	public boolean addItemToTopAtSlot(Object o, int slot){
		if(slot>this.numberOfItemsTall||slot<0){
			return false;
		}
		if(slot>this.numberOfItemsWide||slot<0){
			return false;
		}
		if(o==null){
			return false;
		}
		if(getNumberOfEmptySpotsAtSlot(slot)==0){
			return false;
		}
		int i=0;
		while(shelf[slot][i]!=null){
			i++;
		}
		shelf[slot][i]=o;
		return true;
	}
	
	
	/**
	 * This method should return the item that was previously added into that slot
	 * @param slot
	 * @param location
	 * @return the item in the correct location
	 * 
	 * GOTCHAS:
	 * Return null on invalid slot numbers, or invalid location, or empty locations
	 */
	public Object getButDontRemoveItemAtSlotAndLocation(int slot, int location){
		if(slot<0 || slot>numberOfItemsWide || location<0 || location>numberOfItemsTall){
			return null;
		}
		if(shelf.length<slot){
			return null;
		}
		if(getNumberOfItemsAtSlot(slot)<location){
			return null;
		}
		
		
		Object o = shelf[slot][location];
		
		
		return o;
	}
	
	
	/**
	 * This method should return how many total items are on the entire shelf
	 * @return
	 */
	public int getTotalNumberOfItemsOnShelf(){
		int count=0;
		for(int i=0; i <shelf.length; i++){
			count+=getNumberOfItemsAtSlot(i);
		}
		return count;
	}
	
	
	
}
