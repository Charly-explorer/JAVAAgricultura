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
public class LostCropState implements CropState{
    private Crop crop;

    public LostCropState(Crop crop) {
        this.crop = crop;
    }

    @Override
    public void sown() {
        throw new IllegalStateException("El cultivo ya se a dañado");
    }

    @Override
    public void ripening() {
        throw new IllegalStateException("El cultivo ya se a dañado");
    }

    @Override
    public void harvested() {
        throw new IllegalStateException("El cultivo ya se a dañado");
    }

    @Override
    public void lost() {
        throw new IllegalStateException("El cultivo se daño");
    }
}
