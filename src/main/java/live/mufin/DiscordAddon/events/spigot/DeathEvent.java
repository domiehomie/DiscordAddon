package live.mufin.DiscordAddon.events.spigot;

import live.mufin.DiscordAddon.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

    private Main plugin;

    public DeathEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player p = event.getEntity();
        EmbedBuilder builder = new EmbedBuilder().setColor(0x00000)
                .setDescription(event.getDeathMessage().replace(p.getName(), ""))
                .setAuthor(p.getName(), null, "https://crafatar.com/renders/head/" + p.getUniqueId() + ".png?overlay")
                .setFooter("mufin.live", Main.mufinurl);
        TextChannel channel = Main.jda.getTextChannelById(plugin.getConfig().getString("bot.channel"));
        channel.sendMessage(builder.build()).complete();
    }
}
