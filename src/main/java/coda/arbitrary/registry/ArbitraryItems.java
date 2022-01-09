package coda.arbitrary.registry;

import coda.arbitrary.Arbitrary;
import coda.arbitrary.common.items.AcornCapArmorItem;
import coda.dracoshoard.common.items.DHArmorMaterial;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ArbitraryItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Arbitrary.MOD_ID);

    public static final RegistryObject<Item> ACORN = ITEMS.register("acorn", () -> new Item(new Item.Properties().tab(Arbitrary.GROUP)));
    public static final RegistryObject<Item> ACORN_CAP = ITEMS.register("acorn_cap", () -> new AcornCapArmorItem(EquipmentSlot.HEAD, new Item.Properties().stacksTo(1).tab(Arbitrary.GROUP)));
}
