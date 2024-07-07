package dev.dubhe.curtain.events.utils;

import dev.dubhe.curtain.CurtainRules;
import dev.dubhe.curtain.features.logging.LoggerManager;
import dev.dubhe.curtain.features.player.helpers.FakePlayerResident;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.server.ServerStartedEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

public class ServerEventHandler {
    private int timer = 0;

    @SubscribeEvent
    public void onServerStart(ServerStartedEvent event) {
        if (!event.getServer().isSingleplayer()) FakePlayerResident.onServerStart(event.getServer());
    }

    @SubscribeEvent
    public void onServerStop(ServerStoppingEvent event) {
        FakePlayerResident.onServerStop(event.getServer());
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {
        if (timer <= 0) {
            timer = CurtainRules.HUDLoggerUpdateInterval;
            LoggerManager.updateHUD();
        }
        timer -= 1;
    }

    @SubscribeEvent
    public void onPlayLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            if (player.getServer() != null && player.getServer().isSingleplayer() && player.getServer().isSingleplayerOwner(player.getGameProfile()))
                FakePlayerResident.onServerStart(event.getEntity().getServer());
            String playerName = player.getName().getString();
            if (CurtainRules.defaultLoggers.contentEquals("none")) {
                return;
            }
            if (!LoggerManager.hasSubscribedLogger(playerName)) {
                String[] logs = CurtainRules.defaultLoggers.replace(" ", "").split(",");
                LoggerManager.subscribeLogger(playerName, logs);
            }
        }
    }

    @SubscribeEvent
    public void onPlayLoggedOut(PlayerEvent.PlayerLoggedOutEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            String playerName = player.getName().getString();
            LoggerManager.unsubscribeAllLogger(playerName);
        }
    }
}
