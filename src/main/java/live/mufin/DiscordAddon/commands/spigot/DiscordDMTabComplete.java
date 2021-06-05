package live.mufin.DiscordAddon.commands.spigot;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.*;

import live.mufin.DiscordAddon.Main;
import net.dv8tion.jda.api.entities.*;

public class DiscordDMTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> users = new ArrayList<String>();
        for (User user : Main.jda.getUsers()) {
            String username = user.getName() + "#" + user.getDiscriminator();
            users.add(username);
        }

        // Sorts through list depending on characters that have been put in.
        List<String> results = new ArrayList<String>();
        if (args.length == 1) {
            for (String result : users) {
                if (result.toLowerCase().startsWith(args[0].toLowerCase()))
                    results.add(result);
            }
            return results;
        }
        return null;
    }

}
