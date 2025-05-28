package com.minhcraft.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.minhcraft.ClassicReintegratedTweaks;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class ConfigLoader {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve(ClassicReintegratedTweaks.MOD_ID+".json");
    private static ModConfig config;

    public static void loadConfig() {
        try {
            // Ensure config directory exists
            Files.createDirectories(CONFIG_PATH.getParent());

            if (Files.exists(CONFIG_PATH)) {
                // Read and parse JSON
                String json = Files.readString(CONFIG_PATH);
                config = GSON.fromJson(json, ModConfig.class);
                if (config == null
                    || config.getRecipeCustomSorting() == null
                    || config.getGiantMaxHealth() <= 0
                )
                {
                    ClassicReintegratedTweaks.LOGGER.warn("Invalid config file, using default configuration");
                    config = new ModConfig();
                    saveConfig();
                }
            } else {
                // Create default config
                ClassicReintegratedTweaks.LOGGER.info("Config file not found, creating default configuration");
                config = new ModConfig();
                saveConfig();
            }
        } catch (IOException e) {
            ClassicReintegratedTweaks.LOGGER.error("Failed to load config, using default configuration", e);
            config = new ModConfig();
        }
    }

    public static void saveConfig() {
        try {
            String json = GSON.toJson(config);
            Files.writeString(CONFIG_PATH, json);
        } catch (IOException e) {
            ClassicReintegratedTweaks.LOGGER.error("Failed to save config", e);
        }
    }

    public static ModConfig getConfig() {
        if (config == null) {
            loadConfig();
        }
        return config;
    }
}
