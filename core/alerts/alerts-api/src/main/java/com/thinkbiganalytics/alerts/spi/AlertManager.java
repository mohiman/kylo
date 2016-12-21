/**
 * 
 */
package com.thinkbiganalytics.alerts.spi;

import java.io.Serializable;
import java.net.URI;

import com.thinkbiganalytics.alerts.api.Alert;
import com.thinkbiganalytics.alerts.api.AlertResponse;

/**
 * A kind of AlertSource that provides alert creation and change management functions.
 * 
 * @author Sean Felten
 */
public interface AlertManager extends AlertSource {
    
    /**
     * Adds a new descriptor that this manager will provide.
     * @param descriptor the descriptor to add
     * @return true if the descriptor was not previously present
     */
    boolean addDescriptor(AlertDescriptor descriptor);

    /**
     * Creates a new alert and adds 
     * 
     * @param type the type
     * @param level the level
     * @param description a description of the alert
     * @param content optional content, the type of which is specific to the kind of alert
     * @return
     */
    <C extends Serializable> Alert create(URI type, Alert.Level level, String description, C content);
    
    /**
     * Obtains an AlertResponse object through which AlertResponders will perform updates to the given alert.
     * @param alert the alert that the AlertResponse will update
     * @return an AlertResponse that may be used to update the alert
     */
    AlertResponse getResponse(Alert alert);
    
    /**
     * Removes an alert from the manager.
     * 
     * @param id the ID of the alert to remove
     * @return the alert that was removed
     */
    Alert remove(Alert.ID id);
}
