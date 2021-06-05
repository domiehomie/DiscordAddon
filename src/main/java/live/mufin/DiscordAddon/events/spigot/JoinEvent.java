package live.mufin.DiscordAddon.events.spigot;

import live.mufin.DiscordAddon.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class JoinEvent implements Listener {

    private Main plugin;

    public JoinEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        PersistentDataContainer container = p.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, "discordchat");
        if (!container.has(key, PersistentDataType.INTEGER))
            container.set(key, PersistentDataType.INTEGER, 1);

        if (!p.hasPlayedBefore()) {
            EmbedBuilder builder = new EmbedBuilder()
                    .setAuthor(p.getName(), null,
                            "https://crafatar.com/renders/head/" + p.getUniqueId() + ".png?overlay")
                    .setColor(0xFFC312).setDescription("Just joined the server for the first time!")
                    .setFooter("mufin.live", Main.mufinurl);
            if (plugin.getConfig().getBoolean("features.first-join-message"))
                Main.jda.getTextChannelById(plugin.getConfig().getString("bot.channel")).sendMessage(builder.build())
                        .complete();
            return;
        }

        EmbedBuilder builder = new EmbedBuilder()
                .setAuthor(p.getName(), null, "https://crafatar.com/renders/head/" + p.getUniqueId() + ".png?overlay")
                .setColor(0x009432).setDescription("Just joined the server.").setFooter("mufin.live", Main.mufinurl);
        if (plugin.getConfig().getBoolean("features.join-message")) {
            Main.jda.getTextChannelById(plugin.getConfig().getString("bot.channel")).sendMessage(builder.build())
                    .complete();
        }
    }
}
