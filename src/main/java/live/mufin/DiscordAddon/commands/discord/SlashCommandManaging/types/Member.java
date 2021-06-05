package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

public class Member {
    User user;
    String nick;
    String[] roleIds;
    String joined_at;

    String premium_since;
    boolean deaf;
    boolean mute;
    boolean pending;
    String permissions;

    public User getUser() {
        return user;
    }

    public String getNick() {
        return nick;
    }

    public String[] getRoleIds() {
        return roleIds;
    }

    public String getJoined_at() {
        return joined_at;
    }

    public String getPremium_since() {
        return premium_since;
    }

    public boolean isDeaf() {
        return deaf;
    }

    public boolean isMute() {
        return mute;
    }

    public boolean isPending() {
        return pending;
    }

    public String getPermissions() {
        return permissions;
    }

    @Override
    public String toString() {
        return "Member{" + "user=" + user + ", nick='" + nick + '\'' + ", roleIds=" + Arrays.toString(roleIds)
                + ", joined_at='" + joined_at + '\'' + ", premium_since='" + premium_since + '\'' + ", deaf=" + deaf
                + ", mute=" + mute + ", pending=" + pending + ", permissions='" + permissions + '\'' + '}';
    }
}
