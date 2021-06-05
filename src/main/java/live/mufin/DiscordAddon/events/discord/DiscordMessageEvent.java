package live.mufin.DiscordAddon.events.discord;

import live.mufin.DiscordAddon.Main;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;

public class DiscordMessageEvent implements EventListener {

    private Main plugin;
    public DiscordMessageEvent(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEvent(GenericEvent ge) {
        if (!(ge instanceof MessageReceivedEvent)) return;
        MessageReceivedEvent e = (MessageReceivedEvent) ge;
        if (!e.getChannel().getId().equals(plugin.getConfig().getString("bot.channel"))) return;
        User user = e.getAuthor();
        if(user == e.getJDA().getSelfUser()) return;
        if(user.getAsTag().endsWith("#0000")) return;
        if(e.getMessage().getContentRaw().startsWith(Main.prefix)) return;
        NamespacedKey key = new NamespacedKey(plugin, "discordchat");
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getPersistentDataContainer().get(key, PersistentDataType.INTEGER) == 1) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&9DC&8] &7") + user.getName() + ChatColor.translateAlternateColorCodes('&', "&7: &f") + e.getMessage().getContentDisplay());
            }
        }
    }
}
