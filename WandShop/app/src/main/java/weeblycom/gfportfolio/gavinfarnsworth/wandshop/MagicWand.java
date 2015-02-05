package weeblycom.gfportfolio.gavinfarnsworth.wandshop;

/**
 * 
 * @Gavin Farnsworth
 *
 */
public class MagicWand {

	private String brand;
	private int currentMagicPoints;
	private int maxMagicPoints;
	private String magicCore;
    private WandImage image;
	/**
	 * This is the no argument constructor
	 * When a Wand is created using this constructor it has
	 * 2000 max magic points
	 * 2000 current magic points
	 * a brand name of "Ollivander"
	 * a magic core of "Dragon heartstring"
	 * 
	 */
	public MagicWand(){
		this.brand="Ollivander";
		this.maxMagicPoints=2000;
		this.currentMagicPoints =2000;
		this.magicCore="Dragon heartstring";
	}
	
	/**
	 * This is the 2 argument constructor
	 * When a Wand is created using this constructor it has
	 * a magic core of "Unicorn tail hair"
	 * and the following parameters
	 * @param maxMagicPoints the number of magic points
	 * @param theBrandName the brand name of the wand
	 * 
	 * It also has a full charge of magic points
	 * 
	 * GOTCHAS.  If the maxMagicPoints is negative, set the limit to 0
	 */
	public MagicWand(int maxMagicPoints, String theBrandName){
		if(maxMagicPoints<0){
			maxMagicPoints =0;
		}
		this.maxMagicPoints=maxMagicPoints;
		this.brand = theBrandName;
		this.currentMagicPoints =maxMagicPoints;
		this.magicCore="Unicorn tail hair";
	}

    public MagicWand(String brand, int currentMagicPoints, int maxMagicPoints, WandImage image) {
        this.brand = brand;
        this.currentMagicPoints = currentMagicPoints;
        this.maxMagicPoints = maxMagicPoints;
        this.image = image;
        this.magicCore = image.getName();
    }

    /**
	 * This method should return the number of magic points left 
	 * 
	 * @return the number of magic points left
	 */
	public int getCurrentMagicCharge() {
		return this.currentMagicPoints;
	}

	/**
	 * The method should return the brand name of the wand
	 * 
	 * @return the brand name of the wand
	 */
	public String getBrandName() {
		return this.brand;
	}

	/**
	 * This method should return the type of magic core in the wand
	 * 
	 * @return the type of magic core in the wand
	 */
	public String getMagicCore() {
		return this.magicCore;
	}

	/**
	 * This method should return true if the spell can be cast, false otherwise.
	 * It should also reduce the charge of the wand by numSpellPoints if the spell can be cast
	 * 
	 * A spell can be cast is numSpellPoints <= the current amount of magic points the wand has 
	 * 
	 * @param numSpellPoints the number of points it costs to use the wand
	 * @return true if the spell is cast, false otherwise
	 * 
	 * GOTCHAS: if the numSpellPoints is negative, do not change the current number of points and just return false
	 */
	public boolean castSpell (int numSpellPoints){
		if(this.currentMagicPoints>=numSpellPoints&&numSpellPoints>0){
		this.currentMagicPoints-=numSpellPoints;
		return true;}
		return false;
	}
	
	
	/**
	 * This method should set the number of current magic points to whatever max point value was given to the constructor
	 * 
	 */
	public void rechargeWand() {
		this.currentMagicPoints=this.maxMagicPoints;
	}
	


	/**
	 * @return true if the current wand has any magic points left, false otherwise
	 */
	public boolean hasCharge(){
		if(this.currentMagicPoints>0){
			return true;
		}
		return false;
	}

    public WandImage getImage() {
        return image;
    }

    public void setImage(WandImage image) {
        this.image = image;
    }
}
