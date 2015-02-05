package weeblycom.gfportfolio.gavinfarnsworth.wandshop;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by gavinfarnsworth on 2/4/15.
 */
public class WandManager {
    private ArrayList<WandImage> wandOptions;
    private ArrayList<MagicWand> magicWands;

    public WandManager() {
        wandOptions = new ArrayList<>();
        wandOptions.add(new WandImage("Mickey's Sorcerer Hat", R.drawable.sorcerermickeyhat));
        wandOptions.add(new WandImage("Minnie's Bow", R.drawable.minniebow));
        wandOptions.add(new WandImage("Pluto's Bone", R.drawable.plutobone));
        wandOptions.add(new WandImage("Elsa's Snowflake", R.drawable.elsasnow));
        wandOptions.add(new WandImage("Cinderella's Slipper", R.drawable.cinderellaslipper));
        wandOptions.add(new WandImage("Aladan's Lamp", R.drawable.aladanlamp));
        //String brand, int currentMagicPoints, int maxMagicPoints, WandImage image
        magicWands = new ArrayList<MagicWand>();
        magicWands.add(new MagicWand("Disney's",5000,5000, wandOptions.get(0)));
        magicWands.add(new MagicWand("Galivander's",4000,3000, wandOptions.get(0)));
        magicWands.add(new MagicWand("Pixar's",3000,2000, wandOptions.get(0)));
        magicWands.add(new MagicWand("Google's",2000,5000, wandOptions.get(0)));
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


}
