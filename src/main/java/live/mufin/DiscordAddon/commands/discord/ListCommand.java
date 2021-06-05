package live.mufin.DiscordAddon.commands.discord;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import live.mufin.DiscordAddon.Main;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.InteractionListener;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.InteractionCallbackType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.*;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.*;

public class ListCommand implements InteractionListener {
    @Override
    public void onInteraction(Interaction interaction) {
        if (!interaction.getData().getName().equals("list"))
            return;

        EmbedBuilder builder = new EmbedBuilder()
                .setTitle("Online players: " + Bukkit.getServer().getOnlinePlayers().size() + "/"
                        + Bukkit.getServer().getMaxPlayers())
                .setColor(0xED4C67).setFooter(new EmbedFooter("mufin.live", null));
        List<EmbedField> fields = new ArrayList<EmbedField>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            fields.add(new EmbedField(p.getName(),
                    "`" + Math.round(p.getHealth()) + "/"
                            + Math.round(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) + "` :heart: ` "
                            + Math.round(p.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS).getValue()) + "` :shield: ` "
                            + p.getLevel() + "` <:orb:847431948791316520> ",
                    false));
        }
        EmbedField[] fieldsarr = fields.stream().toArray(EmbedField[]::new);
        builder.setFields(fieldsarr);
        interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
                new InteractionApplicationCommandCallbackData(false, null, new Embed[] { builder.build() }, 64)),
                Main.botKey);
    }
}
