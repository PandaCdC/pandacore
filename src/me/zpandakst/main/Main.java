package me.zpandakst.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§aPLUGIN §fInstanciando plugin!");
        Bukkit.getConsoleSender().sendMessage("§ePLUGIN §fCarregando comandos!");
        Bukkit.getConsoleSender().sendMessage("§ePLUGIN §fCarregando eventos!");
        Bukkit.getConsoleSender().sendMessage("§");
        Bukkit.getConsoleSender().sendMessage("§a==========================");
    }

    public void onDisable() {

    }
}
