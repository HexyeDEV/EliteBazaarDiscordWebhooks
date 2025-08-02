package me.hexye.elitebazaardiscordwebhooks.utils;

public class Images {
    public static String getItemImage(String material) {
        return "https://minecraft-api.vercel.app/images/items/" + material.toLowerCase() + ".png?format=webp&quality=lossless";
    }
}
