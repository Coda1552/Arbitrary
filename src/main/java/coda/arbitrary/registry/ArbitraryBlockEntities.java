package coda.arbitrary.registry;

import coda.arbitrary.Arbitrary;
import coda.arbitrary.common.blockentities.BellOfSuspensionBlockEntity;
import coda.arbitrary.common.blocks.BellOfSuspensionBlock;
import com.mojang.datafixers.types.Type;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BellBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ArbitraryBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Arbitrary.MOD_ID);

    public static final RegistryObject<BlockEntityType<BellOfSuspensionBlockEntity>> BELL_OF_SUSPENSION = BLOCK_ENTITIES.register("bell_of_suspension", () -> BlockEntityType.Builder.of(BellOfSuspensionBlockEntity::new, ArbitraryBlocks.BELL_OF_SUSPENSION.get()).build(null));
}