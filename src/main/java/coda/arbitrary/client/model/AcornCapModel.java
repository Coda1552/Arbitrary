package coda.arbitrary.client.model;

import coda.arbitrary.Arbitrary;
import coda.arbitrary.common.items.AcornCapArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.finsandtails.geckolib3.model.AnimatedGeoModel;

public class AcornCapModel extends AnimatedGeoModel<AcornCapArmorItem> {

	@Override
	public ResourceLocation getModelLocation(AcornCapArmorItem object) {
		return new ResourceLocation(Arbitrary.MOD_ID, "geo/acorn_cap.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(AcornCapArmorItem object) {
		return new ResourceLocation(Arbitrary.MOD_ID, "textures/armor/acorn_cap.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(AcornCapArmorItem object) {
		return null;
	}
}
