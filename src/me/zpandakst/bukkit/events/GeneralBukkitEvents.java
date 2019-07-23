package me.zpandakst.bukkit.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class GeneralBukkitEvents implements Listener {

    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent e) {
        //
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.chat("/tag membro");
    }
}
