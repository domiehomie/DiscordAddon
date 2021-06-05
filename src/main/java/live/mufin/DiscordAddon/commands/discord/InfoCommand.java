package live.mufin.DiscordAddon.commands.discord;

import java.text.MessageFormat;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import live.mufin.DiscordAddon.Main;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.ErrorEmbedBuilder;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.InteractionListener;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.InteractionCallbackType;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.*;
import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds.*;
import net.dv8tion.jda.api.JDA.Status;
import net.dv8tion.jda.api.entities.Guild;

public class InfoCommand implements InteractionListener {

  @Override
  public void onInteraction(Interaction interaction) {
    if (interaction.getData().getName().equals("info")) {
      for (ApplicationCommandInteractionDataOption option : interaction.getData().getOptions()) {
        if (option.getName().equals("plugin")) {
          EmbedBuilder builder = new EmbedBuilder().setColor(0xD980FA).setFooter(new EmbedFooter("mufinlive", null))
              .setTitle("Plugin info:").setDescription("DiscordAddon v1.0")
              .setFields(
                  new EmbedField[] { new EmbedField("Repository:", "https://github.com/mufinlive/DiscordAddons/", true),
                      new EmbedField("License:", "`GNU v3.0`", true),
                      new EmbedField("Discord:", "https://discord.gg/Dm8QvQDhzx/", false) })
              .setAuthor(new EmbedAuthor("mufinlive", "https://mufin.live/",
                  "https://cdn.discordapp.com/avatars/145813501930110976/238a88077a32961b0b4ab8974a9affc0.png"));
          InteractionResponse response = new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
              new InteractionApplicationCommandCallbackData(false, null, new Embed[] { builder.build() }, 64));
          interaction.send(response, Main.botKey);
        }
        if (option.getName().equals("bot")) {
          long restPing = Main.jda.getRestPing().complete();
          long gatewayPing = Main.jda.getGatewayPing();
          List<Guild> guilds = Main.jda.getGuilds();
          String username = Main.jda.getSelfUser().getAsTag();
          Status status = Main.jda.getStatus();
          EmbedBuilder builder = new EmbedBuilder().setColor(0x006266).setFooter(new EmbedFooter("mufinlive", null))
              .setTitle("Bot data:")
              .setFields(new EmbedField[] {
                  new EmbedField("<:ping:847550348469993553> Rest Ping: ", "`" + restPing + "`", true),
                  new EmbedField("<:ping:847550348469993553> Gateway Ping: ", "`" + gatewayPing + "`", true),
                  new EmbedField("Guilds: ", "`" + guilds.size() + "`", true),
                  new EmbedField("Username: ", "`" + username + "`", true),
                  new EmbedField("Status: ", "`" + status.toString() + "`", true) });
          InteractionResponse response = new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
              new InteractionApplicationCommandCallbackData(false, null, new Embed[] { builder.build() }, 64));
          interaction.send(response, Main.botKey);
        }
        if (option.getName().equals("player")) {
          try {
            Player p = Bukkit.getPlayer((String) option.getOptions()[0].getValue());
            String name = p.getName();
            String health = Math.round(p.getHealth()) + "/"
                + Math.round(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            String armor = String.valueOf(Math.round(p.getAttribute(Attribute.GENERIC_ARMOR).getValue()));
            String hunger = p.getFoodLevel() + "/20";
            String ping = String.valueOf(p.getPing());
            String exp = String.valueOf(Math.round(p.getExp()));

            EmbedBuilder builder = new EmbedBuilder().setTitle(p.getName())
                .setFields(
                    new EmbedField[] { new EmbedField("❤ Health:", MessageFormat.format("`{0}`", health), true),
                        new EmbedField("<:hunger:847549177738166313> Hunger:", MessageFormat.format("`{0}`", hunger),
                            true),
                        new EmbedField("🛡 Armor", MessageFormat.format("`{0}`", armor), true),
                        new EmbedField("<:ping:847550348469993553> Ping:", MessageFormat.format("`{0}`", ping), true),
                        new EmbedField("<:orb:847431948791316520> Exp:", MessageFormat.format("`{0}`", exp), true) })
                .setThumbnail(new EmbedThumbnail(
                    MessageFormat.format("https://crafatar.com/renders/body/{0}.png?overlay", p.getUniqueId())))
                .setAuthor(new EmbedAuthor(name, null,
                    "https://crafatar.com/avatars/9c3918a408f440b490e988e347ef4566.png?overlay"))
                .setColor(0xF79F1F).setFooter(new EmbedFooter("mufin.live", null));
            interaction.send(
                new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
                    new InteractionApplicationCommandCallbackData(false, null, new Embed[] { builder.build() }, 64)),
                Main.botKey);
          } catch (NullPointerException e) {
            interaction.send(new InteractionResponse(InteractionCallbackType.CHANNEL_MESSAGE_WITH_SOURCE,
                new InteractionApplicationCommandCallbackData(false, null,
                    new Embed[] { new ErrorEmbedBuilder().build("Invalid player!") }, 64)),
                Main.botKey);
          }
        }
      }
    }
  }
}
