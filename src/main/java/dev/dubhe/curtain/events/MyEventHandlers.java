package dev.dubhe.curtain.events;

import dev.dubhe.curtain.events.rules.PlayerEventHandler;
import dev.dubhe.curtain.events.rules.fake_player_auto_fish.FishingHookEventHandler;
import dev.dubhe.curtain.events.rules.open_fake_player_inventory.EntityInteractHandler;
import dev.dubhe.curtain.events.utils.LevelEventHandler;
import dev.dubhe.curtain.events.utils.ServerEventHandler;
import dev.dubhe.curtain.events.utils.ServerLifecycleEventHandler;
import net.neoforged.neoforge.common.NeoForge;

public class MyEventHandlers {
    public static void register() {
      NeoForge.EVENT_BUS.register(new ServerLifecycleEventHandler());
      NeoForge.EVENT_BUS.register(new LevelEventHandler());
      NeoForge.EVENT_BUS.register(new ServerEventHandler());

      NeoForge.EVENT_BUS.register(new EntityInteractHandler());

      NeoForge.EVENT_BUS.register(new FishingHookEventHandler());

      NeoForge.EVENT_BUS.register(new PlayerEventHandler());
    }
}
