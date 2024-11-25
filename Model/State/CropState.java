/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.State;

/**
 *
 * @author Johel M
 */
public interface CropState {
    public void sown();
    public void ripening();
    public void harvested();
    public void lost();
}
