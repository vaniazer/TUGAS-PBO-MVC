package koneksidatabase;

public class MVC_Praktikum {
    ViewPraktikum viewpraktikum = new ViewPraktikum();
    ModelPraktikum modelpraktikum = new ModelPraktikum();
    ControllerPraktikum controllerpraktikum = new ControllerPraktikum(modelpraktikum,viewpraktikum);
}
