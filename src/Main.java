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
                num=i;//asigna el primer valor nulo que se encuentre a num
                break;//sale del for
            }
        }

        //asignamos los valores
        eventos[num]=new Evento();
        eventos[num].numEvento=num;//numero del evento
        System.out.print("nombre evento: ");
        eventos[num].nombre=sc.nextLine();//nombre del evento
        System.out.print("deporte: ");
        eventos[num].deporte=sc.nextLine();//deporte del evento
        System.out.print("dia: ");
        eventos[num].dia=sc.nextLine();//dia del evento
        System.out.print("mes: ");
        eventos[num].mes=sc.nextLine();//mes del evento
        System.out.print("año: ");
        eventos[num].ano=sc.nextLine();//año del evento
        System.out.print("Horario: ");
        eventos[num].horario=sc.nextLine();//horario del evento
        System.out.print("Estado: ");
        eventos[num].ocupado=sc.nextLine();//estado del evento
        System.out.print("participantes: ");
        eventos[num].participantes=sc.nextInt();//cantidad de participantes del evento
        //todos los 'del evento' an sido puestos por gusto del evento
    }

    //muestra toda la informacion de todos los eventos
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

    //muestra todos los eventos que ocurran en un dia concreto sin tener encuenta mes o año
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

    //muestra todos los eventos que pertenezcan a un deporte especificado
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

    //muestra la cantidad de eentos y los participantes totales
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

    //elimina un evento combirtiendo el objeto elegido a nulo
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

    //Main
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
                    sc.nextLine();
                    String fecha = sc.nextLine();
                    buscarDia(eventos,fecha);
                break;
                case 4://buscar eventos por deporte
                    System.out.println("Deporte a buscar");
                    sc.nextLine();
                    String deporte = sc.nextLine();
                    buscarDeporte(eventos,deporte);
                break;
                case 5://consultar numero de eventos y participantes
                    consultar(eventos);
                break;
                case 6://eliminar evento
                    System.out.print("numero del evento a eliminar: ");
                    sc.nextInt();
                    int num=sc.nextInt();
                    eliminar(eventos,num);
                break;
                case 7://salir del bucle while
                    salir=true;
            }
        }
    }
}
