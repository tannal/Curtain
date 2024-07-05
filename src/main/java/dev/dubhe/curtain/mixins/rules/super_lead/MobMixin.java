package dev.dubhe.curtain.mixins.rules.super_lead;

import dev.dubhe.curtain.CurtainRules;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Mob.class)
public abstract class MobMixin {
    @Unique
    public abstract boolean isLeashed();

    @Inject(method = "canBeLeashed", at = @At("RETURN"), cancellable = true)
    private void canBeLeashed(CallbackInfoReturnable<Boolean> cir) {
        if (CurtainRules.superLead) {
            cir.setReturnValue(!this.isLeashed());
        }
    }
}
