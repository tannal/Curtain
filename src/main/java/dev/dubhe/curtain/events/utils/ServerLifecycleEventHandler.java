package dev.dubhe.curtain.events.utils;

import dev.dubhe.curtain.Curtain;
import dev.dubhe.curtain.api.PlanExecution;
import dev.dubhe.curtain.api.rules.RuleManager;
import dev.dubhe.curtain.commands.LogCommand;
import dev.dubhe.curtain.commands.PlayerCommand;
import dev.dubhe.curtain.commands.RuleCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.event.server.ServerStoppedEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.jetbrains.annotations.NotNull;

public class ServerLifecycleEventHandler {
    @SubscribeEvent
    public void onServerAboutToStart(@NotNull ServerAboutToStartEvent event) {
        Curtain.rules = new RuleManager(event.getServer(), Curtain.MODID);
        Curtain.minecraftServer = event.getServer();
        Curtain.planExecution = new PlanExecution();
        RuleCommand.register(event.getServer().getCommands().getDispatcher(), Curtain.rules);
        PlayerCommand.register(event.getServer().getCommands().getDispatcher());
        LogCommand.register(event.getServer().getCommands().getDispatcher());
    }

    @SubscribeEvent
    public void onServerTick(ServerTickEvent.Post event) {
        ServerLevel level = event.getServer().getLevel(Level.OVERWORLD);
        if (null != level) {
            long time = level.getGameTime();
            if (Curtain.planExecution != null) {
                Curtain.planExecution.execute(time);
            }
        }
    }

    @SubscribeEvent
    public void onServerStopped(@NotNull ServerStoppedEvent event) {
        Curtain.rules.saveToFile();
    }
}
