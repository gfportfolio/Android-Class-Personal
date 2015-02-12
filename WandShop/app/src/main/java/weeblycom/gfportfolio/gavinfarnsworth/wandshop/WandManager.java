package weeblycom.gfportfolio.gavinfarnsworth.wandshop;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by gavinfarnsworth on 2/4/15.
 */
public class WandManager {
    private ArrayList<WandImage> wandOptions;
    private ArrayList<MagicWand> magicWands;
    private int currentWand;
    public WandManager() {
        wandOptions = new ArrayList<>();
        wandOptions.add(new WandImage("Mickey's Sorcerer Hat", R.drawable.sorcerermickeyhatpng));
        wandOptions.add(new WandImage("Minnie's Bow", R.drawable.minniebowpng));
        wandOptions.add(new WandImage("Pluto's Bone", R.drawable.plutobonepng));
        wandOptions.add(new WandImage("Elsa's Snowflake", R.drawable.elsasnowpng));
        wandOptions.add(new WandImage("Cinderella's Slipper", R.drawable.cinderellaslipperpng));
        wandOptions.add(new WandImage("Aladan's Lamp", R.drawable.aladanlamppng));
        //String brand, int currentMagicPoints, int maxMagicPoints, WandImage image
        magicWands = new ArrayList<MagicWand>();
        magicWands.add(new MagicWand("Disney's",5000,5000, wandOptions.get(1)));
        magicWands.add(new MagicWand("Galivander's",3000,4000, wandOptions.get(0)));
        magicWands.add(new MagicWand("Pixar's",2000,3000, wandOptions.get(2)));
        magicWands.add(new MagicWand("Google's",2000,5000, wandOptions.get(3)));
        currentWand =0;

    }


    public ArrayList<String> getWandTypeNames(){
        ArrayList<String> names = new ArrayList<String>();
        for(WandImage img: wandOptions){
            names.add(img.getName());
        }
        return names;
    }

    public MagicWand getWond(int location){

        return magicWands.get(location);
    }
    public MagicWand getCurrentWond(){
        return getWond(currentWand);
    }

    public MagicWand addWond(String company, int maxMagic, int currentMagic, String wandType){
           WandImage type = getWandType(wandType);
        MagicWand newWond = new MagicWand(company, maxMagic, currentMagic, type);
        magicWands.add(newWond);
        return newWond;
    }

    private WandImage getWandType(String wandType){

        for (WandImage img: wandOptions){
            if(img.getName().equals(wandType)){
                return img;
            }
        }
        return null;
    }
    public MagicWand saveEditWand(int id, String company, int maxMagic, int currentMagic, String wandType){
        MagicWand thisWand = getWond(id);
        int wandIndex= magicWands.indexOf(thisWand);
        WandImage thisImage = getWandType(wandType);
        thisWand.setImage(thisImage);
        thisWand.setBrand(company);
        thisWand.setCurrentMagicPoints(currentMagic);
        thisWand.setMaxMagicPoints(maxMagic);
        magicWands.remove(wandIndex);
        magicWands.add(wandIndex, thisWand);
        return thisWand;

    }
    public MagicWand changeWond(boolean forward){
        if(forward){
            currentWand++;
            if(currentWand>magicWands.size()-1){
                currentWand=0;
            }
        }
        else{
            currentWand--;
            if(currentWand<0){
                currentWand=magicWands.size()-1;
            }
        }
        return getWond(currentWand);
    }

    public ArrayList<WandImage> getWandOptions() {
        return wandOptions;
    }
}
