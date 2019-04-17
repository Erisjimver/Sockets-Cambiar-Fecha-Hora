package Sockets;

import Extras.FechaHora;
import java.io.*;
import java.net.*;

public class ClienteC {

    String mc;
    int PUERTOI=0;
    FechaHora cambiar=new FechaHora();

    public String getMc() {
        return mc;
    }
    
 
    public void Conexion(String HOST,String PUERTO){
       PUERTOI = Integer.parseInt(PUERTO);
      
       try{
            Socket skCliente = new Socket( HOST , PUERTOI);
            InputStream aux = skCliente.getInputStream();
            DataInputStream flujo = new DataInputStream( aux );
            DataInputStream flujo1 = new DataInputStream( aux );
            DataInputStream flujo2= new DataInputStream( aux );

            mc=flujo.readUTF();           
            String date = flujo1.readUTF();
            String time = flujo2.readUTF();
            cambiar.cambio(date, time);
            
            skCliente.close();
        }
        catch( IOException e ) {

                mc=e.getMessage();
        } 

    } 
    
    
    
    
    
}
