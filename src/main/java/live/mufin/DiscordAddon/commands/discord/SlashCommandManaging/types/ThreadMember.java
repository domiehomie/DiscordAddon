package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

public class ThreadMember {
    String id;
    String user_id;

    public String getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getJoin_timestamp() {
        return join_timestamp;
    }

    public int getFlags() {
        return flags;
    }

    String join_timestamp;
    int flags;

    @Override
    public String toString() {
        return "ThreadMember{" + "id='" + id + '\'' + ", user_id='" + user_id + '\'' + ", join_timestamp='"
                + join_timestamp + '\'' + ", flags=" + flags + '}';
    }
}
