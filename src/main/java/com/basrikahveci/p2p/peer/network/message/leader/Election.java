package com.basrikahveci.p2p.peer.network.message.leader;

import com.basrikahveci.p2p.peer.Peer;
import com.basrikahveci.p2p.peer.network.Connection;
import com.basrikahveci.p2p.peer.network.message.Message;

/**
 * Notifies other peers about the election started by this peer
 */
public class Election implements Message {

    private static final long serialVersionUID = 3025595002500496571L;

    @Override
    public void handle(Peer peer, Connection connection) {
        peer.handleElection(connection);
    }

}
