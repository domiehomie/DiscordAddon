package live.mufin.DiscordAddon.commands.discord;

import live.mufin.DiscordAddon.Main;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.*;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.InteractionCallbackType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.*;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.Embed;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.EmbedFooter;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.hover.content.Content;
import net.md_5.bungee.api.chat.hover.content.Text;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.text.MessageFormat;

public class MessageCommand implements InteractionListener {

  private Main plugin;

  public MessageCommand(Main plugin) {
    this.plugin = plugin;
  }

  @Override
  public void onInteraction(Interaction interaction) {
    if (interaction.getData().getName().equals("message")) {
      try {
        String message = null;
        String player = null;

        for (ApplicationCommandInteractionDataOption option : interaction.getData().getOptions()) {
          if (option.getName().equals("playername"))
            player = (String) option.getValue();
          else if (option.getName().equals("message"))
            message = (String) option.getValue();
        }

        Player p = plugin.getServer().getPlayer(player);

        String username = interaction.getMember() == null ? interaction.getUser().getUsername()
            : interaction.getMember().getUser().getUsername();
        String discriminator = interaction.getMember() == null ? interaction.getUser().getDiscriminator()
            : interaction.getMember().getUser().getDiscriminator();

        TextComponent msg = new TextComponent(TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&',
            ChatColor.translateAlternateColorCodes('&', "&7" + username + "&8#" + discriminator + " &8-> &7You&7:&f ")
                + message)));

        msg.setClickEvent(new ClickEvent(Action.SUGGEST_COMMAND, "/discorddm " + username + "#" + discriminator + " "));
        msg.setHoverEvent(new HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT,
            new Text(net.md_5.bungee.api.ChatColor.translateAlternateColorCodes('&',
                MessageFormat.format("&7Send a &9DM &7to &9{0}&8#{1}&7.", username, discriminator)))));
        p.spigot().sendMessage(msg);

        EmbedBuilder builder = new EmbedBuilder().setTitle("Message sent:")
            .setDescription(MessageFormat.format("```{0}```", message)).setFooter(new EmbedFooter("mufin.live", null))
            .setColor(0x009432);

        Embed[] embeds = { builder.build() };
        InteractionApplicationCommandCallbackData data = new InteractionApplicationCommandCallbackData(false, "hi",
            embeds, 64);

        interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE, data),
            Main.botKey);

      } catch (NullPointerException e) {
        Embed embed = new ErrorEmbedBuilder().build("Invalid player!");
        Embed[] embeds = { embed };
        InteractionApplicationCommandCallbackData data = new InteractionApplicationCommandCallbackData(false, null,
            embeds, 0);
        interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE, data),
            Main.botKey);
      }
    }
  }
}
