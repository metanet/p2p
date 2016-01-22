package com.basrikahveci.p2p.peer.network.message;

import com.basrikahveci.p2p.peer.Peer;
import com.basrikahveci.p2p.peer.network.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sent to neighbours to notify them about presence of this peer
 */
public class KeepAlive implements Message {

    private static final Logger LOGGER = LoggerFactory.getLogger(KeepAlive.class);

    private static final long serialVersionUID = -4998803925489492616L;

    @Override
    public void handle(Peer peer, Connection connection) {
        LOGGER.debug("Keep alive ping received from {}", connection);
    }

}
