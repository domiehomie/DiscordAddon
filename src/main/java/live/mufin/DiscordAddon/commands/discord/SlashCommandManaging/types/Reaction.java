package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

public class Reaction {
    int count;
    boolean me;
    Emoji emoji;

    public int getCount() {
        return count;
    }

    public boolean isMe() {
        return me;
    }

    public Emoji getEmoji() {
        return emoji;
    }

    @Override
    public String toString() {
        return "Reaction{" + "count=" + count + ", me=" + me + ", emoji=" + emoji + '}';
    }
}
