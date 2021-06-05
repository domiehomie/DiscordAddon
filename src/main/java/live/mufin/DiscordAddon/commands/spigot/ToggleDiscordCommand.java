package live.mufin.DiscordAddon.commands.spigot;

import live.mufin.DiscordAddon.Main;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class ToggleDiscordCommand implements CommandExecutor {

    private Main plugin;
    public ToggleDiscordCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!label.equalsIgnoreCase("togglediscord") && !label.equalsIgnoreCase("tdc")) return true;
        if(!(sender instanceof Player)) return true;
        Player p = (Player) sender;
        NamespacedKey key = new NamespacedKey(plugin, "discordchat");
        int currentValue = p.getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
        String onoff = currentValue == 1 ? "&coff" : "&aon";
        p.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, currentValue == 1 ? 0 : 1);
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&9DA&8] &7Toggled Discord chat " +
        onoff + "&7."));
        return true;
    }
}
