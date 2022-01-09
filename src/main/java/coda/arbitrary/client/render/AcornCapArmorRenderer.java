package coda.arbitrary.client.render;

import coda.arbitrary.client.model.AcornCapModel;
import coda.arbitrary.common.items.AcornCapArmorItem;
import software.bernie.finsandtails.geckolib3.renderers.geo.GeoArmorRenderer;

public class AcornCapArmorRenderer extends GeoArmorRenderer<AcornCapArmorItem> {

    public AcornCapArmorRenderer() {
        super(new AcornCapModel());

        //These values are what each bone name is in blockbench. So if your head bone is named "bone545",
        // make sure to do this.headBone = "bone545";

        // The default values are the ones that come with the default armor template in the geckolib blockbench plugin.
        this.headBone = "armorHead";
    }
}