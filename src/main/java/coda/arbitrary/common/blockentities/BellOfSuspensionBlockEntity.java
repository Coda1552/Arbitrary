package coda.arbitrary.common.blockentities;

import coda.arbitrary.registry.ArbitraryBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BellOfSuspensionBlockEntity extends BlockEntity {
    public int time;

    public BellOfSuspensionBlockEntity(BlockPos p_155173_, BlockState p_155174_) {
        super(ArbitraryBlockEntities.BELL_OF_SUSPENSION.get(), p_155173_, p_155174_);
    }

    public static void tick(Level p_155176_, BlockPos p_155177_, BlockState p_155178_, BellOfSuspensionBlockEntity p_155179_) {
        ++p_155179_.time;
    }
}
