package dev.dubhe.curtain.mixins.rule.cactus;

import dev.dubhe.curtain.utils.BlockRotator;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DispenserBlock.class)
public class DispenserBlockMixin {
    @Inject(method = "getDispenseMethod", at = @At("HEAD"), cancellable = true)
    private void registerCurtainBehaviors(ItemStack stack, CallbackInfoReturnable<DispenseItemBehavior> cir) {
        Item item = stack.getItem();
        if (item == Items.CACTUS) {
            cir.setReturnValue(new BlockRotator.CactusDispenserBehaviour());
        }
    }
}