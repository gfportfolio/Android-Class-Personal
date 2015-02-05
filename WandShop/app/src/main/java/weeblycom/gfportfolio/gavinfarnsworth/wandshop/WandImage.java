package weeblycom.gfportfolio.gavinfarnsworth.wandshop;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by gavinfarnsworth on 2/4/15.
 */
public class WandImage {
    private String name;
    private int imageResourceNumber;

    public WandImage(String name, int imageResourceNumber) {
        this.name = name;
        this.imageResourceNumber = imageResourceNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceNumber() {
        return imageResourceNumber;
    }

    public void setImageResourceNumber(int imageResourceNumber) {
        this.imageResourceNumber = imageResourceNumber;
    }
}
