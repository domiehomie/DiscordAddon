package live.mufin.DiscordAddon.commands.spigot;

import live.mufin.DiscordAddon.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordReloadCommand implements CommandExecutor {

    private Main plugin;
    public DiscordReloadCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("discordreload") || label.equalsIgnoreCase("dcrl")) {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&9DA&8] &7Reloaded &9config.yml&7."));
        }
        return true;
    }
}
