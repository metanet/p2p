package com.basrikahveci.p2p.peer.network.message.ping;

import com.basrikahveci.p2p.peer.Peer;
import com.basrikahveci.p2p.peer.network.Connection;
import com.basrikahveci.p2p.peer.network.message.Message;

public class CancelPings implements Message {

    private static final long serialVersionUID = -8650899535821394626L;

    private String peerName;

    public CancelPings(String peerName) {
        this.peerName = peerName;
    }

    @Override
    public void handle(Peer peer, Connection connection) {
        peer.cancelPings(connection, peerName);
    }

    @Override
    public String toString() {
        return "RemovePings{" +
                "peerName='" + peerName + '\'' +
                '}';
    }

}
