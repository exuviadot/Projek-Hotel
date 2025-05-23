/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.dataUser;
/**
 *
 * @author Bagaskara
 */
public interface datauserimplement {
    public void signup(dataUser user);
    public boolean login(dataUser user);
    public void update(dataUser user);
    public void delete(int id_user);
    public List<dataUser> getAll();
}
