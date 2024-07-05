package dev.dubhe.curtain.events.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.FishingHook;
import net.neoforged.bus.api.Event;

public class FishingHookEvent extends Event {
    private final Player owner;

    public FishingHookEvent(FishingHook entity) {
        owner = entity.getPlayerOwner();
    }

    public Player getOwner() {
        return owner;
    }

    public static class Catching extends FishingHookEvent {
        private final BlockPos pos;

        public Catching(FishingHook entity, BlockPos pos) {
            super(entity);
            this.pos = pos;
        }

        public BlockPos getPos() {
            return pos;
        }
    }
}
