
package frc.robot;

    //Aqui é onde declaramos as portas de cada motor 

public final class Constants {

  public static class Joystick {
    
    //atribui valores para cada id 
    public static final int id_pilot   = 0;
    public static final int id_copilot = 1;

  }

  public static class Drivetrain {
    public static final int id_rfront = 0;
    public static final int id_lfront = 2;
    public static final int id_rback  = 1;
    public static final int id_lback  = 3;

  }

  public static class Intake {

    public static final int id_ileft = 4;
    public static final int id_iright = 5;

  }

    public static class Elevators {

      public static final int id_efirst = 6; 
      public static final int id_esecond = 7; 
      public static final int id_elimit1 = 8;
      public static final int id_elimit2 = 9;
      public static final int id_boreencoder1 = 10;
      public static final int id_boreencoder2 = 11;
    }



  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
}
