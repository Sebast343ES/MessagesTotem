package mt.sqbas.commands;

import mt.sqbas.MessagesTotem;
import mt.sqbas.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainCommand implements CommandExecutor {

    private MessagesTotem messagesTotem;

    public MainCommand(MessagesTotem messagesTotem){
        this.messagesTotem = messagesTotem;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if(!(sender instanceof Player)){
            //Consola
            sender.sendMessage(MessageUtils.getColoredMessage(MessagesTotem.prefix+MessagesTotem.prefix+"&cEste comando solo puede ser usado desde un jugador"));
            return true;
        }

        //Jugador
        Player player = (Player) sender;

        // /messagestotem args[0] args[1] args[2]
        if(args.length >= 1) {
            if(args[0].equalsIgnoreCase("mensaje")){
                // /Messagestotem mensaje
                sender.sendMessage(MessageUtils.getColoredMessage(MessagesTotem.prefix+"&fReemplace &b<mensaje> &fcon el mensaje que usted desee para los totems"));
            }else if(args[0].equalsIgnoreCase("prueba")){
                sender.sendMessage(MessageUtils.getColoredMessage(MessagesTotem.prefix+"&fAun no hay"));
                // /MessagesTotem prueba
            }else if(args[0].equalsIgnoreCase("fecha")){
                // /MessagesTotem fecha
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                String date = dateFormat.format(new Date());
                sender.sendMessage(MessageUtils.getColoredMessage(MessagesTotem.prefix+"&7Fecha y hora actual: &e"+date));

            }else if(args[0].equalsIgnoreCase("get")) {
                // /MessagesTotem <author/version>
                subCommandGet(sender, args);

            }else{
                help(sender);
            }
        }else{
            // /Messagestotem

        }


        return true;
    }
    public void help(CommandSender sender){
        sender.sendMessage(MessageUtils.getColoredMessage("&f-----------------&bCOMANDOS&f-----------------"));
        sender.sendMessage(MessageUtils.getColoredMessage("- /&amessagestotem &emensaje &b<mensaje>"));
        sender.sendMessage(MessageUtils.getColoredMessage("- /&amessagestotem &eprueba"));
        sender.sendMessage(MessageUtils.getColoredMessage("- /&amessagestotem &efecha"));
        sender.sendMessage(MessageUtils.getColoredMessage("- /&amessagestotem &eget &b<autor/version>"));
        sender.sendMessage(MessageUtils.getColoredMessage("&f-----------------&bCOMANDOS&f-----------------"));
    }

    public void subCommandGet(CommandSender sender, String[] args){
        if(sender.hasPermission("messagestotem.commands.mensaje")){
            sender.sendMessage(MessageUtils.getColoredMessage(MessagesTotem.prefix+"&cNo tienes los permisos necesarios"));
            return;
        }

        if(args.length == 1){
            //Messages totems get
            sender.sendMessage(MessageUtils.getColoredMessage(MessagesTotem.prefix+"&cDebes usar &e/messagestotem get &b<autor/version>"));
            return;
        }

        if(args[1].equalsIgnoreCase("autor")){
            //Messages totems get autor
            sender.sendMessage(MessageUtils.getColoredMessage(
                    MessagesTotem.prefix+"&7Autor: &e"+messagesTotem.getDescription().getAuthors()));
        }else if(args[1].equalsIgnoreCase("version")){
            //Messages totems get version
            sender.sendMessage(MessageUtils.getColoredMessage(
                    MessagesTotem.prefix+"&7Version: &e"+messagesTotem.getDescription().getVersion()));
        }else{
            sender.sendMessage(MessageUtils.getColoredMessage(
                    MessagesTotem.prefix+"&cDebes usar &e/messagestotem get &b<autor/version>"));
        }

    }
}

