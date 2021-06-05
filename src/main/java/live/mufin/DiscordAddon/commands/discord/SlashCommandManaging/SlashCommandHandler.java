package live.mufin.DiscordAddon.commands.discord.SlashCommandManaging;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class SlashCommandHandler {

  private static boolean printApiResponse = false;
  private static boolean printApiResponseCode = false;

  /**
   * All option types for better readability.
   */
  public enum OptionType {

    SUB_COMMAND(1), SUB_COMMAND_GROUP(2), STRING(3), INTEGER(4), BOOLEAN(5), USER(6), CHANNEL(7), ROLE(8),
    MENTIONABLE(9);

    int type;

    OptionType(int type) {
      this.type = type;
    }
  }

  /**
   * Class to help make commands easier
   */
  public static class CommandBuilder {
    String name;
    String description;
    List<Option> options;

    public CommandBuilder setName(String name) {
      this.name = name;
      return this;
    }

    public CommandBuilder setDescription(String description) {
      this.description = description;
      return this;
    }

    public CommandBuilder setOptions(List<Option> options) {
      this.options = options;
      return this;
    }

    public Command build() {
      return new Command(name, description, options);
    }
  }

  /**
   * Command class
   */
  public static class Command {
    String name;
    String description;
    List<Option> options;

    /**
     * Creating a command
     * 
     * @param name        Command name
     * @param description Command description
     * @param options     Arguments
     */
    private Command(String name, String description, List<Option> options) {
      this.name = name;
      this.description = description;
      this.options = options;
    }
  }

  /**
   * Command class that you can only get from
   */
  public static class ResponseCommand {
    String id;
    String application_id;
    String name;
    String description;
    String version;
    boolean default_permission;
    List<ResponseOption> options;

    @Override
    public String toString() {
      return "ResponseCommand{" + "id='" + id + '\'' + ", application_id='" + application_id + '\'' + ", name='" + name
          + '\'' + ", description='" + description + '\'' + ", version='" + version + '\'' + ", default_permission="
          + default_permission + ", options=" + options + '}';
    }

    public String getId() {
      return id;
    }

    public String getApplication_id() {
      return application_id;
    }

    public String getName() {
      return name;
    }

    public String getDescription() {
      return description;
    }

    public String getVersion() {
      return version;
    }

    public boolean isDefault_permission() {
      return default_permission;
    }

    public List<ResponseOption> getOptions() {
      return options;
    }
  }

  /**
   * Class to help make options easier
   */
  public static class OptionBuilder {
    String name;
    String description;
    OptionType type;
    boolean required;
    List<Option> options;
    List<Choice> choices;

    public OptionBuilder setOptions(List<Option> options) {
      if (this.type == OptionType.SUB_COMMAND) {
        this.options = options;
      }
      return this;
    }

    public OptionBuilder addOption(Option option) {
      if (this.type == OptionType.SUB_COMMAND) {
        if (this.options == null)
          options = new ArrayList<Option>();
        this.options.add(option);
      }
      return this;
    }

    public OptionBuilder setName(String name) {
      this.name = name;
      return this;
    }

    public OptionBuilder setDescription(String description) {
      this.description = description;
      return this;
    }

    public OptionBuilder setType(OptionType type) {
      this.type = type;
      return this;
    }

    public OptionBuilder setRequired(boolean required) {
      this.required = required;
      return this;
    }

    public OptionBuilder setChoices(List<Choice> choices) {
      this.choices = choices;
      return this;
    }

    public Option build() {
      return new Option(name, description, type, required, choices, options);
    }
  }

  /**
   * Option class
   */
  public static class Option {
    String name;
    String description;
    int type;
    boolean required;
    List<Choice> choices;
    List<Option> options;

    /**
     * Creating an argument
     * 
     * @param name        Name of argument
     * @param description Description of argument
     * @param type        Type that needs to be input
     * @param required    Wether or not the argument is required or not
     * @param choices     The choices of the argument
     */
    private Option(String name, String description, OptionType type, boolean required, List<Choice> choices,
        List<Option> options) {
      this.name = name;
      this.description = description;
      this.type = type.type;
      this.required = required;
      this.choices = choices;
      this.options = options;
    }
  }

  /**
   * Option class
   */
  public static class ResponseOption {
    String name;
    String description;
    int type;
    boolean required;
    List<Choice> choices;
    List<ResponseOption> options;

    public String getName() {
      return name;
    }

    public String getDescription() {
      return description;
    }

    public int getType() {
      return type;
    }

    public boolean isRequired() {
      return required;
    }

    public List<Choice> getChoices() {
      return choices;
    }

    public List<ResponseOption> getOptions() {
      return options;
    }
  }

  /**
   * Choice class
   */
  public static class Choice {
    String name;
    String value;

    /**
     * Creating a choice
     * 
     * @param name  Choice name that will show
     * @param value Choice value
     */
    public Choice(String name, String value) {
      this.name = name;
      this.value = value;
    }
  }

  private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
  private static final OkHttpClient client = new OkHttpClient();

  /**
   * Post method
   * 
   * @param url   Discord URL.
   * @param json  JSON data.
   * @param token Bot token.
   * @return Response.
   * @throws IOException When the connection fails.
   */
  static String post(String url, String json, String token) throws IOException {
    System.out.println(json);
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder().url(url).post(body).header("Authorization", "Bot " + token).build();
    try (Response response = client.newCall(request).execute()) {
      String msg = response.body().string();
      System.out.println(msg);
      if (printApiResponseCode)
        System.out.println(MessageFormat.format("Status: {0}", response.code()));
      return msg;
    }
  }

  /**
   * Patch method
   * 
   * @param url   Discord URL.
   * @param json  JSON data.
   * @param token Bot token.
   * @return Response.
   * @throws IOException When the connection fails.
   */
  static String patch(String url, String json, String token) throws IOException {
    RequestBody body = RequestBody.create(JSON, json);
    Request request = new Request.Builder().url(url).patch(body).header("Authorization", "Bot " + token).build();
    try (Response response = client.newCall(request).execute()) {
      if (printApiResponseCode)
        System.out.println(MessageFormat.format("Status: {0}", response.code()));
      if (printApiResponse)
        System.out.println(response.body().string());
      return response.body().string();
    }
  }

  /**
   * Get method
   * 
   * @param url   Discord URL.
   * @param token Bot token.
   * @return Response.
   * @throws IOException When the connection fails
   */
  static String get(String url, String token) throws IOException {
    Request request = new Request.Builder().url(url).get().header("Authorization", "Bot " + token).build();
    try (Response response = client.newCall(request).execute()) {
      if (printApiResponseCode)
        System.out.println(MessageFormat.format("Status: {0}", response.code()));
      String json = response.body().string();
      return json;
    }
  }

  /**
   * Delete method
   * 
   * @param url   Discord URL
   * @param token Bot token.
   * @return
   * @throws IOException
   */
  static String delete(String url, String token) throws IOException {
    Request request = new Request.Builder().url(url).delete().header("Authorization", "Bot " + token).build();
    try (Response response = client.newCall(request).execute()) {
      if (printApiResponseCode)
        System.out.println(MessageFormat.format("Status: {0}", response.code()));
      if (printApiResponse)
        System.out.println(response.body().string());
      return response.body().string();
    }
  }

  /**
   * Registers a command to Discord
   * 
   * @param command  Command to register.
   * @param token    Bot token to register to.
   * @param clientID The user id of your bot.
   */
  public static void registerCommand(Command command, String token, String clientID) {
    {
      String url = "https://discord.com/api/v8/applications/" + clientID + "/commands";
      Gson gson = new Gson();
      String json = gson.toJson(command).toString();
      try {
        post(url, json, token);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Edits a command that already exists.
   * 
   * @param commandID The id of the command.
   * @param token     Bot auth token.
   * @param clientID  Bot client id.
   * @param command   The NEW command you want to be used.
   */
  public static void editCommand(String commandID, String token, String clientID, Command command) {
    String url = "https://discord.com/api/v8/applications/" + clientID + "/commands/" + commandID;
    Gson gson = new Gson();
    String json = gson.toJson(command).toString();
    try {
      String result = patch(url, json, token);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Deletes a command from the bot.
   * 
   * @param commandID Id of the command.
   * @param token     Auth token of the bot.
   * @param clientID  Client id of the bot.
   */
  public static void deleteCommand(String commandID, String token, String clientID) {
    String url = "https://discord.com/api/v8/applications/" + clientID + "/commands/" + commandID;
    try {
      String result = delete(url, token);
      System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Checks if a command exists.
   * 
   * @param commandName Name of the command you want to check.
   * @param token       Auth token of the bot.
   * @param clientID    Client id of the bot.
   * @return true if the command exists, false if it does not.
   */
  public static boolean commandExists(String commandName, String token, String clientID) {
    try {
      getIdFromCommandName(commandName, token, clientID);
    } catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

  /**
   * Get a list of all registered commands.
   * 
   * @param token    Auth token of the bot.
   * @param clientID Client id of the bot.
   * @return List of ResponseCommand instances
   */
  public static List<ResponseCommand> getCommands(String token, String clientID) {
    String url = "https://discord.com/api/v8/applications/" + clientID + "/commands";
    String response;
    try {
      response = get(url, token);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    Gson gson = new Gson();
    return gson.fromJson(response, new TypeToken<List<ResponseCommand>>() {
    }.getType());
  }

  /**
   * Get the id for a command that you only have the name for.
   * 
   * @param commandName Name of the command
   * @param token       Auth token of the bot.
   * @param clientID    Id of the bot client.
   * @return The command id
   * @throws IllegalArgumentException if the command doesnt exist.
   */
  public static String getIdFromCommandName(String commandName, String token, String clientID) {
    for (ResponseCommand responseCommand : getCommands(token, clientID)) {
      if (responseCommand.getName().equals(commandName))
        return responseCommand.getId();
    }
    throw new IllegalArgumentException("Invalid command name.");
  }

  /**
   * Registers slash command for specific guild.
   * 
   * @param command  Command to register.
   * @param token    Token for authentication.
   * @param clientID ID of bot user.
   * @param guildID  Guild ID for command to be in.
   */
  public static void registerGuildCommand(Command command, String token, String clientID, String guildID) {
    {
      String url = MessageFormat.format("https://discord.com/api/v8/applications/{0}/guilds/{1}/commands", clientID,
          guildID);
      Gson gson = new Gson();
      String json = gson.toJson(command).toString();
      try {
        String response = post(url, json, token);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Edits slash command for specific guild
   * 
   * @param commandID ID of the command you want to edit.
   * @param token     Token for authentication.
   * @param clientID  ID of bot user.
   * @param command   New command to set the command to.
   * @param guildID   ID of the guild you want to edit the command in.
   */
  public static void editGuildCommand(String commandID, String token, String clientID, Command command,
      String guildID) {
    String url = MessageFormat.format("https://discord.com/api/v8/applications/{0}/guilds/{1}/commands/{2}", clientID,
        guildID, commandID);
    Gson gson = new Gson();
    String json = gson.toJson(command).toString();
    try {
      String result = patch(url, json, token);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Deletes slash command for specific guild
   * 
   * @param commandID ID of the command you want to delete.
   * @param token     Token for authentication.
   * @param clientID  ID of bot user.
   * @param guildID   ID of guild you want to delete the command in.
   */
  public static void deleteGuildCommand(String commandID, String token, String clientID, String guildID) {
    String url = MessageFormat.format("https://discord.com/api/v8/applications/{0}/guilds/{1}/commands/{2}", clientID,
        guildID, commandID);
    try {
      String result = delete(url, token);
      System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Check to see if a command already exists in a guild
   * 
   * @param commandName Name of the command.
   * @param token       Token for authentication.
   * @param clientID    ID of bot user.
   * @param guildID     ID of guild you want to check for the command in.
   * @return true - The command exists, false - The command doesn't exist.
   */
  public static boolean guildCommandExists(String commandName, String token, String clientID, String guildID) {
    try {
      getIdFromGuildCommandName(commandName, token, clientID, guildID);
    } catch (IllegalArgumentException e) {
      return false;
    }
    return true;
  }

  /**
   * Get all the commands for a guild
   * 
   * @param token    Token for authentication.
   * @param clientID ID of bot user.
   * @param guildID  ID of guild to check in.
   * @return List<ResponseCommand> with all the commands.
   */
  public static List<ResponseCommand> getGuildCommands(String token, String clientID, String guildID) {
    String url = MessageFormat.format("https://discord.com/api/v8/applications/{0}/guilds/{1}/commands", clientID,
        guildID);
    String response;
    try {
      response = get(url, token);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
    Gson gson = new Gson();
    return gson.fromJson(response, new TypeToken<List<ResponseCommand>>() {
    }.getType());
  }

  /**
   * Method to get the id for a command.
   * 
   * @param commandName Name of the command.
   * @param token       Token for authentication.
   * @param clientID    ID of bot user.
   * @param guildID     ID of guild to check in.
   * @return ID of the command.
   * @throws IllegalArgumentException - There is not a command with that name.
   */
  public static String getIdFromGuildCommandName(String commandName, String token, String clientID, String guildID) {
    for (ResponseCommand responseCommand : getGuildCommands(token, clientID, guildID)) {
      if (responseCommand.getName().equals(commandName))
        return responseCommand.getId();
    }
    throw new IllegalArgumentException("Invalid command name.");
  }
}
