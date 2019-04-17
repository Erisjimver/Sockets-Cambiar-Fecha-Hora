package Extras;

import java.io.BufferedOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaHora {
    

   String fecha,hora;
  
//Cambiar fecha  y Hora 
    public void CambiarF()
    {
        try{
                Runtime runtime = Runtime.getRuntime();
               // Process proc = runtime.exec("cmd /c date "+Dia+"/"+Mes+"/"+Ano);
                runtime.exec("cmd /c date "+fechaActual());
               // runtime.exec("cmd /c time "+Hora+":"+Minuto+":"+Segundo);
                runtime.exec("cmd /c time "+horaActual());
                System.out.println("Fecha actualizada con exito");

             }
             catch (java.io.IOException e)
             {
                 System.out.println("error: "+e);
             }
    }
    
    
 //Obtener fecha      
    public String fechaActual()
    { 
        java.util.Date Fecha=new java.util.Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY");
        fecha=formatoFecha.format(Fecha);
        return fecha;   
    } 
 //Obtener hora   
    public String horaActual() 
    {
        Date time = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        hora = format.format(time);
        return hora;
    }

    
     
 
     public void cambio( String fecha, String hora){
     try {
     String exe = "cmd";
     Process proceso2 = Runtime.getRuntime().exec(exe);
     Process proceso3 = Runtime.getRuntime().exec(exe);
     BufferedOutputStream salida2 = new BufferedOutputStream(proceso2.getOutputStream());
     BufferedOutputStream salida3 = new BufferedOutputStream(proceso3.getOutputStream());
         System.out.println("fecha"+fecha);
     salida2.write(fecha.getBytes());
     salida2.write("\r\n".getBytes());
     salida2.flush();
     salida2.close();
     
     salida3.write(hora.getBytes());
         System.out.println("hora"+hora);
     salida3.write("\r\n".getBytes());
     salida3.flush();
     salida3.close();
   } catch (Exception e) {
     }             
 }   
 }


