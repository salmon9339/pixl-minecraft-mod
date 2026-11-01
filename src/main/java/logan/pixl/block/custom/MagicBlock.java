package logan.pixl.block.custom;

import logan.pixl.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        level.addParticle(ParticleTypes.HAPPY_VILLAGER, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 0, 1, 0);

        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS, 2f, 1f);
        return InteractionResult.SUCCESS;
    }



    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {
        // buddie season 10 :pray:
        BlockPos posBelow = pos.below();
        BlockState blockStateBelow = level.getBlockState(posBelow);
        FluidState fluidStateBelow = blockStateBelow.getFluidState();

        if(entity instanceof Player player) {
            if (fluidStateBelow.is(Fluids.WATER)) {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 1));
            }
            if (fluidStateBelow.is(Fluids.LAVA)) {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 3));
            }
            if (blockStateBelow.is(Blocks.OBSIDIAN)) {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 5));
            }
            if(blockStateBelow.is(Blocks.CRYING_OBSIDIAN)) {
                player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 40, 7));
            }
        }

        if(entity instanceof ItemEntity itemEntity) {

            ItemStack transItem = itemEntity.getItem();

            if(blockStateBelow.is(Blocks.DIAMOND_BLOCK)) {
                if(transItem.is(ModItems.FLUORITE)) {
                    itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
                }
            }
            if(blockStateBelow.is(Blocks.REDSTONE_BLOCK)) {
                if(itemEntity.getItem().is(ModItems.FLUORITE)) {
                    itemEntity.setItem(new ItemStack(Items.REDSTONE, itemEntity.getItem().getCount() * 2));
                }
            }
            if(blockStateBelow.is(Blocks.IRON_BLOCK)) {
                if(transItem.is(ModItems.FLUORITE)) {
                    itemEntity.setItem(new ItemStack(Items.IRON_INGOT, transItem.getCount() * 2));
                }
            }
            if(blockStateBelow.is(Blocks.GOLD_BLOCK)) {
                if(transItem.is(ModItems.FLUORITE)) {
                    itemEntity.setItem(new ItemStack(Items.GOLD_INGOT, transItem.getCount() * 2));
                }
            }
            if(blockStateBelow.is(Blocks.NETHERITE_BLOCK)) {
                if(transItem.is(ModItems.FLUORITE)) {
                    itemEntity.setItem(new ItemStack(Items.NETHERITE_SCRAP, transItem.getCount()));
                }
            }

        }
    }
}
