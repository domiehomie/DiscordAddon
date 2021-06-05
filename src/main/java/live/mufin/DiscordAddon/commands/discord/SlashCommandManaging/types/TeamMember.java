package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.MembershipState;


public class TeamMember {
    MembershipState membership_state;
    String[] permissions;
    String team_id;
    User user;

    public MembershipState getMembership_state() {
        return membership_state;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public String getTeam_id() {
        return team_id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "TeamMember{" + "membership_state=" + membership_state + ", permissions=" + Arrays.toString(permissions)
                + ", team_id='" + team_id + '\'' + ", user=" + user + '}';
    }
}
