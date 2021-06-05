package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

public class Attachment {
    String id;
    String filename;
    String content_type;
    int size;
    String url;
    String proxy_url;
    int height;
    int width;

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getContent_type() {
        return content_type;
    }

    public int getSize() {
        return size;
    }

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

    @Override
    public String toString() {
        return "Attachment{" + "id='" + id + '\'' + ", filename='" + filename + '\'' + ", content_type='" + content_type
                + '\'' + ", size=" + size + ", url='" + url + '\'' + ", proxy_url='" + proxy_url + '\'' + ", height="
                + height + ", width=" + width + '}';
    }
}
