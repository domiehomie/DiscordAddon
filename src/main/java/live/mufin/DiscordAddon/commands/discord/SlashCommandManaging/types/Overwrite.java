package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.OverwriteType;

public class Overwrite {
    String id;
    OverwriteType type;
    String allow;
    String deny;

    public String getId() {
        return id;
    }

    public OverwriteType getType() {
        return type;
    }

    public String getAllow() {
        return allow;
    }

    public String getDeny() {
        return deny;
    }

    @Override
    public String toString() {
        return "Overwrite{" + "id='" + id + '\'' + ", type=" + type + ", allow='" + allow + '\'' + ", deny='" + deny
                + '\'' + '}';
    }
}
