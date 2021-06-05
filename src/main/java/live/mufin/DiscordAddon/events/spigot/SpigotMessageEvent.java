package live.mufin.DiscordAddon.events.spigot;

import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import live.mufin.DiscordAddon.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SpigotMessageEvent implements Listener {

    private Main plugin;

    public SpigotMessageEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMessage(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        WebhookMessageBuilder builder = new WebhookMessageBuilder().setUsername(p.getName())
                .setAvatarUrl("https://crafatar.com/renders/head/" + p.getUniqueId() + ".png?overlay")
                .setContent(event.getMessage());
        Main.client.send(builder.build());
    }
}
