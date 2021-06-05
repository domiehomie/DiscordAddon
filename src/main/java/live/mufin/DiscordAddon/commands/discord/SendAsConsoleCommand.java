package live.mufin.DiscordAddon.commands.discord;

import java.text.MessageFormat;

import com.google.gson.Gson;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import live.mufin.DiscordAddon.Main;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.ErrorEmbedBuilder;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.InteractionListener;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.InteractionCallbackType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.*;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.Embed;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.EmbedFooter;

public class SendAsConsoleCommand implements InteractionListener {

    private Main plugin;

    public SendAsConsoleCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onInteraction(Interaction interaction) {
        if (!interaction.getData().getName().equals("sendasconsole"))
            return;
        String cmd = (String) interaction.getData().getOptions()[0].getValue();
        if (cmd.isEmpty())
            interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
                    new InteractionApplicationCommandCallbackData(false, null,
                            new Embed[] { new ErrorEmbedBuilder().build("You cannot dispatch an empty command.") },
                            64)),
                    Main.botKey);

        if (Permission.getPermissions(Long.valueOf(interaction.getMember().getPermissions()))
                .contains(Permission.ADMINISTRATOR)) {
            new BukkitRunnable() {
                public void run() {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                    EmbedBuilder builder = new EmbedBuilder().setColor(0x009432).setTitle("Command sent successfully!")
                            .setDescription(MessageFormat.format("```{0}```", cmd))
                            .setFooter(new EmbedFooter("mufin.live", null));
                    interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
                            new InteractionApplicationCommandCallbackData(false, null, new Embed[] { builder.build() },
                                    64)),
                            Main.botKey);
                }
            }.runTask(plugin);
        } else {
            interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
                    new InteractionApplicationCommandCallbackData(false, null, new Embed[] { new ErrorEmbedBuilder()
                            .build("You do not have the `ADMINISTATOR` permission. You need this to dispatch console commands.") },
                            64)),
                    Main.botKey);
        }

    }

}
