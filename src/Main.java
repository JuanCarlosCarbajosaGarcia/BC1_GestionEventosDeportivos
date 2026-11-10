import java.util.Scanner;

public class Main {

    public static class Evento{
        int numEvento;
        String nombre,deporte,dia,mes,ano,horario,ocupado;
        int participantes;
    }

    private static void registrar(Evento[] eventos) {
        Scanner sc = new Scanner(System.in);
        int num=1;
        for (int i=1;i<eventos.length;i++) {
            //se asegura de que el objeto sea nulo
            if (eventos[i]==null){
                num=i;
                break;//sale del for
            }
        }

        eventos[num]=new Evento();
        eventos[num].numEvento=num;
        System.out.print("nombre evento: ");
        eventos[num].nombre=sc.nextLine();
        System.out.print("deporte: ");
        eventos[num].deporte=sc.nextLine();
        System.out.print("dia: ");
        eventos[num].dia=sc.nextLine();
        System.out.print("mes: ");
        eventos[num].mes=sc.nextLine();
        System.out.print("año: ");
        eventos[num].ano=sc.nextLine();
        System.out.print("Horario: ");
        eventos[num].horario=sc.nextLine();
        System.out.print("Estado: ");
        eventos[num].ocupado=sc.nextLine();
        System.out.print("participantes: ");
        eventos[num].participantes=sc.nextInt();
    }

    public static void mostrar(Evento[] eventos){
        for(int i=1;i<eventos.length;i++){
            //comprueba que no sea nulo
            if(eventos[i]!=null){
                System.out.println(
                    "Nº: "+eventos[i].numEvento+
                    ", nombre: "+eventos[i].nombre+
                    ", deporte: "+eventos[i].deporte+
                    ", dia: "+eventos[i].dia+
                    ", mes: "+eventos[i].mes+
                    ", año: "+eventos[i].ano+
                    ", horario: "+eventos[i].horario+
                    ", Estado: "+eventos[i].ocupado+
                    ", participantes: "+eventos[i].participantes
                );
            }
        }
    }

    public static void buscarDia(Evento[] eventos, String fecha){
        for(int i=1;i<eventos.length;i++){
            //comprueba que no sea nulo
            if(eventos[i]!=null) {
                if (eventos[i].dia.equals(fecha)) {
                    System.out.println(
                        "Nº: "+eventos[i].numEvento+
                        ", nombre: "+eventos[i].nombre+
                        ", deporte: "+eventos[i].deporte+
                        ", dia: "+eventos[i].dia+
                        ", mes: "+eventos[i].mes+
                        ", año: "+eventos[i].ano+
                        ", horario: "+eventos[i].horario+
                        ", Estado: "+eventos[i].ocupado+
                        ", participantes: "+eventos[i].participantes
                    );
                }
            }
        }
    }

    public static void buscarDeporte(Evento[] eventos, String deporte){
        for(int i=1;i<eventos.length;i++){
            if(eventos[i]!=null) {
                if (eventos[i].deporte.equals(deporte)) {
                    System.out.println(
                        "Nº: "+eventos[i].numEvento+
                        ", nombre: "+eventos[i].nombre+
                        ", deporte: "+eventos[i].deporte+
                        ", dia: "+eventos[i].dia+
                        ", mes: "+eventos[i].mes+
                        ", año: "+eventos[i].ano+
                        ", horario: "+eventos[i].horario+
                        ", Estado: "+eventos[i].ocupado+
                        ", participantes: "+eventos[i].participantes
                    );
                }
            }
        }
    }

    public static void consultar(Evento[] eventos){
        int eventosTotal=0;
        int particTotal=0;

        for(int i=1;i<eventos.length;i++){
            //comprueba que no sea nulo
            if(eventos[i]!=null){
                eventosTotal++;
                particTotal=particTotal+eventos[i].participantes;
            }
        }
        System.out.println("Eventos totales: "+eventosTotal+", Participantes: "+particTotal);
    }

    public static void eliminar(Evento[] eventos, int num){
        for (int i=1;i<eventos.length;i++){
            //comprueba que no sea nulo
            if(eventos[i]!=null){
                if (num==i){
                    //lo combierte a nulo
                    eventos[i]=null;
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean salir=false;
        Scanner sc=new Scanner(System.in);
        Evento[] eventos=new Evento[5];

        while(!salir){
            //menu
            System.out.println("Seleccione una opcion:");
            System.out.println("1: registrar evento");
            System.out.println("2: mostrar eventos");
            System.out.println("3: buscar evento por dia");
            System.out.println("4: buscar evento por deporte");
            System.out.println("5: numero de eventos y participantes");
            System.out.println("6: eliminar evento");
            System.out.println("7: salir");
            switch (sc.nextInt()){
                case 1://registrar nuevos eventos
                    registrar(eventos);
                break;
                case 2://mostrar todos los eventos
                    mostrar(eventos);
                break;
                case 3://buscar eventos por dia
                    System.out.println("introduzca el dia");
                    String fecha = sc.nextLine();
                    buscarDia(eventos,fecha);
                break;
                case 4:
                    System.out.println("Deporte a buscar");
                    String deporte = sc.nextLine();
                    buscarDeporte(eventos,deporte);
                break;
                case 5://consultar numero de eventos y participantes
                    consultar(eventos);
                break;
                case 6://eliminar evento
                    System.out.print("numero del evento a eliminar: ");
                    int num=sc.nextInt();
                    eliminar(eventos,num);
                break;
                case 7:
                    salir=true;
            }
        }
    }
}
