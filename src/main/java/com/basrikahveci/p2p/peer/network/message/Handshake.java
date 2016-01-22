package com.basrikahveci.p2p.peer.network.message;

import com.basrikahveci.p2p.peer.Peer;
import com.basrikahveci.p2p.peer.network.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Informs the new peer about this peer
 */
public class Handshake implements Message {

    private static final Logger LOGGER = LoggerFactory.getLogger(Handshake.class);

    private static final long serialVersionUID = 213352944600339280L;

    private final String peerName;

    private final String leaderName;

    public Handshake(String peerName, String leaderName) {
        this.peerName = peerName;
        this.leaderName = leaderName;
    }

    public void handle(Peer peer, Connection connection) {
        final String peerName = connection.getPeerName();
        if (peerName == null) {
            connection.setPeerName(this.peerName);
            peer.handleConnectionOpened(connection, leaderName);
        } else if (!peerName.equals(this.peerName)) {
            LOGGER.warn(
                    "Mismatching peer name received from connection! Existing: " + this.peerName + " Received: " + this.peerName);
        }
    }

}
