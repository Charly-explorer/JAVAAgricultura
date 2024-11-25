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
public class HarvestedCropState implements CropState{
    private Crop crop;

    public HarvestedCropState(Crop crop) {
        this.crop = crop;
    }

    @Override
    public void sown() {
        throw new IllegalStateException("El cultivo ya fue cosechado");
    }

    @Override
    public void ripening() {
        throw new IllegalStateException("El cultivo ya fue cosechado");
    }

    @Override
    public void harvested() {
        crop.setState(new HarvestedCropState(crop));
    }

    @Override
    public void lost() {
        crop.setState(new LostCropState(crop));
    }
}
