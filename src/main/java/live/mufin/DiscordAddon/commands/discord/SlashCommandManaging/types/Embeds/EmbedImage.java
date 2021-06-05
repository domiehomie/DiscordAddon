package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types.Embeds;

public class EmbedImage {
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

    public EmbedImage(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "EmbedImage{" + "url='" + url + '\'' + ", proxy_url='" + proxy_url + '\'' + ", height=" + height
                + ", width=" + width + '}';
    }
}
