package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds;

public class EmbedAuthor {
    String name;
    String url;
    String icon_url;
    String proxy_icon_url;

    public EmbedAuthor(String name, String url, String icon_url) {
        this.name = name;
        this.url = url;
        this.icon_url = icon_url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getProxy_icon_url() {
        return proxy_icon_url;
    }

    @Override
    public String toString() {
        return "EmbedAuthor{" + "name='" + name + '\'' + ", url='" + url + '\'' + ", icon_url='" + icon_url + '\''
                + ", proxy_icon_url='" + proxy_icon_url + '\'' + '}';
    }
}
