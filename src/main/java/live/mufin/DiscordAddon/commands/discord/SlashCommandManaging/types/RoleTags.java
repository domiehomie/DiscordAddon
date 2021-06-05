package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

public class RoleTags {
    String bot_id;
    String integration_id;

    public String getBot_id() {
        return bot_id;
    }

    public String getIntegration_id() {
        return integration_id;
    }

    @Override
    public String toString() {
        return "RoleTags{" + "bot_id='" + bot_id + '\'' + ", integration_id='" + integration_id + '\'' + '}';
    }
}
