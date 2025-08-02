package me.hexye.elitebazaardiscordwebhooks.events;

import com.google.common.eventbus.Subscribe;
import me.hexye.elitebazaarapi.EBAPI;
import me.hexye.elitebazaarapi.events.BuyOrderFilled;
import me.hexye.elitebazaarapi.events.BuyOrderPlaced;
import me.hexye.elitebazaardiscordwebhooks.EliteBazaarDiscordWebhooks;
import me.hexye.elitebazaardiscordwebhooks.utils.Images;
import me.hexye.elitebazaardiscordwebhooks.utils.Webhook;
import org.bukkit.Material;

public class Listener {
    public Listener() {
        EBAPI.getEventBus().register(this);
    }

    public String replaceOrderPlaceholders(String string, String itemName, String playerName, double price, int amount) {
        return string
                .replace("{player}", playerName)
                .replace("{itemName}", itemName)
                .replace("{price}", String.valueOf(price))
                .replace("{amount}", String.valueOf(amount));
    }

    public String replaceSellOrderFilledPlaceholders(String string, String itemName, String playerName, double price, int amount, double total) {
        return string
                .replace("{player}", playerName)
                .replace("{itemName}", itemName)
                .replace("{price}", String.valueOf(price))
                .replace("{amount}", String.valueOf(amount))
                .replace("{total}", String.valueOf(total));
    }

    @Subscribe
    public void onBuyOrderPlaced(BuyOrderPlaced event) {
        if (!EliteBazaarDiscordWebhooks.getInstance().getConfigBoolean("buy-order-placed.enabled")) {
            return;
        }

        String webhookUrl = EliteBazaarDiscordWebhooks.getInstance().getConfigString("webhook-url");
        String itemName = event.getItemName();
        itemName = itemName.replaceAll("&[0-9a-fk-or]", "");
        String playerName = event.getPlayer().getName();
        double price = event.getPrice();
        int amount = event.getAmount();

        String title = EliteBazaarDiscordWebhooks.getInstance().getConfigString("buy-order-placed.title");
        String description = EliteBazaarDiscordWebhooks.getInstance().getConfigString("buy-order-placed.description");
        String footer = EliteBazaarDiscordWebhooks.getInstance().getConfigString("buy-order-placed.footer");
        String color = EliteBazaarDiscordWebhooks.getInstance().getConfigString("buy-order-placed.color");

        title = replaceOrderPlaceholders(title, itemName, playerName, price, amount);
        description = replaceOrderPlaceholders(description, itemName, playerName, price, amount);
        footer = replaceOrderPlaceholders(footer, itemName, playerName, price, amount);

        Material material = event.getItem().getType();
        String materialName = material.name().toLowerCase();
        if (materialName.contains("log")) {
            materialName = "oak_log";
        }
        String thumbnailURL = Images.getItemImage(materialName);
        Webhook.sendWebhook(webhookUrl, title, description, thumbnailURL, color, footer);
    }

    @Subscribe
    public void onBuyOrderFilled(BuyOrderFilled event) {
        if (!EliteBazaarDiscordWebhooks.getInstance().getConfigBoolean("buy-order-filled.enabled")) {
            return;
        }

        String webhookUrl = EliteBazaarDiscordWebhooks.getInstance().getConfigString("webhook-url");
        String itemName = event.getItemName();
        itemName = itemName.replaceAll("&[0-9a-fk-or]", "");
        String playerName = event.getPlayer().getName();
        double price = event.getPrice();
        int amount = event.getAmount();

        String title = EliteBazaarDiscordWebhooks.getInstance().getConfigString("buy-order-filled.title");
        String description = EliteBazaarDiscordWebhooks.getInstance().getConfigString("buy-order-filled.description");
        String footer = EliteBazaarDiscordWebhooks.getInstance().getConfigString("buy-order-filled.footer");
        String color = EliteBazaarDiscordWebhooks.getInstance().getConfigString("buy-order-filled.color");

        title = replaceOrderPlaceholders(title, itemName, playerName, price, amount);
        description = replaceOrderPlaceholders(description, itemName, playerName, price, amount);
        footer = replaceOrderPlaceholders(footer, itemName, playerName, price, amount);

        Material material = event.getItem().getType();
        String materialName = material.name().toLowerCase();
        if (materialName.contains("log")) {
            materialName = "oak_log";
        }
        String thumbnailURL = Images.getItemImage(materialName);

        Webhook.sendWebhook(webhookUrl, title, description, thumbnailURL, color, footer);
    }

    @Subscribe
    public void onSellOrderPlaced(me.hexye.elitebazaarapi.events.SellOrderPlaced event) {
        if (!EliteBazaarDiscordWebhooks.getInstance().getConfigBoolean("sell-order-placed.enabled")) {
            return;
        }

        String webhookUrl = EliteBazaarDiscordWebhooks.getInstance().getConfigString("webhook-url");
        String itemName = event.getItemName();
        itemName = itemName.replaceAll("&[0-9a-fk-or]", "");
        String playerName = event.getPlayer().getName();
        double price = event.getPrice();
        int amount = event.getAmount();

        String title = EliteBazaarDiscordWebhooks.getInstance().getConfigString("sell-order-placed.title");
        String description = EliteBazaarDiscordWebhooks.getInstance().getConfigString("sell-order-placed.description");
        String footer = EliteBazaarDiscordWebhooks.getInstance().getConfigString("sell-order-placed.footer");
        String color = EliteBazaarDiscordWebhooks.getInstance().getConfigString("sell-order-placed.color");

        title = replaceOrderPlaceholders(title, itemName, playerName, price, amount);
        description = replaceOrderPlaceholders(description, itemName, playerName, price, amount);
        footer = replaceOrderPlaceholders(footer, itemName, playerName, price, amount);

        Material material = event.getItem().getType();
        String materialName = material.name().toLowerCase();
        if (materialName.contains("log")) {
            materialName = "oak_log";
        }
        String thumbnailURL = Images.getItemImage(materialName);

        Webhook.sendWebhook(webhookUrl, title, description, thumbnailURL, color, footer);
    }

    @Subscribe
    public void onSellOrderFilled(me.hexye.elitebazaarapi.events.SellOrderFilled event) {
        if (!EliteBazaarDiscordWebhooks.getInstance().getConfigBoolean("sell-order-filled.enabled")) {
            return;
        }

        String webhookUrl = EliteBazaarDiscordWebhooks.getInstance().getConfigString("webhook-url");
        String itemName = event.getItemName();
        itemName = itemName.replaceAll("&[0-9a-fk-or]", "");
        String playerName = event.getPlayer().getName();
        double price = event.getPrice();
        int amount = event.getAmount();
        double total = event.getTotal();

        String title = EliteBazaarDiscordWebhooks.getInstance().getConfigString("sell-order-filled.title");
        String description = EliteBazaarDiscordWebhooks.getInstance().getConfigString("sell-order-filled.description");
        String footer = EliteBazaarDiscordWebhooks.getInstance().getConfigString("sell-order-filled.footer");
        String color = EliteBazaarDiscordWebhooks.getInstance().getConfigString("sell-order-filled.color");

        title = replaceSellOrderFilledPlaceholders(title, itemName, playerName, price, amount, total);
        description = replaceSellOrderFilledPlaceholders(description, itemName, playerName, price, amount, total);
        footer = replaceSellOrderFilledPlaceholders(footer, itemName, playerName, price, amount, total);

        Material material = event.getItem().getType();
        String materialName = material.name().toLowerCase();
        if (materialName.contains("log")) {
            materialName = "oak_log";
        }
        String thumbnailURL = Images.getItemImage(materialName);

        Webhook.sendWebhook(webhookUrl, title, description, thumbnailURL, color, footer);
    }
}
