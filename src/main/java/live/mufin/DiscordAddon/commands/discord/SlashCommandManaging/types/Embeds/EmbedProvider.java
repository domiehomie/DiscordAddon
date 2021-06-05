package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds;

public class EmbedProvider {
    String name;
    String url;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public EmbedProvider(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "EmbedProvider{" + "name='" + name + '\'' + ", url='" + url + '\'' + '}';
    }
}
