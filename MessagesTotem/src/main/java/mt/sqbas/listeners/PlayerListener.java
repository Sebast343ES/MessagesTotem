package mt.sqbas.listeners;

import mt.sqbas.MessagesTotem;
import mt.sqbas.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onResurrect(EntityResurrectEvent event){
        if(event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            player.sendMessage("&eHas usado un totem de la inmortalidad");

            String message = player.getName() + "ha consumido un totem.";
            Bukkit.broadcastMessage(message);
            System.out.println("El jugador " + player.getName() + " ha usado un tótem.");
        }
    }
}
