/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.State;

import Model.Crops.Crop;

/**
 *
 * @author Johel M
 */
public class SownCropState implements CropState{
    private Crop crop;

    public SownCropState(Crop crop) {
        this.crop = crop;
    }
    
    @Override
    public void sown() {
        crop.setState(new SownCropState(crop));
    }

    @Override
    public void ripening() {
        throw new IllegalStateException("El cultivo aún no se puede cosechar");
    }

    @Override
    public void harvested() {
        throw new IllegalStateException("El cultivo se encuantra en siembra");
    }

    @Override
    public void lost() {
        crop.setState(new LostCropState(crop));
    }
    
}
