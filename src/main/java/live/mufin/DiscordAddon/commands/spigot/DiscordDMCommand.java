package live.mufin.DiscordAddon.commands.spigot;

import live.mufin.DiscordAddon.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.User;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Clock;
import java.time.OffsetTime;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiscordDMCommand implements CommandExecutor {

    private Main plugin;

    public DiscordDMCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (label.equalsIgnoreCase("discorddm")) {
            if (!(sender instanceof Player))
                return true;
            Player p = (Player) sender;
            if (args.length < 2)
                return true;
            List<User> users = Main.jda.getUsers();
            for (User user : users) {
                if (user.getAsTag().equals(args[0])) {
                    if (user == Main.jda.getSelfUser())
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                "&8[&9DA&8] &cYou cannot message that user."));
                    PrivateChannel channel = Main.jda.getPrivateChannelById(user.getId());
                    String text = "";
                    List<String> argslist = new LinkedList<String>(Arrays.asList(args));
                    argslist.remove(0);
                    for (String key : argslist) {
                        text = text + key + " ";
                    }
                    EmbedBuilder builder = new EmbedBuilder().setFooter("mufin.live", Main.mufinurl).setColor(0x12CBC4)
                            .setAuthor(sender.getName(), null, "https://www.mc-heads.net/avatar/" + p.getUniqueId())
                            .setDescription(text);
                    user.openPrivateChannel().queue(privateChannel -> {
                        privateChannel.sendMessage(builder.build()).queue();
                    });

                }
            }
        }

        return true;
    }
}
