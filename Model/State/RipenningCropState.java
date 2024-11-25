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
public class RipenningCropState implements CropState{
    private Crop crop;

    public RipenningCropState(Crop crop) {
        this.crop = crop;
    }

    @Override
    public void sown() {
        throw new IllegalStateException("El cultivo ya paso la etapa de floración");
    }

    @Override
    public void ripening() {
        crop.setState(new RipenningCropState(crop));
    }

    @Override
    public void harvested() {
        throw new IllegalStateException("El cultivo aún esta en cosecha");
    }

    @Override
    public void lost() {
        crop.setState(new LostCropState(crop));
    }
}
