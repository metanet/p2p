Introduction
================

This is an experimental work to build a unstructured P2P network using Java and Netty. 

It has following capabilities:

- Join to the P2P network
- Leave the network
- List peers in the network
- Leader election

P2P network is unstructured. Once a peer is started, it can join by connecting to any of the peers in the network. 
 
To maintain connectivity of the P2P network, each peer connects to more than one peer in the network randomly. 

Peers send periodic keep alive messages to their neighbours to notify them about their presence. If a peer does not receive a message from a neighbour for a configured amount of time, it drops the connection.
 
A peer can discover other peers in the network with a Ping-Pong process by sending a Ping message to its neighbours and waiting for the Pong messages for some time. This message also contains how many hops it can go over the network. When a peer receives a Ping message from a neighbour, it replies with a Pong message and dispatches the Ping message to its own neighbours after decreasing the hop count.
  
This mechanism is a very basic implementation of the Ping-Pong mechanism described in the Gnutella P2P network protocol v0.4. To read more about Gnutella, please see [The Annotated Gnutella Protocol Specification v0.4](http://rfc-gnutella.sourceforge.net/developer/stable/)  and [Gnutella Wikipedia](https://en.wikipedia.org/wiki/Gnutella). 
 
In the image below, you can see a Ping-Pong flow. 
 
![Ping Pong](http://rfc-gnutella.sourceforge.net/developer/stable/GnutellaProtocol-v0.4-r1.6_files/gnutella-ping-pong-routing.gif)


It also implements [Bully Algorithm](https://en.wikipedia.org/wiki/Bully_algorithm) for leader election. Since bully algorithm assumes a fully connected network under the hood, it is users' responsibility to create a connection between each peer before running the election. 

All network messages are sent with a fire-and-forget manner without any acknowledgement or retry system.

You can see available configuration options in [Config class](https://github.com/metanet/p2p/blob/master/src/main/java/com/basrikahveci/p2p/peer/Config.java). Main class is also [here](https://github.com/metanet/p2p/blob/master/src/main/java/com/basrikahveci/p2p/Main.java).


Build
================

This is a very simple Maven project which requires Java 8. 
 
It can be compiled with `mvn clean compile` and final jar can be produced with `mvn clean package`.


 
Run
================
  
You can start a peer by starting a java process with the produced jar file as follows:
  
`java -jar -DpeerName=Peer1 p2p.jar -n Peer1 -b 50670` 

This command starts a peer with name `Peer1` and binds it to port `50670`. It is the user's responsibility to guarantee uniqueness among names of the peers. 

`-DpeerName=...` is not necessary if you change default logging configuration of the project.
 
 After starting the peer, you can type `help` to see available commands.
 
 
 
 
Contribution is welcomed
================
This project is only tested by starting peers in terminal and creating connections among them. Therefore, unit tests and integration tests are welcomed.


