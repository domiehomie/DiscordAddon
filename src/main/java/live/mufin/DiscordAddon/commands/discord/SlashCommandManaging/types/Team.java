package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.util.Arrays;

public class Team {
    String icon;
    String id;
    TeamMember[] members;
    String name;
    String owner_user_id;

    public String getIcon() {
        return icon;
    }

    public String getId() {
        return id;
    }

    public TeamMember[] getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public String getOwner_user_id() {
        return owner_user_id;
    }

    @Override
    public String toString() {
        return "Team{" + "icon='" + icon + '\'' + ", id='" + id + '\'' + ", members=" + Arrays.toString(members)
                + ", name='" + name + '\'' + ", owner_user_id='" + owner_user_id + '\'' + '}';
    }
}
