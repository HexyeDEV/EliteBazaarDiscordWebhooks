package me.hexye.elitebazaardiscordwebhooks;

import me.hexye.elitebazaardiscordwebhooks.events.Listener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class EliteBazaarDiscordWebhooks extends JavaPlugin {
    FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        if (!Bukkit.getPluginManager().isPluginEnabled("EliteBazaar")) {
            getLogger().severe("EliteBazaar plugin is not enabled! Disabling EliteBazaarDiscordWebhooks...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        config = getConfig();
        String webhookUrl = config.getString("webhook-url", null);
        if (webhookUrl == null || webhookUrl.isEmpty()) {
            getLogger().severe("Webhook URL is not set in the config! Disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        new Listener();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public String getConfigString(String path) {
        return config.getString(path, "");
    }

    public int getConfigInt(String path) {
        return config.getInt(path, 0);
    }

    public boolean getConfigBoolean(String path) {
        return config.getBoolean(path, false);
    }

    public static EliteBazaarDiscordWebhooks getInstance() {
        return JavaPlugin.getPlugin(EliteBazaarDiscordWebhooks.class);
    }
}
