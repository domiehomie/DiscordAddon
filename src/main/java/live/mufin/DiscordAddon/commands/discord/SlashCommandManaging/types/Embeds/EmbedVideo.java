package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds;

public class EmbedVideo {
    String url;
    String proxy_url;
    int height;
    int width;

    public String getUrl() {
        return url;
    }

    public String getProxy_url() {
        return proxy_url;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public EmbedVideo(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EmbedVideo{" + "url='" + url + '\'' + ", proxy_url='" + proxy_url + '\'' + ", height=" + height
                + ", width=" + width + '}';
    }
}
