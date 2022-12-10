package fr.pandonia.api.pubsub.manager;

import fr.pandonia.api.pubsub.MessageReceiver;
import fr.pandonia.api.pubsub.Way;
import org.bson.Document;

import java.util.Map;
import java.util.Optional;

public interface IMessageReceiverManager {

    /**
     * Enregistre un nouveau {@link MessageReceiver} lié à un {@link Way}
     * @param way chemin demandé pour exécuter le {@link MessageReceiver}
     * @param receiver class à enregistrer
     */
    void registerMessageReceiver(Way way, Class<? extends MessageReceiver> receiver);

    /**
     * Récupère la class d'un {@link MessageReceiver} enregistré avec un {@link Way}
     * @param way chemin pour récupérer {@link MessageReceiver}
     * @return {@link Optional} de la class trouvée
     */
    Optional<Class<? extends MessageReceiver>> get(Way way);

    /**
     * Exécute un potentiel {@link MessageReceiver} trouvé
     * @param way Chemin du {@link MessageReceiver}
     * @param message Message pour le {@link MessageReceiver}
     */
    void execute(Way way, Document message);

    /**
     * Récupère la liste de tout les receivers
     * @return la liste de tout les {@link MessageReceiver}
     */
    Map<Way, Class<? extends MessageReceiver>> getReceivers();

}
