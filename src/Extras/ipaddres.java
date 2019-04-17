
package Sockets;

import java.net.*;


public class ipaddres {
    
String name;

public String nombre()
{
    try {
        InetAddress address=InetAddress.getLocalHost();
        name=address.getHostName();
    }
    
    catch(UnknownHostException e){
        name="imposible determinar el nombre del equipo";
    }
    return name;
    
    }

public String ip()
{
    try {
        InetAddress address=InetAddress.getLocalHost();
        name=address.getHostAddress();
    }
    
    catch(UnknownHostException e){
        name="imposible determinar la IP del equipo";
    }
    return name;
    
    }
}

