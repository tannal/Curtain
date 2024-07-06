package dev.dubhe.curtain.mixins.events.item_stack;

import dev.dubhe.curtain.CurtainRules;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PickaxeItem.class)
public abstract class PickaxeItemMixin extends DiggerItem {
  public PickaxeItemMixin(Tier pTier, TagKey<Block> pBlocks, Properties pProperties) {
    super(pTier, pBlocks, pProperties);
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack stack, @NotNull BlockState state) {
      if (CurtainRules.missingTools && state.getSoundType() == SoundType.GLASS) {
        final Tool tool = stack.get(DataComponents.TOOL);
        return tool != null ? tool.getMiningSpeed(Blocks.STONE.defaultBlockState()) : super.getDestroySpeed(stack, state);
      }
      return super.getDestroySpeed(stack, state);
    }
}
