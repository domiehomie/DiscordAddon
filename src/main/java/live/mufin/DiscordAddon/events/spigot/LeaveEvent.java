package live.mufin.DiscordAddon.events.spigot;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import live.mufin.DiscordAddon.Main;
import net.dv8tion.jda.api.EmbedBuilder;

public class LeaveEvent implements Listener {

    private Main plugin;

    public LeaveEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        EmbedBuilder builder = new EmbedBuilder()
                .setAuthor(p.getName(), null, "https://crafatar.com/renders/head/" + p.getUniqueId() + ".png?overlay")
                .setColor(0xEA2027).setDescription("Just left the server.").setFooter("mufin.live", Main.mufinurl);
        if (plugin.getConfig().getBoolean("features.leave-message")) {
            Main.jda.getTextChannelById(plugin.getConfig().getString("bot.channel")).sendMessage(builder.build())
                    .complete();
        }
    }
}
