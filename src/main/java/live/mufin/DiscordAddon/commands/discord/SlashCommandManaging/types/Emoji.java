package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

public class Emoji {
    String id;
    String name;
    int[] roles;
    User user;
    boolean require_colons;
    boolean managed;
    boolean animated;
    boolean available;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getRoles() {
        return roles;
    }

    public User getUser() {
        return user;
    }

    public boolean isRequire_colons() {
        return require_colons;
    }

    public boolean isManaged() {
        return managed;
    }

    public boolean isAnimated() {
        return animated;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Emoji{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", roles=" + Arrays.toString(roles)
                + ", user=" + user + ", require_colons=" + require_colons + ", managed=" + managed + ", animated="
                + animated + ", available=" + available + '}';
    }
}
