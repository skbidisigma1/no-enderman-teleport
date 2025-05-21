package org.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class NoEndermenTeleportMod implements ModInitializer {
    // Logger for mod
    private static final Logger LOGGER = LogManager.getLogger("NoEndermenTeleport");

    @Override
    public void onInitialize() {
        LOGGER.info("No Endermen Teleport mod initialized");

        // Register server tick event
        ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);
    }

    private void onServerTick(MinecraftServer server) {
        for (ServerWorld world : server.getWorlds()) {
            // Get all entities in the world and filter for endermen
            List<Entity> entities = world.getEntities(null, entity -> entity instanceof EndermanEntity);

            // Disable teleporting for all endermen
            for (Entity entity : entities) {
                if (entity instanceof EndermanEntity) {
                    // Access teleporting field and set it to false
                    EndermanEntity enderman = (EndermanEntity) entity;
                    enderman.teleporting = false;
                }
            }
        }
    }
}
