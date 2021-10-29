// Button hover effect
package git.Quiz_app.Util;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class jbtn extends JButton implements MouseListener {
private Color def_color;
private Color after_color;
private String text;
//jtbn(text inside button, before hover, after hover)
public jbtn(String text, Color def_color, Color after_color){
    super(text);
    setBackground(def_color);
    this.def_color = def_color;
    this.after_color = after_color;


    addMouseListener(this);

}
    //overriding other functions
    public void mouseClicked(MouseEvent evt) { }
    public void mousePressed(MouseEvent evt) { }
    public void mouseReleased(MouseEvent evt) { }


    public void mouseEntered(MouseEvent evt){
        if(evt.getSource()==this){

            this.setBackground(this.after_color);

        }
    }
    public void mouseExited(MouseEvent evt){
        if(evt.getSource()==this){

            this.setBackground(this.def_color);

        }
    }
}

