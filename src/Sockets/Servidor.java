package Sockets;
import Extras.Escribir;
import Extras.FechaHora;
import java.io.* ;
import java.net.* ;

public class Servidor {
    Escribir historial = new Escribir();
    static final int PUERTO=7000;
    String m,m1;
 
 
    public Servidor( ) {
        try {
            ServerSocket Servidor = new ServerSocket(PUERTO);
         
            FechaHora f=new FechaHora();

            System.out.println("Escucho el puerto " + PUERTO );           
            historial.escribirLog("Escucho el puerto " + PUERTO);

                for( int numCli = 0; numCli< 3; numCli++) 
                {
                
                    try (Socket Cliente = Servidor.accept()) 
                        {
                            InetAddress ip= Cliente.getInetAddress();
                    
                            System.out.println("Sirvo al cliente " + numCli);     
                            m=("Sirvo al cliente " + numCli);
                            historial.escribirLog(m+" con ip "+ip);
                    
                            OutputStream aux = Cliente.getOutputStream();
                            DataOutputStream flujo= new DataOutputStream( aux );
                    
                            flujo.writeUTF( "Hola cliente estas conectado a mi sevidor Isrel " + numCli +" Con ip: "+ip+f.fechaActual());
                            
                            
                            DataOutputStream flujo1= new DataOutputStream( aux );
                            flujo1.writeUTF("date "+ f.fechaActual());
                            
                            DataOutputStream flujo2= new DataOutputStream( aux );
                            flujo2.writeUTF("time "+ f.horaActual());
                        }
                }
            
                System.out.println("Demasiados clientes por hoy");
        }
        catch( IOException e )
        {
                System.out.println( e.getMessage() );
        }
        
        
                        }
 
    public static void main( String[] arg ) {
        Servidor servidor = new Servidor();
    }  
 
}
