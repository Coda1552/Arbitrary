package coda.arbitrary.common.items;

import coda.arbitrary.Arbitrary;
import coda.arbitrary.registry.ArbitraryItems;
import coda.dracoshoard.common.items.DHArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import software.bernie.finsandtails.geckolib3.core.IAnimatable;
import software.bernie.finsandtails.geckolib3.core.manager.AnimationData;
import software.bernie.finsandtails.geckolib3.core.manager.AnimationFactory;
import software.bernie.finsandtails.geckolib3.item.GeoArmorItem;

public class AcornCapArmorItem extends GeoArmorItem implements IAnimatable {
    public static final ArmorMaterial MATERIAL = new DHArmorMaterial(Arbitrary.MOD_ID + ":acorn_cap", 2, new int[]{1, 2, 3, 1}, 8, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, () -> Ingredient.of(ArbitraryItems.ACORN.get()));
    private AnimationFactory factory = new AnimationFactory(this);

    public AcornCapArmorItem(EquipmentSlot slot, Properties builder) {
        super(MATERIAL, slot, builder);
    }

    @Override
    public void registerControllers(AnimationData animationData) {}

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
