package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds;

public class EmbedFooter {
    String text;
    String icon_url;
    String proxy_icon_url;

    public String getText() {
        return text;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public String getProxy_icon_url() {
        return proxy_icon_url;
    }

    public EmbedFooter(String text, String icon_url) {
        this.text = text;
        this.icon_url = icon_url;
    }

    @Override
    public String toString() {
        return "EmbedFooter{" + "text='" + text + '\'' + ", icon_url='" + icon_url + '\'' + ", proxy_icon_url='"
                + proxy_icon_url + '\'' + '}';
    }
}
