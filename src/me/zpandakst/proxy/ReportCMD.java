package me.zpandakst.proxy;

import net.md_5.bungee.api.plugin.*;
import me.zpandakst.main.Main;
import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.*;
import net.md_5.bungee.api.*;
import java.util.*;

public class ReportCMD extends Command implements TabExecutor {
    public static Main plugin;

    @SuppressWarnings("deprecation")
    public static void yourself(final ProxiedPlayer P) {
        P.sendMessage("§3§lPandaCore §7» §cVocê não pode se reportar.");
    }

    @SuppressWarnings("deprecation")
    public static void offline(final ProxiedPlayer P, final String targetname) {
        P.sendMessage("§3§lPandaCore §7» §cO jogador(a): §e" + targetname + " §cnão está offline ou não existe.");
    }

    public ReportCMD(final Main pl) {
        super("report");
        ReportCMD.plugin = pl;
    }

    @SuppressWarnings("deprecation")
    public void execute(final CommandSender cs, final String[] args) {
        if (cs instanceof ProxiedPlayer) {
            final ProxiedPlayer player = (ProxiedPlayer)cs;
            if (args.length < 2) {
                player.sendMessage("§3§lPandaCore §7» §cErrado, utilize a sintaxe correta: /report [Jogador(a)] [Motivo]");
                return;
            }
            final String Targetname = args[0];
            final ProxiedPlayer pls = BungeeCord.getInstance().getPlayer(Targetname);
            if (pls == null) {
                offline(player, Targetname);
                return;
            }
            if (pls == player) {
                yourself(player);
                return;
            }
            final StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.length; ++i) {
                sb.append(args[i]).append(" ");
            }
            final String allArgs = sb.toString().trim();
            for (final ProxiedPlayer pls2 : BungeeCord.getInstance().getPlayers()) {
                if (pls2.hasPermission("panda.core.client.notify.view")) {
                    pls2.sendMessage("");
                    pls2.sendMessage("§3§lPandaCore §7» §6O jogador: §2" + player.getName() + " §6pelo jogador: §2" + args[0] + " §6pelo motivo: §2" + allArgs + " §6no servidor: §2" + player.getServer().getInfo().getName());
                    pls2.sendMessage("");
                }
            }
            player.sendMessage("§3§lPandaCore §7» §aSeu report foi enviado com sucesso.");
        }
    }

    public Iterable<String> onTabComplete(final CommandSender cs, final String[] args) {
        if (args.length <= 2) {
        }
        final Set<String> match = new HashSet<String>();
        if (args.length == 1) {
            final String search = args[0].toLowerCase();
            for (final ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                if (player.getName().toLowerCase().startsWith(search)) {
                    match.add(player.getName());
                }
            }
        }
        return match;
    }
}
