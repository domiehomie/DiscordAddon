package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.types;

import java.io.IOException;
import java.text.MessageFormat;

import com.google.gson.Gson;

import live.mufin.DiscordAddon.commands.discord.SlashCommandManaging.Interactions.InteractionType;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Interaction {
    String id;
    String application_id;
    InteractionType type;
    ApplicationCommandInteractionData data;
    String guild_id;
    String channel_id;
    Member member;
    User user;
    String token;
    int version;
    Message message;

    public String getId() {
        return id;
    }

    public String getApplication_id() {
        return application_id;
    }

    public InteractionType getType() {
        return type;
    }

    public ApplicationCommandInteractionData getData() {
        return data;
    }

    public String getGuild_id() {
        return guild_id;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public Member getMember() {
        return member;
    }

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public int getVersion() {
        return version;
    }

    public Message getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Interaction{" + "id='" + id + '\'' + ", application_id='" + application_id + '\'' + ", type=" + type
                + ", data=" + data + ", guild_id='" + guild_id + '\'' + ", channel_id='" + channel_id + '\''
                + ", member=" + member + ", user=" + user + ", token='" + token + '\'' + ", version=" + version
                + ", message=" + message + '}';
    }

    public void send(InteractionResponse response, String botToken) {
        Gson gson = new Gson();
        String json = gson.toJson(response);
        try {
            sendResponse(json, botToken, this.id, this.token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final OkHttpClient client = new OkHttpClient();

    private String sendResponse(String json, String botToken, String interactionID, String interactionToken)
            throws IOException {
        String url = "https://discord.com/api/v9/interactions/" + interactionID + "/" + interactionToken + "/callback";
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).post(body).header("Authorization", "Bot " + botToken).build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public void edit(InteractionResponse response, String botToken, String clientID) {
        Gson gson = new Gson();

        String json = gson.toJson(response);
        try {
            System.out.println(json);
            this.editResponse(json, botToken, clientID, this.token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String editResponse(String json, String botToken, String clientID, String interactionToken)
            throws IOException {
        String url = MessageFormat.format("https://discord.com/api/v9/webhooks/{0}/{1}/messages/@original", clientID,
                interactionToken);
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(url).patch(body).header("Authorization", "Bot " + botToken).build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
            return response.body().string();
        }
    }

}
