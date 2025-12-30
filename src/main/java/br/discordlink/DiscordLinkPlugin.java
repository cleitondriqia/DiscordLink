package br.discordlink;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class DiscordLinkPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("DiscordLink ativado com sucesso!");
    }

    @Override
    public void onDisable() {
        getLogger().info("DiscordLink desativado.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem usar este comando.");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("vincular")) {
            String codigo = gerarCodigo();

            player.sendMessage("§aSeu código de vinculação:");
            player.sendMessage("§e" + codigo);
            player.sendMessage("§7Use este código no Discord.");

            return true;
        }

        return false;
    }

    private String gerarCodigo() {
        int codigo = 100000 + new Random().nextInt(900000);
        return String.valueOf(codigo);
    }
}
